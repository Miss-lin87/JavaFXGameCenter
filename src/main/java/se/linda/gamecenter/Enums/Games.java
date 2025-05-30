package se.linda.gamecenter.Enums;

public enum Games {
    MEMORY ("1", "Memory"),
    WORDGUESSER ("2", "Word Guesser"),
    FLIPGAME ("3","Flip Game"),
    RPSGAME ("4", "Rock, Paper, Scissors"),
    ROBOT ("5", "Robot Game");

    String game;
    String name;

    Games(String game, String name) {
        this.game = game;
        this.name = name;
    }

    public String getGame(){
        return game;
    }

    public String getName() {
        return name;
    }
}
