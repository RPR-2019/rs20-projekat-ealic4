package ba.unsa.etf.rs.Controllers;

import ba.unsa.etf.rs.beans.Doctor;
import ba.unsa.etf.rs.beans.Manager;
import ba.unsa.etf.rs.beans.MedicalTechnician;
import ba.unsa.etf.rs.beans.Patient;
import ba.unsa.etf.rs.dao.ClinicDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ManagerWorkController {
    public Button logout;
    ClinicDAO clinicDAO = new ClinicDAO();

   public ListView<Doctor>listDoctor;
   public ListView<MedicalTechnician>listMedical;
   public ListView<Manager>listManager;
    public void initialize(){
    listDoctor.setItems(clinicDAO.getDoctors());
    listMedical.setItems(clinicDAO.getMedicalTechnicians());
    listManager.setItems(clinicDAO.getManagers());



    }


    public void cancel() {
        Stage stage = (Stage)logout.getScene().getWindow();
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
