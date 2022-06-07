package com.najjar.students.configurations;

import com.najjar.students.models.Student;
import com.najjar.students.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

//@Configuration
public class studentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student john = new Student(
                    1L,
                    "John",
                    "johnDoe@gmail.com",
                    LocalDate.of(1978,06,03),
                    "021123"
            );
            Student alex = new Student(
                    2L,
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(1995,10,25),
                    "036225"
            );
            repository.saveAll(List.of(john,alex));
        };
    }
}
