package sample.hellofx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloController {


    @FXML
    private Button newGame, solver,exit;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == newGame) {
            try{
                stage = (Stage) newGame.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("newGame.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (event.getSource() == solver) {
            try{
                stage = (Stage) solver.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("solver.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                System.out.println("ye solver main problem hai");
            }
        }
        else{
            try{
                stage = (Stage) exit.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                System.out.println("ye solver main problem hai");
            }
        }

    }
}
