package com.mourid.contollers;

import com.mourid.entities.Employee;
import com.mourid.entities.Service;
import com.mourid.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByID (@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        if(employee == null)
            return new ResponseEntity<Object>("employee n'existe pas ", HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok(employee);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        employee.setId(0L);
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employee newsEmployee) {

        Employee oldEmployee = employeeService.findById(id);
        if (oldEmployee == null) {
            return new ResponseEntity<Object>("Employee avec id" + id + "nexiste pas ", HttpStatus.BAD_REQUEST);

        } else {
            newsEmployee.setId(id);
            return ResponseEntity.ok(employeeService.update(newsEmployee));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {

        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<Object>("Employee avec id" + id + "nexiste pas ", HttpStatus.BAD_REQUEST);

        } else {
            employeeService.delete(employee);
            return ResponseEntity.ok("Employee avec id " + id + " est supprime");
        }
    }



}
