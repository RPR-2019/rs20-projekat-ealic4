package ba.unsa.etf.rs.Controllers;

import ba.unsa.etf.rs.beans.Patient;
import ba.unsa.etf.rs.dao.ClinicDAO;
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

    ClinicDAO clinicDAO = new ClinicDAO();


    public void initialize(){
       umbgF.textProperty().addListener((obs,stara,nova)->{
           if(validationUmbg(umbgF.getText())){
               umbgF.getStyleClass().removeAll("nijeIspravno");
               umbgF.getStyleClass().add("ispravno");

            }else{
               umbgF.getStyleClass().removeAll("ispravno");
               umbgF.getStyleClass().add("nijeIspravno");

            }
        });
    }


    public void submit() throws IOException {
        boolean istina = false;
        for(Patient p: clinicDAO.getPatients()){
            if(umbgF.getText().equals(p.getUmbg())) { istina = true; break; }
        }


        if(!validationUmbg(umbgF.getText()) || !istina){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid umbg");
            alert.setHeaderText("Invalid umbg!");
            alert.setContentText("The umbg must be 13 numeric characters long!");

            alert.show();
        }else {
            cancel();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/doctorFXML/patientInformation.fxml"));
            PatientController patientController = new PatientController(umbgF.getText());
            loader.setController(patientController);
            Parent root = loader.load();
            stage.setTitle("Patient record");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
        }

    }

    public void cancel() {
        Stage stage = (Stage) umbgF.getScene().getWindow();
        stage.close();
    }

    public boolean validationUmbg(String s){
        if(s.matches("[0-9]+") && s.length() == 13) return true;
        return false;
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
