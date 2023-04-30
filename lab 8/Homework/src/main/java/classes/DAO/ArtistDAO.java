package classes.DAO;

import classes.Database.Database;
import classes.Object.Artist;

import java.sql.*;

public class ArtistDAO {

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Artist findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "select * from artists where name = ?")) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Artist artist = new Artist();
                    artist.setId(rs.getInt("id"));
                    artist.setName(rs.getString("name"));
                    return artist;
                } else {
                    return null;
                }
            }
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id='" + id + "'")) {
                return rs.next() ? rs.getString(1) : null;
        }
    }
}