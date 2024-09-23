package com.practice.jpamanytomany.repository;

import com.practice.jpamanytomany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByFeesLessThan(double fee);
}
