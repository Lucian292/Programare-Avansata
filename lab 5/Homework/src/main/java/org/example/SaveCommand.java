package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Class SaveCommand - saves the catalog to an external file in JSON format
 */

public class SaveCommand implements Command{
    private final Catalog catalog;
    private final String fileName;

    public SaveCommand(Catalog catalog,String fileName) {
        this.catalog = catalog;
        this.fileName=fileName;
    }
    public Catalog execute(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(fileName), catalog); // params: file and object
        } catch (IOException e) {
            System.err.println("Error saving catalog to file: " + e.getMessage());
        }
        return null;
    }
}
