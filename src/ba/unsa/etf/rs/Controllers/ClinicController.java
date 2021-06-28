package ba.unsa.etf.rs.Controllers;

import ba.unsa.etf.rs.dao.ClinicDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class ClinicController {

    public Button cancel;

    public ClinicController() { }



    public void doctorLogin(ActionEvent actionEvent) throws Exception {
        closeWindow();
        Stage stageLogDoctor = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/doctorFXML/doctorLogin.fxml"));
        //ClinicDAO clinicDAO = ClinicDAO.getInstance();
        DoctorController doctorController = new DoctorController();
        loader.setController(doctorController);
        Parent root = loader.load();
        stageLogDoctor.setTitle("Login doctor");
        stageLogDoctor.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stageLogDoctor.setResizable(false);
        stageLogDoctor.show();
    }

    public void medicalLogin(ActionEvent actionEvent) throws Exception {
        closeWindow();
        Stage stageLogDoctor = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/medicalTechnicianFXML/medicalTechLogin.fxml"));
        MedicalTechController medicalTechController = new MedicalTechController();
        loader.setController(medicalTechController);
        Parent root = loader.load();
        stageLogDoctor.setTitle("Login medical techinician");
        stageLogDoctor.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stageLogDoctor.setResizable(false);
        stageLogDoctor.show();
    }
    public void managerLogin(ActionEvent actionEvent) throws Exception {
        closeWindow();
        Stage stageLogDoctor = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/managerFXML/managerLogin.fxml"));
        ManagerController managerController = new ManagerController();
        loader.setController(managerController);
        Parent root = loader.load();
        stageLogDoctor.setTitle("Login manager");
        stageLogDoctor.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stageLogDoctor.setResizable(false);
        stageLogDoctor.show();
    }




    public void closeWindow() {

        Stage stage = (Stage)cancel.getScene().getWindow();
        stage.close();
    }


    public void okLogin(ActionEvent actionEvent) throws IOException {
        closeWindow();
        Stage stageLogDoctor = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/doctorFXML/doctorLogin.fxml"));
        stageLogDoctor.setTitle("Login doctor");
        stageLogDoctor.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stageLogDoctor.setResizable(false);
        stageLogDoctor.show();
    }
}