package ba.unsa.etf.rs.Classes;

import ba.unsa.etf.rs.beans.Disease;
import ba.unsa.etf.rs.beans.Patient;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedicalRecord extends Patient {

    public MedicalRecord(String name, String surname, LocalDate dateOfBirth, String umbg, String address, String email, String phoneNumber, ArrayList<Disease> disease) {
        super(name, surname, dateOfBirth, umbg, address, email, phoneNumber, disease);
    }
}
