package com.schooolmanagement.schoolmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name="student_details")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Min(3)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id= id;
//    }


    @Column(name="name")
    private String name;

    private String email;

    private String study;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private  Address address;


    @JoinColumn(name = "teacher_id" )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Teacher> teacher;



}
