package ba.unsa.etf.rs.Controllers;

import ba.unsa.etf.rs.beans.Doctor;
import ba.unsa.etf.rs.beans.Manager;
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

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ManagerController {


 public ManagerController(){}
    public ImageView image1,image2;
    public TextField usernameFiled;
    public PasswordField passField;
    ClinicDAO clinicDAO = new ClinicDAO();

    boolean user,password;
    public void initialize() {
        usernameFiled.textProperty().addListener((obs, old, novi) -> {
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
                password = false;
            } else {
                passField.getStyleClass().removeAll("nijeIspravno");
                passField.getStyleClass().add("ispravno");
                Image image = new Image("/img/ok.png");
                image2.setImage(image);
                password = true;
            }
        });
    }
    public void ok() throws IOException {
        if(!user || !password || !validationData(usernameFiled.getText(),passField.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid username or password!");
            alert.setContentText("Please try again!");
            alert.show();
        }else {
            cancel();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/managerFXML/managerWork.fxml"));
            ManagerWorkController managerWorkController = new ManagerWorkController();
            loader.setController(managerWorkController);
            Parent root = loader.load();
            stage.setTitle("Manager work");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();


        }

    }

    public void cancel() {
        Stage stage = (Stage) usernameFiled.getScene().getWindow();
        stage.close();
    }

    public boolean validationData(String username,String password){
        for(Manager manager : clinicDAO.getManagers()){
            if(manager.getPassword().equals(password) && manager.getUsername().equals(username))
                return true;
        }
        return false;

    }

}
