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

public class NewGame implements display {
    private final Stage stage;
    private final GridPane grid = new GridPane();
    private final TextField[][] textField=new TextField[9][9];
    private final Button submit = new Button("Submit");
    private final Button change = new Button("Change");
    private final Button exit = new Button("exit");
    public NewGame(Stage stage){
        this.stage=stage;
    }
    private final String s = "-fx-font-size:21;" + "-fx-border-color:white;" + "-fx-border-width:3;" + "-fx-text-fill:white;" + "-fx-font-weight:bolder;";
    public Scene show(){
        Scene scene = new Scene(grid, 1150, 664, Color.valueOf("#003459"));
        //new Grid(grid).setup();
        //inputBox();
        Functionalities func= new Functionalities();
        func.gridSetup(grid);
        func.inputBox(textField,grid);

        func.button(submit, 2);
        HBox hbBox1 = new HBox(10);
        hbBox1.getChildren().add(submit);
        hbBox1.setAlignment(Pos.BOTTOM_CENTER);

        func.button(change, 2);
        HBox hbBox2 = new HBox(10);
        hbBox2.getChildren().add(change);
        hbBox2.setAlignment(Pos.CENTER);

        func.button(exit, 2); //giving style to button using method in Home class
        HBox hbBox3 = new HBox(10);
        hbBox3.getChildren().add(exit);
        hbBox3.setAlignment(Pos.TOP_CENTER);

        handleEvents();

        grid.add(hbBox1, 12, 0, 3, 3);
        grid.add(hbBox2, 12, 3, 3, 3);
        grid.add(hbBox3, 12, 6, 3, 3);

        //new SolverTest(textField).test1();
        func.test(textField);
        return scene;
    }
    public void handleEvents(){
        submit.setOnAction(event -> {
            ValidateBoard v = new ValidateBoard();
            Board partial = new Board();
            boolean flag=false;
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    try {
                        Integer i = Integer.valueOf(textField[c][r].getText().trim());
                        partial.set(c, r, i);
                        textField[c][r].setStyle(s + "-fx-background-color:transparent;");
//                            System.out.println("hit");
                    } catch (NumberFormatException e) {
                        flag=true;
                        textField[c][r].setStyle(s + "-fx-background-color:#d21404;");
                    }
                }
            }
            if(flag){
                return;
            }
            if(v.completeAndValid(partial)){
                stage.setScene(new Success(stage).show());
            }


        });
        change.setOnAction(event -> {
            new Functionalities().test(textField);
        });

        exit.setOnAction(event -> {
            stage.setScene(new Home(stage).show());
        });
    }
}
