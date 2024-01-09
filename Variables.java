import java.util.*;

public abstract class Variables implements Enrolled, SOA{
    char yearL;
    String studentCourse, admitType, studentType, schedule, paymentTerm;
    String yearLevel, yearTerm;
    float defaultGrade = 0;
    static int sNum = 1002;
    static int eNum = 9002;
    static int rNum = 1;
    Map<String, String> studentInfo = new LinkedHashMap<>();
    Map<String, String> teacherInfo = new LinkedHashMap<>();
    Map<String, String> reqInfo = new TreeMap<>();
    static Map<String, String> newSteps = new TreeMap<>(){{
	    put("STEP 1" ,"Fill out the application form provided.");
	    put("STEP 2" ,"Pay the required amount indicated on the assessment form or the reservation fee at the Cashier's window or through other payment methods.");
	    put("STEP 3" ,"Get the official receipt. If paid online, send the receipt to the provided details in PAYMENT TERMS");
	    put("STEP 4" ,"Prepare the necessary admission requirements for submission on or before the start of classes.");
    }};
    static Map<String, String> oldSteps = new TreeMap<>(){{
	    put("STEP 1" ,"Fill out the reservation form in the application form if you would like to reserve a slot.");
	    put("STEP 2" ,"Request an assessment form face-to-face.");
	    put("STEP 3" ,"Pay the required amount indicated on the assessment form or the reservation fee at the Cashier's window or through other payment methods.");
	    put("STEP 4" ,"Get the official receipt.");
    }};
    static Map<String, String> freshmenReq = new TreeMap<>(){{
	    put("REQUIREMENT 1","Original Form 138 / SF9-SHS (Learner's Progress Report Card)");
	    put("REQUIREMENT 2","Original Form 137 / SF10-SHS (Learner's Permanent Academic Record)");
	    put("REQUIREMENT 3","NSO/PSA-issued Birth Certificate");
    }};
    static Map<String, String> transfereesReq = new TreeMap<>(){{
	    put("REQUIREMENT 1","Certificate of Transfer (Honorable Dismissal)");
	    put("REQUIREMENT 2","Official Transcript of Records");
	    put("REQUIREMENT 3","NSO/PSA-issued Birth Certificate");
    }};
    static Map<String, String> req1 = new LinkedHashMap<>(){{
            put("FIRST NAME", "Juan"); put("MIDDLE NAME", "NA"); put("LAST NAME", "Penduco");
            put("SUFFIX", "NA"); put("YEAR GRADUATED", "2022");  
            put("COURSE","BACHELOR OF SCIENCE IN INFORMATION TECHNOLOGY (BSIT)"); put("RECORD REQUESTED", "Diploma");
            put("PURPOSE", "For Job Application"); 
            put("EMAIL ADDRESS", "juanpenduco@gmail.com"); put("CONTACT NUMBER", "09566245046");            
        }};
    static Map<Integer, Map<String, String>> docuRequest = new TreeMap<>(){{put(1, req1);}};
    static Map<Integer, Map<String, String>> finishedReq = new TreeMap<>();
    static Map<String, Map<String, String>> archivedStud = new TreeMap<>();
    static Map<String, String> resInitialize = new LinkedHashMap<>(){{
            put("FIRST NAME", "Juan"); put("MIDDLE NAME", "Penduco"); put("LAST NAME", "Dela Cruz"); put("SUFFIX", "NA");
            put("CONTACT NUMBER", "09566245046"); put("EMAIL ADDRESS", "juandelacruz@gmail.com"); put("FACEBOOK ACCOUNT", "Juan Dela Cruz");
            put("GUARDIAN NAME", "Juliana Dela Cruz"); put("GUARDIAN'S NUMBER", "09664484142"); put("GUARDIAN'S EMAIL", "julianadelacruz@gmail.com");
            put("TERM", "1st Term"); put("YEAR LEVEL", "3rd Year"); put("STUDENT TYPE", "Regular"); 
            put("COURSE","BACHELOR OF SCIENCE IN INFORMATION TECHNOLOGY (BSIT)"); put("PREVIOUS SECTION", "BSIT 2A");
            put("PREFERRED SCHEDULE", "AM"); put("EXISTING SCHOLARSHIP", "President's List"); put("PAYMENT TERMS", "Cash");
        }};
    static Map<String, Map<String, String>> reserved = new LinkedHashMap<>(){{put("2023-1001", resInitialize);}};
    
    static Map<String, String> tInitialize = new LinkedHashMap<>(){{
            put("FIRST NAME", "Juan");
            put("MIDDLE NAME", "NA");
            put("LAST NAME", "Dela Cruz");
            put("SUFFIX", "NA");
            put("BIRTHDATE", "02/28/1998");
            put("DATE EMPLOYED", "05/14/2019");
            put("EMAIL", "jdcruz@gmail.com");
            put("USERNAME", "cruz.9001");
            put("PASSWORD", "cruz.05142019");
        }};
    static Map<String, String> tInitialize2 = new LinkedHashMap<>(){{
            put("FIRST NAME", "Juan");
            put("MIDDLE NAME", "Pedro");
            put("LAST NAME", "Penduco");
            put("SUFFIX", "NA");
            put("BIRTHDATE", "02/28/1998");
            put("DATE EMPLOYED", "05/14/2019");
            put("EMAIL", "jppenduco@gmail.com");
            put("USERNAME", "penduco.9002");
            put("PASSWORD", "penduco.05142019");
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
    static String adminPass = "0000";
    public void lineGenerator(){
        for(int i = 0; i < 23; i++){
            System.out.print("------");
        }
        System.out.println();
    }
}
