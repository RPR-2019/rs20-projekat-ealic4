package ba.unsa.etf.rs.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class DoctorWorkController {
    public TextField umbgF;




    public void initialize(){
       umbgF.textProperty().addListener((obs,stara,nova)->{
            if(nova.length() < 13){
                umbgF.getStyleClass().removeAll("ispravno");
                umbgF.getStyleClass().add("nijeIspravno");
            }else{
                umbgF.getStyleClass().removeAll("nijeIspravno");
                umbgF.getStyleClass().add("ispravno");

            }
        });
    }


    public void submit() throws IOException {


            cancel();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/doctorFXML/patientInformation.fxml"));
            PatientController patientController = new PatientController();
            loader.setController(patientController);
            Parent root = loader.load();
            stage.setTitle("Patient record");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();

    }

    public void cancel() {
        Stage stage = (Stage) umbgF.getScene().getWindow();
        stage.close();
    }
}
