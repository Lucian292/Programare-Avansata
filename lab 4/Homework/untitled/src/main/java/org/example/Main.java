package org.example;
import com.github.javafaker.Faker;
import org.example.objects.Problem;
import org.example.objects.Project;
import org.example.objects.Student;

import java.util.*;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var listStudents = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        var listProjects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);

        List<Student> students = new LinkedList<>();
        for (Student s : listStudents) {
            students.add(s);
        }

        Set<Project> projects = new TreeSet<>();
        for (Project p : listProjects) {
            projects.add(p);
        }

        List<Project> projectList = new ArrayList<>(projects);
        List<Project> projectList1 = new ArrayList<>();
        projectList1.add(projectList.get(0));
        projectList1.add(projectList.get(1));

        List<Project> projectList2 = new ArrayList<>();
        projectList2.add(projectList.get(0));

        Problem.addList(students.get(0), projectList);
        Problem.addList(students.get(1), projectList1);
        Problem.addList(students.get(2), projectList2);
        System.out.println(Problem.getPrefMap());

        Problem.Greedy();
        System.out.println(Problem.getGreedyMap());


        Faker faker = new Faker();
        List<Student> fakeStudents = IntStream.rangeClosed(0, 10)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toList();

        List<Project> fakeProjects = IntStream.rangeClosed(0, 5)
                .mapToObj(i -> new Project(faker.company().name()))
                .toList();

        System.out.println(fakeProjects);
        System.out.println(fakeStudents);
    }
}
//        // cream TreeSet de Project folosind stream-uri, sortam(se face automat deoarce e TreeSet) stream-ul obtinut si il convertim inapoi in TreeSet.
//        TreeSet<Project> projects = Stream.of(
//                        new Project("P0", "12/12/12"),
//                        new Project("P1", "15/12/12"),
//                        new Project("P2", "15/11/12"))
//                .sorted().collect(Collectors.toCollection(TreeSet::new));
//
//        //afisam lista folosind un forEach si referinta a metodei println.
//        projects.forEach(System.out::println);
//
//        //cream LinkedList de Student folosind stream-uri, sortam stream-ul obtinut si il convertim inapoi in LinkedList.
//        LinkedList<Student> students = Stream.of(
//                        new Student("S0", 20, projects.stream().limit(3).collect(Collectors.toSet())),
//                        new Student("S1", 21, projects.stream().limit(2).collect(Collectors.toSet())),
//                        new Student("S2", 19, projects.stream().limit(1).collect(Collectors.toSet())))
//                .sorted()
//                .collect(Collectors.toCollection(LinkedList::new));
//        //afisam lista folosind un forEach si referinta a metodei println.
//        students.forEach(System.out::println);
//    }