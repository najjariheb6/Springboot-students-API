package com.najjar.students.repositories;


import com.najjar.students.models.Instructor;
import com.najjar.students.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    @Query("select i from Instructor i where i.email=?1")
    Optional<Instructor> findInstructorByEmail(String email);
}