package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Class LoadCommand - loads a catalog from a given file
 */
public class LoadCommand implements Command {
    String fileName;

    public LoadCommand(String fileName) {
        this.fileName = fileName;
    }

    public Catalog execute() throws InvalidCatalogException {

        ObjectMapper mapper = new ObjectMapper();
        try {
            Catalog catalog = mapper.readValue(new File(this.fileName), Catalog.class);
            return catalog;
        } catch (IOException e) {
            throw new InvalidCatalogException(e);
        }

    }
}
