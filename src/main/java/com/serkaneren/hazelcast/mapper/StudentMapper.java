package com.serkaneren.hazelcast.mapper;

import com.serkaneren.hazelcast.dto.StudentDto;
import com.serkaneren.hazelcast.model.Student;
import org.mapstruct.Mapper;

/**
 * Student mapper
 *
 * @author eren
 */
@Mapper
public interface StudentMapper {

    StudentDto toStudentDto(Student student);

    Student toStudent(StudentDto student);
}
