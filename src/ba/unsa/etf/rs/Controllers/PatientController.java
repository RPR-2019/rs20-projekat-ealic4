package ba.unsa.etf.rs.Controllers;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class PatientController {
    public PatientController(){}

    public TextField namePatient,surnamePatient,umbgPatient,addressPatient,emailPatient,phoneNumberPatient;
    public DatePicker dateOfBirth;
    public void initialize(){

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


    public boolean validationEmail(String s){
        if(s.matches("[a-z]+[A-z0-9._]+@[a-z]+\\.+[a-z.]+")) return true;
        return false;
    }
    public boolean validationPhone(String s){
        if(s.matches("[0-9]+")) return  true;
        return false;
    }
}
