package com.practice.jpamanytomany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name = "STUDENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for MySQL
    private Long id;
    private String name;
    private int age;
    private String dept;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE", joinColumns = {
            @JoinColumn(name ="student_id", referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id")
    })
    private Set<Course> courses;
}
