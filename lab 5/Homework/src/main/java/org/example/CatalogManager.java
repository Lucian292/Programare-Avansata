package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Class CatalogManager - implements a few methods to use with objects
 * of type Catalog - save, load, add and toString.
 * Has an attribute catalog of type Catalog.
 */
public class CatalogManager {
    private static Catalog catalog;

    public CatalogManager(String catalogName) {

    }

    public static void save(Catalog catalog, String file) { //saves a catalog to a file given as input
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(file), catalog); // params: file and object
        } catch (IOException e) {
            System.err.println("Error saving catalog to file: " + e.getMessage());
        }
    }

    public static Catalog load(String file) throws InvalidCatalogException { //loads a catalog from a given file
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(file), Catalog.class);
        } catch (IOException e) {
            throw new InvalidCatalogException(e);
        }
    }

    public void add(Document document) { //adds a document to the catalog
        catalog.add(document);
    }

    public Catalog getCatalog() {
        return catalog;
    }

    @Override
    public String toString() {
        return "CatalogManager{" +
                "catalog=" + catalog +
                '}';
    }
}
