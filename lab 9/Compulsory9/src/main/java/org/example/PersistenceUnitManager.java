package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUnitManager {

    private static final PersistenceUnitManager INSTANCE=new PersistenceUnitManager();
    private final EntityManagerFactory emf;

    private PersistenceUnitManager(){
        emf= Persistence.createEntityManagerFactory("Artist");
    }

    public static PersistenceUnitManager getInstance(){
        return INSTANCE;
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

}
