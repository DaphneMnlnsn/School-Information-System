import java.util.*;

public interface Enrolled {
    static Map<String, String> initialize = new LinkedHashMap<>(){{
            put("COURSE","BACHELOR OF SCIENCE IN INFORMATION TECHNOLOGY (BSIT)"); put("ADMIT TYPE", "New Student");
            put("YEAR LEVEL", "3rd Year"); put("TERM", "1st Term"); put("PAYMENT TERM", "Cash"); put("FIRST NAME", "Juan"); put("MIDDLE NAME", "NA");
            put("LAST NAME", "Dela Cruz"); put("SUFFIX", "NA"); put("GENDER", "Male"); put("CIVIL STATUS", "Single");
            put("CITIZENSHIP", "Filipino"); put("BIRTHDATE", "12/13/2004"); put("BIRTHPLACE", "Marilao, Bulacan");
            put("RELIGION", "Roman Catholic"); put("ADDRESS", "Saog, Marilao, Bulacan"); put("CONTACT NUMBER", "09566245046");
            put("EMAIL ADDRESS", "juandelacruz@gmail.com"); put("LAST SCHOOL", "Dr. Yanga's Colleges, Inc."); put("LAST PROGRAM", "Senior High - ICT"); 
            put("GUARDIAN NAME", "Juliana Dela Cruz"); put("GUARDIAN'S NUMBER", "09664484142"); put("GUARDIAN'S EMAIL", "julianadelacruz@gmail.com");
            put("SCHOOL EMAIL", "delacruz.1001@tbd.edu"); put("PASSWORD", "delacruz.12132004"); put("SECTION", "BSIT 2A");
        }};
    static Map<String, String> initialize2 = new LinkedHashMap<>(){{
            put("COURSE","BACHELOR OF SCIENCE IN INFORMATION TECHNOLOGY (BSIT)"); put("ADMIT TYPE", "New Student");
            put("YEAR LEVEL", "3rd Year"); put("TERM", "1st Term"); put("PAYMENT TERM", "Installment"); put("FIRST NAME", "Juan"); put("MIDDLE NAME", "NA");
            put("LAST NAME", "Penduco"); put("SUFFIX", "NA"); put("GENDER", "Male"); put("CIVIL STATUS", "Single");
            put("CITIZENSHIP", "Filipino"); put("BIRTHDATE", "09/09/2002"); put("BIRTHPLACE", "Marilao, Bulacan");
            put("RELIGION", "Roman Catholic"); put("ADDRESS", "Saog, Marilao, Bulacan"); put("CONTACT NUMBER", "09566245046");
            put("EMAIL ADDRESS", "juanpenduco@gmail.com"); put("LAST SCHOOL", "Dr. Yanga's Colleges, Inc."); put("LAST PROGRAM", "Senior High - ICT"); 
            put("GUARDIAN NAME", "Juliana Dela Cruz"); put("GUARDIAN'S NUMBER", "09664484142"); put("GUARDIAN'S EMAIL", "julianadelacruz@gmail.com");
            put("SCHOOL EMAIL", "penduco.1002@tbd.edu"); put("PASSWORD", "penduco.09092002"); put("SECTION", "BSIT 2A");
        }};
    static Map<String, Map<String, String>> enrolled = new TreeMap<>(){{put("2024-1001", initialize); put("2024-1002", initialize2);}};
}
