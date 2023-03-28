package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * Class ViewCommand - shows the document's location using the native OS system application
 */
public class ViewCommand implements Command {
    private final Document[] documents;

    public ViewCommand(Document[] doc) {
        this.documents=doc;
    }

    public Catalog execute() {
        for(Document d:documents) {
            String path = d.getLocation();
            try {
                Desktop.getDesktop().open(new File(path));
            } catch (IOException e) {
                System.out.println("Error opening document " + e.getMessage());
            }
        }
        return null;
    }
}
