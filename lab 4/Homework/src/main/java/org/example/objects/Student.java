package org.example.objects;
import java.util.*;
public class Student implements Comparable<Student> {
    private String name;
    private int preferences;
    private List<Project> admissibleProjects;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.getName());
    }

    public String toString() {
        return "Student: " + name ;
    }
}
