package ba.unsa.etf.rs.beans;

import javafx.scene.control.DateCell;

import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor extends Employee {


    public Doctor(String name, String surname, LocalDate dateOfBirth, String umbg, String address, String email, String phoneNumber, double salary, String username, String password) {
        super(name, surname, dateOfBirth, umbg, address, email, phoneNumber, salary, username, password);
    }


}
