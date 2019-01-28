package com.serkaneren.hazelcast.repository;

import com.serkaneren.hazelcast.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Student repository
 *
 * @author eren
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
