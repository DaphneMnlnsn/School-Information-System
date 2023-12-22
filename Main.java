import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        //Chatbot
        System.out.println("Good day! I am Owlie, your automated TBD Assistant. What is your concern today?");
        System.out.println("""
                1 - How to Register?
                2 - What are the courses/program offerings?
                3 - I have registered online. How can I pay?
                4 - I am an Alumni and would like to request for documents
                5 - I am an Ongoing student and would like to check my grades or account balance
                6 - I am an Employee and would like to go to the system portal
                7 - TBD Blog
                8 - About TBD
                """);
        System.out.print("Please enter the number of your concern: ");
        int choice = scn.nextInt();

        switch(choice){
            case 1:
                new Admission();
                break;
            case 2:
                new Programs();
                break;
            case 3:
                new Payments();
                break;
            case 4:
                new Request();
                break;
            case 5:
                new Student();
                break;
            case 6:
                new Employee();
                break;
            case 7:
                new Blog();
                break;
            case 8:
                new About();
                break;
        }
    }
}
