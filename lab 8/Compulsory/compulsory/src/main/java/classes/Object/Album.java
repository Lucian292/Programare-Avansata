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
}
