package com.najjar.students.controllers;

import com.najjar.students.models.Student;
import com.najjar.students.repositories.StudentRepository;
import com.najjar.students.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentsController {

	private final StudentServices studentServices;

    @Autowired
    public StudentsController(StudentServices studentServices) {

        this.studentServices = studentServices;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentServices.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentServices.addNewStudent(student);
    }
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentServices.deleteStudent(studentId);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentServices.updateStudent(studentId, name, email);
    }
}
