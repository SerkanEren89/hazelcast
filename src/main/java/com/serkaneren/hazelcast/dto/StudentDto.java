package com.serkaneren.hazelcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author eren
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto implements Serializable {

    private String firstName;

    private String lastName;

    private Long studentNumber;
}
