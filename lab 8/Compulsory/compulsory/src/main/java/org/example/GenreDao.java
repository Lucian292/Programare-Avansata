package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {
    private final Connection connection;
    private int AlbumId;
    private String AlbumName;

    public GenreDao(String rock) throws SQLException {
        connection = DatabaseManager.getConnection();
    }

    public void createGenre(GenreDao genre) throws SQLException {
        String sql = "INSERT INTO genres (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, genre.getName());
            statement.executeUpdate();
        }
    }

    public String getName() {
        return AlbumName;
    }

    public List<GenreDao> getAllGenres() throws SQLException {
        String sql = "SELECT * FROM genres";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
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

    public void setId(int id) {
        this.AlbumId=id;
    }

    public void setName(String name) {
        this.AlbumName=name;
    }
}
