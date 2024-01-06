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
            int choice = scn.nextInt();

            switch(choice){
                case 0:
                    lineGenerator();
                    System.out.println("Thank you for visiting TBD College!");
                    lineGenerator();
                    loop = false;
                    System.exit(0);
                    break;
                case 1:
                    new Admission();
                    loop = false;
                    break;
                case 2:
                    new Programs();
                    loop = false;
                    break;
                case 3:
                        System.out.print("""
                    ------------------------------------------------------- PAYMENT METHODS -------------------------------------------
                    """);
                        Payments payment = new Payments();
                        String allPaymentMethods = payment.getPaymentMethod();
                        System.out.println("All Payment Methods are following below " + allPaymentMethods);
                        System.out.println("Please choose what payment method you prefer.");
                        lineGenerator();
                        System.out.print("Your answer: ");
                        int PaymentChoice = scn.nextInt();
                        lineGenerator();
                        switch(PaymentChoice){
                            case 1:
                                System.out.println("GCash: " + payment.getGCash());
                                System.out.println("Send a copy or a photo of the receipt to the email down below");
                                System.out.println(payment.getEmailLink());
                                lineGenerator();
                                System.out.println("Press any key to go back to the main menu");
                                String paymentResetKey1 = scn.next();
                                if(paymentResetKey1 != null){
                                    new Main();
                                }
                                break;
                            case 2:
                                System.out.println("BDO: " + payment.getBDO());
                                System.out.println("Send a copy or a photo of the receipt to the email down below");
                                System.out.println(payment.getEmailLink());
                                lineGenerator();
                                System.out.println("Press any key to go back to the main menu");
                                String paymentResetKey2 = scn.next();
                                if(paymentResetKey2 != null){
                                    new Main();
                                }
                                break;
                            case 3:
                                System.out.println("ChinaBank: " + payment.getChinaBank());
                                System.out.println("Send a copy or a photo of the receipt to the email down below");
                                System.out.println(payment.getEmailLink());
                                lineGenerator();
                                System.out.println("Press any key to go back to the main menu");
                                String paymentResetKey3 = scn.next();
                                if(paymentResetKey3 != null){
                                    new Main();
                                }
                                break;
                            case 4:
                                System.out.println("LandBank: " + payment.getLandBank());
                                System.out.println("Send a copy or a photo of the receipt to the email down below");
                                System.out.println(payment.getEmailLink());
                                lineGenerator();
                                System.out.println("Press any key to go back to the main menu");
                                String paymentResetKey4 = scn.next();
                                if(paymentResetKey4 != null){
                                    new Main();
                                }
                                break;
                            case 5:
                                System.out.println("PayPal: " + payment.getPayPal());
                                System.out.println("Send a copy or a photo of the receipt to the email down below");
                                System.out.println(payment.getEmailLink());
                                lineGenerator();
                                System.out.println("Press any key to go back to the main menu");
                                String paymentResetKey5 = scn.next();
                                if(paymentResetKey5 != null){
                                    new Main();
                                }
                                break;
                        }
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
    public static void main(String[] args){
            try{
                lineGenerator();
                System.out.println();
                String title = """
                                 ████████╗██████╗ ██████╗      ██████╗ ██████╗ ██╗     ██╗     ███████╗ ██████╗ ███████╗              
                                 ╚══██╔══╝██╔══██╗██╔══██╗    ██╔════╝██╔═══██╗██║     ██║     ██╔════╝██╔════╝ ██╔════╝              
                    -------------   ██║   ██████╔╝██║  ██║    ██║     ██║   ██║██║     ██║     █████╗  ██║  ███╗█████╗  ---------------
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
            System.out.println("Something went wrong. Please try again.");
            System.out.println(e.getMessage());
            new Main();
        }
    }
    public static void lineGenerator(){
        for(int i = 0; i < 23; i++){
            System.out.print("-----");
        }
        System.out.println();
    }
}
