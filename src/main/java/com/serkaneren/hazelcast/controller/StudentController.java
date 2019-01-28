package com.serkaneren.hazelcast.controller;

import com.serkaneren.hazelcast.model.Student;
import com.serkaneren.hazelcast.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Student controller
 *
 * @author eren
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllList();
    }

    @PostMapping
    public ResponseEntity<List<Student>> createStudentList(@RequestBody final List<Student> studentList) {
        return new ResponseEntity<>(studentService.saveStudents(studentList), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read-all-data")
    public Collection<Object> getAllData() {
        return studentService.readAllDataFromHazelcast();
    }
}
