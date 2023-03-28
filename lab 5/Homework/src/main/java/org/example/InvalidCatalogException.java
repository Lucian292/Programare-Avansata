package org.example;

/**
 * InvalidCatalogException - extends Exception and is used to mark
 * that a given catalog file is invalid.
 */
public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    }
}