package sample.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.utils.Functionalities;
import sample.utils.Heading;

public class Success implements display {
    private final Stage stage;
    private Group root=new Group();
    public Success(Stage stage){
        this.stage=stage;
    }
    public Scene show(){
        Scene scene=new Scene(root, 1150, 664, Color.valueOf("#003459"));
        VBox box=new VBox(1);
        box.setLayoutX(420);
        box.setLayoutY(200);
        box.setPadding(new Insets(25,25,25,25));
        box.setStyle("-fx-border-width:3;-fx-border-style:solid;-fx-border-color:#fff;-fx-background-color:#fff;-fx-text-weight:bolder;");
//        Heading heading=new Heading("Congratulations !!! You Won");
//        Text text=heading.showHeading();
//        text.setFill(Color.valueOf("#12b76a"));
//        box.getChildren().add(heading.showHeading());
        ImageView img = new ImageView("file:src/main/java/Images/trophy.png");
//        img.setLayoutX(1);
//        img.setLayoutY(1);
        img.prefHeight(7);
        img.setFitHeight(80);
        img.setFitWidth(80);
        img.prefWidth(9);


        Text greet=new Text();
        greet.setText("Congratulations !");
        greet.setFont(Font.font("Cooper",25));
        greet.setFill(Color.valueOf("#12b76a"));
        greet.setStyle("-fx-text-weight:bolder;");

        Text say=new Text();
        say.setText("You have won this game");
        say.setFont(Font.font("Cooper",25));
        say.setFill(Color.valueOf("#12b76a"));

        Functionalities func=new Functionalities();

        Button btn=new Button("New Game");
        //btn = new Button("Exit");
        func.button(btn,2);
        btn.setOnAction(event -> {
            stage.setScene(new NewGame(stage).show());
        });
        HBox gap=new HBox(10);
        gap.setPadding(new Insets(5,5,5,5));
        btn.setFont(Font.font("Cooper", 10));
        box.getChildren().add(greet);
        box.getChildren().add(img);
        box.getChildren().add(say);
        box.getChildren().add(gap);
        box.getChildren().add(btn);
        box.setAlignment(Pos.CENTER);

        root.getChildren().add(box);
        return scene;
    }
}
