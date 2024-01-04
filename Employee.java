import java.util.*;

public class Employee extends Admin{
    Employee(){
            admin();
    }
    public void admin(){
        //Edit Course/Programs
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                -------------------------------------------------------- EDIT COURSES ---------------------------------------------
                """);
        System.out.print("""
            What would you like to do?
            1 - Add a Course
            2 - Add a Skill to an Existing Course
            3 - Add an Opportunity to an Existing Course
            4 - Remove a Course
            """);
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            int choice = scn.nextInt();

            if(choice == 0){
                new Main();
                break;
            }
            if(choice == 1){
                lineGenerator();
                System.out.println("Here are the currently available courses:");
                for(Map.Entry e: courses.entrySet()){
                    System.out.println(e.getKey() + " - " + e.getValue());
                }
                lineGenerator();
                scn.nextLine();
                System.out.print("Enter the name of the course (full name and abbreviation enclosed in parentheses): ");
                String courseName = scn.nextLine();                
                System.out.print("Enter a top skill to learn on the course: ");
                String courseSkill = scn.nextLine();
                System.out.print("Enter an opportunity when finishing the course: ");
                String courseOpp = scn.nextLine();
                int newKey = addCourse(courseName, courseSkill, courseOpp);
                while(true){
                    System.out.print("Add another skill (Press Y for yes and any key for No)? ");
                    char yn = scn.next().toUpperCase().charAt(0);
                    if(yn == 'Y'){
                        scn.nextLine();
                        System.out.print("Enter a top skill to learn on the course: ");
                        addSkill(newKey, scn.nextLine());
                    }
                    else{
                        break;
                    }
                }
                while(true){
                    System.out.print("Add another opportunity (Press Y for yes and any key for No)? ");
                    char yn = scn.next().toUpperCase().charAt(0);
                    if(yn == 'Y'){
                        scn.nextLine();
                        System.out.print("Enter an opportunity when finishing the course: ");
                        addOpp(newKey, scn.nextLine());
                    }
                    else{
                        break;
                    }
                }
                System.out.println("The program has been added successfully.");
                lineGenerator();
                System.out.println("Here are the currently available courses:");
                for(Map.Entry e: courses.entrySet()){
                    System.out.println(e.getKey() + " - " + e.getValue());
                }
                lineGenerator();
                System.out.print("Press 0 to go back to editing courses/programs: ");
                int back = scn.nextInt();
                if(back == 0){
                    new Employee();
                }
                
                break;
            }
            if(choice == 2){
                lineGenerator();
                System.out.println("Here are the currently available courses:");
                for(Map.Entry e: courses.entrySet()){
                    System.out.println(e.getKey() + " - " + e.getValue());
                }
                lineGenerator();
                System.out.print("Enter the number of the course you would like to add skills to: ");
                int edit = scn.nextInt();
                scn.nextLine();
                System.out.print("Enter a top skill to learn on the course: ");
                addSkill(edit, scn.nextLine());
                while(true){
                    System.out.print("Add another skill (Press Y for yes and any key for No)? ");
                    char yn = scn.next().toUpperCase().charAt(0);
                    if(yn == 'Y'){
                        scn.nextLine();
                        System.out.print("Enter a top skill to learn on the course: ");
                        addSkill(edit, scn.nextLine());
                    }
                    else{
                        break;
                    }
                }
                lineGenerator();
                System.out.println("The skill/s has been added successfully.");
                System.out.print("\nPress 0 to go back to editing courses/programs: ");
                int back = scn.nextInt();
                if(back == 0){
                    new Employee();
                }
                break;
            }
            if(choice == 3){
                lineGenerator();
                System.out.println("Here are the currently available courses:");
                for(Map.Entry e: courses.entrySet()){
                    System.out.println(e.getKey() + " - " + e.getValue());
                }
                lineGenerator();
                System.out.print("Enter the number of the course you would like to add opportunities to: ");
                int edit = scn.nextInt();
                scn.nextLine();
                System.out.print("Enter an opportunity when finishing the course: ");
                addOpp(edit, scn.nextLine());
                while(true){
                    System.out.print("Add another opportunity (Press Y for yes and any key for No)? ");
                    char yn = scn.next().toUpperCase().charAt(0);
                    if(yn == 'Y'){
                        scn.nextLine();
                        System.out.print("Enter an opportunity when finishing the course: ");
                        addOpp(edit, scn.nextLine());
                    }
                    else{
                        break;
                    }
                }
                lineGenerator();
                System.out.println("The opportunities has been added successfully.");
                System.out.print("\nPress 0 to go back to editing courses/programs: ");
                int back = scn.nextInt();
                if(back == 0){
                    new Employee();
                }
                break;
            }
            if(choice == 4){
                lineGenerator();
                System.out.println("Here are the currently available courses:");
                for(Map.Entry e: courses.entrySet()){
                    System.out.println(e.getKey() + " - " + e.getValue());
                }
                lineGenerator();
                System.out.print("Enter the number of the course you would like to remove: ");
                int remove = scn.nextInt();
                System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                char yn = scn.next().toUpperCase().charAt(0);
                if(yn == 'Y'){
                    removeCourse(remove);
                    System.out.println("The program has been removed successfully.");
                    lineGenerator();
                    System.out.println("Here are the currently available courses:");
                    for(Map.Entry e: courses.entrySet()){
                        System.out.println(e.getKey() + " - " + e.getValue());
                    }
                    lineGenerator();
                    System.out.print("Press 0 to go back to editing courses/programs: ");
                    int back = scn.nextInt();
                    if(back == 0){
                        new Employee();
                    }
                }
                else{
                    new Employee();
                }
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
