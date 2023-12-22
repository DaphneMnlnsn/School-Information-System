import java.util.*;

public class Main {
    public static void main(String[] args){
        boolean loop = true;
        while(loop){
            Scanner scn = new Scanner(System.in);

            //Chatbot
            System.out.println("Good day! I am Owlie, your automated TBD Assistant. What is your concern today?");
            System.out.print("""
                    ---------------------------------------------------------------------------------
                    1 - How to Register?
                    2 - What are the courses/program offerings?
                    3 - I have registered online. How can I pay?
                    4 - I am an Alumni and would like to request for documents
                    5 - I am an Ongoing student and would like to check my grades or account balance
                    6 - I am an Employee and would like to go to the system portal
                    7 - TBD Blog
                    8 - About TBD
                    ---------------------------------------------------------------------------------
                    """);
            System.out.print("Please enter the number of your concern: ");
            int choice = scn.nextInt();

            switch(choice){
                case 1:
                    new Admission();
                    loop = false;
                    break;
                case 2:
                    new Programs();
                    loop = false;
                    break;
                case 3:
                    new Payments();
                    loop = false;
                    break;
                case 4:
                    new Request();
                    loop = false;
                    break;
                case 5:
                    new Student();
                    loop = false;
                    break;
                case 6:
                    new Employee();
                    loop = false;
                    break;
                case 7:
                    new Blog();
                    loop = false;
                    break;
                case 8:
                    new About();
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.\n");
            }
        }
    }
}
