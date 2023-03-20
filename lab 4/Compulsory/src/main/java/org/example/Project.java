package org.example;

import java.util.Objects;
public class Project implements Comparable<Project> {
    private String name;
    private String presentationDate;

    public Project(String name, String presentationDate) {
        this.name = name;
        this.presentationDate = presentationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresentationDate() {
        return presentationDate;
    }

    public void setPresentationDate(String presentationDate) {
        this.presentationDate = presentationDate;
    }

    @Override
    public int compareTo(Project o) {
        return (this.getName().compareTo(o.getName()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project p = (Project) o;
        return Objects.equals(name, p.name) && Objects.equals(presentationDate, p.presentationDate);
    }

    /**
     * @return an int representing the hash-ed value of the members.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, presentationDate);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", presentationDate='" + presentationDate + '\'' +
                '}';
    }
}
