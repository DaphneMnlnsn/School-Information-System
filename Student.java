import java.util.*;

public class Student extends Variables implements Grades {
    Student(){
        System.out.println("------------------------------------------------ STUDENT PORTAL ---------------------------------------------------");
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
                if(enrolled.get(e.getKey()).get("School Email").equals(email)){
                    if(enrolled.get(e.getKey()).get("Password").equals(password)){
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
        System.out.println("Welcome, " + enrolled.get(studentNum).get("First Name") + "!");
        System.out.print("""
            What would you like to do?
            1 - View Grades
            2 - View Subjects
            """);
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            int stdDo = scn.nextInt();

            if(stdDo == 0){
                new Student();
                break;
            }
            if(stdDo == 1){
                viewGrades(studentNum);
                break;
            }
            if(stdDo == 2){
                viewSubs(studentNum);
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
            int quarter = scn.nextInt();
            if(quarter == 0){
                student(studentNum);
                break;
            }
            if(quarter > 0 && quarter < 5){
                String quarterChoice = "";
                if(quarter == 1){ quarterChoice = "Prelims"; }
                if(quarter == 2){ quarterChoice = "Midterms"; }
                if(quarter == 3){ quarterChoice = "Prefinals"; }
                if(quarter == 4){ quarterChoice = "Finals"; }
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
                String back = scn.next();
                if(back != null){
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
        String studentCourse = enrolled.get(studentNum).get("Course");
        String yearLevel = enrolled.get(studentNum).get("Year Level");
        String term = enrolled.get(studentNum).get("Term");
        lineGenerator();
        System.out.println("Here are your subjects: ");
        for(Map.Entry e: subjectCourse.entrySet()){
            if(e.getKey() == studentCourse){
                System.out.println(Arrays.toString(subjectCourse.get(studentCourse).get(yearLevel).get(term)).replaceAll(", ", "\n- ").replace("[", "- ").replace("]", ""));
            }
        }
        lineGenerator();
        System.out.println("Press any key to go back your dashboard.");
        String back = scn.next();
        if(back != null){
            student(studentNum);
        }
    }
}
