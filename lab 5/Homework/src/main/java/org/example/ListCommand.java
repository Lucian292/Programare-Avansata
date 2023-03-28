package org.example;

/**
 * Class ListCommand - used to print the documents from a given catalog
 */
public class ListCommand implements Command{
    private final Catalog catalog;

    public ListCommand(Catalog catalog){
        this.catalog=catalog;
    }
    public Catalog execute(){
        System.out.println("Documents: ");
        for(Document doc:catalog.getDocs())
            System.out.println(doc);
        return null;
    }

}
