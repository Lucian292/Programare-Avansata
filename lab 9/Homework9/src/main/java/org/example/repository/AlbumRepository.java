package org.example.repository;

import org.example.PersistenceUnitManager;
import org.example.entity.Album;
import org.example.entity.Artist;
import org.example.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository {
    private final EntityManager entityManager;

    public AlbumRepository(EntityManagerFactory emf) {
        entityManager = PersistenceUnitManager.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public void create(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
    }

    public Album findById(Long id) {
        return entityManager.find(Album.class, id);
    }

    public void update(Album album) {
        entityManager.getTransaction().begin();
        entityManager.merge(album);
        entityManager.getTransaction().commit();
    }

    public void delete(Album album) {
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();
    }
    public List<Song> findAlbumsSongs(Long albumId) {
        TypedQuery<Song> query = entityManager.createQuery(
                "SELECT s FROM Song s WHERE s.idAlbum.id = :albumId", Song.class);
        query.setParameter("albumId", albumId);
        return query.getResultList();
    }

    public List<Album> findByName(String pattern) {
        TypedQuery<Album> query = entityManager.createNamedQuery("Album.findByName", Album.class);
        query.setParameter("name","%" + pattern + "%");
        return query.getResultList();
    }
}
