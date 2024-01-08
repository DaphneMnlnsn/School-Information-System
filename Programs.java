import java.util.*;

public class Programs extends Variables implements Courses{
    Programs(){
        Scanner scn = new Scanner(System.in);
        lineGenerator();
        System.out.println("Programs Offered\nPlease select a course you would like to view the description of.");
        for(Map.Entry e: courses.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
        while(true){
            lineGenerator();
            System.out.print("Your choice (Press 0 to go back): ");
            String choice = scn.next();
            lineGenerator();
            if(Integer.parseInt(choice) == 0){
                new Main();
                break;
            }
            if(courses.containsKey(Integer.parseInt(choice))){
                System.out.println(courses.get(Integer.parseInt(choice)).toUpperCase());
                System.out.println("\nTop Skills to Learn: ");
                System.out.println(topSkills.get(courses.get(Integer.parseInt(choice))));
            
                System.out.println("\nCareer Opportunities: ");
                System.out.println(opportunities.get(courses.get(Integer.parseInt(choice))));
                lineGenerator();
                System.out.print("Go Back (Press Y for Yes and any key to exit system)? ");
                char back = scn.next().toUpperCase().charAt(0);
                if(back == 'Y'){
                    new Programs();
                }
                else{
                    lineGenerator();
                    System.out.println("Thank you for visiting TBD College!");
                    lineGenerator();
                    System.exit(0);
                }
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
