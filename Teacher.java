import java.util.*;

public class Teacher extends Variables implements Grades{
    Teacher(String employeeNum){
        System.out.println("---------------------------------------------------------- TEACHER PORTAL ----------------------------------------------------------------");
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome, " + tInfo.get(employeeNum).get("First Name") + "!");
        System.out.print("""
            What would you like to do?
            1 - Edit Student Grades
            2 - View Students
            3 - Change Password
            """);
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            char tchDo = scn.next().charAt(0);

            if(tchDo == '0'){
                new Employee();
                break;
            }
            if(tchDo == '1'){
                editGrades(employeeNum);
                break;
            }
            if(tchDo == '2'){
                viewStudents(employeeNum);
                break;
            }
            if(tchDo == '3'){
                changePassword(employeeNum);
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    private void editGrades(String employeeNum){
        Scanner scn = new Scanner(System.in);
        lineGenerator();
        System.out.println("Select the section you would like to view the students of.");
        for(Map.Entry e: tSub.entrySet()){
            if(e.getKey().equals(employeeNum)){
                Map<String, String> value = (Map<String, String>) e.getValue();
                for(Map.Entry f: value.entrySet()){
                    System.out.println("- " + f.getKey() + ": " + f.getValue());
                }
            }
        }
        lineGenerator(); 
        boolean hasStudent = false;
        String section = "", subjectEdit = "", studentNum = "", quarter = "";
        while(true){
            System.out.print("Your answer (0 to go back): ");
            section = scn.nextLine();
            if(section.equals("0")){
                new Teacher(employeeNum);
                break;
            }
            if(tSub.get(employeeNum).containsKey(section)){
                lineGenerator();
                System.out.println(section + ":");
                for(Map.Entry e: enrolled.entrySet()){
                    if(enrolled.get(e.getKey()).get("Section").equals(section)){
                        hasStudent = true;
                        Map<String, String> value = (Map<String, String>) e.getValue();
                        System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                        if(!value.get("Middle Name").equals("NA")){
                            System.out.print(value.get(" Middle Name"));
                        }
                        if(!value.get("Suffix").equalsIgnoreCase("NA")){
                            System.out.print(value.get(" Suffix"));
                        }
                    }
                }
                if(hasStudent == false){
                    System.out.println("This section has no students listed.");
                    lineGenerator();
                    System.out.print("Press any key to go back: ");
                    if(scn.next() != null){
                        editGrades(employeeNum);
                    }
                }
                break;
            }
            else{
                System.out.println("This section does not exist or is not handled by you. Please try again.");
            }
        }
        lineGenerator();
        if(tSub.get(employeeNum).get(section).size() > 1 && hasStudent){
            System.out.println("Enter the subject you would like to edit/add grades to: ");
            subjectEdit = scn.nextLine();
            System.out.print("Enter the student number of the student you would like to edit/add grades to: ");
            studentNum = scn.next();
        }
        if(tSub.get(employeeNum).get(section).size() == 1 && hasStudent){
            subjectEdit = tSub.get(employeeNum).get(section).get(0);
            System.out.print("Enter the student number of the student you would like to edit/add grades to: ");
            studentNum = scn.next();
        }
        if(hasStudent){
            while(true){
                lineGenerator();
                System.out.print("""
                        Select a term.
                        1 - Prelims
                        2 - Midterms
                        3 - Prefinals
                        4 - Finals
                        """);
                lineGenerator();
                System.out.print("Your answer (0 to go back): ");
                char choice = scn.next().charAt(0);
                if(choice == '0'){
                    editGrades(employeeNum);
                    break;
                }
                if(choice == '1'){ quarter = "Prelims"; break; }
                if(choice == '2'){ quarter = "Midterms"; break; }
                if(choice == '3'){ quarter = "Prefinals"; break; }
                if(choice == '4'){ quarter = "Finals"; break; }
                else{
                    System.out.println("Invalid input. Please try again.");
                }
            }
            lineGenerator();
            System.out.println("Current grade: " + studentGrades.get(studentNum).get(quarter).get(subjectEdit));
            System.out.print("Enter new grade: ");
            studentGrades.get(studentNum).get(quarter).replace(subjectEdit, scn.nextFloat());
            lineGenerator();
            System.out.println("Grade is updated successfully!");
            System.out.println(subjectEdit + ": " + studentGrades.get(studentNum).get(quarter).get(subjectEdit));
            lineGenerator();
            System.out.print("Press any key to go back: ");
            if(scn.next() != null){
                editGrades(employeeNum);
            }
        }
    }
    private void viewStudents(String employeeNum){
        Scanner scn = new Scanner(System.in);
        lineGenerator();
        System.out.println("Select the section you would like to view the students of.");
        for(Map.Entry e: tSub.entrySet()){
            if(e.getKey().equals(employeeNum)){
                Map<String, String> value = (Map<String, String>) e.getValue();
                System.out.println(e.getKey());
                for(Map.Entry f: value.entrySet()){
                    System.out.println("- " + f.getKey() + ": " + f.getValue());
                }
            }
        }
        lineGenerator(); 
        while(true){
            boolean hasStudent = false;
            System.out.print("Your answer (0 to go back): ");
            String section = scn.nextLine();
            if(section.equals("0")){
                new Teacher(employeeNum);
                break;
            }
            if(tSub.get(employeeNum).containsKey(section)){
                lineGenerator();
                System.out.println(section + ":");
                for(Map.Entry e: enrolled.entrySet()){
                    if(enrolled.get(e.getKey()).get("Section").equals(section)){
                        hasStudent = true;
                        Map<String, String> value = (Map<String, String>) e.getValue();
                        System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                        if(!value.get("Middle Name").equals("NA")){
                            System.out.print(value.get(" Middle Name"));
                        }
                        if(!value.get("Suffix").equalsIgnoreCase("NA")){
                            System.out.print(value.get(" Suffix"));
                        }
                    }
                }
                if(hasStudent == false){
                    System.out.println("This section has no students listed.");
                }
                break;
            }
            else{
                System.out.println("This section does not exist or is not handled by you. Please try again.");
            }
        }
        lineGenerator();
        System.out.print("Press any key to go back: ");
        if(scn.next() != null){
            new Teacher(employeeNum);
        }
    }
    public void changePassword(String employeeNum){
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                ----------------------------------------------------------- CHANGE PASSWORD --------------------------------------------------------------
                """);
        System.out.print("Here is your current account password: ");
        for(Map.Entry e: tInfo.entrySet()){
            if(e.getKey() == employeeNum){
                System.out.println(tInfo.get(employeeNum).get("Password"));
            }
        }
        System.out.print("Enter the new password (Press 0 to go back): ");
        String passNew = scn.nextLine();
        if(passNew.equals("0")){
            new Teacher(employeeNum);
        }
        else{
            while(true){
                System.out.print("Confirm password (0 to cancel): ");
                String confirmPass = scn.nextLine();
                if(confirmPass.equals("0")){
                    changePassword(employeeNum);
                    break;
                }
                if(confirmPass.equals(passNew)){
                    tInfo.get(employeeNum).replace("Password", passNew);
                    System.out.println("Password changed!");
                    lineGenerator();
                    System.out.print("Press any key to re-login: ");
                    if(scn.next() != null){
                        new Employee();
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
}
