package sample.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.scenes.Home;
import sample.scenes.Solver;
import sample.scenes.Success;

public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
//        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

            //Initializing Home Scene
            Home home = new Home(primaryStage);   // encapsulated homePageUI
            Scene homeScene = home.show();

            //Initializing Solver Scene
            Solver solve = new Solver(primaryStage);
            Scene solverPage = solve.show();

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