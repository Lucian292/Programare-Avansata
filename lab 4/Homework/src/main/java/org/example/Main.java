package org.example;
import com.github.javafaker.Faker;
import org.example.objects.MatchingProblem;
import org.example.objects.Project;
import org.example.objects.Student;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //genereaza 3 studenti
        var listStudents = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        //genereaza 3 proiecte
        var listProjects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);
        //pune studentii intr-un linkedlist
        List<Student> students = new LinkedList<>();
        for(Student s: listStudents){
            students.add(s);
        }
        //pune poroiectele in treeset
        Set<Project> projects = new TreeSet<>();
        for(Project p: listProjects){
            projects.add(p);
        }

        List<Project> projectList = new ArrayList<>(projects); //primului student i se atribui in preferinte toate problemele disponibile
        List<Project> projectList1 = new ArrayList<>();//genereaza maparea studentului 1
        projectList1.add(projectList.get(0));//adauga in lista problema 0 si 1
        projectList1.add(projectList.get(1));

        List<Project> projectList2 = new ArrayList<>();//genereaza maparea studentului 2
        projectList2.add(projectList.get(0));//adauga in lista problema 0

        MatchingProblem.addList(students.get(0),projectList); //adauga informatia in matchingProblem
        MatchingProblem.addList(students.get(1),projectList1);
        MatchingProblem.addList(students.get(2),projectList2);
        System.out.println(MatchingProblem.getPrefMap()); //afisazi informatia cum e stocata

        MatchingProblem.Greedy();//apeleaza algoritmul greedy
        System.out.println(MatchingProblem.getGreedyMap()); //afiseaza din matchingProblem informatia dupa greedy


        //lista de studenti unde sunt 10 nume
        Faker faker = new Faker();
        List<Student> fakeStudents = IntStream.rangeClosed(0, 10)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toList();
        //lista de 5 proiecte si nume generate
        List<Project> fakeProjects = IntStream.rangeClosed(0, 5)
                .mapToObj(i -> new Project(faker.company().name()))
                .toList();

        System.out.println(fakeProjects);
        System.out.println(fakeStudents);

    }
}