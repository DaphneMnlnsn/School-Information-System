import java.util.*;

public class Student implements Grades, Enrolled {
    Student(){
        System.out.println("-------------------------------------------------------- STUDENT PORTAL ---------------------------------------------------------------");
        while(true){
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter Email : ");
            String email = scn.next();
            String studentNum = "2024-0000";

            System.out.print("Enter Password : ");
            String password = scn.next();

            boolean match = false;
            boolean containsEmail = false;
            for(Map.Entry e: enrolled.entrySet()){
                if(enrolled.get(e.getKey()).get("SCHOOL EMAIL").equals(email)){
                    if(enrolled.get(e.getKey()).get("PASSWORD").equals(password)){
                        match = true;
                        studentNum = e.getKey().toString();
                    }
                    else{
                        containsEmail = true;
                    }
                }
            } 
            if (match) {
                student(studentNum);
                break;
            }
            else if (!containsEmail) {
                System.out.print("\nInvalid Email. ");
            } 
            else if (!match) {
                System.out.print("\nInvalid Password. ");
            }
            System.out.print("Try again (Press Y for yes and any key to go back to Owlie)? ");
            char again = scn.next().toUpperCase().charAt(0);
            if(again != 'Y'){
                new Main();
                break;
            }
            System.out.println();
        }
    }
    private void student(String studentNum) {
        Scanner scn = new Scanner(System.in);
        lineGenerator();
        System.out.println("Welcome, " + enrolled.get(studentNum).get("FIRST NAME") + "!");
        System.out.print("""
            What would you like to do?
            1 - View Grades
            2 - View Subjects
            3 - Statement of Account
            4 - Change Password
            """);
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            String stdDo = scn.next();

            if(stdDo.equals("0")){
                new Student();
                break;
            }
            if(stdDo.equals("1")){
                viewGrades(studentNum);
                break;
            }
            if(stdDo.equals("2")){
                viewSubs(studentNum);
                break;
            }
            if(stdDo.equals("3")){
                viewSOA(studentNum);
                break;
            }
            if(stdDo.equals("4")){
                changePassword(studentNum);
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    private void viewGrades(String studentNum) {
        Scanner scn = new Scanner(System.in);
        lineGenerator();
        System.out.print("""
            Which quarter would you like to view your grades in?
            1 - Prelims
            2 - Midterms
            3 - Prefinals
            4 - Finals
            """);
        lineGenerator();
        while(true){
            System.out.print("Your answer (Press 0 to go back): ");
            String quarter = scn.next();
            if(Integer.parseInt(quarter) == 0){
                student(studentNum);
                break;
            }
            if(Integer.parseInt(quarter) > 0 && Integer.parseInt(quarter) < 5){
                String quarterChoice = "";
                if(Integer.parseInt(quarter) == 1){ quarterChoice = "PRELIMS"; }
                if(Integer.parseInt(quarter) == 2){ quarterChoice = "MIDTERMS"; }
                if(Integer.parseInt(quarter) == 3){ quarterChoice = "PREFINALS"; }
                if(Integer.parseInt(quarter) == 4){ quarterChoice = "FINALS"; }
                for(Map.Entry e: studentGrades.entrySet()){
                    if(e.getKey() == studentNum){
                        for(Map.Entry f: studentGrades.get(e.getKey()).entrySet()){
                            if(f.getKey() == quarterChoice){
                                for(Map.Entry g: studentGrades.get(e.getKey()).get(f.getKey()).entrySet()){
                                    System.out.println(g.getKey() + ": " + g.getValue());
                                }
                            }
                        }
                    }
                }
                lineGenerator();
                System.out.println("Press any key to go back your dashboard.");
                if(scn.next() != null){
                    student(studentNum);
                }
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    private void viewSubs(String studentNum) {
        Scanner scn = new Scanner(System.in);
        String studentCourse = enrolled.get(studentNum).get("COURSE");
        String yearLevel = enrolled.get(studentNum).get("YEAR LEVEL");
        String term = enrolled.get(studentNum).get("TERM");
        lineGenerator();
        System.out.println("Here are your subjects: ");
        for(Map.Entry e: subjectCourse.entrySet()){
            if(e.getKey() == studentCourse){
                System.out.println(Arrays.toString(subjectCourse.get(studentCourse).get(yearLevel).get(term)).replaceAll(", ", "\n- ").replace("[", "- ").replace("]", ""));
            }
        }
        lineGenerator();
        System.out.println("Press any key to go back your dashboard.");
        if(scn.next() != null){
            student(studentNum);
        }
    }
    public void viewSOA(String studentNum){
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                ------------------------------------------------------- STATEMENT OF ACCOUNT ----------------------------------------------------------
                """);
        float assessment = (float) 0.00;
        if(enrolled.get(studentNum).get("PAYMENT TERM").equals("Cash")){
            assessment = courseRatesCash.get(enrolled.get(studentNum).get("COURSE"));
        }
        else{
            assessment = courseRatesIns.get(enrolled.get(studentNum).get("COURSE"));
        }
        float totalBalance = (assessment - studentSOA.get(studentNum).get("PAYMENTS")) - studentSOA.get(studentNum).get("ADJUSTMENTS");
        System.out.println("Assessment: " + assessment);
        System.out.println("Payments: " + studentSOA.get(studentNum).get("PAYMENTS"));
        System.out.println("Adjustments (Discount, etc.): " + studentSOA.get(studentNum).get("ADJUSTMENTS"));
        System.out.print("TOTAL BALANCE: ");
        System.out.printf("%.2f", totalBalance);
        System.out.println();
        lineGenerator();
        System.out.println("Press any key to go back your dashboard.");
        if(scn.next() != null){
            student(studentNum);
        }
    }
    public void changePassword(String studentNum){
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                --------------------------------------------------------- CHANGE PASSWORD -------------------------------------------------------------
                """);
        System.out.print("Here is your current account password: ");
        for(Map.Entry e: enrolled.entrySet()){
            if(e.getKey() == studentNum){
                System.out.println(enrolled.get(studentNum).get("PASSWORD"));
            }
        }
        System.out.print("Enter the new password (Press 0 to go back): ");
        String passNew = scn.nextLine();
        if(passNew.equals("0")){
            student(studentNum);
        }
        else{
            while(true){
                System.out.print("Confirm password (0 to cancel): ");
                String confirmPass = scn.nextLine();
                if(confirmPass.equals("0")){
                    changePassword(studentNum);
                    break;
                }
                if(confirmPass.equals(passNew)){
                    enrolled.get(studentNum).replace("PASSWORD", passNew);
                    System.out.println("Password changed!");
                    lineGenerator();
                    System.out.print("Press any key to re-login: ");
                    if(scn.next() != null){
                        new Student();
                        break;
                    }
                    break;
                }
                else{
                    System.out.println("Passwords do not match. Please try again.");
                }
            }
        }
    }
    public void lineGenerator(){
        for(int i = 0; i < 27; i++){
            System.out.print("-----");
        }
        System.out.println();
    }
}
