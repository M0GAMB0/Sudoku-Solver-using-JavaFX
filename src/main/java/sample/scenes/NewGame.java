package sample.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.constants.SolverTest;
import sample.utils.Functionalities;
import sample.utils.Grid;

public class NewGame implements display {
    private Stage stage;
    private final GridPane grid = new GridPane();
    private TextField textField[][]=new TextField[9][9];
    private final Button submit = new Button("Submit");
    private final Button exit = new Button("exit");
    public NewGame(Stage stage){
        this.stage=stage;
    }
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

        func.button(exit, 2); //giving style to button using method in Home class
        HBox hbBox2 = new HBox(10);
        hbBox2.getChildren().add(exit);
        hbBox2.setAlignment(Pos.CENTER);

        handleEvents();

        grid.add(hbBox1, 12, 0, 3, 3);
        grid.add(hbBox2, 12, 3, 3, 3);

        new SolverTest(textField).test1();
        return scene;
    }
    public void handleEvents(){

        exit.setOnAction(event -> {
            stage.setScene(new Home(stage).show());
        });
    }
}
