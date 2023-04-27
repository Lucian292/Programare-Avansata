package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {
    private Connection connection = DatabaseManager.getConnection();

    String AlbumName, GroupName;
    int year;
    private int AlbumId;

    public AlbumDao() throws SQLException {
        connection = DatabaseManager.getConnection();
    }

    public AlbumDao(String AlbumName, String GroupName, int year) throws SQLException {
        this.AlbumName=AlbumName;
        this.GroupName=GroupName;
        this.year=year;
    }

    public void createAlbum(AlbumDao album) throws SQLException {
        String sql = "INSERT INTO albums (title, artist, release_year) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, album.getTitle());
            statement.setString(2, album.getArtist());
            statement.setInt(3, album.getReleaseYear());
            statement.executeUpdate();
        }
    }

    public int getReleaseYear() {
        return year;
    }

    public String getArtist() {
        return GroupName;
    }

    public String getTitle() {
        return AlbumName;
    }

    public List<AlbumDao> getAllAlbums() throws SQLException {
        String sql = "SELECT * FROM albums";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            List<AlbumDao> albums = new ArrayList<>();
            while (resultSet.next()) {
                AlbumDao album = new AlbumDao();
                album.setId(resultSet.getInt("id"));
                album.setTitle(resultSet.getString("title"));
                album.setArtist(resultSet.getString("artist"));
                album.setReleaseYear(resultSet.getInt("release_year"));
                albums.add(album);
            }
            return albums;
        }
    }

    private void setId(int id) {
        this.AlbumId=id;
    }

    private void setReleaseYear(int releaseYear) {
        this.year=releaseYear;
    }

    private void setArtist(String artist) {
        this.GroupName=artist;
    }

    private void setTitle(String title) {
        this.AlbumName=title;
    }

    public void createAlbumGenreAssociation(int albumId, int genreId) throws SQLException {
        String sql = "INSERT INTO album_genre (album_id, genre_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, albumId);
            statement.setInt(2, genreId);
            statement.executeUpdate();
        }
    }

    public List<GenreDao> getGenresForAlbum(int albumId) throws SQLException {
        String sql = "SELECT genres.id, genres.name FROM genres JOIN album_genre ON genres.id = album_genre.genre_id WHERE album_genre.album_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, albumId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<GenreDao> genres = new ArrayList<>();
                while (resultSet.next()) {
                    GenreDao genre = new GenreDao("Rock");
                    genre.setId(resultSet.getInt("id"));
                    genre.setName(resultSet.getString("name"));
                    genres.add(genre);
                }
                return genres;
            }
        }
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public int getId() {
        return AlbumId;
    }
}
