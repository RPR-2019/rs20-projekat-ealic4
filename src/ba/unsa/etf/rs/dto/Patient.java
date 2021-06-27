package ba.unsa.etf.rs.dto;


import ba.unsa.etf.rs.Classes.Disease;
import ba.unsa.etf.rs.Classes.Drug;
import ba.unsa.etf.rs.dto.Person;

import java.util.ArrayList;

public class Patient extends Person {

   ArrayList<Disease>diseases = new ArrayList<>();
   ArrayList<Drug> medicines = new ArrayList<>();

}
