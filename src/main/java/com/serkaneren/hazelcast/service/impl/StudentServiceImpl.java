package com.serkaneren.hazelcast.service.impl;

import com.hazelcast.core.HazelcastInstance;
import com.serkaneren.hazelcast.model.Student;
import com.serkaneren.hazelcast.repository.StudentRepository;
import com.serkaneren.hazelcast.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Student service implementation
 *
 * @author eren
 */
@Service
@CacheConfig(cacheNames = "students")
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final HazelcastInstance hazelcastInstance;

    @Autowired
    public StudentServiceImpl(HazelcastInstance hazelcastInstance,
                              StudentRepository studentRepository) {
        this.hazelcastInstance = hazelcastInstance;
        this.studentRepository = studentRepository;
    }

    @Cacheable
    @Override
    public List<Student> getAllList() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> saveStudents(List<Student> studentList) {
        return studentRepository.saveAll(studentList);
    }

    @Override
    public Collection<Object> readAllDataFromHazelcast() {
        return hazelcastInstance.getMap("students").values();
    }
}
