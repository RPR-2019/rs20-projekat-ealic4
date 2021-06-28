package ba.unsa.etf.rs.beans;


import ba.unsa.etf.rs.Classes.Drug;


import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends Person {
   ArrayList<Disease>diseases = new ArrayList();
   public Patient(String name, String surname, LocalDate dateOfBirth, String umbg, String address, String email, String phoneNumber,ArrayList<Disease> disease) {
      super(name, surname, dateOfBirth, umbg, address, email, phoneNumber);
      diseases = disease;
   }







}
