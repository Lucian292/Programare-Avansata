package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "songs")
@NamedQuery(name = "Song.findByName", query = "SELECT s FROM Song s WHERE s.name LIKE :name")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_album")
    private Album idAlbum;

    public Song() {}

    public Song(String name, Album album) {
        this.name = name;
        this.idAlbum = album;
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

    public Album getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Album idAlbum) {
        this.idAlbum = idAlbum;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", album=" + idAlbum +
                '}';
    }
}

