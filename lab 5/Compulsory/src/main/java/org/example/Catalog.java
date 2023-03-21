package org.example;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Catalog implements Serializable {

    // Numele catalogului
    private String name;

    // Lista de documente din catalog
    private List<Document> docs = new ArrayList<>();

    // Constructor implicit (fără argumente)
    public Catalog(){};

    // Constructor care primește numele catalogului
    public Catalog(String name){
        this.name=name;
    }

    // Metoda getter pentru numele catalogului
    public String getName() {
        return name;
    }

    // Metoda setter pentru numele catalogului
    public void setName(String name) {
        this.name = name;
    }

    // Metoda getter pentru lista de documente din catalog
    public List<Document> getDoc() {
        return docs;
    }

    // Metoda setter pentru lista de documente din catalog
    public void setDoc(List<Document> docs) {
        this.docs = docs;
    }

    // Adaugă un document în catalog
    public void add(Document doc) {
        docs.add(doc);
    }

    // Găsește un document din catalog după ID
    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    // Converteste catalogul intr-un String pentru afisare
    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", doc=" + docs +
                '}';
    }
}
