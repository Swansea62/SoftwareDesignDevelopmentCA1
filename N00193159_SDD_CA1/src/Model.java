import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {

    private static Model instance = null;

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }


    private List<Game> games;
    private GameGateway gateway;


    private Model() {

        try {
            Connection conn = DBConnect.getInstance();
            this.gateway = new GameGateway(conn);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "Connection Error. Please check JDBC Driver .jar file.");
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        /*this.games = new ArrayList<>();

        this.games.add(
                new Game("Red Dead Redemption 2",
                        "PS4/Xbox One", "Action-Adventure",
                        18, "Medium-Hard"));

        this.games.add(
                new Game("Call of Duty: Modern Warfare",
                        "PS4/Xbox One", "First-Person Shooter",
                        18, "Medium"));

        this.games.add(
                new Game("Super Mario Odyssey",
                        "Nintendo Switch", "Action-Adventure/Platform",
                        7, "Easy"));

        this.games.add(
                new Game("God of War",
                        "PS4", "Action-Adventure",
                        18, "Hard"));*/
    }


    public List<Game> getGames() {
        return
        gateway.getGames();
    }

    public boolean addGame(Game g) {
        return (gateway.insertGame(g));
    }

    public boolean deleteGame(int id)
    {
        return (gateway.deleteGame(id));
    }

    public boolean updateGame(int id, String name, String platform, String genre, int ageRating, String difficulty) {
        return this.gateway.updateGame(id, name, platform, genre, ageRating, difficulty);
    }
}
