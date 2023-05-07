package org.example.repository;

import org.example.PersistenceUnitManager;
import org.example.entity.Album;
import org.example.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class SongRepository {
    private final EntityManager entityManager;

    public SongRepository(EntityManagerFactory emf) {
        entityManager = PersistenceUnitManager.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public void create(Song song) {
        entityManager.getTransaction().begin();
        entityManager.persist(song);
        entityManager.getTransaction().commit();
    }

    public Song findById(Long id) {
        return entityManager.find(Song.class, id);
    }

    public void update(Song song) {
        entityManager.getTransaction().begin();
        entityManager.merge(song);
        entityManager.getTransaction().commit();
    }

    public void delete(Song song) {
        entityManager.getTransaction().begin();
        entityManager.remove(song);
        entityManager.getTransaction().commit();
    }

    public List<Song> findByName(String pattern) {
        TypedQuery<Song> query = entityManager.createNamedQuery("Song.findByName", Song.class);
        query.setParameter("name","%" + pattern + "%");
        return query.getResultList();
    }
}
