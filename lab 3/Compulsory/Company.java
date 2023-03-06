import java.util.*;

public class Company implements Node, Comparable<Company> {
    private final String name;
    private List<Person> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String getNodeName() {
        return name;
    }

    public void addEmployee(Person person) {
        if (!employees.contains(person)) {
            employees.add(person);
            person.setEmployment(this, null);
        }
    }

    public List<Person> getEmployees() {
        return new ArrayList<>(employees);
    }


    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }
}
