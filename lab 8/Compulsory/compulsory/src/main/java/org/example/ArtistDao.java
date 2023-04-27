package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDao {
    private final Connection connection;
    private String ArtistName;
    private int ArtistId;

    public ArtistDao() throws SQLException {
        connection = DatabaseManager.getConnection();
    }

    public void createArtist(ArtistDao artist) throws SQLException {
        String sql = "INSERT INTO artists (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, artist.getName());
            statement.executeUpdate();
        }
    }

    private String getName() {
        return ArtistName;
    }

    public List<ArtistDao> getAllArtists() throws SQLException {
        String sql = "SELECT * FROM artists";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            List<ArtistDao> artists = new ArrayList<>();
            while (resultSet.next()) {
                ArtistDao artist = new ArtistDao();
                artist.setId(resultSet.getInt("id"));
                artist.setName(resultSet.getString("name"));
                artists.add(artist);
            }
            return artists;
        }
    }

    private void setName(String name) {
        this.ArtistName=name;
    }

    private void setId(int id) {
        this.ArtistId=id;
    }
}
