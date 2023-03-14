import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Network {

    private List<Node> nodes;

    public Network() {
        nodes = new ArrayList<Node>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    // computes the importance of each node in the network and sorts them in descending order
    public void computeImportance() {
        // create a map to store each node's importance (i.e., number of connections to other nodes)
        Map<Node, Integer> importance = new HashMap<Node, Integer>();

        // iterate over each node in the network
        for (Node node : nodes) {
            int connections = 0;

            // count the number of connections to other nodes (excluding self-connections)
            for (Map.Entry<Node, String> entry : node.getRelationships().entrySet()) {
                if (entry.getKey() != node) {
                    connections++;
                }
            }

            // add the node and its importance to the map
            importance.put(node, connections);
        }

        // sort the nodes in descending order of importance (i.e., number of connections)
        Collections.sort(nodes, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return importance.get(n2) - importance.get(n1);
            }
        });
    }

    // prints the network, with nodes ordered by importance (i.e., number of connections to other nodes)
    public void printNetwork() {
        for (Node node : nodes) {
            System.out.print(node.getClass().getSimpleName() + ": " + node.getName());
            Map<Node, String> relationships = node.getRelationships();
            if (!relationships.isEmpty()) {
                System.out.print(" (");
                for (Map.Entry<Node, String> entry : relationships.entrySet()) {
                    Node otherNode = entry.getKey();
                    String relationship = entry.getValue();
                    System.out.print(otherNode.getName() + " - " + relationship + ", ");
                }
                System.out.print("\b\b)"); // remove trailing comma and space
            }
            System.out.println();
        }
    }

}
