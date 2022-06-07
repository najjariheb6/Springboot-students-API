package com.najjar.students.services;

import com.najjar.students.models.Instructor;
import com.najjar.students.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> getInstructors(){
        return instructorRepository.findAll();
    }


    public void addNewInstructor(Instructor instructor) {
        Optional<Instructor> instructorOptional = instructorRepository.findInstructorByEmail(instructor.getEmail());
        if(instructorOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        instructorRepository.save(instructor);
    }

    public void deleteInstructor(Long instructorId) {
        boolean exists = instructorRepository.existsById(instructorId);
        if(!exists){
            throw new IllegalStateException("Instructor with id: "+instructorId+" does not exists !");
        }
        instructorRepository.deleteById(instructorId);
    }
    @Transactional
    public void updateInstructor(Long instructorId, String name, String email) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new IllegalStateException(
                        "Instructor with id: "+instructorId+" does not exists !"
                ));
        if(name != null && name.length()!=0 && !Objects.equals(name, instructor.getName())){
            instructor.setName(name);
        }
        if(email != null && email.length()  !=0 && !Objects.equals(email, instructor.getEmail())){
            Optional<Instructor> instructorOptional = instructorRepository.findInstructorByEmail(instructor.getEmail());
            if(instructorOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            instructor.setEmail(email);
        }
    }
}
