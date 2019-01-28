package com.serkaneren.hazelcast.service;

import com.serkaneren.hazelcast.dto.StudentDto;

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
    List<StudentDto> getAllList();

    /**
     * Save student
     *
     * @param studentDto student dto
     * @return student dto
     */
    StudentDto saveStudent(StudentDto studentDto);

    /**
     * Save list of student
     *
     * @param studentDtoList student list
     * @return list of student
     */
    List<StudentDto> saveStudents(List<StudentDto> studentDtoList);
}
