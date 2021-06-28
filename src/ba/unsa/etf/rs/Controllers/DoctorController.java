package ba.unsa.etf.rs.Controllers;

import ba.unsa.etf.rs.beans.Doctor;
import ba.unsa.etf.rs.dao.ClinicDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class DoctorController {

   ClinicDAO clinicDAO = new ClinicDAO();




    public ImageView image1,image2;
    public TextField usernameFiled;
    public PasswordField passField;
    public boolean user,password1;

    public DoctorController() throws SQLException {
    }

    public void initialize() {
        usernameFiled.textProperty().addListener(
                (obs, old, novi) -> {
            if (usernameFiled.getText().length() < 6) {
                usernameFiled.getStyleClass().removeAll("ispravno");
                usernameFiled.getStyleClass().add("nijeIspravno");
                Image image = new Image("/img/not.png");
                image1.setImage(image);
                user = false;
            } else {
                usernameFiled.getStyleClass().removeAll("nijeIspravno");
                usernameFiled.getStyleClass().add("ispravno");
                Image image = new Image("/img/ok.png");
                image1.setImage(image);
                user = true;
            }
        });

        passField.textProperty().addListener((obs, old, novi) -> {
            if (passField.getText().isEmpty()) {
                passField.getStyleClass().removeAll("ispravno");
                passField.getStyleClass().add("nijeIspravno");
                Image image = new Image("/img/not.png");
                image2.setImage(image);
                password1 = false;
            } else {
                passField.getStyleClass().removeAll("nijeIspravno");
                passField.getStyleClass().add("ispravno");
                Image image = new Image("/img/ok.png");
                image2.setImage(image);
                password1 = true;
            }
        });
    }

    public void ok() throws IOException {
        if(!user || !password1 || !validationData(usernameFiled.getText(),passField.getText()) ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error while logging in.");
            alert.setContentText("You did not enter a valid username or password, please\ntry again.");
            alert.show();


        }else{

            cancel();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/doctorFXML/doctorWork.fxml"));
            DoctorWorkController doctorWorkController = new DoctorWorkController();
            loader.setController(doctorWorkController);
            Parent root = loader.load();
            stage.setTitle("Doctor work");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();

        }

    }

    public void cancel() {
        Stage stage = (Stage) usernameFiled.getScene().getWindow();
        stage.close();
    }

    public boolean validationData(String username,String password){
        for(Doctor doctor : clinicDAO.getDoctors()){
            if(doctor.getPassword().equals(password) && doctor.getUsername().equals(username))
                return true;
        }
        return false;

    }


}
