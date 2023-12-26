import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    Main(){
        boolean loop = true;
        while(loop){
            Scanner scn = new Scanner(System.in);
            //Chatbot
            lineGenerator();
            System.out.println("Good day! I am Owlie, your automated TBD Assistant. What is your concern today?");
            lineGenerator();
            System.out.print("""
                    1 - How do I register?
                    2 - What are the courses/program offerings?
                    3 - I have registered online. How can I pay?
                    4 - I am an Alumni and would like to request for documents
                    5 - I am an Ongoing student and would like to check my grades or account balance
                    6 - I am an Employee and would like to go to the system portal
                    7 - TBD Blog
                    8 - About TBD
                    """);
            lineGenerator();
            System.out.print("Please enter the number of your concern (0 to exit): ");
            int choice = scn.nextInt();

            switch(choice){
                case 0:
                    System.out.println("\nThank you for visiting TBD College!");
                    loop = false;
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
    public static void main(String[] args){
        lineGenerator();
        System.out.println();
        int width = 120;
        int height = 50;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 18));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("TBD College", 3, 20);

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "*");

            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
        }
        new Main();
    }
    public static void lineGenerator(){
        for(int i = 0; i < 23; i++){
            System.out.print("-----");
        }
        System.out.println();
    }
}
