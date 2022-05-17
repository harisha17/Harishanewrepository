package com.schooolmanagement.schoolmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="Teacher_Details")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int t_id;
    private String name;
    private String email;
    private Long phone_number;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

}
