package sample.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.constants.SolverTest;
import sample.utils.Board;
import sample.utils.Functionalities;
import sample.utils.ValidateBoard;

public class Solver implements display {
    TextField[][] textFields = new TextField[9][9];
    private final Button solveBtn = new Button("Solve");
    private final Button clearBtn = new Button("Clear");
    private final Button exitBtn = new Button("Exit");
    private final GridPane grid = new GridPane();
    private final Stage stage;
    private final String s = "-fx-font-size:21;" + "-fx-border-color:white;" + "-fx-border-width:3;" + "-fx-text-fill:white;" + "-fx-font-weight:bolder;";

    public Solver(Stage stage) {
        this.stage = stage;
    }

    public Scene show() {
        Scene scene = new Scene(grid, 1150, 664, Color.valueOf("#003459"));
        //line();
        Functionalities func = new Functionalities();
        //calling method setting up grid properties
        func.gridSetup(grid);
        //Inserting text-fields into the field
        func.inputBox(textFields, grid);

        //for testing purpose
        new SolverTest(textFields).test1();

        //Solve button
        func.button(solveBtn, 2);
        HBox hbBox1 = new HBox(10);
        hbBox1.getChildren().add(solveBtn);
        hbBox1.setAlignment(Pos.BOTTOM_CENTER);
        //hbBox1.setStyle("-fx-border-width:3;-fx-border-style:solid;-fx-border-color:#3981bd;");

        //Clear Button clearBtn
        func.button(clearBtn, 2); //giving style to button using method in Home class
        HBox hbBox2 = new HBox(10);
        hbBox2.getChildren().add(clearBtn);
        hbBox2.setAlignment(Pos.CENTER);

        //Exit Button exitBtn
        func.button(exitBtn, 2);
        HBox hbBox3 = new HBox(10);
        hbBox3.getChildren().add(exitBtn);
        hbBox3.setAlignment(Pos.TOP_CENTER);

        // to handle the button events
        handleEvents();

        grid.add(hbBox1, 12, 0, 3, 3);
        grid.add(hbBox2, 12, 3, 3, 3);
        grid.add(hbBox3, 12, 6, 3, 3);

        return scene;
    }

    //function for text-field


    //Handling Actions
    private void handleEvents() {
        //Event Handle for Solve Button
        solveBtn.setOnAction(event -> {
            ValidateBoard v = new ValidateBoard();
            Board partial = new Board();
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    try {
                        Integer i = Integer.valueOf(textFields[c][r].getText().trim());
                        partial.set(c, r, i);
//                            System.out.println("hit");
                    } catch (NumberFormatException e) {
                    }
                }
            }
            Board solution = v.solve(partial);
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if (textFields[c][r].getText().trim().equals("")) {
                        if (solution == null) {
                            textFields[c][r].setStyle(s + "-fx-background-color:#d21404;");
                        } else {
                            //coloring after solution
                            textFields[c][r].setStyle(s + "-fx-background-color:#3981bd;");
                            textFields[c][r].setText("" + solution.get(c, r));
                        }
                    } else {
                        textFields[c][r].setStyle(s + "-fx-background-color:transparent;");
                    }
                }
            }
        });



        // Event Handle for Clear Button
        clearBtn.setOnAction(event -> {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    textFields[col][row].setText("");
                    textFields[col][row].setEditable(true);
                    textFields[col][row].setStyle(s + "-fx-background-color:transparent;");
                }//end of loop Col
            }//end of loop row
            //test();
        });



        //exit back to home scene
        exitBtn.setOnAction(event -> {
            stage.setScene(new Home(stage).show());
        });

    }


}
