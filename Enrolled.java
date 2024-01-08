import java.util.*;

public interface Enrolled {
    static Map<String, String> initialize = new LinkedHashMap<>(){{
            put("Course","Bachelor of Science in Information Technology (BSIT)"); put("Admit Type", "New Student");
            put("Year Level", "3rd Year"); put("Term", "1st Term"); put("First Name", "Juan"); put("Middle Name", "NA");
            put("Last Name", "Dela Cruz"); put("Suffix", "NA"); put("Gender", "Male"); put("Civil Status", "Single");
            put("Citizenship", "Filipino"); put("Birthdate", "12/13/2004"); put("Birthplace", "Marilao, Bulacan");
            put("Religion", "Roman Catholic"); put("Address", "Saog, Marilao, Bulacan"); put("Contact Number", "09566245046");
            put("Email Address", "juandelacruz@gmail.com"); put("Last School", "Dr. Yanga's Colleges, Inc."); put("Last Program", "Senior High - ICT"); 
            put("Guardian Name", "Juliana Dela Cruz"); put("Guardian's Number", "09664484142"); put("Guardian's Email", "julianadelacruz@gmail.com");
            put("School Email", "delacruz.1001@tbd.edu"); put("Password", "delacruz.12132004"); put("Section", "BSIT 2A");
        }};
    static Map<String, String> initialize2 = new LinkedHashMap<>(){{
            put("Course","Bachelor of Science in Information Technology (BSIT)"); put("Admit Type", "New Student");
            put("Year Level", "3rd Year"); put("Term", "1st Term"); put("First Name", "Juan"); put("Middle Name", "NA");
            put("Last Name", "Penduco"); put("Suffix", "NA"); put("Gender", "Male"); put("Civil Status", "Single");
            put("Citizenship", "Filipino"); put("Birthdate", "09/09/2002"); put("Birthplace", "Marilao, Bulacan");
            put("Religion", "Roman Catholic"); put("Address", "Saog, Marilao, Bulacan"); put("Contact Number", "09566245046");
            put("Email Address", "juanpenduco@gmail.com"); put("Last School", "Dr. Yanga's Colleges, Inc."); put("Last Program", "Senior High - ICT"); 
            put("Guardian Name", "Juliana Dela Cruz"); put("Guardian's Number", "09664484142"); put("Guardian's Email", "julianadelacruz@gmail.com");
            put("School Email", "penduco.1002@tbd.edu"); put("Password", "penduco.09092002"); put("Section", "BSIT 2A");
        }};
    static Map<String, Map<String, String>> enrolled = new TreeMap<>(){{put("2024-1001", initialize); put("2024-1002", initialize2);}};
}
