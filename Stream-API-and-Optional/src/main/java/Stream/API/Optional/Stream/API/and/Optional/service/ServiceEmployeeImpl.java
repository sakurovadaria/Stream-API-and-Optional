package Stream.API.Optional.Stream.API.and.Optional.service;

import Stream.API.Optional.Stream.API.and.Optional.Employee;
import Stream.API.Optional.Stream.API.and.Optional.exception.EmployeeAlreadyAddedException;
import Stream.API.Optional.Stream.API.and.Optional.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;



@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    private final Map<String, Employee> employees;

    public ServiceEmployeeImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(
                firstName,
                lastName,
                salary,
                departmentId);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }


    private String getKey(String firstName, String lastName) {
        return (firstName + " " + lastName).toLowerCase();
    }

}
