import java.util.*;

public abstract class Variables {
    boolean loop = true;
    String studentCourse, admitType, studentType, schedule, paymentTerm;
    String yearLevel, yearTerm;
    Map<String, String> studentInfo = new LinkedHashMap<>();
    static Map<String, String> initialize = new LinkedHashMap<>(){{
            put("Course","Bachelor of Science in Information Technology (BSIT)"); put("Admit Type", "New Student");
            put("Year Level", "3rd Year"); put("Term", "1st Term"); put("First Name", "Juan"); put("Middle Name", "NA");
            put("Last Name", "Dela Cruz"); put("Suffix", "NA"); put("Gender", "Male"); put("Civil Status", "Single");
            put("Citizenship", "Filipino"); put("Birthdate", "12/13/2004"); put("Birthplace", "Marilao, Bulacan");
            put("Religion", "Roman Catholic"); put("Address", "Saog, Marilao, Bulacan"); put("Contact Number", "09566245046");
            put("Email Address", "juandelacruz@gmail.com"); put("Last School", "Dr. Yanga's Colleges, Inc."); put("Last Program", "Senior High - ICT"); 
            put("Guardian Name", "Juliana Dela Cruz"); put("Guardian's Number", "09664484142"); put("Guardian's Email", "julianadelacruz@gmail.com");
            put("School Email", "delacruz.1001"); put("Password", "delacruz12132004");
        }};
    static Map<String, String> initialize2 = new LinkedHashMap<>(){{
            put("Course","Bachelor of Science in Information Technology (BSIT)"); put("Admit Type", "New Student");
            put("Year Level", "3rd Year"); put("Term", "1st Term"); put("First Name", "Juan"); put("Middle Name", "NA");
            put("Last Name", "Penduco"); put("Suffix", "NA"); put("Gender", "Male"); put("Civil Status", "Single");
            put("Citizenship", "Filipino"); put("Birthdate", "09/09/2002"); put("Birthplace", "Marilao, Bulacan");
            put("Religion", "Roman Catholic"); put("Address", "Saog, Marilao, Bulacan"); put("Contact Number", "09566245046");
            put("Email Address", "juandelacruz@gmail.com"); put("Last School", "Dr. Yanga's Colleges, Inc."); put("Last Program", "Senior High - ICT"); 
            put("Guardian Name", "Juliana Dela Cruz"); put("Guardian's Number", "09664484142"); put("Guardian's Email", "julianadelacruz@gmail.com");
            put("School Email", "penduco.1002"); put("Password", "penduco09092002");
        }};
    static Map<String, Map<String, String>> enrolled = new LinkedHashMap<>(){{put("2024-1001", initialize); put("2024-1002", initialize2);}};
    static int sNum = 1002;
    static Map<String, Map<String, String>> archivedStud = new LinkedHashMap<>();
    static Map<Integer, Map<String, String>> reserved = new LinkedHashMap<>();
    String teacherUser[] = {"mauricio.123", "manalansan.456", "lagula.789", "cabangon.038"};
    String teacherPass[] = {"mau0000", "man0000", "lag0000", "cab0000"};
    String adminUser = "admin";
    String adminPass = "0000";
    public void lineGenerator(){
        for(int i = 0; i < 23; i++){
            System.out.print("-----");
        }
        System.out.println();
    }
}
