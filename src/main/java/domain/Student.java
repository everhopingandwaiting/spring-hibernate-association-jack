package domain;

/**
 * Created by john on 15-9-28.
 */

import javax.persistence.*;
import java.io.Serializable;


import domain.*;


import java.util.List;


import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "STUDENTS")

public class Student implements Serializable {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int ID;
    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NUMBER_ID")
    private Number number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLASS_ID")
    private Class aClass;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "STUDENTS_COURSES", joinColumns = @JoinColumn(name =

            "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name =
            "COURSE_ID"))
    private List<Course> courses;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(domain.Number number) {
        this.number = number;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(domain.Class aClass) {
        this.aClass = aClass;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
