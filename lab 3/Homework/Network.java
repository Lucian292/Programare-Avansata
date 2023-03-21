import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Network {

    // create a map to store each node's importance (i.e., number of connections to other nodes)
    Map<Node, Integer> importance = new HashMap<Node, Integer>();
    Map<Node, Integer> sortedImportance = new LinkedHashMap<>();
    private List<Node> nodes;

    public Network() {
        nodes = new ArrayList<Node>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    // computes the importance of each node in the network and sorts them in descending order
    public void computeImportance() {


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
        // sort the map in descending order of importance
        List<Map.Entry<Node, Integer>> entries = new ArrayList<>(importance.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Node, Integer>>() {
            public int compare(Map.Entry<Node, Integer> e1, Map.Entry<Node, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        // create a new LinkedHashMap to store the sorted entries
        for (Map.Entry<Node, Integer> entry : entries) {
            sortedImportance.put(entry.getKey(), entry.getValue());
        }
    }

    // prints the network, with nodes ordered by importance (i.e., number of connections to other nodes)
    public void printNetwork() {
        for (Map.Entry<Node, Integer> entry : sortedImportance.entrySet()) {
            Node node = entry.getKey();
            int importanceValue = entry.getValue();
            System.out.println("Node: " + node.getName() + ", Importance: " + importanceValue);
        }
    }
}