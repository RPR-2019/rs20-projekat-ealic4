package ba.unsa.etf.rs.Controllers;

import ba.unsa.etf.rs.beans.Patient;
import ba.unsa.etf.rs.dao.ClinicDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class PatientController {
    ClinicDAO clinicDAO = new ClinicDAO();
    public String enterUmbg;
    public PatientController(){}
    public PatientController(String enterUmbg){
        this.enterUmbg = enterUmbg;
    }

    Patient patient = null;
    public TextField namePatient,surnamePatient,umbgPatient,addressPatient,emailPatient,phoneNumberPatient;
    public DatePicker dateOfBirth;
    public void initialize() {


        for (Patient p : clinicDAO.getPatients()) {
            if (p.getUmbg().equals(enterUmbg)) {
                patient = p;
                break;
            }
        }


        namePatient.setText(patient.getName());
        surnamePatient.setText(patient.getSurname());
        dateOfBirth.setValue(patient.getDateOfBirth());
        umbgPatient.setText(patient.getUmbg());
        addressPatient.setText(patient.getAddress());
        emailPatient.setText(patient.getEmail());
        phoneNumberPatient.setText(patient.getPhoneNumber());


    }
//enter patient

    public void end() throws IOException {
        Stage stage = (Stage)namePatient.getScene().getWindow();
        stage.close();

        stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/doctorFXML/doctorWork.fxml"));
        DoctorWorkController doctorWorkController = new DoctorWorkController();
        loader.setController(doctorWorkController);
        Parent root = loader.load();
        stage.setTitle("Doctor work");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }


}
