package se.linda.gamecenter.Enums;

public enum GridMovment {
    UP (-1,0),
    DOWN (1,0),
    LEFT (0,-1),
    RIGHT(0,1);

    private final int[] coordinates;

    GridMovment(int x, int y) {
        this.coordinates = new int[]{x, y};
    }

    public int[] getCoordinates() {
        return coordinates;
    }
}
