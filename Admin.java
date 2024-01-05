import java.util.*;

public class Admin extends Variables implements Courses  {
    Admin(){
        Scanner scn = new Scanner(System.in);
        System.out.println("-------------------------------------------------- ADMIN PORTAL ---------------------------------------------------");
        System.out.print("""
            What would you like to do?
            1 - Student List
            2 - Teacher List
            3 - Add Blog
            4 - Add Teacher Credentials
            5 - Edit Payment Info
            6 - Edit Admission Requirements/Steps
            7 - Edit About
            8 - Edit Courses
            """);
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            int adminDo = scn.nextInt();

            if(adminDo == 0){
                new Employee();
                break;
            }
            if(adminDo == 1){
                studentList();
                break;
            }
            if(adminDo == 2){
                teacherList();
                break;
            }
            if(adminDo == 3){
                //addBlog();
                break;
            }
            if(adminDo == 4){
                //addTeacher();
                break;
            }
            if(adminDo == 5){
                //editPInfo();
                break;
            }
            if(adminDo == 6){
                //editAdmission();
                break;
            }
            if(adminDo == 7){
                //editAbout();
                break;
            }
            if(adminDo == 8){
                editCourse();
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public void studentList(){
        //Student List
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                --------------------------------------------------- STUDENT LIST --------------------------------------------------
                Please pick the course you would like to view students of.
                """);
        lineGenerator();
        for(Map.Entry e: courses.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            int choice = scn.nextInt();

            if(choice == 0){
                new Admin();
                break;
            }
            if(courses.containsKey(choice)){
                lineGenerator();
                        System.out.print("""
                            What would you like to do?
                            1 - View Student Information
                            2 - Remove a Student
                            3 - View Archived Students
                            4 - Edit Student Information
                            """);
                lineGenerator();
                while(true){
                    System.out.print("Your Answer (0 to go back): ");
                    int doAdmin = scn.nextInt();
                    if(doAdmin == 0){
                        studentList();
                        break;
                    }
                    if(doAdmin == 1){
                        lineGenerator();
                        for(Map.Entry e: enrolled.entrySet()){
                            Map<String, String> value = (Map<String, String>) e.getValue();
                            if(value.get("Course") == courses.get(choice)){
                                System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                                if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Middle Name"));
                                }
                                if(!value.get("Suffix").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Suffix"));
                                }
                            }
                        }
                        lineGenerator();
                        while(true){
                            System.out.print("Enter the student number of the student you would like to view information of (0 to go back): ");
                            String viewInfo = scn.next();
                            if(viewInfo.equals("0")){
                                studentList();
                                break;
                            }
                            if(enrolled.containsKey(viewInfo)){
                                lineGenerator();
                                for(Map.Entry e: enrolled.entrySet()){
                                    if(e.getKey().equals(viewInfo)){
                                        Map<String, String> value = (Map<String, String>) e.getValue();
                                        System.out.println(e.getKey());
                                        for(Map.Entry f: value.entrySet()){
                                            System.out.println(f.getKey() + ": " + f.getValue());
                                        }
                                    }
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Press 0 to go back: ");
                                    int back = scn.nextInt();
                                    if(back == 0){
                                        studentList();
                                        break;
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Student does not exist. Please try again.");
                            }
                        }
                        break;
                    }
                    if(doAdmin == 2){
                        lineGenerator();
                        for(Map.Entry e: enrolled.entrySet()){
                            Map<String, String> value = (Map<String, String>) e.getValue();
                            if(value.get("Course") == courses.get(choice)){
                                System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                                if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Middle Name"));
                                }
                                if(!value.get("Suffix").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Suffix"));
                                }
                            }
                        }
                        lineGenerator();
                        while(true){
                            System.out.print("Enter the student number of the student you would like to remove (0 to go back): ");
                            String removeStd = scn.next();
                            if(removeStd.equals(0)){
                                studentList();
                                break;
                            }
                            if(enrolled.containsKey(removeStd)){
                                System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                                char yn = scn.next().toUpperCase().charAt(0);
                                if(yn == 'Y'){
                                    archiveStudent(removeStd);
                                    System.out.println("The student has been removed successfully and moved to archives.");
                                    while(true){
                                        System.out.print("Press 0 to go back: ");
                                        int back = scn.nextInt();
                                        if(back == 0){
                                            studentList();
                                            break;
                                        }
                                    }
                                }
                                else{
                                    studentList();
                                }
                                break;
                            }
                            else{
                                System.out.print("Student does not exist. Please try again.");
                            }
                        }
                        break;
                    }
                    if(doAdmin == 3){
                        lineGenerator();
                        System.out.println("Here are the archived students: ");
                        for(Map.Entry e: archivedStud.entrySet()){
                            Map<String, String> value = (Map<String, String>) e.getValue();
                            if(value.get("Course") == courses.get(choice)){
                                System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                                if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Middle Name"));
                                }
                                if(!value.get("Suffix").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Suffix"));
                                }
                            }
                        }
                        lineGenerator();
                        System.out.print("""
                            What would you like to do?
                            1 - Restore a Student's Information
                            2 - Delete a Student's Information Permanently
                            """);
                        lineGenerator();
                        while(true){
                            System.out.print("Your Answer (0 to go back): ");
                            int archive = scn.nextInt();

                            if(archive == 0){
                                studentList();
                                break;
                            }
                            if(archive == 1){
                                System.out.println("Here are the archived students: ");
                                for(Map.Entry e: archivedStud.entrySet()){
                                    Map<String, String> value = (Map<String, String>) e.getValue();
                                    if(value.get("Course") == courses.get(choice)){
                                        System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                                        if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                                            System.out.print(value.get(" Middle Name"));
                                        }
                                        if(!value.get("Suffix").equalsIgnoreCase("NA")){
                                            System.out.print(value.get(" Suffix"));
                                        }
                                    }
                                }
                                while(true){
                                    System.out.println("Enter the student number of the student you would like to restore (0 to go back): ");
                                    String restore = scn.next();
                                    if(restore.equals("0")){
                                        studentList();
                                        break;
                                    }
                                    if(archivedStud.containsKey(restore)){
                                        restoreStudent(restore);
                                        System.out.println("The student has been restored.");
                                        while(true){
                                            System.out.print("Press 0 to go back to student list: ");
                                            int back = scn.nextInt();
                                            if(back == 0){
                                                studentList();
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("Student does not exist. Please try again.");
                                    }
                                }
                            }
                            if(archive == 2){
                                System.out.println("Here are the archived students: ");
                                for(Map.Entry e: archivedStud.entrySet()){
                                    Map<String, String> value = (Map<String, String>) e.getValue();
                                    if(value.get("Course") == courses.get(choice)){
                                        System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                                        if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                                            System.out.print(value.get(" Middle Name"));
                                        }
                                        if(!value.get("Suffix").equalsIgnoreCase("NA")){
                                            System.out.print(value.get(" Suffix"));
                                        }
                                    }
                                }
                                while(true){
                                    System.out.println("Enter the student number of the student you would like to remove (0 to go back): ");
                                    String removeP = scn.next();
                                    if(removeP.equals("0")){
                                        studentList();
                                        break;
                                    }
                                    if(archivedStud.containsKey(removeP)){
                                        System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                                        char yn = scn.next().toUpperCase().charAt(0);
                                        if(yn == 'Y'){
                                            archiveStudent(removeP);
                                            System.out.println("The student has been removed permanently.");
                                            while(true){
                                                System.out.print("Press 0 to go back: ");
                                                int back = scn.nextInt();
                                                if(back == 0){
                                                    studentList();
                                                    break;
                                                }
                                            }
                                        }
                                        else{
                                            studentList();
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("Student does not exist. Please try again.");
                                    }
                                }
                            }
                            else{
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                    }
                    if(doAdmin == 4){
                        lineGenerator();
                        for(Map.Entry e: enrolled.entrySet()){
                            Map<String, String> value = (Map<String, String>) e.getValue();
                            if(value.get("Course") == courses.get(choice)){
                                System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                                if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Middle Name"));
                                }
                                if(!value.get("Suffix").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Suffix"));
                                }
                            }
                        }
                        lineGenerator();
                        while(true){
                            System.out.print("Enter the student number of the student you would like to edit information of (0 to go back): ");
                            String editInfo = scn.next();
                            if(editInfo.equals("0")){
                                studentList();
                                break;
                            }
                            if(enrolled.containsKey(editInfo)){
                                lineGenerator();
                                System.out.println("Here is the student's current information: ");
                                for(Map.Entry e: enrolled.entrySet()){
                                    if(e.getKey().equals(editInfo)){
                                        Map<String, String> value = (Map<String, String>) e.getValue();
                                        System.out.println(e.getKey());
                                        for(Map.Entry f: value.entrySet()){
                                            System.out.println(f.getKey() + ": " + f.getValue());
                                        }
                                    }
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Enter the information you would like to edit (e.g. Contact Number) (Press 0 to go back): ");
                                    scn.nextLine();
                                    String edit = scn.nextLine();
                                    
                                    if(edit.equals("0")){
                                        studentList();
                                        break;
                                    }
                                    if(enrolled.get(editInfo).containsKey(edit)){
                                        System.out.print("Enter the updated information: ");
                                        enrolled.get(editInfo).replace(edit, scn.nextLine());
                                        lineGenerator();
                                        System.out.println("Here is the student's updated information: ");
                                        for(Map.Entry e: enrolled.entrySet()){
                                            if(e.getKey().equals(editInfo)){
                                                Map<String, String> value = (Map<String, String>) e.getValue();
                                                System.out.println(e.getKey());
                                                for(Map.Entry f: value.entrySet()){
                                                    System.out.println(f.getKey() + ": " + f.getValue());
                                                }
                                            }
                                        }
                                        lineGenerator();
                                        while(true){
                                            System.out.print("Press 0 to go back: ");
                                            int back = scn.nextInt();
                                            if(back == 0){
                                                studentList();
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("That information does not exist. Please try again.");
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Student does not exist. Please try again.");
                            }
                        }
                        break;
                    }
                }
                break;
            }
            if(!courses.containsKey(choice)){
                System.out.println("This course does not exist! Please try again.");
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public void teacherList(){
        //Teacher List
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                --------------------------------------------------- TEACHER LIST --------------------------------------------------
                """);
        lineGenerator();
        System.out.print("""
            What would you like to do?
            1 - View Teacher Information
            2 - Remove a Teacher
            3 - View Archived Teachers
            4 - Edit Teacher Information
        """);
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            int doAdmin = scn.nextInt();
            if(doAdmin == 0){
                teacherList();
                break;
            }
            if(doAdmin == 1){
                lineGenerator();
                for(Map.Entry e: tInfo.entrySet()){
                    Map<String, String> value = (Map<String, String>) e.getValue();
                    System.out.println(e.getKey() + " - " + value.get("Full Name"));
                }
                lineGenerator();
                while(true){
                    System.out.print("Enter the employee number of the teacher you would like to view information of (0 to go back): ");
                    String viewInfo = scn.next();
                    if(viewInfo.equals("0")){
                        teacherList();
                        break;
                    }
                    if(tInfo.containsKey(viewInfo)){
                        lineGenerator();
                        for(Map.Entry e: tInfo.entrySet()){
                            if(e.getKey().equals(viewInfo)){
                                Map<String, String> value = (Map<String, String>) e.getValue();
                                System.out.println(e.getKey());
                                for(Map.Entry f: value.entrySet()){
                                    System.out.println(f.getKey() + ": " + f.getValue());
                                }
                            }
                        }
                        lineGenerator();
                        while(true){
                            System.out.print("Press 0 to go back: ");
                            int back = scn.nextInt();
                            if(back == 0){
                                studentList();
                                break;
                            }
                        }
                        break;
                    }
                    else{
                        System.out.println("Student does not exist. Please try again.");
                    }
                    break;
                }
            }
            if(doAdmin == 2){
                lineGenerator();
                for(Map.Entry e: enrolled.entrySet()){
                    Map<String, String> value = (Map<String, String>) e.getValue();
                    System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                    if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                        System.out.print(value.get(" Middle Name"));
                    }
                        if(!value.get("Suffix").equalsIgnoreCase("NA")){
                            System.out.print(value.get(" Suffix"));
                        }
                }
                lineGenerator();
                while(true){
                    System.out.print("Enter the student number of the student you would like to remove (0 to go back): ");
                    String removeStd = scn.next();
                    if(removeStd.equals(0)){
                        studentList();
                        break;
                    }
                    if(enrolled.containsKey(removeStd)){
                        System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                        char yn = scn.next().toUpperCase().charAt(0);
                        if(yn == 'Y'){
                            archiveStudent(removeStd);
                            System.out.println("The student has been removed successfully and moved to archives.");
                            while(true){
                                System.out.print("Press 0 to go back: ");
                                int back = scn.nextInt();
                                if(back == 0){
                                    studentList();
                                    break;
                                }
                            }
                        }
                        else{
                            studentList();
                        }
                        break;
                    }
                    else{
                        System.out.print("Student does not exist. Please try again.");
                    }
                }
                break;
            }
            if(doAdmin == 3){
                lineGenerator();
                System.out.println("Here are the archived students: ");
                for(Map.Entry e: archivedStud.entrySet()){
                    Map<String, String> value = (Map<String, String>) e.getValue();
                    if(value.get("Course") == courses.get(choice)){
                        System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                        if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                            System.out.print(value.get(" Middle Name"));
                        }
                        if(!value.get("Suffix").equalsIgnoreCase("NA")){
                            System.out.print(value.get(" Suffix"));
                        }
                    }
                }
                lineGenerator();
                System.out.print("""
                    What would you like to do?
                    1 - Restore a Student's Information
                    2 - Delete a Student's Information Permanently
                    """);
                lineGenerator();
                while(true){
                    System.out.print("Your Answer (0 to go back): ");
                    int archive = scn.nextInt();

                    if(archive == 0){
                        studentList();
                        break;
                    }
                    if(archive == 1){
                        System.out.println("Here are the archived students: ");
                        for(Map.Entry e: archivedStud.entrySet()){
                            Map<String, String> value = (Map<String, String>) e.getValue();
                            if(value.get("Course") == courses.get(choice)){
                                System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                                if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Middle Name"));
                                }
                                if(!value.get("Suffix").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Suffix"));
                                }
                            }
                        }
                        while(true){
                            System.out.println("Enter the student number of the student you would like to restore (0 to go back): ");
                            String restore = scn.next();
                            if(restore.equals("0")){
                                studentList();
                                break;
                            }
                            if(archivedStud.containsKey(restore)){
                                restoreStudent(restore);
                                System.out.println("The student has been restored.");
                                while(true){
                                    System.out.print("Press 0 to go back to student list: ");
                                    int back = scn.nextInt();
                                    if(back == 0){
                                        studentList();
                                        break;
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Student does not exist. Please try again.");
                            }
                        }
                    }
                    if(archive == 2){
                        System.out.println("Here are the archived students: ");
                        for(Map.Entry e: archivedStud.entrySet()){
                            Map<String, String> value = (Map<String, String>) e.getValue();
                            if(value.get("Course") == courses.get(choice)){
                                System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                                if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Middle Name"));
                                }
                                if(!value.get("Suffix").equalsIgnoreCase("NA")){
                                    System.out.print(value.get(" Suffix"));
                                }
                            }
                        }
                        while(true){
                            System.out.println("Enter the student number of the student you would like to remove (0 to go back): ");
                            String removeP = scn.next();
                            if(removeP.equals("0")){
                                studentList();
                                break;
                            }
                            if(archivedStud.containsKey(removeP)){
                                System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                                char yn = scn.next().toUpperCase().charAt(0);
                                if(yn == 'Y'){
                                    archiveStudent(removeP);
                                    System.out.println("The student has been removed permanently.");
                                    while(true){
                                        System.out.print("Press 0 to go back: ");
                                        int back = scn.nextInt();
                                        if(back == 0){
                                            studentList();
                                            break;
                                        }
                                    }
                                }
                                else{
                                    studentList();
                                }
                                        break;
                            }
                            else{
                                System.out.println("Student does not exist. Please try again.");
                            }
                        }
                    }
                    else{
                        System.out.println("Invalid input. Please try again.");
                    }
                }
            }
            if(doAdmin == 4){
                lineGenerator();
                for(Map.Entry e: enrolled.entrySet()){
                    Map<String, String> value = (Map<String, String>) e.getValue();
                    if(value.get("Course") == courses.get(choice)){
                        System.out.println(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                        if(!value.get("Middle Name").equalsIgnoreCase("NA")){
                            System.out.print(value.get(" Middle Name"));
                        }
                        if(!value.get("Suffix").equalsIgnoreCase("NA")){
                            System.out.print(value.get(" Suffix"));
                        }
                    }
                }
                lineGenerator();
                while(true){
                    System.out.print("Enter the student number of the student you would like to edit information of (0 to go back): ");
                    String editInfo = scn.next();
                    if(editInfo.equals("0")){
                        studentList();
                        break;
                    }
                    if(enrolled.containsKey(editInfo)){
                        lineGenerator();
                        System.out.println("Here is the student's current information: ");
                        for(Map.Entry e: enrolled.entrySet()){
                            if(e.getKey().equals(editInfo)){
                                Map<String, String> value = (Map<String, String>) e.getValue();
                                System.out.println(e.getKey());
                                for(Map.Entry f: value.entrySet()){
                                    System.out.println(f.getKey() + ": " + f.getValue());
                                }
                            }
                        }
                        lineGenerator();
                        while(true){
                            System.out.print("Enter the information you would like to edit (e.g. Contact Number) (Press 0 to go back): ");
                            scn.nextLine();
                            String edit = scn.nextLine();
                                    
                            if(edit.equals("0")){
                                studentList();
                                break;
                            }
                            if(enrolled.get(editInfo).containsKey(edit)){
                                System.out.print("Enter the updated information: ");
                                enrolled.get(editInfo).replace(edit, scn.nextLine());
                                lineGenerator();
                                System.out.println("Here is the student's updated information: ");
                                for(Map.Entry e: enrolled.entrySet()){
                                    if(e.getKey().equals(editInfo)){
                                        Map<String, String> value = (Map<String, String>) e.getValue();
                                        System.out.println(e.getKey());
                                        for(Map.Entry f: value.entrySet()){
                                            System.out.println(f.getKey() + ": " + f.getValue());
                                        }
                                    }
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Press 0 to go back: ");
                                    int back = scn.nextInt();
                                    if(back == 0){
                                        studentList();
                                        break;
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("That information does not exist. Please try again.");
                            }
                        }
                        break;
                    }
                    else{
                        System.out.println("Student does not exist. Please try again.");
                    }
                }
                break;
            }
        }
        break;
    }
    public void editCourse(){
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
            5 - View Archived Courses
            """);
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            int choice = scn.nextInt();

            if(choice == 0){
                new Admin();
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
                while(true){
                    System.out.print("Press 0 to go back to editing courses/programs: ");
                    int back = scn.nextInt();
                    if(back == 0){
                        new Employee();
                        break;
                    }
                    else{}
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
                while(true){
                    System.out.print("\nPress 0 to go back to editing courses/programs: ");
                    int back = scn.nextInt();
                    if(back == 0){
                        new Employee();
                        break;
                    }
                    else{}
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
                while(true){
                    System.out.print("\nPress 0 to go back to editing courses/programs: ");
                    int back = scn.nextInt();
                    if(back == 0){
                        editCourse();
                        break;
                    }
                    else{}
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
                if(yn == 'Y' && courses.containsKey(remove)){
                    removeCourse(remove);
                    System.out.println("The program has been removed successfully and moved to archives.");
                    lineGenerator();
                    System.out.println("Here are the currently available courses:");
                    for(Map.Entry e: courses.entrySet()){
                        System.out.println(e.getKey() + " - " + e.getValue());
                    }
                    lineGenerator();
                    while(true){
                        System.out.print("Press 0 to go back to editing courses/programs: ");
                        int back = scn.nextInt();
                        if(back == 0){
                            editCourse();
                            break;
                        }
                        else{}
                    }
                }
                else{
                    new Admin();
                }
                break;
            }
            if(choice == 5){
                lineGenerator();
                System.out.println("Here are the currently archived courses:");
                for(Map.Entry e: archivedCourses.entrySet()){
                    System.out.println(e.getKey() + " - " + e.getValue());
                }
                lineGenerator();
                System.out.print("""
                    What would you like to do?
                    1 - View Course Top Skills and Opportunities
                    2 - Delete A Course Permanently
                    3 - Restore A Course
                    """);
                lineGenerator();
                while(true){
                    System.out.print("Your Answer (0 to go back): ");
                    int archive = scn.nextInt();

                    if(archive == 0){
                        editCourse();
                        break;
                    }
                    if(archive == 1){
                        lineGenerator();
                        System.out.println("Here are the currently archived courses:");
                        for(Map.Entry e: archivedCourses.entrySet()){
                            System.out.println(e.getKey() + " - " + e.getValue());
                        }
                        lineGenerator();
                        System.out.print("Please enter the number of the course you would like to view: ");
                        int view = scn.nextInt();
                        lineGenerator();
                        while(true){
                            if(archivedCourses.containsKey(view)){
                                System.out.println(archivedCourses.get(view).toUpperCase());
                                System.out.println("\nTop Skills to Learn: ");
                                System.out.println(archivedSkills.get(archivedCourses.get(view)));
                            
                                System.out.println("\nCareer Opportunities: ");
                                System.out.println(archivedOpp.get(archivedCourses.get(view)));
                                lineGenerator();
                                while(true){
                                    System.out.print("Press 0 to go back: ");
                                    int back = scn.nextInt();
                                    if(back == 0){
                                        editCourse();
                                        break;
                                    }
                                    else{}
                                }
                                break;
                            }
                            else{
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        break;
                    }
                    if(archive == 2){
                        lineGenerator();
                        System.out.println("Here are the currently archived courses:");
                        for(Map.Entry e: archivedCourses.entrySet()){
                            System.out.println(e.getKey() + " - " + e.getValue());
                        }
                        lineGenerator();
                        System.out.print("Enter the number of the course you would like to remove: ");
                        int remove = scn.nextInt();
                        System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                        char yn = scn.next().toUpperCase().charAt(0);
                        if(yn == 'Y' && archivedCourses.containsKey(remove)){
                            removeCourseP(remove);
                            System.out.println("The program has been removed permanently.");
                            lineGenerator();
                            System.out.println("Here are the currently archived courses:");
                            for(Map.Entry e: archivedCourses.entrySet()){
                                System.out.println(e.getKey() + " - " + e.getValue());
                            }
                            lineGenerator();
                            while(true){
                                System.out.print("Press 0 to go back to editing courses/programs: ");
                                int back = scn.nextInt();
                                if(back == 0){
                                    editCourse();
                                    break;
                                }
                                else{}
                            }
                            
                        }
                        else{
                            new Admin();
                        }
                        break;
                    }
                    if(archive == 3){
                        lineGenerator();
                        System.out.println("Here are the currently archived courses:");
                        for(Map.Entry e: archivedCourses.entrySet()){
                            System.out.println(e.getKey() + " - " + e.getValue());
                        }
                        lineGenerator();
                        System.out.print("Enter the number of the course you would like to restore: ");
                        int restore = scn.nextInt();
                        if(archivedCourses.containsKey(restore)){
                            restoreCourse(restore);
                            System.out.println("The program has been restored.");
                            while(true){
                                System.out.print("Press 0 to go back to editing courses/programs: ");
                                int back = scn.nextInt();
                                if(back == 0){
                                    editCourse();
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    //Edit Programs
    int addCourse(String newCourse, String topSkill, String opportunity){
        LinkedList<Integer> list = new LinkedList<>(courses.keySet());
        int newKey = list.getLast()+1;
        courses.put(newKey, newCourse);
        topSkills.put(newCourse, "- " + topSkill);
        opportunities.put(newCourse, "- " + opportunity);
        return newKey;
    }
    void addSkill(int courseNum, String skill){
        topSkills.replace(courses.get(courseNum), topSkills.get(courses.get(courseNum)).concat("\n- " + skill));
    }
    void addOpp(int courseNum, String opp){
        opportunities.replace(courses.get(courseNum), opportunities.get(courses.get(courseNum)).concat("\n- " + opp));
    }
    void removeCourse(int courseNum){
        archivedCourses.put(courseNum, courses.get(courseNum));
        archivedSkills.put(courses.get(courseNum), topSkills.get(courses.get(courseNum)));
        archivedOpp.put(courses.get(courseNum), opportunities.get(courses.get(courseNum)));
        opportunities.remove(courses.get(courseNum));
        topSkills.remove(courses.get(courseNum));
        courses.remove(courseNum);   
    }
    void removeCourseP(int courseNum){
        archivedOpp.remove(archivedCourses.get(courseNum));
        archivedSkills.remove(archivedCourses.get(courseNum));
        archivedCourses.remove(courseNum);
    }
    void restoreCourse(int courseNum){
        courses.put(courseNum, archivedCourses.get(courseNum));
        topSkills.put(archivedCourses.get(courseNum), archivedSkills.get(archivedCourses.get(courseNum)));
        opportunities.put(archivedCourses.get(courseNum), archivedOpp.get(archivedCourses.get(courseNum)));
        archivedOpp.remove(courses.get(courseNum));
        archivedSkills.remove(courses.get(courseNum));
        archivedCourses.remove(courseNum);
    }
    void archiveStudent(String studentNum){
        archivedStud.put(studentNum, enrolled.get(studentNum));
        enrolled.remove(studentNum);
    }
    void removeStudentP(String studentNum){
        archivedStud.put(studentNum, enrolled.get(studentNum));
        enrolled.remove(studentNum);
    }
    void restoreStudent(String studentNum){
        enrolled.put(studentNum, archivedStud.get(studentNum));
        archivedStud.remove(studentNum);
    }
}
