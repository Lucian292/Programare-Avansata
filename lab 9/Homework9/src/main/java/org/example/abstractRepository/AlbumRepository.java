package org.example.abstractRepository;

import org.example.PersistenceUnitManager;
import org.example.entity.Album;
import org.example.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository extends AbstractRepository<Album, Long> {
    private final EntityManager entityManager;
    public AlbumRepository() {
        super(Album.class);
        entityManager = PersistenceUnitManager.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public List<Song> findAlbumsSongs(Long albumId) {
        TypedQuery<Song> query = entityManager.createQuery(
                "SELECT s FROM Song s WHERE s.idAlbum.id = :albumId", Song.class);
        query.setParameter("albumId", albumId);
        return query.getResultList();
    }
}
