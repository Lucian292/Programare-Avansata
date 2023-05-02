package classes.csv;

import classes.DAO.AlbumDAO;
import classes.DAO.ArtistDAO;
import classes.Database.Database;
import classes.Object.Artist;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class AlbumCSVReader {

    public static void main(String[] args) throws IOException, SQLException {
    try {
        //stergem toate inregistrarile din baza de date
//        Database.deleteAll("albums");
//        Database.deleteAll("artists");

        Reader reader = new FileReader("albumlist.csv");
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        for (CSVRecord csvRecord : csvParser) {
            String albumName = csvRecord.get("Album");
            String artistName = csvRecord.get("Artist");
            int releaseYear = Integer.parseInt(csvRecord.get("Year"));
            String genre = csvRecord.get("Genre");

            //testez daca s-a citic corect informatia din fisierul csv
            //System.out.println("album name: " + albumName + " artist name: " + artistName +" year: " + releaseYear +" genre: " + genre);

            // Verificăm dacă artistul există deja în baza de date sau nu.
            ArtistDAO artistDAO = new ArtistDAO();
            Artist artist = artistDAO.findByName(artistName);
            if (artist == null) {
                // Dacă artistul nu există, îl inserăm în baza de date.
                artistDAO.create(artistName);
                artist = artistDAO.findByName(artistName);
            }

            // Inserăm albumul în baza de date.
            AlbumDAO albumDAO = new AlbumDAO();
            albumDAO.create(albumName, artist.getId(), releaseYear, genre);
        }

        csvParser.close();
        reader.close();

        var albums = new AlbumDAO();
        // Retrieve all albums and their corresponding artists
        System.out.println("Albums and their corresponding artists:");
        for (String album : albums.findAll()) {
            System.out.println(album);
        }
        Database.getConnection().close();

    } catch (SQLException e) {
        System.err.println(e);
        //Database.rollback();
        Database.closeConnection();
    }
    }
}
