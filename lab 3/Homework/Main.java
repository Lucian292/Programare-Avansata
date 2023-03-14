import java.util.*;
import java.time.LocalDate;
    public class Main {
        public static void main(String[] args) {

            // create some people
            Person alice = new Person("Alice", new Date(1980, 1, 1));
            Person bob = new Person("Bob", new Date(1990, 1, 1));
            Programmer charlie = new Programmer("Charlie", new Date(1995, 1, 1), "Java");
            Designer diana = new Designer("Diana", new Date(1985, 1, 1), "User Experience");

            // create some companies
            Company acme = new Company("Acme Inc.", "Manufacturing");
            Company globex = new Company("Globex Corp.", "Technology");

            // add some employees to the companies
            acme.addEmployee(alice, "Manager");
            acme.addEmployee(bob, "Engineer");
            globex.addEmployee(charlie, "Developer");
            globex.addEmployee(diana, "Designer");

            // create the network and add the nodes
            Network network = new Network();
            network.addNode(alice);
            network.addNode(bob);
            network.addNode(charlie);
            network.addNode(diana);
            network.addNode(acme);
            network.addNode(globex);

            // compute and print the importance of each node in the network
            network.computeImportance();
            network.printNetwork();

        }
    }
