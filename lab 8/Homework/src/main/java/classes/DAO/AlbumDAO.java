package classes.DAO;

import classes.Database.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    public void create(String name, int id_artist, int realease_year, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (name, id_artist, release_year, genre) values (?, ?, ?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id_artist);
            pstmt.setInt(3, realease_year);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
            con.commit();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from albums where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public List<String> findByArtistId(Integer artistId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from albums where id_artist='" + artistId + "'")) {

            List<String> result = new ArrayList<String>();
            int index = 0;

            while (rs.next()) {
                result.add("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Artist ID: " + rs.getInt("id_artist") + ", Release Year: " + rs.getInt("release_year") + ", Genre: " + rs.getString("genre"));
            }

            return result;
        }
    }

    public List<String> findAll() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT artists.name AS artist_name, albums.name AS album_name, release_year, genre " +
                             "FROM albums " +
                             "JOIN artists ON albums.id_artist = artists.id " +
                             "ORDER BY artist_name, album_name")) {
            List<String> result = new ArrayList<String>();
            while (rs.next()) {
                result.add("Artist: " + rs.getString("artist_name") + ", Album: " + rs.getString("album_name") + ", Release Year: " + rs.getInt("release_year") + ", Genre: " + rs.getString("genre"));
            }
            return result;
        }
    }

}
