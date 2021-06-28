package ba.unsa.etf.rs.dao;

import ba.unsa.etf.rs.beans.Disease;
import ba.unsa.etf.rs.beans.Doctor;
import ba.unsa.etf.rs.beans.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ClinicDAO {


    ObservableList<Doctor> doctors = FXCollections.observableArrayList();
    ObservableList<Patient> patients = FXCollections.observableArrayList();
    PreparedStatement psDoctor,inDoctor,inPatient;

    public ObservableList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ObservableList<Patient> patients) {
        this.patients = patients;
    }
    public ObservableList<Doctor> getDoctors() {
        return doctors;
    }
    public void setDoctors(ObservableList<Doctor> doctors) {
        this.doctors = doctors;
    }
    String url = "jdbc:sqlite:baza.db";
    Connection connection;
    public static ClinicDAO instance = null;

    public static ClinicDAO getInstance() throws SQLException {

                 if(instance == null) new ClinicDAO();

                    return instance;
    }




    public ClinicDAO() {

        try {
            connection = DriverManager.getConnection(url);
            vratiNaDefault();
            regenerisiBazu();
            inDoctor = connection.prepareStatement("INSERT INTO doctor(id,name,surname,date_of_birth,umbg,address,email,phone_number,salary,username,password)values(?,?,?,?,?,?,?,?,?,?,?)");
            psDoctor = connection.prepareStatement("SELECT *FROM doctor");
            inPatient = connection.prepareStatement("INSERT INTO patient(id,name,surname,date_of_birth,umbg,address,email,phone_number)values(?,?,?,?,?,?,?,?)");
            napuni();


        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    void napuni() throws SQLException {
        doctors.add(new Doctor("Nikola","Tesla", LocalDate.of(1960, 06, 12),"1206960499152","Brazilska 1","nikolatesla@gmail.com","033/123-456",2000,"ntesla","tesla"));
        doctors.add(new Doctor("Albert","Einstein",LocalDate.of(1955, 12, 14),"1412955300561","Bosanska 21","alberteinstein@gmail.com","033/234-890",3000,"aeinstein","einstein"));
        addDoctor();


        Disease disease = new Disease("Reumatoidni artritis");
        ArrayList<Disease> diseases = new ArrayList<>();
        diseases.add(disease);


        patients.add(new Patient("Jasmina","Alic",LocalDate.of(1973,05,21),"2106973600153","Alici bb","jasminaalic21@gmail.com","061-123-456",diseases));
        addPatient();
    }

    public void addDoctor() throws SQLException {
        for(Doctor d: doctors) {
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
        }

    }
    public void addPatient() throws SQLException {
        for (Patient p : patients) {
            inPatient.setInt(1, 1);
            inPatient.setString(2, p.getName());
            inPatient.setString(3, p.getSurname());
            inPatient.setString(4, String.valueOf(p.getDateOfBirth()));
            inPatient.setString(5, p.getUmbg());
            inPatient.setString(6, p.getAddress());
            inPatient.setString(7, p.getEmail());
            inPatient.setString(8, p.getPhoneNumber());

            inPatient.executeUpdate();
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
        }catch (Exception e){

        }

    }


}

