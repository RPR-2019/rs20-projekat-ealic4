package ba.unsa.etf.rs.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MedicalWorkController {
    public MedicalWorkController(){}
    public void addPatient() throws IOException {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/medicalTechnicianFXML/addPatient.fxml"));
                PatientController patientController = new PatientController();
                loader.setController(patientController);
                Parent root = loader.load();
                stage.setTitle("Add patient");


                stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));

                stage.show();
    }

}
