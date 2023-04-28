package com.subham.controller;

import com.subham.model.Student;
import com.subham.repository.StudentRepoInterface;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller(value = "/student")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Inject
    private final StudentRepoInterface studentRepoInterface;

    @Get("/read")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Student> read(){
        logger.debug("Inside read method...");
        return studentRepoInterface.findAll();
    }

    @Post("/create")
    public Student createWithBody(@Body Student student){
        logger.debug("Inside createWithBody method...");
        logger.debug("Student class: "+student.toString());
        return studentRepoInterface.save(student);
    }

    @Post("/update")
    public Student updateWithBody(@Body Student student){
        Optional<Student> studenyByRoll = studentRepoInterface.findById(student.getRoll());

        Student entity = studenyByRoll.get();

        entity.setFirstName(student.getFirstName());
        entity.setLastName(student.getLastName());
        entity.setStandard(student.getStandard());

        return studentRepoInterface.update(entity);
    }

}
