package com.practice.jpamanytomany.controller;

import com.practice.jpamanytomany.entity.Course;
import com.practice.jpamanytomany.entity.Student;
import com.practice.jpamanytomany.repository.CourseRepository;
import com.practice.jpamanytomany.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/student/course")
public class StudentCourseController {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository,
                                   CourseRepository courseRepository){
        this.courseRepository=courseRepository;
        this.studentRepository=studentRepository;
    }

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/")
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student findStudent(@PathVariable long id){
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/find/{name}")
    public List<Student> findByNameContaining(@PathVariable String name){
        return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/course/{fee}")
    public List<Course> findByCourseLessThanFees(@PathVariable double fee){
        return courseRepository.findByFeesLessThan(fee);
    }
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable long id){
        studentRepository.deleteById(id);
    }
    @DeleteMapping("/course/{id}")
    public void deleteCourses(@PathVariable long id){
        courseRepository.deleteById(id);
    }

}
