package sample.utils;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import sample.constants.SolverTest;

import java.util.Random;

public class Functionalities {
    private String s = "-fx-font-size:21;"  + "-fx-border-width:3;" + "-fx-text-fill:white;" +
            "-fx-border-style:solid;" + "-fx-font-weight:bolder;";

    private static final String IDLE_BUTTON_STYLE = "-fx-font-size:32;-fx-border-width:3;-fx-border-style:solid;-fx-border-color:#fff;-fx-border-radius:5em;-fx-background-color:#3981bd;-fx-background-radius: 5em;-fx-text-fill: white;-fx-font-weight:bold; ";
    private static final String HOVERED_BUTTON_STYLE = "-fx-font-size:32;-fx-border-width:3;-fx-border-style:solid;-fx-border-color:#3981bd;-fx-border-radius:5em;-fx-background-color:#fff;-fx-background-radius: 5em;-fx-text-fill: #3981bd;-fx-font-weight:bold;";

    public void gridSetup(GridPane grid) {
        Grid grids = new Grid(grid);
        grids.setup();
    }

    public void inputBox(TextField textFields[][], GridPane grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                TextField t = new TextField();

                t.setPrefHeight(60);
                t.setPrefWidth(60);
                t.setAlignment((Pos.CENTER));
                if(col==2 || col==5){
                    t.setStyle("-fx-background-color:transparent;" +
                            "-fx-border-color:#fff;" +
                            "-fx-border-left-color:#3981bd;"+s);
                }
                else
                t.setStyle("-fx-background-color:transparent;" +
                        "-fx-border-color:#fff;"+s);

                textFields[col][row] = t;
                grid.add(t, col, row);
            }
        }
    }

    public void button(Button btn, int pos) {
        btn.setLayoutX(880);
        if (pos == 1) {
            btn.setLayoutY(150);
        } else if (pos == 2) {
            btn.setLayoutY(280);
        } else {
            btn.setLayoutY(410);
        }

        //setting style of buttons
        btn.setStyle(IDLE_BUTTON_STYLE);
        btn.setOnMouseEntered(e -> btn.setStyle(HOVERED_BUTTON_STYLE));
        btn.setOnMouseExited(e -> btn.setStyle(IDLE_BUTTON_STYLE));
        btn.setCursor(Cursor.HAND);
        btn.setFont(Font.font("Cooper", 16));
        btn.setTextAlignment(TextAlignment.CENTER);
    }

    public void test(TextField[][] textfields) {
        Random random = new Random();
        int x = random.nextInt(3);
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                textfields[c][r].setText("");
                textfields[c][r].setEditable(true);
            }
        }
        SolverTest test = new SolverTest(textfields);
        switch (x) {
            case 0:
                test.test1();
                break;
            case 1:
                test.test2();
                break;
            case 2:
                test.test3();
                break;
            default:
                break;
            //case 3: test.test3();
        }
    }
}
