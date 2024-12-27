package Stream.API.Optional.Stream.API.and.Optional.service;


import Stream.API.Optional.Stream.API.and.Optional.Employee;
import Stream.API.Optional.Stream.API.and.Optional.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentServiceImpl implements  DepartmentService {

    private final ServiceEmployee serviceEmployee;

    public DepartmentServiceImpl(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }


    @Override
    public Employee findEmployeeWithMaxSalary(Integer departmentId) {
        return serviceEmployee
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(Integer departmentId) {
        return serviceEmployee
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartmentSortedByNameSurname() {
        return serviceEmployee
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(groupingBy(Employee::getDepartmentId));
    }

    @Override
    public Collection<Employee> findEmployeesByDepartmentSortedByNameSurname(Integer departmentId) {
        return serviceEmployee
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(toList());
    }



    @Override
    public List<String> useFlatMapTest() {
        return List.of();
    }
}
