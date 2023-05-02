package org.example.repository;

import org.example.PersistenceUnitManager;
import org.example.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {
    private final EntityManager entityManager;

    public ArtistRepository(EntityManagerFactory emf){
        entityManager = PersistenceUnitManager.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public void create(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
    }

    public Artist findById(Long id){
        return entityManager.find(Artist.class, id);
    }
    public List<Artist> findByName(String pattern) {
        TypedQuery<Artist> query = entityManager.createNamedQuery("Artist.findByName", Artist.class);
        query.setParameter("name","%" + pattern + "%");
        return query.getResultList();
    }
}
