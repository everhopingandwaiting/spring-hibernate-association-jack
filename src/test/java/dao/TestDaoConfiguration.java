package dao;


import domain.Class;
import domain.Course;
import domain.Number;
import domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 15-9-29.
 */
@Configuration
public class TestDaoConfiguration {
    @Bean
    public Class aClass1() {
        Class aClass1 = new Class();
        aClass1.setName("class one ");
        aClass1.setStudents(students());
        return aClass1;
    }

    @Bean
    public Student student1() {
        Student student1 = new Student();
        student1.setName("stu one ");

        student1.setaClass(aClass1());
        student1.setCourses(courses());
        student1.setNumber(number1());
        return student1;
    }
    @Bean
    public Student student2() {
        Student student = new Student();
        student.setName("stu two ");

        student.setaClass(aClass1());
        student.setCourses(courses());

        student.setNumber(number2());

        return student;
    }

    @Bean
    public Course course1(){
        Course course = new Course();
        course.setName("course one");
        course.setStudents(students());

        return course;
    }
        @Bean
        public Course course2(){
            Course course = new Course();
            course.setName("course two");
            course.setStudents(students());
            return course;
        }

    @Bean
    public List<Course> courses() {
        List<Course> courses = new ArrayList<>();
        courses.add(course1());
        courses.add(course2());
        return courses;
    }
    @Bean
    public Number number1() {
        Number number = new Number();
        number.setPrefix("1234567");
        number.setSuffix("890");
        number.setStudent(student1());
        return number;
    }

    @Bean
    public Number number2(){
        Number number = new Number();
        number.setPrefix("7654321");
        number.setSuffix("098");
        number.setStudent(student2());
        return number;
    }



    @Bean
    public List<Student> students() {
        List<Student> students = new ArrayList<>();
        students.add(student1());
        students.add(student2());
        return students;
    }
}
