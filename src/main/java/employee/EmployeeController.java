package employee;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Collection<Employee> employees() {
        // return employeeRepository.findAll();
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        // Optional<Employee> employee = employeeRepository.findById(id);
        
        // return employee.map(response -> ResponseEntity.ok().body(response))
        //         .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        return null;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) throws Exception {
        Employee result = employeeService.saveEmployee(employee);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {
        
        // Employee result = employeeRepository.save(employee);
        
        // return ResponseEntity.ok().body(result);
        return null;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        // employeeRepository.deleteById(id);
        
        // return ResponseEntity.ok().build();
        return null;
    }

}