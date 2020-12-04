
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GameGateway {
    private static final String TABLE_NAME = "game";
    private static final String COLUMN_ID = "game_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PLATFORM = "platform";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_RATING = "age_rating";
    private static final String COLUMN_DIFFICULTY = "difficulty";

    private Connection mConnection;

    public GameGateway(Connection connection) {
        mConnection = connection;
    }

    public boolean insertGame(Game g) {
        String query;
        PreparedStatement stmt;
        int numRowsAffected;

        query = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_NAME + ", " +
                COLUMN_PLATFORM + ", " +
                COLUMN_GENRE + ", " +
                COLUMN_RATING + ", " +
                COLUMN_DIFFICULTY + ") VALUES (?, ?, ?, ?, ?)";

        try {
            stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, g.getName());
            stmt.setString(2, g.getPlatform());
            stmt.setString(3, g.getGenre());
            stmt.setInt(4, g.getAgeRating());
            stmt.setString(5, g.getDifficulty());

            numRowsAffected = stmt.executeUpdate();

            if (numRowsAffected == 1) {
                return true;
            }
        } catch (
                SQLException e) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception in ProgrammerTableGateway : insertProgrammer(), Check the SQL you have created to see where your error is", e);
        }
        return false;
    }

    public List<Game> getGames()  {
        String query;
        Statement stmt;
        ResultSet rs;
        List<Game> games;

        String name, platform, genre, difficulty;
        int id, ageRating;

        Game g;

        games = new ArrayList<Game>();

        try {
            query = "SELECT * FROM " + TABLE_NAME;
            stmt = this.mConnection.createStatement();
            rs = stmt.executeQuery(query);



            while (rs.next()) {
                name = rs.getString(COLUMN_NAME);
                platform = rs.getString(COLUMN_PLATFORM);
                genre = rs.getString(COLUMN_GENRE);
                difficulty = rs.getString(COLUMN_DIFFICULTY);

                id = rs.getInt(COLUMN_ID);
                ageRating = rs.getInt(COLUMN_RATING);

                g = new Game(id, name, platform, genre, ageRating, difficulty);
                games.add(g);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception");
        }

        return games;
    }

    public boolean deleteGame(int id)    {

        int numRowsAffected;



        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "= ?";


        try {
            PreparedStatement stmt;

            stmt = mConnection.prepareStatement(query);
            stmt.setInt(1, id);

            System.out.println("\n\nTHE SQL LOOKS LIKE THIS " + stmt.toString() + "\n\n");

            numRowsAffected = stmt.executeUpdate();

            if (numRowsAffected == 1) {
                return true;
            }
        }
        catch (SQLException e)
        {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception in GameGateway : deleteGame(), Check the SQL you have created to see where your error is", e);
        }

        return false;
    }

    public boolean updateGame(int game_id, String name, String platform, String genre, int ageRating, String difficulty) {
        String query;
        PreparedStatement stmt;
        int numRowsAffected;

        query = "UPDATE Game SET name = (?), platform = (?), genre = (?), age_rating = (?), difficulty = (?) WHERE game_id = ?";
        try {

            stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setString(2, platform);
            stmt.setString(3, genre);
            stmt.setInt(4, ageRating);
            stmt.setString(5, difficulty);

            stmt.setInt(6, game_id);

            numRowsAffected = stmt.executeUpdate();

            if (numRowsAffected == 1) {
                return true;
            }
        }
        catch (SQLException e) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception in GameGateway : updateGame(), check the SQL you have created to see where your error is", e);
        }

        return false;
    }
}
