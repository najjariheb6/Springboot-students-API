package com.najjar.students.controllers;

import com.najjar.students.models.Student;
import com.najjar.students.services.InstructorService;
import com.najjar.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/m1")
public class StudentsController {

	private final StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService, InstructorService instructorService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping(path="{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId){
        return studentService.getStudent(studentId);
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }
}
