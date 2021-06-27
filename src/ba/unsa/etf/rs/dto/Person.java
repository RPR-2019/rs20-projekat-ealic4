package ba.unsa.etf.rs.dto;

import javafx.scene.control.DateCell;

public class Person {
   private String name;
   private String surname;
   private DateCell dateOfBirth;
   private String jmbg;
   private String address;
   private String email;
   private String phoneNumber;

    public Person() {}

    public Person(String name, String surname, DateCell dateOfBirth, String jmbg, String address, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.jmbg = jmbg;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

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

    public DateCell getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateCell dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

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
