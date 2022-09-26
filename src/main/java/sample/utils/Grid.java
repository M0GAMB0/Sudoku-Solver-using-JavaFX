package sample.utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Grid {
    private GridPane grid = new GridPane();

    public Grid(GridPane grid) {
        this.grid = grid;
    }

    public void setup() {
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(25);
        grid.setVgap(20);
        grid.setBackground(new Background(new BackgroundFill(Color.rgb(0, 52, 89), new CornerRadii(0), new Insets(0))));
        grid.setPadding(new Insets(25, 25, 25, 25));
    }

}
