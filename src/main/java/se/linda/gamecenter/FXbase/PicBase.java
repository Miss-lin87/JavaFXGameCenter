package se.linda.gamecenter.FXbase;

import javafx.scene.layout.GridPane;
import se.linda.gamecenter.Componenets.Picture;
import java.util.List;

public class PicBase {
    private final GridPane mainGrid;
    private final List<?> picList;
    private final int picHight;
    private final int picWidth;


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
