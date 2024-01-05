import java.time.Year;
import java.util.*;

public class Admission extends Variables implements Courses{
    Admission(){
        Scanner scn = new Scanner(System.in);
        System.out.println("--------------------------------------------------- ADMISSIONS ----------------------------------------------------");
        System.out.println("------------------------------------------------ Admission Steps --------------------------------------------------");
        //Steps
        System.out.println("--------------------------------------------- Admission Requirements ----------------------------------------------");
        //Requirements
        while(true){
            System.out.print("\nProceed to Online Application? Press Y for yes and N to go back: ");
            char proceed = scn.next().toUpperCase().charAt(0);
            if(proceed == 'Y'){
                applicationForm();
                break;
            }
            if(proceed == 'N'){
                new Main();
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }    
    }
    public void applicationForm(){
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                \n---------------------------------------------- ONLINE APPLICATION ------------------------------------------------
                Kindly fill-out the online application form for a fast and efficient admissions procedure.
                What type of student are you?
                1 - New
                2 - Old/Existing
                """);
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int type = scn.nextInt();
            if(type == 1){
                newStudent();
                break;
            }
            if(type == 2){
                oldStudent();
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public void newStudent(){
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                --------------------------------------------- NEW STUDENT APPLICATION ---------------------------------------------
                Please select the course you would like to take.
                """);
        for(Map.Entry e: courses.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int type = scn.nextInt();
            if(courses.containsKey(type)){
                studentCourse = courses.get(type);
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
        System.out.println("\nYou have chosen the course " + studentCourse);
        studentInfo.put("Course", studentCourse);
        System.out.print("""
                \n------------------------------------------------ APPLICATION INFORMATION ------------------------------------------
                Please select your Admit Type
                1 - New Student
                2 - Transferee
                """);
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int admit = scn.nextInt();
            if(admit == 1){
                admitType = "New Student";
                break;
            }
            if(admit == 2){
                admitType = "Transferee";
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
        studentInfo.put("Admit Type", admitType);
        lineGenerator();
        System.out.print("""
                Please select your Year Level
                1 - First Year
                2 - Second Year
                3 - Third Year
                4 - Fourth Year
                """);
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int year = scn.nextInt();
            if(year == 1){
                yearLevel = "1st Year";
                break;
            }
            if(year == 2){
                yearLevel = "2nd Year";
                break;
            }
            if(year == 3){
                yearLevel = "3rd Year";
                break;
            }
            if(year == 4){
                yearLevel = "4th Year";
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
        studentInfo.put("Year Level", yearLevel);
        lineGenerator();
        System.out.print("""
                Please select the Term
                1 - First Term
                2 - Second Term
                """);
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int term = scn.nextInt();
            if(term == 1){
                yearTerm = "1st Term";
                break;
            }
            if(term == 2){
                yearTerm = "2nd Term";
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
        studentInfo.put("Term", yearTerm);
        System.out.print("""
                ---------------------------------------------------- PERSONAL INFORMATION -----------------------------------------
                """);
        System.out.print("Enter student's first name: ");
        scn.nextLine();
        studentInfo.put("First Name", scn.nextLine());
        System.out.print("Enter student's middle name (NA if no middle name): ");
        String middleName = scn.nextLine();
        if(middleName.equalsIgnoreCase("NA")){
            studentInfo.put("Middle Name", "");
        }
        else{
            studentInfo.put("Middle Name", middleName);
        }
        System.out.print("Enter student's last name: ");
        studentInfo.put("Last Name", scn.nextLine());
        System.out.print("Enter student's suffix name (NA if no suffix): ");
        String suffix = scn.nextLine();
        if(suffix.equalsIgnoreCase("NA")){
            studentInfo.put("Suffix","");
        }
        else{
            studentInfo.put("Suffix", suffix);
        }
        System.out.print("Enter student's gender: ");
        studentInfo.put("Gender",scn.nextLine());
        System.out.print("Enter student's civil status (single or married): ");
        studentInfo.put("Civil Status", scn.nextLine());
        System.out.print("Enter student's citizenship: ");
        studentInfo.put("Citizenship", scn.nextLine());
        System.out.print("Enter student's date of birth (MM/DD/YYYY): ");
        studentInfo.put("Birthdate", scn.nextLine());
        System.out.print("Enter student's birthplace: ");
        studentInfo.put("Birthplace", scn.nextLine());
        System.out.print("Enter student's religion: ");
        studentInfo.put("Religion", scn.nextLine());
        System.out.print("Enter student's complete address: ");
        studentInfo.put("Address", scn.nextLine());
        System.out.print("Enter student's contact number: ");
        studentInfo.put("Contact Number", scn.nextLine());
        System.out.print("Enter student's email address: ");
        studentInfo.put("Email Address", scn.nextLine());
        System.out.print("Enter student's school last attended: ");
        studentInfo.put("Last School", scn.nextLine());
        System.out.print("Enter student's last program: ");
        studentInfo.put("Last Program", scn.nextLine());
        System.out.print("Guardian's Full Name: ");
        studentInfo.put("Guardian Name", scn.nextLine());
        System.out.print("Guardian's Mobile Number: ");
        studentInfo.put("Guardian's Number", scn.nextLine());
        System.out.print("Guardian's Email Address: ");
        studentInfo.put("Guardian's Email", scn.nextLine());

        System.out.print("""
                \n------------------------------------------------ VALIDATION OF DETAILS --------------------------------------------
                """);
        System.out.println("Student Name: " + studentInfo.get("First Name") + " " + studentInfo.get("Middle Name")
        + " " + studentInfo.get("Last Name") + " " + studentInfo.get("Suffix"));
        for(Map.Entry e : studentInfo.entrySet()){
            if(e.getKey() == "First Name" || e.getKey() == "Middle Name" || e.getKey() == "Last Name" || e.getKey() == "Suffix"){
                continue;
            }
            else{
                System.out.println(e.getKey() + ": " + e.getValue());
            }
        }
        while(true){
            System.out.print("Are the details above correct (Press Y for Yes or any key to re-fill out the form)? ");
            char details = scn.next().toUpperCase().charAt(0);
            if(details == 'Y'){
                lineGenerator();
                System.out.println("Your application has been submitted! Please pay to finalize your enrollment.");
                int year = Year.now().getValue();
                studentInfo.put("School Email", studentInfo.get("Last Name").toLowerCase().concat(".").concat(Integer.toString(sNum)).concat("@tbd.edu"));
                studentInfo.put("Password", studentInfo.get("Last Name").toLowerCase().concat(studentInfo.get("Birthdate").replace("/", "")));
                sNum = sNum+1;
                enrolled.put(year + "-" + sNum, studentInfo);

                System.out.println("Proceed to Payments (Press Y for yes or any key for no)?");
                char next = scn.next().toUpperCase().charAt(0);
                if(next == 'Y'){
                    new Payments();
                }
                else{
                    new Main();
                }
                break;
            }
            if(details == 'N'){
                Set<String> keys = new HashSet<>();
                for(Map.Entry e : studentInfo.entrySet()){
                    keys.add(e.getKey().toString());
                }
                studentInfo.keySet().removeAll(keys);
                newStudent();
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public void oldStudent(){
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                ------------------------------------------- APPLICATION FOR EXISTING STUDENTS -------------------------------------
                Fill out the form to reserve a slot in your preferred college program in TBD College.
                """);
        System.out.print("Enter student ID number: ");
        int studentID = scn.nextInt();
        scn.nextLine();
        System.out.print("Enter student's first name: ");
        studentInfo.put("First Name", scn.nextLine());
        System.out.print("Enter student's middle name (NA if no middle name): ");
        String middleName = scn.nextLine();
        if(middleName.equalsIgnoreCase("NA")){
            studentInfo.put("Middle Name", "");
        }
        else{
            studentInfo.put("Middle Name", middleName);
        }
        System.out.print("Enter student's last name: ");
        studentInfo.put("Last Name", scn.nextLine());
        System.out.print("Enter student's suffix name (NA if no suffix): ");
        String suffix = scn.nextLine();
        if(suffix.equalsIgnoreCase("NA")){
            studentInfo.put("Suffix","");
        }
        else{
            studentInfo.put("Suffix", suffix);
        }
        System.out.print("Enter student's contact number: ");
        studentInfo.put("Contact Number", scn.nextLine());
        System.out.print("Enter student's email address: ");
        studentInfo.put("Email Address", scn.nextLine());
        System.out.print("Enter student's Facebook account: ");
        studentInfo.put("Facebook Account", scn.nextLine());
        System.out.print("Guardian's Full Name: ");
        studentInfo.put("Guardian Name", scn.nextLine());
        System.out.print("Guardian's Mobile Number: ");
        studentInfo.put("Guardian's Number", scn.nextLine());
        System.out.print("Guardian's Email Address: ");
        studentInfo.put("Guardian's Email", scn.nextLine());
        lineGenerator();
        System.out.print("""
                Please select the Term
                1 - First Term
                2 - Second Term
                """);
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int term = scn.nextInt();
            if(term == 1){
                yearTerm = "1st Term";
                break;
            }
            if(term == 2){
                yearTerm = "2nd Term";
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
        studentInfo.put("Term", yearTerm);
        lineGenerator();
        System.out.print("""
                Please select your Year Level
                1 - First Year
                2 - Second Year
                3 - Third Year
                4 - Fourth Year
                """);
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int year = scn.nextInt();
            if(year == 1){
                yearLevel = "1st Year";
                break;
            }
            if(year == 2){
                yearLevel = "2nd Year";
                break;
            }
            if(year == 3){
                yearLevel = "3rd Year";
                break;
            }
            if(year == 4){
                yearLevel = "4th Year";
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
        studentInfo.put("Year Level", yearLevel);
        lineGenerator();
        System.out.print("""
                Please select your Student Type
                1 - Regular
                2 - Irregular
                """);
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int type = scn.nextInt();
            if(type == 1){
                studentType = "Regular";
                break;
            }
            if(type == 2){
                studentType = "Irregular";
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
        studentInfo.put("Student Type", admitType);
        lineGenerator();
        System.out.print("""
                Please enter the student's program.
                """);
        for(Map.Entry e: courses.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int type = scn.nextInt();
            if(courses.containsKey(type)){
                studentCourse = courses.get(type);
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
        studentInfo.put("Course", studentCourse);
        lineGenerator();
        System.out.print("\nPrevious Section: ");
        studentInfo.put("Previous Section", scn.next());
        lineGenerator();
        System.out.print("""
                Preferred Schedule
                1 - AM
                2 - PM
                """);
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int sched = scn.nextInt();
            if(sched == 1){
                schedule = "AM";
                break;
            }
            if(sched == 2){
                schedule = "PM";
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
        studentInfo.put("Preferred Schedule", schedule);
        lineGenerator();
        System.out.print("Existing Scholarship: ");
        studentInfo.put("Existing Scholarship", scn.nextLine());
        lineGenerator();
        System.out.print("""
                Payment Terms
                1 - Cash
                2 - Low Downpayment
                3 - Low Monthly Payment
                """);
        lineGenerator();
        while(true){
            System.out.print("Your answer: ");
            int term = scn.nextInt();
            if(term == 1){
                paymentTerm = "Cash";
                break;
            }
            if(term == 2){
                paymentTerm = "Low Downpayment";
                break;
            }
            if(term == 3){
                paymentTerm = "Low Monthly Payment";
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
        studentInfo.put("Payment Term", paymentTerm);
        System.out.print("""
                -------------------------------------------------- CONFIRM RESERVATION --------------------------------------------
                """);
        while(true){
            System.out.print("""
                    Do you hereby confirm your enrollment in TBD College under the specified term and school year?
                    Do you understand that you will settle the necessary assessment fees or pay the Minimum Reservation Fee of Php 1,000(One Thousand Pesos)
                    to complete your enrollment (Y/N)?
                    """);
            char confirm = scn.next().toUpperCase().charAt(0);
            if(confirm == 'Y'){
                lineGenerator();
                System.out.println("Your application has been submitted! Please pay to finalize your enrollment.");
                reserved.put(studentID, studentInfo);
                System.out.println(enrolled.toString());
                System.out.println("Proceed to Payments (Press Y for yes or any key for no)?");
                char next = scn.next().toUpperCase().charAt(0);
                if(next == 'Y'){
                    new Payments();
                }
                else{
                    new Main();
                }
                break;
            }
            if(confirm == 'N'){
                System.out.println("The reservation has been cancelled. You will now be redirected back to Owlie.");
                new Main();
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
