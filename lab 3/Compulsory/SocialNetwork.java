import java.util.*;

public class SocialNetwork {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Person ana = new Person("Ana");
        Person ion = new Person("Ion");
        Company amazon = new Company("Amazon");
        Company bitdefender = new Company("Bitdefender");

        ana.addFriend(ion);    // Ana este prietena cu Ion
        ion.addFriend(ana);
        ana.setEmployment(amazon, "Programator");    // Ana lucreaza la Amazon ca Programator
        amazon.addEmployee(ana, "Programator");
        ion.setEmployment(bitdefender, "Designer");   // Ion lucreaza la Bitdefender ca Designer
        bitdefender.addEmployee(ion, "Designer");

        nodes.add(ana);
        nodes.add(ion);
        nodes.add(amazon);
        nodes.add(bitdefender);

        for (Node node : nodes) {
            if (node instanceof Person) {
                Person person = (Person) node;
                List<Person> friends = person.getFriends();
                if (!friends.isEmpty()) {
                    System.out.println(person.getName() + " este prieten cu:");
                    for (Person friend : friends) {
                        System.out.println("- " + friend.getName());
                    }
                }
                Company employer = person.getEmployer();
                if (employer != null) {
                    System.out.println(person.getName() + " lucreaza la " + employer.getName() + " cu funtia de " + person.getPosition());
                }
            } else if (node instanceof Company) {
                Company company = (Company) node;
                List<Person> employees = company.getEmployees();
                if (!employees.isEmpty()) {
                    System.out.println(company.getName() + " are urmatorii angajati:");
                    for (Person employee : employees) {
                        System.out.println("- " + employee.getName() + " (" + employee.getPosition() + ")");
                    }
                }
            }
        }
    }
}
