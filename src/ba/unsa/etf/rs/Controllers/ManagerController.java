package ba.unsa.etf.rs.Controllers;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ManagerController {


 public ManagerController(){}
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
