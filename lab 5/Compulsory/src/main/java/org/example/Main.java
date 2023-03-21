package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("My Catalog");

        Document doc1 = new Document("1", "Document 1", "doc1.txt");
        doc1.addTag("author", "Mihai Creanga");
        doc1.addTag("year", 2022);

        Document doc2 = new Document("2", "Document 2", "doc2.html");
        doc2.addTag("author", "Ion Eminescu");
        doc2.addTag("year", 2023);

        catalog.add(doc1);
        catalog.add(doc2);

        CatalogUtil.save(catalog, "./catalog.json");

        Catalog loadedCatalog = CatalogUtil.load("./catalog.json");
        System.out.println(loadedCatalog);
    }
}
