package org.example;

import org.example.entity.Album;
import org.example.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;
public class TestJPA {
    public static void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Artist");
        EntityManager em = emf.createEntityManager();

        // create a large number of artists and albums
        em.getTransaction().begin();

        for (int i = 0; i < 10000; i++) {
            Artist artist = new Artist("Artist " + i);
            em.persist(artist);

            for (int j = 0; j < 10; j++) {
                Album album = new Album("Album " + j, artist, 2020, getRandomGenre());
                em.persist(album);
            }
        }

        em.getTransaction().commit();

        // measure the execution time of JPQL statements
        long start = System.currentTimeMillis();

        em.createQuery("SELECT a FROM Album a WHERE a.genre = :genre", Album.class)
                .setParameter("genre", "Pop")
                .getResultList();

        em.createQuery("SELECT a FROM Album a JOIN FETCH a.artist WHERE a.releaseYear > :year", Album.class)
                .setParameter("year", 2010)
                .getResultList();

        long end = System.currentTimeMillis();

        System.out.println("Execution time: " + (end - start) + " ms");

        em.close();
        emf.close();
    }

    private static final String[] genres = {"Pop", "Rock", "Hip hop", "Electronic"};

    private static String getRandomGenre() {
        int index = new Random().nextInt(genres.length);
        return genres[index];
    }
}
