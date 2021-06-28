package ba.unsa.etf.rs.beans;

import ba.unsa.etf.rs.beans.Employee;
import javafx.scene.control.DateCell;

import java.time.LocalDate;

public class Manager extends Employee {
    public Manager(String name, String surname, LocalDate dateOfBirth, String umbg, String address, String email, String phoneNumber, double salary, String username, String password) {
        super(name, surname, dateOfBirth, umbg, address, email, phoneNumber, salary, username, password);
    }
}
