package ba.unsa.etf.rs.beans;

import javafx.scene.control.DateCell;

import java.time.LocalDate;

public class Person {
    private int id;
   private String name;
   private String surname;
   private LocalDate dateOfBirth;
   private String umbg;
   private String address;
   private String email;
   private String phoneNumber;

    public Person() {}

    public Person(String name, String surname, LocalDate dateOfBirth, String umbg, String address, String email, String phoneNumber) {
        this.id = 1;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.umbg = umbg;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getUmbg() { return umbg; }

    public void setUmbg(String umbg) { this.umbg = umbg; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
