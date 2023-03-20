package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // cream TreeSet de Project folosind stream-uri, sortam(se face automat deoarce e TreeSet) stream-ul obtinut si il convertim inapoi in TreeSet.
        TreeSet<Project> projects = Stream.of(
                        new Project("P0", "12/12/12"),
                        new Project("P1", "15/12/12"),
                        new Project("P2", "15/11/12"))
                .sorted().collect(Collectors.toCollection(TreeSet::new));

        //afisam lista folosind un forEach si referinta a metodei println.
        projects.forEach(System.out::println);

        //cream LinkedList de Student folosind stream-uri, sortam stream-ul obtinut si il convertim inapoi in LinkedList.
        LinkedList<Student> students = Stream.of(
                        new Student("S0", 20, projects.stream().limit(3).collect(Collectors.toSet())),
                        new Student("S1", 21, projects.stream().limit(2).collect(Collectors.toSet())),
                        new Student("S2", 19, projects.stream().limit(1).collect(Collectors.toSet())))
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));
        //afisam lista folosind un forEach si referinta a metodei println.
        students.forEach(System.out::println);
    }
}