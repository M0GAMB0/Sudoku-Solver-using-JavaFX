package sample.hellofx;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.scenes.Home;

public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
//        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

            //OverAll
            Image icon = new Image("file:src/main/java/Images/logo_512.png");
            primaryStage.setScene(new Home(primaryStage).show());
            primaryStage.setResizable(false);
            primaryStage.setTitle("Sudoku Solver");
            primaryStage.getIcons().add(icon);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}