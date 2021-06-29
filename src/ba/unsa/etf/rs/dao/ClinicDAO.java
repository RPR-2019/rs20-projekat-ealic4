package ba.unsa.etf.rs.dao;

import ba.unsa.etf.rs.beans.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ClinicDAO {


    private ObservableList<Doctor> doctors = FXCollections.observableArrayList();
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ObservableList<MedicalTechnician> medicalTechnicians = FXCollections.observableArrayList();
    private ObservableList<Manager>managers = FXCollections.observableArrayList();


    public SimpleObjectProperty<Patient> trenutniPatientProperty() {
        return trenutniPatient;
    }

    public void setTrenutniPatient(Patient trenutniPatient) {
        this.trenutniPatient.set(trenutniPatient);
    }

    private SimpleObjectProperty<Patient> trenutniPatient = new SimpleObjectProperty<>();
    PreparedStatement psDoctor,inDoctor,inPatient,psPatient,psMedicalTechnician,psManager,editPatient;


    public Patient getTrenutniPatient() {
        return trenutniPatient.get();
    }









    public ObservableList<Patient> getPatients() {
        ResultSet resultSet;
        try {
            psPatient = connection.prepareStatement("SELECT  *FROM patient");
            resultSet = psPatient.executeQuery();

            while (resultSet.next()) {


                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                LocalDate dateOfBirth = LocalDate.parse(resultSet.getString(4));
                String umbg = resultSet.getString(5);
                String address = resultSet.getString(6);
                String email = resultSet.getString(7);
                String phoneNumber = resultSet.getString(8);
                patients.add(new Patient(name,surname,dateOfBirth,umbg,address,email,phoneNumber));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return patients;
    }


    public ObservableList<MedicalTechnician> getMedicalTechnicians() {
        ResultSet resultSet;
        try {
            psMedicalTechnician = connection.prepareStatement("SELECT  *FROM medicalTechnician");
            resultSet = psMedicalTechnician.executeQuery();

            while (resultSet.next()) {


                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                LocalDate dateOfBirth = LocalDate.parse(resultSet.getString(4));
                String umbg = resultSet.getString(5);
                String address = resultSet.getString(6);
                String email = resultSet.getString(7);
                String phoneNumber = resultSet.getString(8);
                Double salary = resultSet.getDouble(9);
                String username = resultSet.getString(10);
                String password = resultSet.getString(11);
                medicalTechnicians.add(new MedicalTechnician(name, surname, dateOfBirth, umbg, address, email, phoneNumber, salary, username, password));
            }

            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return medicalTechnicians;
    }
    public ObservableList<Manager> getManagers() {
        try{
            ResultSet resultSet;
            psManager = connection.prepareStatement("SELECT  *FROM manager");
            resultSet = psManager.executeQuery();

            while (resultSet.next()) {


                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                LocalDate dateOfBirth = LocalDate.parse(resultSet.getString(4));
                String umbg = resultSet.getString(5);
                String address = resultSet.getString(6);
                String email = resultSet.getString(7);
                String phoneNumber = resultSet.getString(8);
                Double salary = resultSet.getDouble(9);
                String username = resultSet.getString(10);
                String password = resultSet.getString(11);
                managers.add(new Manager(name, surname, dateOfBirth, umbg, address, email, phoneNumber, salary, username, password));
        }

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
        return managers;
    }

    public void setManagers(ObservableList<Manager> managers) {
        this.managers = managers;
    }



    public void setPatients(ObservableList<Patient> patients) {
        this.patients = patients;
    }

    public ObservableList<Doctor> getDoctors() {ResultSet resultSet = null;
        try {
            psDoctor = connection.prepareStatement("SELECT  *FROM doctor");
            resultSet = psDoctor.executeQuery();

            while (resultSet.next()) {


                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                LocalDate dateOfBirth = LocalDate.parse(resultSet.getString(4));
                String umbg = resultSet.getString(5);
                String address = resultSet.getString(6);
                String email = resultSet.getString(7);
                String phoneNumber = resultSet.getString(8);
                Double salary = resultSet.getDouble(9);
                String username = resultSet.getString(10);
                String password = resultSet.getString(11);
                doctors.add(new Doctor(name,surname,dateOfBirth,umbg,address,email,phoneNumber,salary,username,password));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return doctors;
    }

    public void setDoctors(ObservableList<Doctor> doctors) {
        this.doctors = doctors;
    }



    public void setMedicalTechnicians(ObservableList<MedicalTechnician> medicalTechnicians) {
        this.medicalTechnicians = medicalTechnicians;
    }



    String url = "jdbc:sqlite:baza.db";
    Connection connection;
    public ClinicDAO() {

        try {
            connection = DriverManager.getConnection(url);
            vratiNaDefault();
            regenerisiBazu();

        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public void addDoctor(Doctor d)  {

        try {
            inDoctor= connection.prepareStatement("INSERT INTO doctor(id,name,surname,date_of_birth,umbg,address,email,phone_number,salary,username,password)values (?,?,?,?,?,?,?,?,?,?,?);");
            inDoctor.setInt(1, 1);
            inDoctor.setString(2, d.getName());
            inDoctor.setString(3, d.getSurname());
            inDoctor.setString(4, String.valueOf(d.getDateOfBirth()));
            inDoctor.setString(5, d.getUmbg());
            inDoctor.setString(6, d.getAddress());
            inDoctor.setString(7, d.getEmail());
            inDoctor.setString(8, d.getPhoneNumber());
            inDoctor.setDouble(9, d.getSalary());
            inDoctor.setString(10,d.getUsername());
            inDoctor.setString(11,d.getPassword());

            inDoctor.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }
    public void addPatient(Patient p) {
        try {
            inPatient = connection.prepareStatement("INSERT INTO patient(id,name,surname,date_of_birth,umbg,address,email,phone_number)values (?,?,?,?,?,?,?,?);");


        inPatient.setInt(1, 1);
            inPatient.setString(2, p.getName());
            inPatient.setString(3, p.getSurname());
            inPatient.setString(4, String.valueOf(p.getDateOfBirth()));
            inPatient.setString(5, p.getUmbg());
            inPatient.setString(6, p.getAddress());
            inPatient.setString(7, p.getEmail());
            inPatient.setString(8, p.getPhoneNumber());

            inPatient.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editPatient()  {
        try {
            editPatient = connection.prepareStatement("select *from patient");
            ResultSet resultSet = editPatient.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    private void regenerisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.sql"));
            String sqlUpit = "";
            while (ulaz.hasNext()) {
                sqlUpit += ulaz.nextLine();
                if (sqlUpit.length() > 1 && sqlUpit.charAt(sqlUpit.length() - 1) == ';') {
                    try {
                        Statement stmt = connection.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ne postoji SQL datoteka... nastavljam sa praznom bazom");
        }
    }
    public void vratiNaDefault() throws SQLException {
        Statement stmt = connection.createStatement();
        try {
            stmt.executeUpdate("DELETE FROM doctor");
            stmt.executeUpdate("DELETE FROM patient");
            stmt.executeUpdate("DELETE FROM manager");
            stmt.executeUpdate("DELETE FROM medicalTechnician");
        }catch (Exception e){

        }

    }


}

