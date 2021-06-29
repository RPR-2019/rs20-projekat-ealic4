package ba.unsa.etf.rs.beans;

import ba.unsa.etf.rs.beans.Person;
import javafx.scene.control.DateCell;

import java.time.LocalDate;

public class Employee extends Person {
    private String username;
    private String password;
    private double salary;

    public Employee(String name, String surname, LocalDate dateOfBirth, String umbg, String address, String email, String phoneNumber, double salary,String username,String password) {
        super(name, surname, dateOfBirth, umbg, address, email, phoneNumber);
        this.salary = salary;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString(){
        return getName() + " " + getSurname() + " " +getDateOfBirth() + " " +
                getUmbg() + " " + getAddress() + " " + getEmail() + " " + getPhoneNumber() + " "+ getSalary();
    }

}
