package org.example;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class AddCommand - used to add an array of documents to the specified catalog
 */
public class AddCommand implements Command {
    private final Catalog catalog;
    private final Document[] documents;

    public AddCommand(Catalog catalog, Document[] documents) {
        this.catalog = catalog;
        this.documents = documents;
    }

    public Catalog execute() throws FileNotFoundException {
        for (Document document : documents) {
            File file = new File(document.getLocation());
            if (!file.exists()) {
                throw new FileNotFoundException("File not found: " + document.getLocation());
            } else {
                catalog.add(document);
                System.out.println("Document " + document.getTitle() + " added to the catalog");
            }
        }
        return null;
    }

}
