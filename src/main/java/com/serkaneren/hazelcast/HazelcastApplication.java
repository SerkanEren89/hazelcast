package com.serkaneren.hazelcast;

import com.serkaneren.hazelcast.dto.StudentDto;
import com.serkaneren.hazelcast.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class HazelcastApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HazelcastApplication.class, args);
        StudentService studentService = context.getBean(StudentService.class);

        List<StudentDto> studentDtoList = new ArrayList<>();

        StudentDto student1Dto = new StudentDto();
        student1Dto.setFirstName("serkan");
        student1Dto.setLastName("eren");
        student1Dto.setStudentNumber(12345L);
        studentDtoList.add(student1Dto);

        StudentDto student2Dto = new StudentDto();
        student2Dto.setFirstName("test");
        student2Dto.setLastName("test");
        student2Dto.setStudentNumber(123L);
        studentDtoList.add(student2Dto);

        studentService.saveStudents(studentDtoList);

        List<StudentDto> allList = studentService.getAllList();
        for (StudentDto studentDto : allList) {
            System.out.println(studentDto.toString());
        }

    }

}

