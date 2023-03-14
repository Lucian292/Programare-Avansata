import java.util.*;
// Base class for all network node
abstract class Node {

    private String name;
    private Date birthDate;
    private Map<Node, String> relationships; // maps other nodes to their relationship type

    public Node(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.relationships = new HashMap<Node, String>();
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void addRelationship(Node node, String relationship) {
        relationships.put(node, relationship);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

}