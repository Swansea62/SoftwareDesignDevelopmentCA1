import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static Model model = Model.getInstance();

    public static void main(String[] args) {

        Game g;

        int opt;
        do {
            //This is what the user sees first when the code starts running
            System.out.println("\n------- Welcome! -------");
            System.out.println("1. View all games");
            System.out.println("2. Add a game to the list");
            System.out.println("3. Delete a game from the list by ID");
            System.out.println("4: Update an existing game");
            System.out.println("5. Exit Program");

            System.out.print("\n------- Please enter your choice -------\n");
            String line = keyboard.nextLine();
            opt = Integer.parseInt(line);

            //This lays out the actions to be taken depending on what input the user gives.
            switch (opt) {
                case 1: {
                    viewGame();

                    break;
                }

                case 2: {
                    g = readGame();

                    boolean created = model.addGame(g);
                    if (created)
                        System.out.println("***** Game has been added to the Database *****");
                    else
                        System.out.println("***** Game has NOT been Added to the Database *****");

                    break;
                }

                case 3: {
                    deleteGame();
                    break;
                }

                case 4: {
                    updateGame();
                    break;
                }
            }
        }
        while (opt != 5);
        System.out.println("Have a nice day!");
    }

    //The readGame function is called when the user wishes to add a game to the database
    private static Game readGame() {
        String name, platform, genre, difficulty;
        int ageRating;

        System.out.print("\nGame name: ");
        name = keyboard.nextLine();

        System.out.print("Platform: ");
        platform = keyboard.nextLine();

        System.out.print("Genre: ");
        genre = keyboard.nextLine();

        System.out.print("PEGI Rating: ");
        ageRating = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("Difficulty: ");
        difficulty = keyboard.nextLine();
        //keyboard.nextLine();


        Game g =
                new Game(name, platform, genre, ageRating, difficulty);
        return g;
    }

    //This calls the Model class to view all the games currently in the database
    private static void viewGame() {

        List<Game> games = model.getGames();

        for (Game gs : games) {
            System.out.println(gs);
        }

    }

    //This calls on the model class and carries out the deleteGame function to delete any information under the ID the user has given
    private static void deleteGame() {
        System.out.print("Enter the ID of the Game to delete: ");
        int id = Integer.parseInt(keyboard.nextLine());

        if (model.deleteGame(id)) {
            System.out.println("\nGame has been deleted");
        }
        else {
            System.out.println("\nGame has not been deleted, check your database to see if a game with this ID actually exists");
        }
    }

    //The updateGame function sends multiple input statements out for the user to make any changes. If nothing is to be changed, the user must input the values it already has
    private static void updateGame() {

        String name, platform, genre, difficulty;
        int game_id, ageRating;

        System.out.println("Enter the ID of the game: ");
        game_id = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Enter the name of the game: ");
        name = keyboard.nextLine();

        System.out.println("Enter the platform of the game: ");
        platform = keyboard.nextLine();

        System.out.println("Enter the genre of the game: ");
        genre = keyboard.nextLine();

        System.out.println("Enter the age rating of the game: ");
        ageRating = keyboard.nextInt();

        System.out.println("Enter the difficulty of the game: ");
        difficulty = keyboard.nextLine();

        keyboard.nextLine();

        if (model.updateGame(game_id, name, platform, genre, ageRating, difficulty)) {
            System.out.println("\n***** Game has been updated! *****");
        }else{
            System.out.println("\n***** Game has not been updated *****");
        }
    }
}
