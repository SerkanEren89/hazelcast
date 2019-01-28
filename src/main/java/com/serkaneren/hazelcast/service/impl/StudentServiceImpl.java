package com.serkaneren.hazelcast.service.impl;

import com.serkaneren.hazelcast.dto.StudentDto;
import com.serkaneren.hazelcast.mapper.StudentMapper;
import com.serkaneren.hazelcast.model.Student;
import com.serkaneren.hazelcast.repository.StudentRepository;
import com.serkaneren.hazelcast.service.StudentService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Student service implementation
 *
 * @author eren
 */
@Service
@CacheConfig(cacheNames = "students")
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;


    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Cacheable
    @Override
    public List<StudentDto> getAllList() {
        return studentRepository.findAll()
                .stream().map(studentMapper::toStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = studentRepository.save(studentMapper.toStudent(studentDto));
        return studentMapper.toStudentDto(student);
    }

    @Override
    public List<StudentDto> saveStudents(List<StudentDto> studentDtoList) {
        List<Student> studentList = studentDtoList.stream().map(studentMapper::toStudent).collect(Collectors.toList());
        return studentRepository.saveAll(studentList)
                .stream().map(studentMapper::toStudentDto).collect(Collectors.toList());
    }
}
