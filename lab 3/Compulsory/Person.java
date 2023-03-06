import java.util.ArrayList;
import java.util.List;

public class Person implements Node, Comparable<Person> {
    private String name;
    private List<Person> friends;
    private Employment employment;
    private String position;

    public Person(String name) {
        this.name = name;
        this.friends = new ArrayList<>();
    }

    public void addFriend(Person person) {
        friends.add(person);
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setEmployment(Company company, String position) {
        this.employment = new Employment(company, position);
        this.position = position;
        company.addEmployee(this, position);
    }


    public Company getEmployer() {
        if (employment == null) {
            return null;
        }
        return employment.getCompany();
    }

    public String getPosition() {
        if (position == null) {
            return "neangajat";
        } else {
            return position;
        }
    }

    public String getPosition(Person person) {
        if (person.equals(this)) {
            return getPosition();
        } else {
            return null;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person other) {
        return name.compareTo(other.getName());
    }

    @Override
    public String getNodeName() {
        return name;
    }
}
