package ba.unsa.etf.rs.Controllers;

import ba.unsa.etf.rs.beans.Patient;
import ba.unsa.etf.rs.dao.ClinicDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MedicalWorkController {
    public MedicalWorkController(){}
   ClinicDAO clinicDAO = new ClinicDAO();
    public ListView<Patient>listPatient;
    public void initialize(){
        listPatient.setItems(clinicDAO.getPatients());
        listPatient.getSelectionModel().selectedItemProperty().addListener((obs, oldPatient, newPatient) -> {
            clinicDAO.setTrenutniPatient(newPatient);
            listPatient.refresh();
        });
    }
    public void addPatient() throws IOException {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/medicalTechnicianFXML/addPatient.fxml"));
                PatientController2 patientController = new PatientController2();
                loader.setController(patientController);
                Parent root = loader.load();
                stage.setTitle("Add patient");
                stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
                stage.show();
    }

    public void editPatient() throws IOException {

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/medicalTechnicianFXML/addPatient.fxml"));
        PatientController2 patientController = new PatientController2();
        loader.setController(patientController);
        Parent root = loader.load();
        stage.setTitle("Add patient");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();


    }
    public void cancel() {
        Stage stage = (Stage)listPatient.getScene().getWindow();
        stage.close();
    }
    public void logout() throws IOException {
        cancel();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        ClinicController clinicController = new ClinicController();
        loader.setController(clinicController);
        Parent root = loader.load();
        stage.setTitle("Home");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();


    }

}
