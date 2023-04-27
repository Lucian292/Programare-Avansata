package org.example;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        AlbumDao albumDao = new AlbumDao();
        albumDao.createAlbum(new AlbumDao("Rubber Soul", "The Beatles", 1965));
        albumDao.createAlbum(new AlbumDao("The White Album", "The Beatles", 1968));

        GenreDao genreDao = new GenreDao("Rock");
        genreDao.createGenre(new GenreDao("Rock"));
        genreDao.createGenre(new GenreDao("Pop"));

        albumDao.createAlbumGenreAssociation(1, 1);
        albumDao.createAlbumGenreAssociation(1, 2);
        albumDao.createAlbumGenreAssociation(2, 1);

        List<AlbumDao> albums = albumDao.getAllAlbums();
        for (AlbumDao album : albums) {
            System.out.println(album.getTitle() + " by " + album.getArtist() + " (" + album.getReleaseYear() + ")");
            List<GenreDao> genres = albumDao.getGenresForAlbum(album.getId());
            for (GenreDao genre : genres) {
                System.out.println("- " + genre.getName());
            }
            System.out.println();
        }
    }
}

