package com.najjar.students.controllers;

import com.najjar.students.models.Instructor;
import com.najjar.students.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/m2")
public class InstructorController {
    private final InstructorService instructorService;
    
    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
   
    @GetMapping
    public List<Instructor> getInstructors(){
        return instructorService.getInstructors();
    }
    @PostMapping
    public void registerNewInstructor(@RequestBody Instructor instructor){
        instructorService.addNewInstructor(instructor);
    }
    @DeleteMapping(path="{instructorId}")
    public void deleteInstructor(@PathVariable("instructorId") Long studentId){
        instructorService.deleteInstructor(studentId);
    }
    @PutMapping(path="{instructorId}")
    public void updateInstructor(
            @PathVariable("instructorId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        instructorService.updateInstructor(studentId, name, email);
    }
}
