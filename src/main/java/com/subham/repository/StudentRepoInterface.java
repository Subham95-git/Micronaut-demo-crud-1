package com.subham.repository;

import com.subham.model.Student;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface StudentRepoInterface extends CrudRepository<Student, Integer> {
}
