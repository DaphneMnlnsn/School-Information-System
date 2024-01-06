import java.util.*;

public class Employee extends Variables{
    Employee(){
        System.out.println("------------------------------------------------ EMPLOYEE PORTAL --------------------------------------------------");
        while(true){
            Scanner scn = new Scanner(System.in);
            String employeeNum = "2019-0000";
            System.out.print("Enter Username : ");
            String username = scn.next();

            System.out.print("Enter Password : ");
            String password = scn.next();

            boolean match = false;
            boolean containsUsername = false;
            for(Map.Entry e: tInfo.entrySet()){
                if(tInfo.get(e.getKey()).get("Username").equals(username)){
                    if(tInfo.get(e.getKey()).get("Password").equals(password)){
                        match = true;
                        employeeNum = e.getKey().toString();
                    }
                    else{
                        containsUsername = true;
                    }
                }
            } 
            if (match) {
                new Teacher(employeeNum);
                break;
            }
            else if (username.equalsIgnoreCase(adminUser) && password.equalsIgnoreCase(adminPass)){
                new Admin();
                break;
            }
            else if (!containsUsername) {
                System.out.print("\nInvalid Username. ");
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
}
