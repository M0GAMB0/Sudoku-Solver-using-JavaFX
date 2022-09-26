package sample.scenes;


import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.utils.Functionalities;
import sample.utils.Heading;

public class Home implements display {
    private final Stage stage;


    private final Group root = new Group(); // setting root of home
    private final Scene scene = new Scene(root, 1150, 664, Color.valueOf("#003459"));

    public Home(Stage stage) {
        this.stage = stage;
    }

    public Scene show() {
        Text text = new Text();
        Heading heading = new Heading();
        heading.showHeading(text);
        root.getChildren().add(text);
        Button btn1, btn2, btn3;

        //Calling functionalities class for diff constant func
        Functionalities func = new Functionalities();

        //buttonUp
        btn1 = new Button("New Game");
        func.button(btn1, 1);
        btn1.setOnAction(event -> {
            stage.setScene(new NewGame(stage).show());
        });
        root.getChildren().add(btn1);

        //buttonMid
        btn2 = new Button("Start Solver");
        func.button(btn2, 2);
        btn2.setOnAction(event -> {
            stage.setScene(new Solver(stage).show());
        });
        root.getChildren().add(btn2);

        //buttonDown
        btn3 = new Button("Exit");
        func.button(btn3, 3);
        btn3.setOnAction(event -> {
            Stage sb = (Stage) stage.getScene().getWindow();
            sb.close();
        });
        root.getChildren().add(btn3);

        //HomePage image
        ImageView img = new ImageView("file:src/main/java/Images/logo_512.png");
        img.setLayoutX(150);
        img.setLayoutY(120);
        img.prefHeight(200);
        img.prefWidth(400);
        root.getChildren().add(img);
        return scene;
    }


}
