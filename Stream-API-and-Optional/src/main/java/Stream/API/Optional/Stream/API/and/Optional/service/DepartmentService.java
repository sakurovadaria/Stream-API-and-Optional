package Stream.API.Optional.Stream.API.and.Optional.service;

import Stream.API.Optional.Stream.API.and.Optional.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(Integer departmentId);

    Employee findEmployeeWithMinSalary(Integer departmentId);

    Map<Integer, List<Employee>> findEmployeesByDepartmentSortedByNameSurname();

    Collection<Employee> findEmployeesByDepartmentSortedByNameSurname(Integer departmentId);

    List<String> useFlatMapTest();
}
