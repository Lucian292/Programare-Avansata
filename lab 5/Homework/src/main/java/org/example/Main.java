package org.example;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class used to test the methods and classes implemented
 */

public class Main {
    public static void main(String[] args) throws InvalidCatalogException, FileNotFoundException {
        Catalog catalog = new Catalog("My Catalog");

        // create objects
        Document doc1 = new Document("1", "article1.txt", "D:\\Universitate\\programare avansata\\Programare-Avansata\\lab 5\\Homework\\article1.txt");
        doc1.addTag("author", "Author1");
        doc1.addTag("year", "2021");
        doc1.addTag("category", "Science");

        Document doc2 = new Document("2", "book1.txt", "D:\\Universitate\\programare avansata\\Programare-Avansata\\lab 5\\Homework\\book1.txt");
        doc2.addTag("author", "Author2");
        doc2.addTag("year", "2020");
        doc2.addTag("category", "Literature");

        Document doc3 = new Document("3", "book2.txt", "D:\\Universitate\\programare avansata\\Programare-Avansata\\lab 5\\Homework\\book2.txt");
        doc3.addTag("author", "Lucian");
        doc3.addTag("year", "2023");
        doc3.addTag("category", "SF");


        // create commands
        String path = new File("catalog.json").getAbsolutePath();
        Command addCommand = new AddCommand(catalog, new Document[]{doc1, doc2, doc3});
        Command listCommand = new ListCommand(catalog);
        Command viewCommand = new ViewCommand(new Document[]{doc1, doc2, doc3});
        Command reportCommand = new ReportCommand(catalog, "D:\\Universitate\\programare avansata\\Programare-Avansata\\lab 5\\Homework\\catalog.html");
        Command saveCommand = new SaveCommand(catalog, path);
        Command loadCommand = new LoadCommand(path);

        // and executing them
        addCommand.execute();
        saveCommand.execute();
        listCommand.execute();
        viewCommand.execute();
        reportCommand.execute();
        Catalog loadCat = loadCommand.execute();
        System.out.println("verificare " + loadCat);
    }
}