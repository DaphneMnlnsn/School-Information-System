import java.util.*;

public abstract class Variables {
    boolean loop = true;
    int yearL;
    String studentCourse, admitType, studentType, schedule, paymentTerm;
    String yearLevel, yearTerm;
    float defaultGrade = 0;
    Map<String, String> studentInfo = new LinkedHashMap<>();
    Map<String, String> teacherInfo = new LinkedHashMap<>();
    static Map<String, String> newSteps = new TreeMap<>(){{
	    put("Step 1" ,"Fill out the application form provided.");
	    put("Step 2" ,"Pay the required amount indicated on the assessment form or the reservation fee at the Cashier's window or through other payment methods.");
	    put("Step 3" ,"Get the official receipt. If paid online, send the receipt to the provided details in Payment Terms");
	    put("Step 4" ,"Prepare the necessary admission requirements for submission on or before the start of classes.");
    }};
    static Map<String, String> oldSteps = new TreeMap<>(){{
	    put("Step 1" ,"Fill out the reservation form in the application form if you would like to reserve a slot.");
	    put("Step 2" ,"Request an assessment form face-to-face.");
	    put("Step 3" ,"Pay the required amount indicated on the assessment form or the reservation fee at the Cashier's window or through other payment methods.");
	    put("Step 4" ,"Get the official receipt.");
    }};
    static Map<String, String> freshmenReq = new TreeMap<>(){{
	    put("Requirement 1","Original Form 138 / SF9-SHS (Learner's Progress Report Card)");
	    put("Requirement 2","Original Form 137 / SF10-SHS (Learner's Permanent Academic Record)");
	    put("Requirement 3","NSO/PSA-issued Birth Certificate");
    }};
    static Map<String, String> transfereesReq = new TreeMap<>(){{
	    put("Requirement 1","Certificate of Transfer (Honorable Dismissal)");
	    put("Requirement 2","Official Transcript of Records");
	    put("Requirement 3","NSO/PSA-issued Birth Certificate");
    }};
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
            put("Email Address", "juandelacruz@gmail.com"); put("Last School", "Dr. Yanga's Colleges, Inc."); put("Last Program", "Senior High - ICT"); 
            put("Guardian Name", "Juliana Dela Cruz"); put("Guardian's Number", "09664484142"); put("Guardian's Email", "julianadelacruz@gmail.com");
            put("School Email", "penduco.1002@tbd.edu"); put("Password", "penduco.09092002"); put("Section", "BSIT 2A");
        }};
    static Map<String, Map<String, String>> enrolled = new TreeMap<>(){{put("2024-1001", initialize); put("2024-1002", initialize2);}};
    static int sNum = 1002;
    static int eNum = 9002;
    static Map<String, Map<String, String>> archivedStud = new TreeMap<>();
    static Map<Integer, Map<String, String>> reserved = new LinkedHashMap<>();
    static Map<String, String> tInitialize = new LinkedHashMap<>(){{
            put("First Name", "Johnwin");
            put("Middle Name", "NA");
            put("Last Name", "Vendi");
            put("Suffix", "NA");
            put("Birthdate", "02/28/1998");
            put("Date Employed", "05/14/2019");
            put("Email", "jwvendi@gmail.com");
            put("Username", "vendi.9001");
            put("Password", "vendi.05142019");
        }};
    static Map<String, String> tInitialize2 = new LinkedHashMap<>(){{
            put("First Name", "Johnwin");
            put("Middle Name", "NA");
            put("Last Name", "Vendi");
            put("Suffix", "NA");
            put("Birthdate", "02/28/1998");
            put("Date Employed", "05/14/2019");
            put("Email", "jwvendi@gmail.com");
            put("Username", "vendi.9002");
            put("Password", "vendi.05142019");
        }};
    static LinkedList<String> subInitialize = new LinkedList<String>(){{
        add("BSIT Subject 1");
        add("BSIT Subject 4");
    }};
    static LinkedList<String> subInitialize3 = new LinkedList<String>(){{
        add("BSIT Subject 1");
        add("BSIT Subject 7");
    }};
    static LinkedList<String> subInitialize2 = new LinkedList<String>(){{
        add("BSIT Subject 3");
    }};
    static Map<String, LinkedList<String>> tInitialize3 = new LinkedHashMap<>(){{
            put("BSIT 1A", subInitialize);
            put("BSIT 2A", subInitialize2);
        }};
    static Map<String, LinkedList<String>> tInitialize4 = new LinkedHashMap<>(){{
            put("BSIT 1A", subInitialize3);
            put("BSIT 2A", subInitialize2);
        }};
    static Map<String, Map<String, String>> tInfo = new TreeMap<>(){{put("2019-9001", tInitialize); put("2019-9002", tInitialize2);}};
    static Map<String, Map<String, LinkedList<String>>> tSub = new TreeMap<>(){{put("2019-9001", tInitialize3); put("2019-9002", tInitialize4);}};
    static Map<String, Map<String, String>> archivedTInfo = new TreeMap<>();
    static Map<String, Map<String, LinkedList<String>>> archivedTSub = new TreeMap<>();
    String adminUser = "admin";
    String adminPass = "0000";
    public void lineGenerator(){
        for(int i = 0; i < 23; i++){
            System.out.print("-----");
        }
        System.out.println();
    }
}
