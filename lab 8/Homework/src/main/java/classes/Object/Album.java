package classes.Object;

import classes.DAO.ArtistDAO;

public class Album {
    private int id;
    private String genre;
    private String name;
    private int id_artist;
    private int release_year;

    public Album(String genre, String name, int id_artist, int release_year) {
        this.genre = genre;
        this.name = name;
        this.id_artist = id_artist;
        this.release_year = release_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_artist() {
        return id_artist;
    }

    public void setId_artist(int id_artist) {
        this.id_artist = id_artist;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
