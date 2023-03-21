package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CatalogUtil {

    /**
     * Salvează catalogul dat în fișierul specificat.
     *
     * @param catalog catalogul de salvat
     * @param path calea către fișierul în care se salvează catalogul
     * @throws IOException dacă există o problemă la scrierea în fișier
     */
    public static void save(Catalog catalog, String path) throws IOException {
        // Inițializează un obiect ObjectMapper pentru a serializa catalogul în JSON
        ObjectMapper objectMapper = new ObjectMapper();
        // Scrie catalogul în fișierul specificat
        objectMapper.writeValue(new File(path), catalog);
    }

    /**
     * Încarcă un catalog din fișierul specificat.
     *
     * @param path calea către fișierul din care se încarcă catalogul
     * @return catalogul încărcat
     * @throws IOException dacă există o problemă la citirea din fișier
     */
    public static Catalog load(String path) throws IOException {
        // Inițializează un obiect ObjectMapper pentru a deserializa catalogul din JSON
        ObjectMapper objectMapper = new ObjectMapper();
        // Încarcă catalogul din fișierul specificat și îl returnează
        return objectMapper.readValue(new File(path), Catalog.class);
    }
}
