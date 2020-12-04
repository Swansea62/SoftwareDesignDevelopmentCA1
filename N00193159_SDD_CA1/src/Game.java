public class Game {

    private int id;
    private String name;
    private String platform;
    private String genre;
    private int ageRating;
    private String difficulty;

    public Game(int i, String n, String p, String g, int ar, String d) {
        this.id = i;
        this.name = n;
        this.platform = p;
        this.genre = g;
        this.ageRating = ar;
        this.difficulty = d;
    }

    public Game(String n, String p, String g, int ar, String d) {
        this.name = n;
        this.platform = p;
        this.genre = g;
        this.ageRating = ar;
        this.difficulty = d;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }
    public void setEmail(String platform) {
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAgeRating() {
        return ageRating;
    }
    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    @Override
    public String toString(){
        return "\n\nID: " + this.id +
                "\nName: " + this.name +
                "\nPlatform: " + this.platform +
                "\nGenre: " + this.genre +
                "\nAge Rating: " + this.ageRating +
                "\nDifficulty: " + this.difficulty; }
}
