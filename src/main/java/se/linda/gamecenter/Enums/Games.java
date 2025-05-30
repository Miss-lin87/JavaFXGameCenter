package se.linda.gamecenter.Enums;

public enum Games {
    FLIPGAME ("3"),
    MEMORY ("1"),
    ROBOT ("5"),
    RPSGAME ("4"),
    WORDGUESSER ("2");

    String game;

    Games(String game) {
        this.game = game;
    }

    public String getGame(){
        return game;
    }
}
