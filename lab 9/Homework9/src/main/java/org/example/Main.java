package org.example;

import org.example.entity.Album;
import org.example.entity.Artist;
import org.example.entity.Song;
import org.example.repository.AlbumRepository;
import org.example.repository.ArtistRepository;
import org.example.repository.SongRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Artist");
        ArtistRepository artistRepository = new ArtistRepository(emf);
        AlbumRepository albumRepository = new AlbumRepository(emf);
        SongRepository songRepository = new SongRepository(emf);

        Artist artist=new Artist("bla-bla");
        artistRepository.create(artist);
        Album album=new Album("test", artist, 2023, "muzica faina");
        albumRepository.create(album);
        Song song = new Song("E sarbatoare si rasuna muzica", album);
        songRepository.create(song);

        System.out.println("testare metoda findById pentru artist: " + artistRepository.findById(1L));
        System.out.println("testare findByName pt artist dupa pattern: " + artistRepository.findByName("-b"));
        System.out.println("testare metoda findArtistAlbums pentru artist: " + artistRepository.findArtistsAlbums(1L));



        System.out.println("testare findByName pt album dupa pattern: " + albumRepository.findByName("es"));
        System.out.println("testare metoda findById pentru album: " + albumRepository.findById(1L));
        System.out.println("testare metoda findAlbumsSong: " + albumRepository.findAlbumsSongs(1L));

        System.out.println("testare metoda findById pentru song: " + songRepository.findById(1L));
        System.out.println("testare metoda findByName pentru song: " + songRepository.findByName("e s"));

        TestJPA testJPA = new TestJPA();
        testJPA.test();
    }
}