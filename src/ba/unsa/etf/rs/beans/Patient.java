package ba.unsa.etf.rs.beans;


import ba.unsa.etf.rs.Classes.Drug;


import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends Person {

   public Patient(String name, String surname, LocalDate dateOfBirth, String umbg, String address, String email, String phoneNumber) {
      super(name, surname, dateOfBirth, umbg, address, email, phoneNumber);

   }
   public  String toString(){
      return  getName() + " " + getSurname() + " " + getUmbg();
   }







}
