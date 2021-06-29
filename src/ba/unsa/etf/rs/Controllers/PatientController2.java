package ba.unsa.etf.rs.Controllers;

import ba.unsa.etf.rs.beans.Patient;
import ba.unsa.etf.rs.dao.ClinicDAO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;

public class PatientController2 {

    SimpleObjectProperty patientX;
    public PatientController2(){}
    /*public PatientController2(SimpleObjectProperty<Patient>patientSimpleObjectProperty){
        patientX = patientSimpleObjectProperty;
    }*/

    ClinicDAO clinicDAO = new ClinicDAO();
    public TextField namePatient,surnamePatient,umbgPatient,addressPatient,emailPatient,phoneNumberPatient;
    public DatePicker dateOfBirth;

    boolean name,surname,date,address,email,phone,umbg;

    public void initialize(){
       /* patientX.addListener((obs, oldKorisnik, newKorisnik) -> {
            if (oldKorisnik != null) {
                //namePatient.textProperty().unbindBidirectional(oldKorisnik.);


            }
            if (newKorisnik == null) {
                namePatient.setText("");
                surnamePatient.setText("");
                dateOfBirth.setValue(null);
                umbgPatient.setText("");
                addressPatient.setText("");
                emailPatient.setText("");
                phoneNumberPatient.setText("");
            } else {
               // namePatient.textProperty().bindBidirectional(newKorisnik.nameProperty());

            }
        });*/
     namePatient.textProperty().addListener((obs,stara,nova)->{
        if(namePatient.getText().isEmpty()){
            namePatient.getStyleClass().removeAll("ispravno");
            namePatient.getStyleClass().add("nijeIspravno");
            name = false;
        }else{
            namePatient.getStyleClass().removeAll("nijeIspravno");
            namePatient.getStyleClass().add("ispravno");
            name = true;

        }
    });

        surnamePatient.textProperty().addListener((obs,stara,nova)->{
        if(surnamePatient.getText().isEmpty()){
            surnamePatient.getStyleClass().removeAll("ispravno");
            surnamePatient.getStyleClass().add("nijeIspravno");
            surname = false;
        }else{
            surnamePatient.getStyleClass().removeAll("nijeIspravno");
            surnamePatient.getStyleClass().add("ispravno");
            surname = true;

        }
    });

        dateOfBirth.valueProperty().addListener((obs,stara,nova)->{
        if(dateOfBirth.getValue().isAfter(LocalDate.now())){
            dateOfBirth.getEditor().getStyleClass().removeAll("ispravno");
            dateOfBirth.getEditor().getStyleClass().add("nijeIspravno");
            date = false;
        }else{
            dateOfBirth.getEditor().getStyleClass().removeAll("nijeIspravno");
            dateOfBirth.getEditor().getStyleClass().add("ispravno");
            date = true;
        }
    });

        addressPatient.textProperty().addListener((obs,stara,nova)->{
        if(addressPatient.getText().isEmpty()){
            addressPatient.getStyleClass().removeAll("ispravno");
            addressPatient.getStyleClass().add("nijeIspravno");
            address = false;
        }else{
            addressPatient.getStyleClass().removeAll("nijeIspravno");
            addressPatient.getStyleClass().add("ispravno");
            address = true;

        }
    });

        emailPatient.textProperty().addListener((obs,stara,nova)->{
        if(!validationEmail(emailPatient.getText())){
            emailPatient.getStyleClass().removeAll("ispravno");
            emailPatient.getStyleClass().add("nijeIspravno");
            email = false;
        }else{
            emailPatient.getStyleClass().removeAll("nijeIspravno");
            emailPatient.getStyleClass().add("ispravno");
            email = true;

        }
    });

        phoneNumberPatient.textProperty().addListener((obs,stara,nova)->{
        if(!validationPhone(phoneNumberPatient.getText())){
            phoneNumberPatient.getStyleClass().removeAll("ispravno");
            phoneNumberPatient.getStyleClass().add("nijeIspravno");
            phone = false;
        }else{
            phoneNumberPatient.getStyleClass().removeAll("nijeIspravno");
            phoneNumberPatient.getStyleClass().add("ispravno");
            phone = true;
        }
    });


        umbgPatient.textProperty().addListener((obs,stara,nova)-> {
        String novi = umbgPatient.getText();

        int i = 0;
        if (novi.length() != 13) {
            umbgPatient.getStyleClass().removeAll("ispravno");
            umbgPatient.getStyleClass().add("nijeIspravno");

            umbg = false;
        } else {
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
                umbg = true;
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
    public boolean validationEmail(String s){
        if(s.matches("[a-z]+[A-z0-9._]+@[a-z]+\\.+[a-z.]+")) return true;
        return false;
    }
    public boolean validationPhone(String s){
        if(s.matches("[0-9]+") && s.length() > 8) return  true;
        return false;
    }
    public void cancel(){
        Stage stage  = (Stage)namePatient.getScene().getWindow();
        stage.close();
    }
    public void ok(){
        if(!name || !surname || !date || !address || !email || !phone || !umbg){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
        }else {

                clinicDAO.addPatient(new Patient(namePatient.getText(),surnamePatient.getText(),
                        dateOfBirth.getValue(),umbgPatient.getText(),addressPatient.getText(),emailPatient.getText(),phoneNumberPatient.getText()));

            cancel();
        }
    }

}
