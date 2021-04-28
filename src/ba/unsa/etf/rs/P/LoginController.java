package ba.unsa.etf.rs.P;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;




import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class LoginController {

    public Button cancel;

    public void loginDoctor(ActionEvent actionEvent) throws Exception {

            Stage stageLogDoctor = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/doctorLogin.fxml"));
            stageLogDoctor.setTitle("Login doctor");
            stageLogDoctor.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
            stageLogDoctor.show();

    }

    public void loginMedical(ActionEvent actionEvent) throws Exception{
        Stage stageLogDoctor = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/medicalLogin.fxml"));
        stageLogDoctor.setTitle("Login doctor");
        stageLogDoctor.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stageLogDoctor.show();
    }

    public void loginManger(ActionEvent actionEvent)  throws Exception{
        Stage stageLogDoctor = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/managerLogin.fxml"));
        stageLogDoctor.setTitle("Login doctor");
        stageLogDoctor.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stageLogDoctor.show();
    }

    public void closeWindow(ActionEvent actionEvent) {

        Stage stage = (Stage)cancel.getScene().getWindow();
        stage.close();
    }


}