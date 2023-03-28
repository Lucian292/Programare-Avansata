package org.example;

import java.io.FileNotFoundException;

/**
 * Interface Command - is implemented by all the created commands
 */
public interface Command {
    Catalog execute() throws InvalidCatalogException, FileNotFoundException;
}
