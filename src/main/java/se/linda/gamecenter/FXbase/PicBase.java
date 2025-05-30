package se.linda.gamecenter.FXbase;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import lombok.Getter;
import se.linda.gamecenter.Componenets.Card;
import se.linda.gamecenter.Componenets.Letter;
import se.linda.gamecenter.Componenets.Picture;
import se.linda.gamecenter.Enums.RPS;

import java.util.List;
import java.util.Random;

public class PicBase {
    private final GridPane mainGrid;
    private List<?> picList;
    private int picHight;
    private int picWidth;


    public PicBase(List<?> picList, int hight, int width) {
        this.mainGrid = new GridPane();
        this.picList = picList;
        this.picHight = hight;
        this.picWidth = width;
    }

    private void addPicToGrid(int x, int y) {
        Picture pic = (Picture) picList.getFirst();
        mainGrid.add(pic.getPic(picHight, picWidth), x, y);
        picList.removeFirst();
    }

    private void setGrid() {
        mainGrid.setPrefSize(100,200);
        int x = 0;
        int y = 0;
        while (!picList.isEmpty()) {
            addPicToGrid(x,y);
            x = (x < 3) ? x + 1 : 0;
            y += (x == 0) ? 1 : 0;
        }
    }

    public GridPane init() {
        setGrid();
        return mainGrid;
    }
}
