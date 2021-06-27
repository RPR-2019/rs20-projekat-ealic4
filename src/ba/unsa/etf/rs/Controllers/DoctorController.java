package ba.unsa.etf.rs.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class DoctorController {
    public void submit(ActionEvent actionEvent) throws IOException {

        Stage stageLogDoctor = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/patient.fxml"));
        stageLogDoctor.setTitle("Login doctor");
        stageLogDoctor.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stageLogDoctor.setResizable(false);
        stageLogDoctor.show();
    }

    public ImageView image1,image2;
    public TextField usernameFiled;
    public PasswordField passField;
    public void initialize() {
        usernameFiled.textProperty().addListener((obs, old, novi) -> {
            if (usernameFiled.getText().length() < 6) {
                usernameFiled.getStyleClass().removeAll("ispravno");
                usernameFiled.getStyleClass().add("nijeIspravno");
                Image image = new Image("/img/not.png");
                image1.setImage(image);
            } else {
                usernameFiled.getStyleClass().removeAll("nijeIspravno");
                usernameFiled.getStyleClass().add("ispravno");
                Image image = new Image("/img/ok.png");
                image1.setImage(image);
            }
        });

        passField.textProperty().addListener((obs, old, novi) -> {
            if (passField.getText().isEmpty()) {
                passField.getStyleClass().removeAll("ispravno");
                passField.getStyleClass().add("nijeIspravno");
                Image image = new Image("/img/not.png");
                image2.setImage(image);
            } else {
                passField.getStyleClass().removeAll("nijeIspravno");
                passField.getStyleClass().add("ispravno");
                Image image = new Image("/img/ok.png");
                image2.setImage(image);
            }
        });
    }

}
