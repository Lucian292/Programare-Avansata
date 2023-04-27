package app;

import classes.DAO.ArtistDAO;
import classes.DAO.AlbumDAO;
import classes.Database.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {

        try {
            Database.deleteAll("albums");
            Database.deleteAll("artists");

            var artists1 = new ArtistDAO();
            var artists2 = new ArtistDAO();
            artists1.create("Beatles");
            artists2.create("Eagles");

            Database.getConnection().commit();
            var albums = new AlbumDAO();

            int beatlesId = artists1.findByName("Beatles");
            int eaglesId=artists2.findByName("Eagles");

            albums.create("Abbey Road", beatlesId);
            albums.create("Revolver", beatlesId);

            albums.create("One Of These Nights", eaglesId);
            albums.create("Hotel California", eaglesId);
            Database.getConnection().commit();
            System.out.println(albums.findByArtistId(beatlesId));
            System.out.println(albums.findByArtistId(eaglesId));
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
            Database.closeConnection();
        }
    }
}