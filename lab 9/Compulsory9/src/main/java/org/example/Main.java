package org.example;

import org.example.entity.Artist;
import org.example.repository.ArtistRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Artist");
        ArtistRepository artistRepository = new ArtistRepository(emf);
        Artist artist=new Artist("Luci");
        artistRepository.create(artist);
        Artist test = artistRepository.findById(579L);
        System.out.println(test);

        System.out.println(artistRepository.findByName("Lu"));
    }
//    Singleton s = new Singleton();
//    s.testJPA();
}