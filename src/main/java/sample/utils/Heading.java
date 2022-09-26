package sample.utils;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Heading {
    public void showHeading(Text text){
        text.setText("Welcome to Sudoku Solver !!!");
        text.setX(60);
        text.setY(80);
        text.setFont(Font.font("Cooper",60));
        text.setFill(Color.rgb(255,255,255));
    }


}
