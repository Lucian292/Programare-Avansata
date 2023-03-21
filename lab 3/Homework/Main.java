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
        Company camline = new Company("CamLine", "Manufacturing");
        Company vitesco = new Company("Vitesco", "Technology");

        // create the network and add the nodes
        Network network = new Network();
        network.addNode(alice);
        network.addNode(bob);
        network.addNode(charlie);
        network.addNode(diana);
        network.addNode(camline);
        network.addNode(vitesco);

        //adaugam relatii intre persoane
        alice.addRelationship(bob, "frind");
        alice.addRelationship(charlie, "husbands");
        diana.addRelationship(charlie, "coworkers");

        // add some employees to the companies
        camline.addEmployee(alice, "Manager");
        camline.addEmployee(bob, "Engineer");
        vitesco.addEmployee(charlie, "Developer");
        vitesco.addEmployee(diana, "Designer");

        // compute and print the importance of each node in the network
        network.computeImportance();
        network.printNetwork();

    }
}