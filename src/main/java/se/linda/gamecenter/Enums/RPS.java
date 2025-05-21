package se.linda.gamecenter.Enums;

import javafx.scene.image.Image;

import java.util.Objects;

public enum RPS {
    ROCK ("/se/linda/gamecenter/Pictures/RockH.jpg","Rock"),
    PAPER ("/se/linda/gamecenter/Pictures/PapperH.jpg", "Raper"),
    SCISSOR("/se/linda/gamecenter/Pictures/SissorH.jpg", "Scissor");

    private String imagePath;
    private String name;

    RPS(String path, String name) {
        this.imagePath=path;
        this.name = name;
    }

    public String getImagePath(){
        return Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm();
    }
    public String getName() {return this.name;}
}
