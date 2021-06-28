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
    public void initialize(){


        for(Patient p: clinicDAO.getPatients()){
            if(p.getUmbg().equals(enterUmbg)){ patient = p; break;}
        }


        namePatient.setText(patient.getName());
        surnamePatient.setText(patient.getSurname());
        dateOfBirth.setValue(patient.getDateOfBirth());
        umbgPatient.setText(patient.getUmbg());
        addressPatient.setText(patient.getAddress());
        emailPatient.setText(patient.getEmail());
        phoneNumberPatient.setText(patient.getPhoneNumber());



//enter patient
        namePatient.textProperty().addListener((obs,stara,nova)->{
            if(namePatient.getText().isEmpty()){
                namePatient.getStyleClass().removeAll("ispravno");
                namePatient.getStyleClass().add("nijeIspravno");
            }else{
                namePatient.getStyleClass().removeAll("nijeIspravno");
                namePatient.getStyleClass().add("ispravno");

            }
        });

        surnamePatient.textProperty().addListener((obs,stara,nova)->{
            if(surnamePatient.getText().isEmpty()){
                surnamePatient.getStyleClass().removeAll("ispravno");
                surnamePatient.getStyleClass().add("nijeIspravno");
            }else{
                surnamePatient.getStyleClass().removeAll("nijeIspravno");
                surnamePatient.getStyleClass().add("ispravno");

            }
        });

        dateOfBirth.valueProperty().addListener((obs,stara,nova)->{
            if(dateOfBirth.getValue().isAfter(LocalDate.now())){
                dateOfBirth.getEditor().getStyleClass().removeAll("ispravno");
                dateOfBirth.getEditor().getStyleClass().add("nijeIspravno");
            }else{
                dateOfBirth.getEditor().getStyleClass().removeAll("nijeIspravno");
                dateOfBirth.getEditor().getStyleClass().add("ispravno");

            }
        });

        addressPatient.textProperty().addListener((obs,stara,nova)->{
            if(addressPatient.getText().isEmpty()){
                addressPatient.getStyleClass().removeAll("ispravno");
                addressPatient.getStyleClass().add("nijeIspravno");
            }else{
               addressPatient.getStyleClass().removeAll("nijeIspravno");
               addressPatient.getStyleClass().add("ispravno");

            }
        });

        emailPatient.textProperty().addListener((obs,stara,nova)->{
            if(!validationEmail(emailPatient.getText())){
                emailPatient.getStyleClass().removeAll("ispravno");
                emailPatient.getStyleClass().add("nijeIspravno");
            }else{
                emailPatient.getStyleClass().removeAll("nijeIspravno");
                emailPatient.getStyleClass().add("ispravno");

            }
        });

        phoneNumberPatient.textProperty().addListener((obs,stara,nova)->{
            if(!validationPhone(phoneNumberPatient.getText())){
                phoneNumberPatient.getStyleClass().removeAll("ispravno");
                phoneNumberPatient.getStyleClass().add("nijeIspravno");
            }else{
                phoneNumberPatient.getStyleClass().removeAll("nijeIspravno");
                phoneNumberPatient.getStyleClass().add("ispravno");

            }
        });


        umbgPatient.textProperty().addListener((obs,stara,nova)-> {
            String novi = umbgPatient.getText();

            int i = 0;
            if (novi.length() < 7) {
                umbgPatient.getStyleClass().removeAll("ispravno");
                umbgPatient.getStyleClass().add("nijeIspravno");


            } else if (novi.length() >= 7) {
                String datum = dateOfBirth.getValue().toString();
                String spol = new String();

                String dan = String.valueOf(datum.charAt(8)) + datum.charAt(9);
                String mjesec = String.valueOf(datum.charAt(5)) + datum.charAt(6);
                String godina = String.valueOf(datum.charAt(1)) + datum.charAt(2) + datum.charAt(3);
                datum = dan + mjesec + godina;


                if (!datum.equals(novi.substring(0, 7))) {
                    umbgPatient.getStyleClass().removeAll("ispravno");
                    umbgPatient.getStyleClass().add("nijeIspravno");

                }




                else {
                    umbgPatient.getStyleClass().removeAll("nijeIspravno");
                    umbgPatient.getStyleClass().add("ispravno");
                }
            }


        });
    }

    public void validation(char znak){
        int broj = 0;
        if(znak == '1') broj += 1;
        else if(znak == '2') broj += 2;
        else if(znak == '3') broj += 3;
        else if(znak == '4') broj += 4;
        else if(znak == '5') broj += 5;
        else if(znak == '6') broj += 6;
        else if(znak == '7') broj += 7;
        else if(znak == '8') broj += 8;
        else if(znak == '9') broj += 9;


    }

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


    public boolean validationEmail(String s){
        if(s.matches("[a-z]+[A-z0-9._]+@[a-z]+\\.+[a-z.]+")) return true;
        return false;
    }
    public boolean validationPhone(String s){
        if(s.matches("[0-9]+")) return  true;
        return false;
    }
}
