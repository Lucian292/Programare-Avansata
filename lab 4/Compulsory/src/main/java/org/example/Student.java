package org.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
public class Student implements Comparable<Student>{

    private String name;
    private int age;
    private Set<Project> admissibleProjects;

    public Student(String name, int age, Set<Project> admissibleProjects) {
        this.name = name;
        this.age = age;
        this.admissibleProjects = admissibleProjects;
    }

    public Student addAdmissibleProject(Project project){
        this.admissibleProjects.add(project);
        return this;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void setAdmissibleProjects(Set<Project> admissibleProjects) {
        this.admissibleProjects = admissibleProjects;
    }

    @Override
    public int compareTo(Student o) {
        return (this.getName().compareTo(o.getName()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student s = (Student) o;
        return age == s.age && Objects.equals(name, s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", admissibleProjects=" + admissibleProjects +
                '}';
    }
}
