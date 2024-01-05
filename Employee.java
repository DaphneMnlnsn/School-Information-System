import java.util.*;

public class Employee extends Teacher{
    Employee(){
        System.out.println("------------------------------------------------ EMPLOYEE PORTAL --------------------------------------------------");
            while(true){
                Scanner scn = new Scanner(System.in);
                System.out.print("Enter Username : ");
                String username = scn.next();

                System.out.print("Enter Password : ");
                String password = scn.next();

                List<String> teacherUserList = Arrays.asList(teacherUser);
                List<String> teacherPassList = Arrays.asList(teacherPass);
                boolean match = teacherUserList.indexOf(username) == teacherPassList.indexOf(password);
                    
                if (teacherUserList.contains(username) && teacherPassList.contains(password) && match) {
                    teacher();
                    break;
                }
                else if (username.equalsIgnoreCase(adminUser) && password.equalsIgnoreCase(adminPass)){
                    new Admin();
                    break;
                }
                else if (teacherUserList.contains(username) && !match) {
                    System.out.print("\nInvalid Password. ");
                } else if (teacherPassList.contains(password) && !match) {
                    System.out.print("\nInvalid Username. ");
                } else {
                    System.out.print("\nInvalid Username & Password. ");
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
    void teacher(){
        System.out.println("Welcome, Teacher!");
    }
    
}
