package Stream.API.Optional.Stream.API.and.Optional.service;

import Stream.API.Optional.Stream.API.and.Optional.Employee;

import java.util.Collection;

public interface ServiceEmployee {
    Employee add(String firstName, String lastName, Integer salary, Integer departmentId);
    Employee remove(String firstName, String lastName, Integer salary, Integer departmentId);
    Employee find(String firstName, String lastName, Integer salary, Integer departmentId);

    Collection<Employee> findAll();

}
