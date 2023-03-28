package org.example;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Catalog - has a name and an array of documents.
 * Has a method load that loads a specific catalog from a specified file
 * using ObjectInputStream
 */

public class Catalog implements Serializable {
    private String name;
    private final List<Document> docs = new ArrayList<>();

    // constructors
    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    // function to add a file/document to a list of documents
    public void add(Document doc) {
        File file = new File(doc.getLocation());
        if (!file.exists()) {
            System.out.println("File not found: " + doc.getLocation());
        } else
            docs.add(doc);
    }

    public List<Document> getDocs() {
        return docs;
    }

    public String getName() {
        return name;
    }

    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }


}