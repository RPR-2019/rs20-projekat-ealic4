package ba.unsa.etf.rs;

import ba.unsa.etf.rs.Controllers.ClinicController;
import ba.unsa.etf.rs.beans.Doctor;
import ba.unsa.etf.rs.beans.Patient;
import ba.unsa.etf.rs.dao.ClinicDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        ClinicDAO clinicDAO = new ClinicDAO();
        for(Patient d : clinicDAO.getPatients()){
            System.out.println(d.getName());
        }



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
