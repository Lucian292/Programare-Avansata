package app;

import classes.DAO.ArtistDAO;
import classes.DAO.AlbumDAO;
import classes.Database.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {

        try {

//            var artists1 = new ArtistDAO();
//            var artists2 = new ArtistDAO();
//            artists1.create("Beatles");
//            artists2.create("Eagles");
//
//            Database.getConnection().commit();
              var albums = new AlbumDAO();
//
//            int beatlesId = artists1.findByName("Beatles");
//            int eaglesId=artists2.findByName("Eagles");
//
//            albums.create("Abbey Road", beatlesId, 1968, "Rock");
//            albums.create("Revolver", beatlesId, 1968, "Rock");
//
//            albums.create("One Of These Nights", eaglesId, 1968, "Rock");
//            albums.create("Hotel California", eaglesId, 1968, "Rock");
//            Database.getConnection().commit();
//            System.out.println(artists1.findById(beatlesId));
//            System.out.println(albums.findByArtistId(beatlesId));
//            System.out.println(artists2.findById(eaglesId));
//            System.out.println(albums.findByArtistId(eaglesId));

            // Retrieve all albums and their corresponding artists
            System.out.println("Albums and their corresponding artists:");
            for (String album : albums.findAll()) {
                System.out.println(album);
            }

//            Database.deleteAll("albums");
//            Database.deleteAll("artists");

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
            Database.closeConnection();
        }

    }
}