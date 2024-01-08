import java.util.*;

public class Admin extends Variables implements Courses  {
    Admin(){
        Scanner scn = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------- ADMIN PORTAL --------------------------------------------------------------");
        System.out.print("""
            What would you like to do?
            1 - Student List
            2 - Teacher List
            3 - Add/Edit Blog
            4 - Add Teacher Credentials
            5 - Edit Payment Info
            6 - Edit Admission Requirements/Steps
            7 - Edit About
            8 - Edit Courses
            9 - View Alumni Document Requests
            10 - Change Password
            """);
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            String adminDo = scn.next();

            if(adminDo.equals("0")){
                new Employee();
                break;
            }
            if(adminDo.equals("1")){
                studentList();
                break;
            }
            if(adminDo.equals("2")){
                teacherList();
                break;
            }
            if(adminDo.equals("3")){
                addBlog();
                break;
            }
            if(adminDo.equals("4")){
                addTeacherCredentials();
                break;
            }
            if(adminDo.equals("5")){
                editPInfo();
                break;
            }
            if(adminDo.equals("6")){
                editAdmission();
                break;
            }
            if(adminDo.equals("7")){
                editAbout();
                break;
            }
            if(adminDo.equals("8")){
                editCourse();
                break;
            }
            if(adminDo.equals("9")){
                viewDocuReq();
                break;
            }
            if(adminDo.equals("10")){
                changePassword();
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
                -------------------------------------------------------------- STUDENT LIST --------------------------------------------------------------
                Please pick the course you would like to view students of.
                """);
        lineGenerator();
        for(Map.Entry e: courses.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back, R to View Reserved Students): ");
            String choice = scn.next();

            if(choice.equals("0")){
                new Admin();
                break;
            }
            if(choice.equalsIgnoreCase("R")){
                boolean hasStudent = false;
                lineGenerator();
                for(Map.Entry e: reserved.entrySet()){
                    Map<String, String> value = (Map<String, String>) e.getValue();
                    if(value != null){hasStudent = true;}
                    System.out.print(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                    if(!value.get("Middle Name").equals("NA")){
                        System.out.print(" " + value.get("Middle Name"));
                    }
                    if(!value.get("Suffix").equalsIgnoreCase("NA")){
                        System.out.print(" " + value.get("Suffix"));
                    }
                    System.out.println();
                }
                if(hasStudent == false){
                    System.out.println("No students listed.");
                }
                if(hasStudent == true){
                    lineGenerator();
                    while(true){
                        System.out.print("Enter the student number of the student you would like to view information of (0 to go back): ");
                        String viewInfo = scn.next();
                        if(viewInfo.equals("0")){
                            studentList();
                            break;
                        }
                        if(reserved.containsKey(viewInfo)){
                            lineGenerator();
                            for(Map.Entry e: reserved.entrySet()){
                                if(e.getKey().equals(viewInfo)){
                                    Map<String, String> value = (Map<String, String>) e.getValue();
                                    System.out.println(e.getKey());
                                    for(Map.Entry f: value.entrySet()){
                                        System.out.println(f.getKey() + ": " + f.getValue());
                                    }
                                }
                            }
                            break;
                        }
                        else{
                            System.out.println("Student does not exist. Please try again.");
                        }
                    }
                }
                lineGenerator();
                System.out.print("Press any key to go back: ");
                if(scn.next() != null){
                    studentList();
                }
                break;
            }
            if(courses.containsKey(Integer.parseInt(choice))){
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
                    char doAdmin = scn.next().charAt(0);
                    if(doAdmin == '0'){
                        studentList();
                        break;
                    }
                    if(doAdmin == '1'){
                        boolean hasStudent = false;
                        hasStudent = displayStd(choice, hasStudent);
                        
                        if(hasStudent == false){
                            System.out.println("No students listed.");
                        }
                        if(hasStudent == true){
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
                                    break;
                                }
                                else{
                                    System.out.println("Student does not exist. Please try again.");
                                }
                            }
                        }
                        lineGenerator();
                        System.out.print("Press any key to go back: ");
                        if(scn.next() != null){
                            studentList();
                        }
                        break;
                    }
                    if(doAdmin == '2'){
                        lineGenerator();
                        boolean hasStudent = false;
                        hasStudent = displayStd(choice, hasStudent);
                        if(hasStudent == false){
                            System.out.println("No students listed.");
                        }
                        if(hasStudent == true){
                            lineGenerator();
                            while(true){
                                System.out.print("Enter the student number of the student you would like to remove (0 to go back): ");
                                String removeStd = scn.next();
                                if(removeStd.equals("0")){
                                    studentList();
                                    break;
                                }
                                if(enrolled.containsKey(removeStd)){
                                    System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                                    char yn = scn.next().toUpperCase().charAt(0);
                                    if(yn == 'Y'){
                                        archiveStudent(removeStd);
                                        System.out.println("The student has been removed successfully and moved to archives.");
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
                        }
                        lineGenerator();
                        System.out.print("Press any key to go back: ");
                        if(scn.next() != null){
                            studentList();
                        }
                        break;
                    }
                    if(doAdmin == '3'){
                        lineGenerator();
                        boolean hasStudent = false;
                        hasStudent = displayArchivedStd(choice, hasStudent);
                        if(hasStudent == false){
                            System.out.println("No students listed.");
                        }
                        if(hasStudent == true){
                            lineGenerator();
                            System.out.print("""
                                What would you like to do?
                                1 - Restore a Student's Information
                                2 - Delete a Student's Information Permanently
                                """);
                            lineGenerator();
                            while(true){
                                System.out.print("Your Answer (0 to go back): ");
                                char archive = scn.next().charAt(0);

                                if(archive == '0'){
                                    studentList();
                                    break;
                                }
                                if(archive == '1'){
                                    displayArchivedStd(choice, hasStudent);
                                    lineGenerator();
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
                                            break;
                                        }
                                        else{
                                            System.out.println("Student does not exist. Please try again.");
                                        }
                                    }
                                    break;
                                }
                                if(archive == '2'){
                                    displayArchivedStd(choice, hasStudent);
                                    lineGenerator();
                                    while(true){
                                        System.out.print("Enter the student number of the student you would like to remove permanently (0 to go back): ");
                                        String removeP = scn.next();
                                        if(removeP.equals("0")){
                                            studentList();
                                            break;
                                        }
                                        if(archivedStud.containsKey(removeP)){
                                            System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                                            char yn = scn.next().toUpperCase().charAt(0);
                                            if(yn == 'Y'){
                                                removeStudentP(removeP);
                                                System.out.println("The student has been removed permanently.");
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
                                    break;
                                }
                                else{
                                    System.out.println("Invalid input. Please try again.");
                                }
                            }
                        }
                        lineGenerator();
                        System.out.print("Press any key to go back to student list: ");
                        if(scn.next() != null){
                            studentList();
                        }
                        break;
                    }
                    if(doAdmin == '4'){
                        lineGenerator();
                        boolean hasStudent = false;
                        hasStudent = displayStd(choice, hasStudent);
                        if(hasStudent == false){
                            System.out.println("No students listed.");
                        }
                        if(hasStudent == true){
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
                        }
                        lineGenerator();
                        System.out.print("Press any key to go back: ");
                        if(scn.next() != null){
                            studentList();
                        }
                        break;
                    }
                }
                break;
            }
            if(!courses.containsKey(Integer.parseInt(choice))){
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
                -------------------------------------------------------------- TEACHER LIST --------------------------------------------------------------
                """);
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
            char doAdmin = scn.next().charAt(0);
            if(doAdmin == '0'){
                new Admin();
                break;
            }
            if(doAdmin == '1'){
                lineGenerator();
                boolean hasTeacher = false;
                hasTeacher = displayTch(hasTeacher);
                if(hasTeacher == false){
                    System.out.println("No teachers listed.");
                }
                if(hasTeacher == true){
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
                            displayHandled(viewInfo);
                            break;
                        }
                        else{
                            System.out.println("Teacher does not exist. Please try again.");
                        }
                        break;
                    }
                }
                lineGenerator();
                System.out.print("Press any key to go back: ");
                if(scn.next() != null){
                    teacherList();
                }
                break;
            }
            if(doAdmin == '2'){
                lineGenerator();
                boolean hasTeacher = false;
                hasTeacher = displayTch(hasTeacher);
                if(hasTeacher == false){
                    System.out.println("No teachers listed.");
                }
                if(hasTeacher == true){
                    lineGenerator();
                    while(true){
                        System.out.print("Enter the employee number of the teacher you would like to remove (0 to go back): ");
                        String removeTch = scn.next();
                        if(removeTch.equals("0")){
                            teacherList();
                            break;
                        }
                        if(tInfo.containsKey(removeTch)){
                            System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                            char yn = scn.next().toUpperCase().charAt(0);
                            if(yn == 'Y'){
                                archiveTeacher(removeTch);
                                System.out.println("The teacher has been removed successfully and moved to archives.");
                            }
                            else{
                                teacherList();
                            }
                            break;
                        }
                        else{
                            System.out.println("Teacher does not exist. Please try again.");
                        }
                    }
                }
                lineGenerator();
                System.out.print("Press any key to go back: ");
                if(scn.next() != null){
                    teacherList();
                }
                break;
            }
            if(doAdmin == '3'){
                lineGenerator();
                boolean hasTeacher = false;
                hasTeacher = displayArchivedTch(hasTeacher);
                if(hasTeacher == false){
                    System.out.println("No teachers listed.");
                }
                if(hasTeacher == true){
                    lineGenerator();
                    System.out.print("""
                        What would you like to do?
                        1 - Restore a Teacher's Information
                        2 - Delete a Teacher's Information Permanently
                        """);
                    lineGenerator();
                    while(true){
                        System.out.print("Your Answer (0 to go back): ");
                        char archive = scn.next().charAt(0);

                        if(archive == '0'){
                            teacherList();
                            break;
                        }
                        if(archive == '1'){
                            lineGenerator();
                            displayArchivedTch(hasTeacher);
                            lineGenerator();
                            while(true){
                                System.out.print("Enter the employee number of the teacher you would like to restore (0 to go back): ");
                                String restore = scn.next();
                                if(restore.equals("0")){
                                    teacherList();
                                    break;
                                }
                                if(archivedTInfo.containsKey(restore)){
                                    restoreTeacher(restore);
                                    System.out.println("The teacher has been restored.");
                                    break;
                                }
                                else{
                                    System.out.println("Teacher does not exist. Please try again.");
                                }
                            }
                            break;
                        }
                        if(archive == '2'){
                            lineGenerator();
                            displayArchivedTch(hasTeacher);
                            lineGenerator();
                            while(true){
                                System.out.print("Enter the employee number of the teacher you would like to remove permanently (0 to go back): ");
                                String removeP = scn.next();
                                if(removeP.equals("0")){
                                    teacherList();
                                    break;
                                }
                                if(archivedTInfo.containsKey(removeP)){
                                    System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                                    char yn = scn.next().toUpperCase().charAt(0);
                                    if(yn == 'Y'){
                                        removeTeacherP(removeP);
                                        System.out.println("The teacher has been removed permanently.");
                                    }
                                    else{
                                        teacherList();
                                    }
                                    break;
                                }
                                else{
                                    System.out.println("Teacher does not exist. Please try again.");
                                }
                            }
                            break;
                        }
                        else{
                            System.out.println("Invalid input. Please try again.");
                        }
                    }
                }
                lineGenerator();
                System.out.print("Press any key to go back to teacher list: ");
                if(scn.next() != null){
                    teacherList();
                }
                break;
            }
            if(doAdmin == '4'){
                lineGenerator();
                boolean hasTeacher = false;
                hasTeacher = displayTch(hasTeacher);
                if(hasTeacher == false){
                    System.out.println("No teachers listed.");
                }
                if(hasTeacher == true){
                    lineGenerator();
                    while(true){
                        System.out.print("Enter the employee number of the teacher you would like to edit information of (0 to go back): ");
                        String editInfo = scn.next();
                        if(editInfo.equals("0")){
                            teacherList();
                            break;
                        }
                        if(tInfo.containsKey(editInfo)){
                            lineGenerator();
                            System.out.println("Here is the teacher's current information: ");
                            for(Map.Entry e: tInfo.entrySet()){
                                if(e.getKey().equals(editInfo)){
                                    Map<String, String> value = (Map<String, String>) e.getValue();
                                    System.out.println(e.getKey());
                                    for(Map.Entry f: value.entrySet()){
                                        System.out.println(f.getKey() + ": " + f.getValue());
                                    }
                                }
                            }
                            lineGenerator();
                            displayHandled(editInfo);
                            lineGenerator();
                            while(true){
                                System.out.print("Enter the information you would like to edit (e.g. Email) (Press 0 to go back, 1 to remove a section handled, 2 to add a section/subject handled): ");
                                scn.nextLine();
                                String edit = scn.nextLine();
                                        
                                if(edit.equals("0")){
                                    teacherList();
                                    break;
                                }
                                if(edit.equals("1")){
                                    while(true){
                                        lineGenerator();
                                        System.out.print("""
                                                What would you like to do?
                                                1 - Remove a whole handled section
                                                2 - Remove a subject within a handled section
                                                """);
                                        System.out.print("Your answer (0 to go back): ");
                                        char removeChoice = scn.next().charAt(0);
                                        if(removeChoice == '0'){
                                            teacherList();
                                            break;
                                        }
                                        if(removeChoice == '1'){
                                            System.out.print("Enter the section handled you would like to remove permanently (0 to go back): ");
                                            scn.nextLine();
                                            String removeP = scn.nextLine().toUpperCase();
                                            if(removeP.equals("0")){
                                                teacherList();
                                                break;
                                            }
                                            if(tSub.get(editInfo).containsKey(removeP)){
                                                System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                                                char yn = scn.next().toUpperCase().charAt(0);
                                                if(yn == 'Y'){
                                                    removeHandled(editInfo, removeP);
                                                    System.out.println("The section handled has been removed permanently.");
                                                }
                                                else{
                                                    teacherList();
                                                }
                                                break;
                                            }
                                            else{
                                                System.out.println("Subject does not exist. Please try again.");
                                            }
                                            break;
                                        }
                                        if(removeChoice == '2'){
                                            System.out.print("Enter the section with the subject to be removed (0 to go back): ");
                                            scn.nextLine();
                                            String section = scn.nextLine().toUpperCase();
                                            lineGenerator();
                                            System.out.println("Here are the subjects handled within the section: " + tSub.get(editInfo).get(section));
                                            lineGenerator();
                                            while(true){
                                                System.out.print("Enter the subject to be removed permanently (0 to go back): ");
                                                String removeSubject = scn.nextLine();
                                                if(removeSubject.equals("0")){
                                                    teacherList();
                                                    break;
                                                }
                                                if(tSub.get(editInfo).get(section).contains(removeSubject)){
                                                    System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                                                    char yn = scn.next().toUpperCase().charAt(0);
                                                    if(yn == 'Y'){
                                                        int subjectRemove = tSub.get(editInfo).get(section).indexOf(removeSubject);
                                                        tSub.get(editInfo).get(section).remove(subjectRemove);
                                                        System.out.println("The section handled has been removed permanently.");
                                                        lineGenerator();
                                                        System.out.println("Here are the subjects handled within the section: " + tSub.get(editInfo).get(section));
                                                    }
                                                    else{
                                                        teacherList();
                                                    }
                                                    break;
                                                }
                                                else{
                                                    System.out.println("This subject does not exist. Please try again.");
                                                }
                                            }
                                            break;
                                        }
                                        else{
                                            System.out.println("Invalid input. Please try again.");
                                        }
                                    }
                                    break;
                                }
                                if(edit.equals("2")){
                                    while(true){
                                        lineGenerator();
                                        System.out.print("""
                                                What would you like to do?
                                                1 - Add a section and subject handled
                                                2 - Add a subject handled in an existing section handled
                                                """);
                                        lineGenerator();
                                        System.out.print("Your answer (0 to go back): ");
                                        char add = scn.next().charAt(0);
                                        if(add == '0'){
                                            teacherList();
                                            break;
                                        }
                                        if(add == '1'){
                                            System.out.print("Enter the section handled (e.g. BSIT 2A): ");
                                            scn.nextLine();
                                            String section = scn.nextLine();
                                            System.out.print("Enter the subject handled: ");
                                            String subject = scn.nextLine();
                                            addHandled(editInfo, section, subject);
                                            System.out.println("The section handled has been added.");
                                        }
                                        if(add == '2'){
                                        lineGenerator();
                                            displayHandled(editInfo);
                                            lineGenerator(); 
                                            while(true){
                                                System.out.print("Enter the section to add a subject handled to: ");
                                                scn.nextLine();
                                                String section = scn.nextLine();
                                                if(tSub.get(editInfo).containsKey(section)){
                                                    while(true){
                                                        System.out.print("Enter the subject handled: ");
                                                        String subject = scn.nextLine();
                                                        if(tSub.get(editInfo).get(section).contains(subject)){
                                                            System.out.println("This subject is already handled by the teacher! Please enter a different subject.");
                                                        }
                                                        else{
                                                            addHandledSub(editInfo, section, subject);
                                                            System.out.println("The subject handled has been added.");
                                                            lineGenerator();
                                                            displayHandled(editInfo);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else{
                                                    System.out.println("Section is not handled by this teacher. Please try again.");
                                                }
                                            }
                                        }
                                    }
                                    break;
                                }
                                if(tInfo.get(editInfo).containsKey(edit)){
                                    System.out.print("Enter the updated information: ");
                                    tInfo.get(editInfo).replace(edit, scn.nextLine());
                                    lineGenerator();
                                    System.out.println("Here is the teachers's updated information: ");
                                    for(Map.Entry e: tInfo.entrySet()){
                                        if(e.getKey().equals(editInfo)){
                                            Map<String, String> value = (Map<String, String>) e.getValue();
                                            System.out.println(e.getKey());
                                            for(Map.Entry f: value.entrySet()){
                                                System.out.println(f.getKey() + ": " + f.getValue());
                                            }
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
                            System.out.println("Teacher does not exist. Please try again.");
                        }
                    }
                }
                lineGenerator();
                System.out.print("Press any key to go back: ");
                if(scn.next() != null){
                    teacherList();
                }
                break;
            }
            else{
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }
    public void addBlog(){
        //Edit/Add Blog
        Scanner scn = new Scanner(System.in);
        Blog blog = new Blog();
        System.out.print("""
                ------------------------------------------------------------- EDIT/ADD BLOG --------------------------------------------------------------
                """);
        System.out.print("""
            Which blog article would you like to edit?
            """);
        blog.displayBlog();
        blog.setArticleSize();
        int blogSize = blog.getArticleSize();
        System.out.println((blogSize+1) + " - Add New Blog Article");
        System.out.println((blogSize+2) + " - Remove Blog Article");
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            String choice = scn.next();

            if(choice.equals("0")){
                new Admin();
                break;
            }
            if(Integer.parseInt(choice) <= blogSize){
                blog.setToRetrieve(Integer.parseInt(choice));
                System.out.println("Current Details: ");
                String blogCurrent = blog.getHeadline();
                System.out.println(blogCurrent);
                System.out.println("\n" + blog.getArticle());
                lineGenerator();
                System.out.print("Enter new headline of " + blogCurrent + " (press 0 if you want the headline to remain as is): ");
                scn.nextLine();
                String headline = scn.nextLine();
                if(!headline.equals("0")){
                    blog.setHeadline(headline);
                }
                if(headline.equals("0")){}
                System.out.print("Enter article: ");
                blog.setArticle(scn.nextLine());
                lineGenerator();
                System.out.println("Updated successfully!");
                System.out.println("Current Headline: " + blog.getHeadline());
                System.out.println("Current Content:\n" + blog.getArticle());
                System.out.print("Press any key to go back: ");
                String back = scn.next();
                if(back != null){
                    addBlog();
                }
                break;
            }
            if(Integer.parseInt(choice) == blogSize+1){
                System.out.print("Enter headline: ");
                scn.nextLine();
                String newHeadline = scn.nextLine();
                System.out.print("Enter article content: ");
                String newArticle = scn.nextLine();
                blog.setHeadline(newHeadline, newArticle);
                blog.setArticleSize();
                lineGenerator();
                System.out.println("Article added successfully!");
                System.out.println("New Article Details: ");
                blog.setToRetrieve(blog.getArticleSize());
                System.out.println(blog.getHeadline());
                System.out.println("\n" + blog.getArticle());
                System.out.print("\nPress any key to go back: ");
                if(scn.next() != null){
                    addBlog();
                }
                break;
            }
            if(Integer.parseInt(choice) == blogSize+2){
                lineGenerator();
                System.out.print("""
                    Which blog article would you like to remove?
                    """);
                blog.displayBlog();
                lineGenerator();
                while(true){
                    System.out.print("Your Answer (0 to go back): ");
                    String remove = scn.next();
                    blog.setToRetrieve(Integer.parseInt(remove));
                    if(Integer.parseInt(remove) == 0){
                        addBlog();
                        break;
                    }
                    if(Integer.parseInt(remove) <= blogSize){
                        System.out.print("Are you sure (0 to go back or any key to continue)? ");
                        char sure = scn.next().charAt(0);
                        if(sure == '0'){
                            addBlog();
                        }
                        else{
                            blog.removeHeadline();
                            System.out.println("Article has been removed successfully!");
                            System.out.print("\nPress any key to go back: ");
                            if(scn.next() != null){
                                addBlog();
                            }
                        }
                        break;
                    }
                    else{
                        System.out.println("Invalid input. Please try again.");
                    }
                }
                break;  
            }
            else{
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }
    public void addTeacherCredentials(){
        System.out.print("""
                --------------------------------------------------------------- ADD TEACHER --------------------------------------------------------------
                """);
        Scanner scn = new Scanner(System.in);
        System.out.println("Here are the current teachers:");
        for(Map.Entry e: tInfo.entrySet()){
            Map<String, String> value = (Map<String, String>) e.getValue();
            System.out.print(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
            if(!value.get("Middle Name").equals("NA")){
                System.out.print(" " + value.get("Middle Name"));
            }
            if(!value.get("Suffix").equals("NA")){
                System.out.print(" " + value.get("Suffix"));
            }
            System.out.println();
        }
        lineGenerator();
        System.out.print("Enter first name (Press 0 to go back): ");
        String firstName = scn.nextLine();
        if(firstName.equals("0")){
            new Admin();
        }
        else{
            teacherInfo.put("First Name", firstName);
            System.out.print("Enter middle name (NA if no middle): ");
            teacherInfo.put("Middle Name", scn.nextLine());
            System.out.print("Enter last name: ");
            teacherInfo.put("Last Name", scn.nextLine());
            System.out.print("Enter suffix name (NA if no suffix): ");
            teacherInfo.put("Suffix", scn.nextLine());
            System.out.print("Enter birthday (MM/DD/YYYY): ");
            teacherInfo.put("Birthdate", scn.nextLine());
            System.out.print("Enter date employed (MM/DD/YYYY): ");
            teacherInfo.put("Date Employed", scn.nextLine());
            System.out.print("Enter email address: ");
            teacherInfo.put("Email", scn.nextLine());
            System.out.print("Enter the section handled (e.g. BSIT 2A): ");
            String section = scn.nextLine();
            System.out.print("Enter the subject handled: ");
            String subject = scn.nextLine();
            

            System.out.print("""
            \n---------------------------------------------------------- VALIDATION OF DETAILS ---------------------------------------------------------
            """);
            System.out.print("Teacher Name: " + teacherInfo.get("Last Name") + ", " + teacherInfo.get("First Name"));
            if(!teacherInfo.get("Middle Name").equals("NA")){
                System.out.print(" " + teacherInfo.get("Middle Name"));
            }
            if(!teacherInfo.get("Suffix").equals("NA")){
                System.out.print(" " + teacherInfo.get("Suffix"));
            }
            System.out.println();
            for(Map.Entry e : teacherInfo.entrySet()){
                if(e.getKey() == "First Name" || e.getKey() == "Middle Name" || e.getKey() == "Last Name" || e.getKey() == "Suffix"){
                    continue;
                }
                else{
                    System.out.println(e.getKey() + ": " + e.getValue());
                }
            }
            System.out.println("Section Handled: " + section);
            System.out.println("Subject Handled: " + subject);
            while(true){
                System.out.print("Are the details above correct (Press Y for Yes or any key to re-fill out the form)? ");
                char details = scn.next().toUpperCase().charAt(0);
                if(details == 'Y'){
                    lineGenerator();
                    System.out.println("The teacher has been added.\n");
                    String year = teacherInfo.get("Date Employed").substring(6);
                    eNum = eNum+1;
                    String employeeNumber = year + "-" + eNum;
                    teacherInfo.put("Username", teacherInfo.get("Last Name").toLowerCase().concat(".").concat(Integer.toString(eNum)));
                    teacherInfo.put("Password", teacherInfo.get("Last Name").toLowerCase().concat("." + teacherInfo.get("Date Employed").replace("/", "")));
                    tInfo.put(employeeNumber, teacherInfo);
                    addHandledNew(employeeNumber, section, subject);
                    System.out.println("Your username is " + teacherInfo.get("Username"));
                    System.out.println("Your password is " + teacherInfo.get("Password"));
                    lineGenerator();
                    System.out.print("Press any key to go back: ");
                    if(scn.next() != null){
                        new Admin();
                        break;
                    }
                    break;
                }
                else{
                    Set<String> keys = new HashSet<>();
                    for(Map.Entry e : teacherInfo.entrySet()){
                        keys.add(e.getKey().toString());
                    }
                    teacherInfo.keySet().removeAll(keys);
                    addTeacherCredentials();
                    break;
                }
            }
        }
    }
    public void editPInfo(){
        //Edit Payment Info
        Scanner scn = new Scanner(System.in);
        Payments payment = new Payments();
        System.out.print("""
                ----------------------------------------------------- EDIT PAYMENT INFO ------------------------------------------------------------------
                """);
        System.out.print("""
            Which payment method would you like to edit?
            """);
        payment.displayPaymentMethod();
        payment.setPaymentSize();
        int paymentSize = payment.getPaymentSize();
        System.out.println((paymentSize+1) + " - Edit Email");
        System.out.println((paymentSize+2) + " - Add New Payment Method");
        System.out.println((paymentSize+3) + " - Remove Payment Method");
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            String choice = scn.next();

            if(Integer.parseInt(choice) == 0){
                new Admin();
                break;
            }
            if(Integer.parseInt(choice) <= paymentSize){
                payment.setToRetrieve(Integer.parseInt(choice));
                System.out.println("Current Details: ");
                String paymentMethodCurrent = payment.getPaymentMethod();
                System.out.println(paymentMethodCurrent);
                System.out.println("Account Number: " + payment.getAccount());
                System.out.println("Account Name: " + payment.getAccountName());
                lineGenerator();
                System.out.print("Enter account number of " + paymentMethodCurrent + " account: ");
                scn.nextLine();
                payment.setAccount(scn.nextLine());
                System.out.print("Enter name of owner: ");
                payment.setAccountName(scn.nextLine());
                lineGenerator();
                System.out.println("Updated successfully!");
                System.out.println("Current " + paymentMethodCurrent + " Account Number: " + payment.getAccount());
                System.out.println("Current " + paymentMethodCurrent + " Account Name: " + payment.getAccountName());
                System.out.print("Press any key to go back: ");
                String paymentResetKey = scn.next();
                if(paymentResetKey != null){
                    editPInfo();
                }
                break;
            }
            if(Integer.parseInt(choice) == paymentSize+1){
                lineGenerator();
                System.out.println("Current Email Address: " + payment.getEmailLink());
                lineGenerator();
                System.out.print("Enter email where receipt can be sent: ");
                scn.nextLine();
                payment.setEmail(scn.nextLine());
                lineGenerator();
                System.out.println("Updated successfully!");
                System.out.println("Updated Email Address: " + payment.getEmailLink());
                System.out.print("\nPress any key to go back: ");
                if(scn.next() != null){
                    editPInfo();
                }
                break;
            }
            if(Integer.parseInt(choice) == paymentSize+2){
                System.out.print("Enter new payment method name (e.g. Metrobank): ");
                scn.nextLine();
                String newMethod = scn.nextLine();
                System.out.print("Enter account number: ");
                String newAccount = scn.nextLine();
                System.out.print("Enter name of owner: ");
                String newOwner = scn.nextLine();
                payment.setAccount(newMethod, newAccount, newOwner);
                payment.setPaymentSize();
                lineGenerator();
                System.out.println("Payment method added successfully!");
                System.out.println("New Payment Method Details: ");
                payment.setToRetrieve(payment.getPaymentSize());
                System.out.println(payment.getPaymentMethod());
                System.out.println("Account Number: " + payment.getAccount());
                System.out.println("Account Name: " + payment.getAccountName());
                System.out.print("\nPress any key to go back: ");
                if(scn.next() != null){
                    editPInfo();
                }
                break;
            }
            if(Integer.parseInt(choice) == paymentSize+3){
                lineGenerator();
                System.out.print("""
                    Which payment method would you like to remove?
                    """);
                payment.displayPaymentMethod();
                lineGenerator();
                while(true){
                    System.out.print("Your Answer (0 to go back): ");
                    String remove = scn.next();
                    payment.setToRetrieve(Integer.parseInt(remove));
                    if(Integer.parseInt(remove) == 0){
                        editPInfo();
                        break;
                    }
                    if(Integer.parseInt(remove) <= paymentSize){
                        System.out.print("Are you sure (0 to go back or any key to continue)? ");
                        char sure = scn.next().charAt(0);
                        if(sure == '0'){
                            editPInfo();
                            break;
                        }
                        else{
                            payment.removeAccount();
                            System.out.println("Payment Method has been removed successfully!");
                            System.out.print("\nPress any key to go back: ");
                            if(scn.next() != null){
                                editPInfo();
                            }
                        }
                        break;
                    }
                    else{
                        System.out.println("Invalid input. Please try again.");
                    }
                }
                break;  
            }
            else{
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }
    public void editAdmission(){
        //Edit Admission Steps/Requirements
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                ---------------------------------------------------------- EDIT ADMISSION ----------------------------------------------------------------
                """);
        System.out.print("""
            What would you like to edit?
            1 - Admission Steps
            2 - Admission Requirements
            """);
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            String choice = scn.next();

            if(Integer.parseInt(choice) == 0){
                new Admin();
                break;
            }
            if(Integer.parseInt(choice) == 1){
                while(true){
                    lineGenerator();
                    System.out.print("""
                        What would you like to do?
                        1 - Edit a Step
                        2 - Add a Step
                        3 - Remove a Step
                        """);
                    lineGenerator();
                    System.out.print("Your answer (0 to go back): ");
                    String doEdit = scn.next();
                    if(Integer.parseInt(doEdit) == 0){
                        editAdmission();
                        break;
                    }
                    if(Integer.parseInt(doEdit) == 1){
                        while(true){
                            System.out.print("Press N to edit steps for New Students and L for Old Students: ");
                            char newOld = scn.next().toUpperCase().charAt(0);
                            if(newOld == 'N'){
                                lineGenerator();
                                System.out.println("Here are the current steps:");
                                for (Map.Entry entryy : newSteps.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Enter Step and then its number you would like to edit (e.g. Step 1)(0 to go back): ");
                                    scn.nextLine();
                                    String stepEdit = scn.nextLine();
                                    if(stepEdit.equals("0")){
                                        editAdmission();
                                        break;
                                    }
                                    if(newSteps.containsKey(stepEdit)){
                                        System.out.print("Enter the new step details: ");
                                        newSteps.replace(stepEdit, scn.nextLine());
                                        System.out.println("Step edited successfully.");
                                        System.out.print("\nPress any key to go back: ");
                                        if(scn.next() != null){
                                            editAdmission();
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("This step does not exist. Please try again.");
                                    }
                                }
                                break;
                            }
                            if(newOld == 'L'){
                                lineGenerator();
                                System.out.println("Here are the current steps:");
                                for (Map.Entry entryy : oldSteps.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Enter Step and then its number you would like to edit (e.g. Step 1)(0 to go back): ");
                                    scn.nextLine();
                                    String stepEdit = scn.nextLine();
                                    if(stepEdit.equals("0")){
                                        editAdmission();
                                        break;
                                    }
                                    if(oldSteps.containsKey(stepEdit)){
                                        System.out.print("Enter the new step details: ");
                                        oldSteps.replace(stepEdit, scn.nextLine());
                                        System.out.println("Step edited successfully.");
                                        System.out.print("\nPress any key to go back: ");
                                        if(scn.next() != null){
                                            editAdmission();
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("This step does not exist. Please try again.");
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        break;
                    }
                    if(Integer.parseInt(doEdit) == 2){
                        while(true){
                            System.out.print("Press N to add steps for New Students and L for Old Students: ");
                            char newOld = scn.next().toUpperCase().charAt(0);
                            if(newOld == 'N'){
                                lineGenerator();
                                System.out.println("Here are the current steps:");
                                for (Map.Entry entryy : newSteps.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                System.out.print("Enter step number (0 to go back): ");
                                scn.nextLine();
                                String stepAdd = scn.nextLine();
                                if(stepAdd.equals("0")){
                                    editAdmission();
                                    break;
                                }
                                System.out.print("Enter step details: ");
                                newSteps.put(stepAdd, scn.nextLine());
                                System.out.println("Step added successfully.");
                                System.out.print("\nPress any key to go back: ");
                                if(scn.next() != null){
                                    editAdmission();
                                }
                                break;
                            }
                            if(newOld == 'L'){
                                lineGenerator();
                                System.out.println("Here are the current steps:");
                                for (Map.Entry entryy : oldSteps.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                System.out.print("Enter step number (0 to go back): ");
                                scn.nextLine();
                                String stepAdd = scn.nextLine();
                                if(stepAdd.equals("0")){
                                    editAdmission();
                                    break;
                                }
                                System.out.print("Enter step details: ");
                                oldSteps.put(stepAdd, scn.nextLine());
                                System.out.println("Step added successfully.");
                                System.out.print("\nPress any key to go back: ");
                                if(scn.next() != null){
                                    editAdmission();
                                }
                                break;
                            }
                            else{
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        break;
                    }
                    if(Integer.parseInt(doEdit) == 3){
                        while(true){
                            System.out.print("Press N to remove steps for New Students and L for Old Students: ");
                            char newOld = scn.next().toUpperCase().charAt(0);
                            if(newOld == 'N'){
                                lineGenerator();
                                System.out.println("Here are the current steps:");
                                for (Map.Entry entryy : newSteps.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Enter the step you would like to remove (e.g. Step 1)(0 to go back): ");
                                    scn.nextLine();
                                    String stepEdit = scn.nextLine();
                                    if(stepEdit.equals("0")){
                                        editAdmission();
                                        break;
                                    }
                                    if(newSteps.containsKey(stepEdit)){
                                        newSteps.remove(stepEdit);
                                        System.out.println("Step deleted successfully.");
                                        System.out.print("\nPress any key to go back: ");
                                        if(scn.next() != null){
                                            editAdmission();
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("This step does not exist. Please try again.");
                                    }
                                }
                                break;
                            }
                            if(newOld == 'L'){
                                lineGenerator();
                                System.out.println("Here are the current steps:");
                                for (Map.Entry entryy : oldSteps.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Enter the step you would like to remove (e.g. Step 1)(0 to go back): ");
                                    scn.nextLine();
                                    String stepEdit = scn.nextLine();
                                    if(stepEdit.equals("0")){
                                        editAdmission();
                                        break;
                                    }
                                    if(oldSteps.containsKey(stepEdit)){
                                        oldSteps.remove(stepEdit, scn.nextLine());
                                        System.out.println("Step deleted successfully.");
                                        System.out.print("\nPress any key to go back: ");
                                        if(scn.next() != null){
                                            editAdmission();
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("This step does not exist. Please try again.");
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        break;
                    }
                }
                break;
            }
            if(Integer.parseInt(choice) == 2){
                while(true){
                    lineGenerator();
                    System.out.print("""
                        What would you like to do?
                        1 - Edit a Requirement
                        2 - Add a Requirement
                        3 - Remove a Requirement
                        """);
                    lineGenerator();
                    System.out.print("Your answer (0 to go back): ");
                    char doEdit = scn.next().charAt(0);
                    if(doEdit == '0'){
                        editAdmission();
                        break;
                    }
                    if(doEdit == '1'){
                        while(true){
                            System.out.print("Press F to edit requirements for Freshmen and T for Transferees: ");
                            char newOld = scn.next().toUpperCase().charAt(0);
                            if(newOld == 'F'){
                                lineGenerator();
                                System.out.println("Here are the current requirements:");
                                for (Map.Entry entryy : freshmenReq.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Enter requirement and then its number you would like to edit (e.g. Requirement 1)(0 to go back): ");
                                    scn.nextLine();
                                    String reqEdit = scn.nextLine();
                                    if(reqEdit.equals("0")){
                                        editAdmission();
                                        break;
                                    }
                                    if(freshmenReq.containsKey(reqEdit)){
                                        System.out.print("Enter the new requirement details: ");
                                        newSteps.replace(reqEdit, scn.nextLine());
                                        System.out.println("Requirement edited successfully.");
                                        System.out.print("\nPress any key to go back: ");
                                        if(scn.next() != null){
                                            editAdmission();
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("This requirement does not exist. Please try again.");
                                    }
                                }
                                break;
                            }
                            if(newOld == 'T'){
                                lineGenerator();
                                System.out.println("Here are the current requirements:");
                                for (Map.Entry entryy : transfereesReq.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Enter requirement and then its number you would like to edit (e.g. Requirement 1)(0 to go back): ");
                                    scn.nextLine();
                                    String reqEdit = scn.nextLine();
                                    if(reqEdit.equals("0")){
                                        editAdmission();
                                        break;
                                    }
                                    if(transfereesReq.containsKey(reqEdit)){
                                        System.out.print("Enter the new requirement details: ");
                                        transfereesReq.replace(reqEdit, scn.nextLine());
                                        System.out.println("Requirement edited successfully.");
                                        System.out.print("\nPress any key to go back: ");
                                        if(scn.next() != null){
                                            editAdmission();
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("This requirement does not exist. Please try again.");
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        break;
                    }
                    if(doEdit == '2'){
                        while(true){
                            System.out.print("Press F to add steps for Freshmen and T for Transferees: ");
                            char newOld = scn.next().toUpperCase().charAt(0);
                            if(newOld == 'F'){
                                lineGenerator();
                                System.out.println("Here are the current requirements:");
                                for (Map.Entry entryy : freshmenReq.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                System.out.print("Enter requirement number (e.g. Requirement 1)(0 to go back): ");
                                scn.nextLine();
                                String reqAdd = scn.nextLine();
                                if(reqAdd.equals("0")){
                                    editAdmission();
                                    break;
                                }
                                System.out.print("Enter requirement details: ");
                                freshmenReq.put(reqAdd, scn.nextLine());
                                System.out.println("Requirement added successfully.");
                                System.out.print("\nPress any key to go back: ");
                                if(scn.next() != null){
                                    editAdmission();
                                }
                                break;
                            }
                            if(newOld == 'T'){
                                lineGenerator();
                                System.out.println("Here are the current requirements:");
                                for (Map.Entry entryy : transfereesReq.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                System.out.print("Enter requirement number (e.g. Requirement 1)(0 to go back): ");
                                scn.nextLine();
                                String reqAdd = scn.nextLine();
                                if(reqAdd.equals("0")){
                                    editAdmission();
                                    break;
                                }
                                System.out.print("Enter requirement details: ");
                                transfereesReq.put(reqAdd, scn.nextLine());
                                System.out.println("Requirement added successfully.");
                                System.out.print("\nPress any key to go back: ");
                                if(scn.next() != null){
                                    editAdmission();
                                }
                                break;
                            }
                            else{
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        break;
                    }
                    if(doEdit == '3'){
                        while(true){
                            System.out.print("Press F to remove requirements for Freshmen and T for Transferees: ");
                            char newOld = scn.next().toUpperCase().charAt(0);
                            if(newOld == 'F'){
                                lineGenerator();
                                System.out.println("Here are the current requirements:");
                                for (Map.Entry entryy : freshmenReq.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Enter the requirement you would like to remove (e.g. Requirement 1)(0 to go back): ");
                                    scn.nextLine();
                                    String reqRemove = scn.nextLine();
                                    if(reqRemove.equals("0")){
                                        editAdmission();
                                        break;
                                    }
                                    if(freshmenReq.containsKey(reqRemove)){
                                        freshmenReq.remove(reqRemove);
                                        System.out.println("Requirement deleted successfully.");
                                        System.out.print("\nPress any key to go back: ");
                                        if(scn.next() != null){
                                            editAdmission();
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("This requirement does not exist. Please try again.");
                                    }
                                }
                                break;
                            }
                            if(newOld == 'T'){
                                lineGenerator();
                                System.out.println("Here are the current requirements:");
                                for (Map.Entry entryy : transfereesReq.entrySet()) {
                                    System.out.println(entryy.getKey() + ": " + entryy.getValue());
                                }
                                lineGenerator();
                                while(true){
                                    System.out.print("Enter the requirement you would like to remove (e.g. Requirement 1)(0 to go back): ");
                                    scn.nextLine();
                                    String reqRemove = scn.nextLine();
                                    if(reqRemove.equals("0")){
                                        editAdmission();
                                        break;
                                    }
                                    if(transfereesReq.containsKey(reqRemove)){
                                        transfereesReq.remove(reqRemove, scn.nextLine());
                                        System.out.println("Requirement deleted successfully.");
                                        System.out.print("\nPress any key to go back: ");
                                        if(scn.next() != null){
                                            editAdmission();
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("This requirement does not exist. Please try again.");
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        break;
                    }
                }
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public void editAbout(){
        //Edit/Add About
        Scanner scn = new Scanner(System.in);
        About about = new About();
        System.out.print("""
                --------------------------------------------------------------- EDIT ABOUT ---------------------------------------------------------------
                """);
        System.out.print("""
            Which about section would you like to edit?
            """);
        about.displayAbout();
        about.setAboutSize();
        int aboutSize = about.getAboutSize();
        System.out.println((aboutSize+1) + " - Add an About Section");
        System.out.println((aboutSize+2) + " - Remove an About Section");
        lineGenerator();
        while(true){
            System.out.print("Your Answer (0 to go back): ");
            String choice = scn.next();

            if(Integer.parseInt(choice) == 0){
                new Admin();
                break;
            }
            if(Integer.parseInt(choice) <= aboutSize && Integer.parseInt(choice) != about.getIndex()){
                about.setToRetrieve(Integer.parseInt(choice));
                System.out.println("Current Details: ");
                String aboutCurrent = about.getAbout();
                System.out.println(aboutCurrent);
                System.out.println("\n" + about.getAboutContent());
                lineGenerator();
                System.out.print("Enter new title of " + aboutCurrent + " (press 0 if you want the title to remain as is): ");
                scn.nextLine();
                String title = scn.nextLine();
                if(!title.equals("0")){
                    about.setAbout(title);
                }
                if(title.equals("0")){}
                System.out.print("Enter article: ");
                about.setAboutContent(scn.nextLine());
                lineGenerator();
                System.out.println("Updated successfully!");
                System.out.println("Current Title: " + about.getAbout());
                System.out.println("Current Content:\n" + about.getAboutContent());
                System.out.print("Press any key to go back: ");
                String back = scn.next();
                if(back != null){
                    editAbout();
                }
                break;
            }
            if(Integer.parseInt(choice) <= aboutSize && Integer.parseInt(choice) == about.getIndex()){
                about.setPoliciesPrint();
                about.setToRetrieve(Integer.parseInt(choice));
                lineGenerator();
                System.out.print("Current Policies: ");
                System.out.println(about.getPoliciesPrint());
                about.setPolicySize();
                int policySize = about.getPolicySize();
                System.out.println((policySize+1) + " - Add a Policy");
                System.out.println((policySize+2) + " - Remove a Policy");
                lineGenerator();
                while(true){
                    System.out.print("Enter the number of the policy you would like to edit (0 to go back): ");
                    String policy = scn.next();

                    if(Integer.parseInt(policy) == 0){
                        editAbout();
                        break;
                    }
                    if(Integer.parseInt(policy) <= policySize){
                        about.setToRetrieve(Integer.parseInt(policy));
                        lineGenerator();
                        System.out.println("Current Details: ");
                        String policyCurrent = about.getPolicy();
                        System.out.println(policyCurrent);
                        System.out.println("\n" + about.getPolicyContent());
                        lineGenerator();
                        System.out.print("Enter new title of policy (press 0 if you want the title to remain as is): ");
                        scn.nextLine();
                        String title = scn.nextLine();
                        if(!title.equals("0")){
                            about.setAbout(title);
                        }
                        if(title.equals("0")){}
                        System.out.print("Enter policy content: ");
                        about.setPolicyContent(scn.nextLine());
                        lineGenerator();
                        System.out.println("Updated successfully!");
                        System.out.println("Current Policy Title: " + about.getPolicy());
                        System.out.println("Current Content:\n" + about.getPolicyContent());
                        lineGenerator();
                        System.out.print("Press any key to go back: ");
                        String back = scn.next();
                        if(back != null){
                            editAbout();
                        }
                        break;
                    }
                    if(Integer.parseInt(policy) == policySize+1){
                        System.out.print("Enter policy title: ");
                        scn.nextLine();
                        String newTitle = scn.nextLine();
                        System.out.print("Enter policy content: ");
                        String newContent = scn.nextLine();
                        about.setPolicy(newTitle, newContent);
                        about.setPolicySize();
                        lineGenerator();
                        System.out.println("Policy added successfully!");
                        System.out.println("New Policy Details: ");
                        about.setToRetrieve(about.getPolicySize());
                        System.out.println(about.getPolicy());
                        System.out.println("\n" + about.getPolicyContent());
                        lineGenerator();
                        System.out.print("\nPress any key to go back: ");
                        if(scn.next() != null){
                            editAbout();
                        }
                        break;
                    }
                    if(Integer.parseInt(policy) == policySize+2){
                        lineGenerator();
                        System.out.print("""
                            Which policy would you like to remove?
                            """);
                        System.out.println(about.getPoliciesPrint());
                        lineGenerator();
                        while(true){
                            System.out.print("Your Answer (0 to go back): ");
                            String remove = scn.next();
                            about.setToRetrieve(Integer.parseInt(remove));
                            if(Integer.parseInt(remove) == 0){
                                editAbout();
                                break;
                            }
                            if(Integer.parseInt(remove) <= policySize){
                                System.out.print("Are you sure (0 to go back or any key to continue)? ");
                                char sure = scn.next().charAt(0);
                                if(sure == '0'){
                                    editAbout();
                                }
                                else{
                                    about.removePolicy();
                                    System.out.println("Policy has been removed successfully!");
                                    System.out.print("\nPress any key to go back: ");
                                    if(scn.next() != null){
                                        editAbout();
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        break;  
                    }
                    else{
                        System.out.println("Invalid input. Please try again.");
                    }
                } 
            }
            if(Integer.parseInt(choice) == aboutSize+1){
                System.out.print("Enter about title: ");
                scn.nextLine();
                String newTitle = scn.nextLine();
                System.out.print("Enter about content: ");
                String newContent = scn.nextLine();
                about.setAbout(newTitle, newContent);
                about.setAboutSize();
                lineGenerator();
                System.out.println("About added successfully!");
                System.out.println("New About Details: ");
                about.setToRetrieve(about.getAboutSize());
                System.out.println(about.getAbout());
                System.out.println("\n" + about.getAboutContent());
                System.out.print("\nPress any key to go back: ");
                if(scn.next() != null){
                    editAbout();
                }
                break;
            }
            if(Integer.parseInt(choice) == aboutSize+2){
                lineGenerator();
                System.out.print("""
                    Which about section would you like to remove?
                    """);
                about.displayAbout();
                lineGenerator();
                while(true){
                    System.out.print("Your Answer (0 to go back): ");
                    String remove = scn.next();
                    about.setToRetrieve(Integer.parseInt(remove));
                    if(Integer.parseInt(remove) == 0){
                        editAbout();
                        break;
                    }
                    if(Integer.parseInt(remove) <= aboutSize){
                        System.out.print("Are you sure (0 to go back or any key to continue)? ");
                        char sure = scn.next().charAt(0);
                        if(sure == '0'){
                            editAbout();
                        }
                        else{
                            about.removeAbout();
                            System.out.println("About has been removed successfully!");
                            System.out.print("\nPress any key to go back: ");
                            if(scn.next() != null){
                                editAbout();
                            }
                        }
                        break;
                    }
                    else{
                        System.out.println("Invalid input. Please try again.");
                    }
                }
                break;  
            }
            else{
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }
    public void editCourse(){
        //Edit Course/Programs
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                -------------------------------------------------------------- EDIT COURSES --------------------------------------------------------------
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
            char choice = scn.next().charAt(0);

            if(choice == '0'){
                new Admin();
                break;
            }
            if(choice == '1'){
                lineGenerator();
                System.out.println("Here are the currently available courses:");
                for(Map.Entry e: courses.entrySet()){
                    System.out.println(e.getKey() + " - " + e.getValue());
                }
                lineGenerator();
                scn.nextLine();
                while(true){
                    System.out.print("Enter the name of the course (full name and abbreviation enclosed in parentheses)(0 to go back): ");
                    String courseName = scn.nextLine(); 
                    if(courseName.equals("0")){
                        editCourse();
                        break;
                    }
                    if(!courses.containsValue(courseName)){
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
                        System.out.print("Press any key to go back: ");
                        if(scn.next() != null){
                            editCourse();
                        }
                        break;
                    }
                    else{
                        System.out.println("This course already exists! Please enter a non-existent course.");
                    }
                }  
                break;
            }
            if(choice == '2'){
                lineGenerator();
                System.out.println("Here are the currently available courses:");
                for(Map.Entry e: courses.entrySet()){
                    System.out.println(e.getKey() + " - " + e.getValue());
                }
                while(true){
                    lineGenerator();
                    System.out.print("Enter the number of the course you would like to add skills to (0 to go back): ");
                    String edit = scn.next();
                    if(Integer.parseInt(edit) == 0){
                        editCourse();
                        break;
                    }
                    if(courses.containsKey(Integer.parseInt(edit))){
                        scn.nextLine();
                        System.out.print("Enter a top skill to learn on the course: ");
                        addSkill(Integer.parseInt(edit), scn.nextLine());
                        while(true){
                            System.out.print("Add another skill (Press Y for yes and any key for No)? ");
                            char yn = scn.next().toUpperCase().charAt(0);
                            if(yn == 'Y'){
                                scn.nextLine();
                                System.out.print("Enter a top skill to learn on the course: ");
                                addSkill(Integer.parseInt(edit), scn.nextLine());
                            }
                            else{
                                break;
                            }
                        }
                        lineGenerator();
                        System.out.println("The skill/s has been added successfully.");
                        System.out.print("\nPress any key to go back: ");
                        if(scn.next() != null){
                            editCourse();
                        }
                        break;
                    }
                    else{
                        System.out.println("This course does not exist. Please try again.");
                    }
                }
                break;
            }
            if(choice == '3'){
                lineGenerator();
                System.out.println("Here are the currently available courses:");
                for(Map.Entry e: courses.entrySet()){
                    System.out.println(e.getKey() + " - " + e.getValue());
                }
                while(true){
                    lineGenerator();
                    System.out.print("Enter the number of the course you would like to add opportunities to (0 to go back): ");
                    String edit = scn.next();
                    if(Integer.parseInt(edit) == 0){
                        editCourse();
                        break;
                    }
                    if(courses.containsKey(Integer.parseInt(edit))){
                        scn.nextLine();
                        System.out.print("Enter an opportunity when finishing the course: ");
                        addOpp(Integer.parseInt(edit), scn.nextLine());
                        while(true){
                            System.out.print("Add another opportunity (Press Y for yes and any key for No)? ");
                            char yn = scn.next().toUpperCase().charAt(0);
                            if(yn == 'Y'){
                                scn.nextLine();
                                System.out.print("Enter an opportunity when finishing the course: ");
                                addOpp(Integer.parseInt(edit), scn.nextLine());
                            }
                            else{
                                break;
                            }
                        }
                        lineGenerator();
                        System.out.println("The opportunities has been added successfully.");
                        System.out.print("\nPress any key to go back to editing courses/programs: ");
                        if(scn.next() != null){
                            editCourse();
                        }
                        break;
                    }
                    else{
                        System.out.println("This course does not exist. Please try again.");
                    }
                }
                break;
            }
            if(choice == '4'){
                lineGenerator();
                System.out.println("Here are the currently available courses:");
                for(Map.Entry e: courses.entrySet()){
                    System.out.println(e.getKey() + " - " + e.getValue());
                }
                while(true){
                    lineGenerator();
                    System.out.print("Enter the number of the course you would like to remove (0 to go back): ");
                    String remove = scn.next();
                    if(Integer.parseInt(remove) == 0){
                        editCourse();
                        break;
                    }
                    if(courses.containsKey(Integer.parseInt(remove))){
                        System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                        char yn = scn.next().toUpperCase().charAt(0);
                        if(yn == 'Y' && courses.containsKey(Integer.parseInt(remove))){
                            removeCourse(Integer.parseInt(remove));
                            System.out.println("The program has been removed successfully and moved to archives.");
                            lineGenerator();
                            System.out.println("Here are the currently available courses:");
                            for(Map.Entry e: courses.entrySet()){
                                System.out.println(e.getKey() + " - " + e.getValue());
                            }
                            lineGenerator();
                            System.out.print("Press any key to go back to editing courses/programs: ");
                            if(scn.next() != null){
                                editCourse();
                                break;
                            }
                        }
                        else{
                            editCourse();
                        }
                        break;
                    }
                    else{
                        System.out.println("This course does not exist. Please try again");
                    }
                }
                break;
            }
            if(choice == '5'){
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
                    char archive = scn.next().charAt(0);

                    if(archive == '0'){
                        editCourse();
                        break;
                    }
                    if(archive == '1'){
                        lineGenerator();
                        System.out.println("Here are the currently archived courses:");
                        for(Map.Entry e: archivedCourses.entrySet()){
                            System.out.println(e.getKey() + " - " + e.getValue());
                        }
                        while(true){
                            lineGenerator();
                            System.out.print("Please enter the number of the course you would like to view (0 to go back): ");
                            String view = scn.next();
                            lineGenerator();
                            if(Integer.parseInt(view) == 0){
                                editCourse();
                                break;
                            }
                            if(archivedCourses.containsKey(Integer.parseInt(view))){
                                System.out.println(archivedCourses.get(Integer.parseInt(view)).toUpperCase());
                                System.out.println("\nTop Skills to Learn: ");
                                System.out.println(archivedSkills.get(archivedCourses.get(Integer.parseInt(view))));
                            
                                System.out.println("\nCareer Opportunities: ");
                                System.out.println(archivedOpp.get(archivedCourses.get(Integer.parseInt(view))));
                                lineGenerator();
                                System.out.print("Press any key to go back: ");
                                if(scn.next() != null){
                                    editCourse();
                                }
                                break;
                            }
                            else{
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                        break;
                    }
                    if(archive == '2'){
                        lineGenerator();
                        System.out.println("Here are the currently archived courses:");
                        for(Map.Entry e: archivedCourses.entrySet()){
                            System.out.println(e.getKey() + " - " + e.getValue());
                        }
                        while(true){
                            lineGenerator();
                            System.out.print("Enter the number of the course you would like to remove (0 to go back): ");
                            String remove = scn.next();
                            if(Integer.parseInt(remove) == 0){
                                editCourse();
                                break;
                            }
                            if(courses.containsKey(Integer.parseInt(remove))){
                                System.out.print("Are you sure (Press Y for yes or any key to go back)? ");
                                char yn = scn.next().toUpperCase().charAt(0);
                                if(yn == 'Y' && archivedCourses.containsKey(remove)){
                                    removeCourseP(Integer.parseInt(remove));
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
                            else{
                                System.out.println("This course does not exist. Please try again.");
                            }
                        }

                        break;
                    }
                    if(archive == '3'){
                        lineGenerator();
                        System.out.println("Here are the currently archived courses:");
                        for(Map.Entry e: archivedCourses.entrySet()){
                            System.out.println(e.getKey() + " - " + e.getValue());
                        }
                        lineGenerator();
                        System.out.print("Enter the number of the course you would like to restore (0 to go back): ");
                        String restore = scn.next();
                        if(Integer.parseInt(restore) == 0){
                            editCourse();
                            break;
                        }
                        if(archivedCourses.containsKey(Integer.parseInt(restore))){
                            restoreCourse(Integer.parseInt(restore));
                            System.out.println("The program has been restored.");
                            System.out.print("Press any key to go back: ");
                            if(scn.next() != null){
                                editCourse();
                            }
                        }
                        else{
                            System.out.println("This course does not exist. Please try again.");
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
    public void viewDocuReq(){
        Scanner scn = new Scanner(System.in);
        boolean hasRequest = false;
        System.out.print("""
                --------------------------------------------------------- VIEW DOCUMENT REQUESTS ----------------------------------------------------------
                """);
        for(Map.Entry e: docuRequest.entrySet()){
            Map<String, String> value = (Map<String, String>) e.getValue();
            if(value != null){hasRequest = true;}
            System.out.print(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
            if(!value.get("Middle Name").equals("NA")){
                System.out.print(" " + value.get("Middle Name"));
            }
            if(!value.get("Suffix").equalsIgnoreCase("NA")){
                System.out.print(" " + value.get("Suffix"));
            }
            System.out.println();
        }
        if(hasRequest == false){
            System.out.println("No requests.");
            lineGenerator();
            System.out.print("Press any key to go back: ");
            if(scn.next() != null){
                new Admin();
            }
        }
        if(hasRequest == true){
            while(true){      
                lineGenerator();
                System.out.print("Enter the number of the alumni you would like to view information of (0 to go back, F to see fulfilled requests): ");
                String viewInfo = scn.next();
                if(Integer.parseInt(viewInfo) == 0){
                    new Admin();
                    break;
                }
                if(docuRequest.containsKey(Integer.parseInt(viewInfo))){
                    lineGenerator();
                    for(Map.Entry e: docuRequest.entrySet()){
                        if(e.getKey().equals(Integer.parseInt(viewInfo))){
                            Map<String, String> value = (Map<String, String>) e.getValue();
                            System.out.println(e.getKey());
                            for(Map.Entry f: value.entrySet()){
                                System.out.println(f.getKey() + ": " + f.getValue());
                            }
                        }
                    }
                    lineGenerator();
                    while(true){
                        System.out.print("Move request to fulfilled (Press Y for yes and any key to go back)? ");
                        char back = scn.next().toUpperCase().charAt(0);
                        if(back == 'Y'){
                            finishReq(Integer.parseInt(viewInfo));
                            System.out.println("Request has been moved to Fulfilled Requests.");
                            lineGenerator();
                            System.out.print("Press 0 to go back to viewing requests: ");
                            if(scn.next() != null){
                                viewDocuReq();
                            }
                            break;
                        }
                        else{
                            viewDocuReq();
                            break;
                        }
                    }
                    break;
                }
                if(viewInfo.equalsIgnoreCase("F")){
                    lineGenerator();
                    for(Map.Entry e: finishedReq.entrySet()){
                        Map<String, String> value = (Map<String, String>) e.getValue();
                        System.out.print(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                        if(!value.get("Middle Name").equals("NA")){
                            System.out.print(" " + value.get("Middle Name"));
                        }
                        if(!value.get("Suffix").equalsIgnoreCase("NA")){
                            System.out.print(" " + value.get("Suffix"));
                        }
                        System.out.println();
                    }
                    lineGenerator();
                    while(true){
                        System.out.print("Enter the number of the request you would like to view information of (0 to go back): ");
                        String viewInfoF = scn.next();
                        if(Integer.parseInt(viewInfoF) == 0){
                            new Admin();
                            break;
                        }
                        if(finishedReq.containsKey(Integer.parseInt(viewInfoF))){
                            lineGenerator();
                            for(Map.Entry e: finishedReq.entrySet()){
                                if(e.getKey().equals(viewInfoF)){
                                    Map<String, String> value = (Map<String, String>) e.getValue();
                                    System.out.println(e.getKey());
                                    for(Map.Entry f: value.entrySet()){
                                        System.out.println(f.getKey() + ": " + f.getValue());
                                    }
                                }
                            }
                            lineGenerator();
                            while(true){
                                System.out.print("Move request back to unfulfilled (Press Y for yes and any key to go back)? ");
                                char back = scn.next().toUpperCase().charAt(0);
                                if(back == 'Y'){
                                    restoreReq(Integer.parseInt(viewInfoF));
                                    System.out.println("Request has been moved to Unfulfilled Requests.");
                                    System.out.print("Press 0 to go back to viewing requests: ");
                                    if(scn.next() != null){
                                        viewDocuReq();
                                    }
                                    break;
                                }
                                else{
                                    viewDocuReq();
                                    break;
                                }
                            }
                            break;
                        }
                        else{
                            System.out.println("Finished request does not exist. Please try again.");
                        }
                    }
                    break;
                }
                else{
                    System.out.println("Alumni request does not exist. Please try again.");
                }
            }
        }
    }
    public void changePassword(){
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                ----------------------------------------------------------- CHANGE PASSWORD --------------------------------------------------------------
                """);
        System.out.println("Here is the current administrator account password: " + adminPass);
        System.out.print("Enter the new password (Press 0 to go back): ");
        String adminPassNew = scn.nextLine();
        if(adminPassNew.equals("0")){
            new Admin();
        }
        else{
            while(true){
                System.out.print("Confirm password (0 to cancel): ");
                String confirmPass = scn.nextLine();
                if(confirmPass.equals("0")){
                    changePassword();
                    break;
                }
                if(confirmPass.equals(adminPassNew)){
                    adminPass = adminPassNew;
                    System.out.println("Password changed!");
                    lineGenerator();
                    System.out.print("Press 0 to re-login: ");
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
        archivedStud.remove(studentNum);
    }
    void restoreStudent(String studentNum){
        enrolled.put(studentNum, archivedStud.get(studentNum));
        archivedStud.remove(studentNum);
    }
    void archiveTeacher(String employeeNum){
        archivedTInfo.put(employeeNum, tInfo.get(employeeNum));
        archivedTSub.put(employeeNum, tSub.get(employeeNum));
        tSub.remove(employeeNum);
        tInfo.remove(employeeNum);
    }
    void finishReq(int reqID){
        finishedReq.put(reqID, docuRequest.get(reqID));
        docuRequest.remove(reqID);
    }
    void restoreReq(int reqID){
        docuRequest.put(reqID, finishedReq.get(reqID));
        finishedReq.remove(reqID);
    }
    void removeTeacherP(String employeeNum){
        archivedTInfo.remove(employeeNum);
        archivedTSub.remove(employeeNum);
    }
    void restoreTeacher(String employeeNum){
        tInfo.put(employeeNum, archivedTInfo.get(employeeNum));
        tSub.put(employeeNum, archivedTSub.get(employeeNum));
        archivedTInfo.remove(employeeNum);
        archivedTSub.remove(employeeNum);
    }
    void removeHandled(String employeeNum, String removeP){
        tSub.get(employeeNum).remove(removeP);
    }
    void addHandled(String employeeNum, String section, String subject){
        LinkedList<String> subjects = new LinkedList<String>();
        subjects.add(subject);
        tSub.get(employeeNum).put(section, subjects);
    }
    void addHandledNew(String employeeNum, String section, String subject){
        LinkedList<String> subjects = new LinkedList<String>();
        subjects.add(subject);
        Map<String, LinkedList<String>> newSection = new LinkedHashMap<>();
        newSection.put(section, subjects);
        tSub.put(employeeNum, newSection);
    }
    void addHandledSub(String employeeNum, String section, String subject){
        tSub.get(employeeNum).get(section).add(subject);
    }
    boolean displayArchivedStd(String choice, boolean hasStudent){
        System.out.println("Here are the archived students: ");
        for(Map.Entry e: archivedStud.entrySet()){
            Map<String, String> value = (Map<String, String>) e.getValue();
            if(value.get("Course") == courses.get(Integer.parseInt(choice))){
                if(value != null){ hasStudent = true;} else{ hasStudent = false;}
                System.out.print(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                if(!value.get("Middle Name").equals("NA")){
                    System.out.print(" " + value.get("Middle Name"));
                }
                if(!value.get("Suffix").equalsIgnoreCase("NA")){
                    System.out.print(" " + value.get("Suffix"));
                }
                System.out.println();
            }
        }
        return hasStudent;
    }
    boolean displayStd(String choice, boolean hasStudent){
        for(Map.Entry e: enrolled.entrySet()){
            Map<String, String> value = (Map<String, String>) e.getValue();
            if(value.get("Course") == courses.get(Integer.parseInt(choice))){
                if(value != null){hasStudent = true;} else{hasStudent = false;}
                System.out.print(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
                if(!value.get("Middle Name").equals("NA")){
                    System.out.print(" " + value.get("Middle Name"));
                }
                if(!value.get("Suffix").equalsIgnoreCase("NA")){
                    System.out.print(" " + value.get("Suffix"));
                }
                System.out.println();
            }
        }
        return hasStudent;
    }
    boolean displayTch(boolean hasTeacher){
        System.out.println("Here are the current teachers:");
        for(Map.Entry e: tInfo.entrySet()){
            Map<String, String> value = (Map<String, String>) e.getValue();
            if(value != null){hasTeacher = true;} else{hasTeacher = false;}
            System.out.print(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
            if(!value.get("Middle Name").equals("NA")){
                System.out.print(" " + value.get("Middle Name"));
            }
            if(!value.get("Suffix").equals("NA")){
                System.out.print(" " + value.get("Suffix"));
            }
            System.out.println();
        }
        return hasTeacher;
    }
    boolean displayArchivedTch(boolean hasTeacher){
        System.out.println("Here are the archived teachers:");
        for(Map.Entry e: archivedTInfo.entrySet()){
            Map<String, String> value = (Map<String, String>) e.getValue();
            if(value != null){hasTeacher = true;} else{hasTeacher = false;}
            System.out.print(e.getKey() + " - " + value.get("Last Name") + ", " + value.get("First Name"));
            if(!value.get("Middle Name").equals("NA")){
                System.out.print(" " + value.get("Middle Name"));
            }
            if(!value.get("Suffix").equals("NA")){
                System.out.print(" " + value.get("Suffix"));
            }
            System.out.println();
        }
        return hasTeacher;
    }
    void displayHandled(String editInfo){
        System.out.println("Sections and Subjects Currently Handled: ");
        for(Map.Entry e: tSub.entrySet()){
            if(e.getKey().equals(editInfo)){
                Map<String, String> value = (Map<String, String>) e.getValue();
                System.out.println(e.getKey());
                for(Map.Entry f: value.entrySet()){
                    System.out.println(f.getKey() + ": " + f.getValue());
                }
            }
        }
    }
}
