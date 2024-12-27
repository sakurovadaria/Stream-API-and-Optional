package Stream.API.Optional.Stream.API.and.Optional.service;

import Stream.API.Optional.Stream.API.and.Optional.Employee;
import Stream.API.Optional.Stream.API.and.Optional.exception.EmployeeAlreadyAddedException;
import Stream.API.Optional.Stream.API.and.Optional.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.InvalidNameException;
import java.util.*;

import static org.apache.tomcat.util.http.parser.HttpParser.isAlpha;


@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    private final Map<String, Employee> employees;

    public ServiceEmployeeImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, Integer salary, Integer departmentId) {
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
    public Employee remove(String firstName, String lastName,Integer salary, Integer departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, Integer salary, Integer departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }



}
