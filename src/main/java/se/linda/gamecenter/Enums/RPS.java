package se.linda.gamecenter.Enums;

import lombok.Getter;
import java.util.Objects;

public enum RPS {
    ROCK ("/se/linda/gamecenter/Pictures/RockH.jpg","Rock"),
    PAPER ("/se/linda/gamecenter/Pictures/PapperH.jpg", "Raper"),
    SCISSOR("/se/linda/gamecenter/Pictures/SissorH.jpg", "Scissor");

    private final String imagePath;
    private final String name;

    RPS(String path, String name) {
        this.imagePath = path;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getImagePath(){
        return Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm();
    }
}
