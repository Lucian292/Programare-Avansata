package org.example;

import javax.persistence.EntityManager;
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

    public class EntityManagerFactoryProvider {
        private static final String PERSISTENCE_UNIT_NAME = "Artist";

        private static EntityManagerFactory entityManagerFactory;

        public static EntityManager getEntityManager() {
            if (entityManagerFactory == null) {
                entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            }
            return entityManagerFactory.createEntityManager();
        }
    }

}
