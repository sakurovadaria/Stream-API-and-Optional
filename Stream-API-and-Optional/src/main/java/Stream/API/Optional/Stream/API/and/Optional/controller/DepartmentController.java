package Stream.API.Optional.Stream.API.and.Optional.controller;


import Stream.API.Optional.Stream.API.and.Optional.Employee;
import Stream.API.Optional.Stream.API.and.Optional.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}/salary/max")
    public Employee findEmployeeWithMaxSalaryByDepartmentId(@PathVariable Integer departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/{departmentId}/salary/min")
    public Employee findEmployeeWithMinSalaryByDepartmentId(@PathVariable Integer departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departmentService.findEmployeesByDepartmentSortedByNameSurname();
    }

    @GetMapping(path = "/{departmentId}/employees")
    public Collection<Employee> findEmployees(@PathVariable Integer departmentId) {
        return departmentService.findEmployeesByDepartmentSortedByNameSurname(departmentId);
    }

}
