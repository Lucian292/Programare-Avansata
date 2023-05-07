package org.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
@NamedQuery(name = "Album.findByName", query = "SELECT a FROM Album a WHERE a.name LIKE :name")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artist")
    private Artist artist;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "genre")
    private String genre;

    @OneToMany(mappedBy = "idAlbum", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Song> songs = new HashSet<>();

    public Album() {}

    public Album(String name, Artist artist, int releaseYear, String genre) {
        this.name = name;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        songs.add(song);
        song.setIdAlbum(this);
    }

    public void removeSong(Song song) {
        songs.remove(song);
        song.setIdAlbum(null);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist=" + artist +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                '}';
    }
}
