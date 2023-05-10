package org.example.abstractRepository;

import org.example.PersistenceUnitManager;
import org.example.entity.Album;
import org.example.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository extends AbstractRepository<Artist, Long> {

    private final EntityManager entityManager;
    public ArtistRepository() {
        super(Artist.class);
        entityManager = PersistenceUnitManager.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public List<Album> findArtistsAlbums(Long artistId) {
        TypedQuery<Album> query = entityManager.createQuery("SELECT a FROM Album a WHERE a.artist.id = :artistId", Album.class);
        query.setParameter("artistId", artistId);
        return query.getResultList();
    }
}
