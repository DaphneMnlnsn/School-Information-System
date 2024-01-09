import java.util.*;

public class Main {
    Main(){
        boolean loop = true;
        while(loop){
            Scanner scn = new Scanner(System.in);
            //Chatbot
            lineGenerator();
            System.out.println("Good day! I am Owlie, your automated TBD Assistant. What is your concern for today?");
            lineGenerator();
            System.out.print("""
                    1 - How do I register?
                    2 - What are the courses/program offerings?
                    3 - I have registered online. How can I pay?
                    4 - I am an Alumni and would like to request for documents
                    5 - I am an Ongoing student and would like to check my grades
                    6 - I am an Employee and would like to go to the system portal
                    7 - TBD Blog
                    8 - About TBD
                    """);
            lineGenerator();
            System.out.print("Please enter the number of your concern (0 to exit): ");
            String choice = scn.next();

            switch(choice){
                case "0":
                    lineGenerator();
                    System.out.println("Thank you for visiting TBD College!");
                    lineGenerator();
                    loop = false;
                    System.exit(0);
                    break;
                case "1":
                    new Admission();
                    loop = false;
                    break;
                case "2":
                    new Programs();
                    loop = false;
                    break;
                case "3":
                    payments();
                    loop = false;
                    break;
                case "4":
                    new Request();
                    loop = false;
                    break;
                case "5":
                    new Student();
                    loop = false;
                    break;
                case "6":
                    new Employee();
                    loop = false;
                    break;
                case "7":
                    blog();
                    loop = false;
                    break;
                case "8":
                    about();
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public static void main(String[] args){
            try{
                lineGenerator();
                System.out.println();
                String title = """
                                           ████████╗██████╗ ██████╗      ██████╗ ██████╗ ██╗     ██╗     ███████╗ ██████╗ ███████╗              
                                            ╚═██╔══╝██╔══██╗██╔══██╗    ██╔════╝██╔═══██╗██║     ██║     ██╔════╝██╔════╝ ██╔════╝              
                    \t\t\t  ██║   ██████╔╝██║  ██║    ██║     ██║   ██║██║     ██║     █████╗  ██║  ███╗█████╗  
                                              ██║   ██╔══██╗██║  ██║    ██║     ██║   ██║██║     ██║     ██╔══╝  ██║   ██║██╔══╝                
                                              ██║   ██████╔╝██████╔╝    ╚██████╗╚██████╔╝███████╗███████╗███████╗╚██████╔╝███████╗              
                                              ╚═╝   ╚═════╝ ╚═════╝      ╚═════╝ ╚═════╝ ╚══════╝╚══════╝╚══════╝ ╚═════╝ ╚══════╝              
                                                                                       """;
                for(int i = 0; i < title.length(); i++){
                    System.out.print(title.charAt(i));
                }
                new Main();
        }
        catch(Exception e){
            System.out.println("Something went wrong. You may have entered a wrong option. Please try again.");
            new Main();
        }
    }
    public void payments(){
        Scanner scn = new Scanner(System.in);
        System.out.print("""
        ------------------------------------------------------------------ PAYMENT METHODS -------------------------------------------------------
        """);
        Payments payment = new Payments();
        System.out.println("All Payment Methods are following below ");
        payment.displayPaymentMethod();
        System.out.println("Please choose what payment method you prefer.");
        lineGenerator();
        payment.setPaymentSize();
        while(true){
            System.out.print("Your answer (Press 0 to go back): ");
            String PaymentChoice = scn.next();
            lineGenerator();
            if(Integer.parseInt(PaymentChoice) == 0){
                new Main();
                break;
            }
            if(Integer.parseInt(PaymentChoice) <= payment.getPaymentSize()){
                payment.setToRetrieve(Integer.parseInt(PaymentChoice));
                System.out.println(payment.getPaymentMethod());
                System.out.println("Account Number: " + payment.getAccount());
                System.out.println("Account Name: " + payment.getAccountName());
                System.out.println("\nSend a copy or a photo of the receipt to the email down below");
                System.out.println(payment.getEmailLink());
                lineGenerator();
                System.out.print("Press any key to go back: ");
                if(scn.next() != null){
                    payments();
                }
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            } 
        }
    }
    public void blog(){
        Scanner scn = new Scanner(System.in);
        System.out.print("""
        ------------------------------------------------------------------ TBD COLLEGE BLOG ------------------------------------------------------
        """);
        Blog blog = new Blog();
        System.out.println("Here are the blog article headlines.");
        blog.displayBlog();
        lineGenerator();
        blog.setArticleSize();
        while(true){
            System.out.print("Your answer (Press 0 to go back): ");
            String blogChoice = scn.next();
            lineGenerator();
            if(Integer.parseInt(blogChoice) == 0){
                new Main();
                break;
            }
            if(Integer.parseInt(blogChoice) <= blog.getArticleSize()){
                blog.setToRetrieve(Integer.parseInt(blogChoice));
                System.out.println(blog.getHeadline());
                System.out.println("\n" + blog.getArticle());
                lineGenerator();
                System.out.print("Press any key to go back: ");
                if(scn.next() != null){
                    blog();
                }
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            } 
        }
    }
    public void about(){
        Scanner scn = new Scanner(System.in);
        System.out.print("""
        ------------------------------------------------------------------ ABOUT TBD COLLEGE -----------------------------------------------------
        """);
        About about = new About();
        about.displayAbout();
        lineGenerator();
        about.setAboutSize();
        while(true){
            System.out.print("Your answer (Press 0 to go back): ");
            String aboutChoice = scn.next();
            lineGenerator();
            if(Integer.parseInt(aboutChoice) == 0){
                new Main();
                break;
            }
            if(Integer.parseInt(aboutChoice) <= about.getAboutSize() && Integer.parseInt(aboutChoice) != about.getIndex()){
                about.setToRetrieve(Integer.parseInt(aboutChoice));
                System.out.println(about.getAbout());
                System.out.println("\n" + about.getAboutContent());
                lineGenerator();
                System.out.print("Press any key to go back: ");
                String back = scn.next();
                if(back != null){
                    about();
                }
                break;
            }
            if(Integer.parseInt(aboutChoice) <= about.getAboutSize() && Integer.parseInt(aboutChoice) == about.getIndex()){
                about.setPoliciesPrint();
                System.out.print("Current Policies: ");
                System.out.println(about.getPoliciesPrint());
                lineGenerator();
                System.out.print("Select the policy you would like to view (0 to go back): ");
                String policyChoice = scn.next();
                lineGenerator();
                about.setPolicySize();
                while(true){
                    if(Integer.parseInt(policyChoice) == 0){
                        about();
                        break;
                    }
                    if(Integer.parseInt(policyChoice) <= about.getPolicySize()){
                        about.setToRetrieve(Integer.parseInt(policyChoice));
                        System.out.println(about.getPolicy());
                        System.out.println("\n" + about.getPolicyContent());
                        lineGenerator();
                        System.out.print("Press any key to go back: ");
                        if(scn.next() != null){
                            about();
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
    public static void lineGenerator(){
        for(int i = 0; i < 27; i++){
            System.out.print("-----");
        }
        System.out.println();
    }
}
