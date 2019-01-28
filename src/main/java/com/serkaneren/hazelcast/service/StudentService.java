package com.serkaneren.hazelcast.service;

import com.serkaneren.hazelcast.model.Student;

import java.util.Collection;
import java.util.List;

/**
 * Student service
 *
 * @author eren
 */
public interface StudentService {


    /**
     * Get all list
     *
     * @return get list of student
     */
    List<Student> getAllList();

    /**
     * Save list of student
     *
     * @param studentList student list
     * @return list of student
     */
    List<Student> saveStudents(List<Student> studentList);

    /**
     * Get cached data
     *
     * @return cached data
     */
    Collection<Object> readAllDataFromHazelcast();
}
