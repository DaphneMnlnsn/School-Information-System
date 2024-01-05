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
    static Map<String, String> tInitialize = new LinkedHashMap<>(){{
            put("Full Name", "Johnwin Vendi");
            put("Birthdate", "02/28/1998");
            put("Date Employed", "05/14/2019");
            put("Email", "jwvendi@gmail.com");
            put("Username", "vendi.9001");
            put("Password", "vendi0000");
        }};
    static Map<String, String> tInitialize2 = new LinkedHashMap<>(){{
            put("Full Name", "Johnwin Vendi");
            put("Birthdate", "02/28/1998");
            put("Date Employed", "05/14/2019");
            put("Email", "jwvendi@gmail.com");
            put("Username", "vendi.9001");
            put("Password", "vendi0000");
        }};
    static Map<String, String> tInitialize3 = new LinkedHashMap<>(){{
            put("BSIT 1A", "Computer Programming 1");
            put("BSIT 2A", "Object-Oriented Programming");
            put("BSIT 2B", "Object-Oriented Programming");
            put("BSCpE 2A", "Introduction to Robotics");
            put("BSCpE 3A", "Programming Fundamentals");
            put("BSCS 4A", "Theories in Programming");
        }};
    static Map<String, Map<String, String>> tInfo = new LinkedHashMap<>(){{put("2019-9001", tInitialize); put("2019-9009", tInitialize2);}};
    static Map<String, Map<String, String>> tSub = new LinkedHashMap<>(){{put("2019-9001", tInitialize3); put("2019-9009", tInitialize3);}};
    String adminUser = "admin";
    String adminPass = "0000";
    public void lineGenerator(){
        for(int i = 0; i < 23; i++){
            System.out.print("-----");
        }
        System.out.println();
    }
}
