package ba.unsa.etf.rs.Classes;

import ba.unsa.etf.rs.Controllers.ClinicController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        ClinicController loginController = new ClinicController();
        loader.setController(loginController);
        Parent root = loader.load();

        primaryStage.setTitle("Home");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }






    public static void main(String[] args) {

        launch(args);
    }
}
