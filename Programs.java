import java.util.*;

public class Programs extends Variables implements Courses{
    Programs(){
        Scanner scn = new Scanner(System.in);
        lineGenerator();
        System.out.println("Programs Offered\nPlease select a course you would like to view the description of.");
        initialization();
        for(Map.Entry e: courses.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
        while(true){
            lineGenerator();
            System.out.print("Your choice (Press 0 to go back): ");
            int choice = scn.nextInt();
            lineGenerator();
            if(choice == 0){
                new Main();
                break;
            }
            if(courses.containsKey(choice)){
                System.out.println(courses.get(choice).toUpperCase());
                System.out.println("\nTop Skills to Learn: ");
                System.out.println(topSkills.get(courses.get(choice)).toString().replace("[", "").replace("]", ""));
            
                System.out.println("\nCareer Opportunities: ");
                System.out.println(opportunities.get(courses.get(choice)).toString().replace("[", "").replace("]", ""));
                lineGenerator();
                System.out.print("Go Back (Press Y for Yes and any key to exit system)? ");
                char back = scn.next().toUpperCase().charAt(0);
                if(back == 'Y'){
                    new Programs();
                }
                else{
                    System.exit(0);
                }
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public static void initialization() {
            List<String> skills1 = Arrays.asList("- Customer Service\n" + "- Communication\n" + "- Business Acumen and Commercial Awareness\n" + "- Events Planning\n" +
                    "- Tour and Travel Management and Operations\n" + "- Tourism Sales and Marketing\n" + "- Airline Management and Operations");
            topSkills.get("Bachelor of Science in Tourism Management (BSTM)").addAll(skills1);
            List<String> op1 = Arrays.asList("- Flight Attendant\n" + "- Events Manager\n" + "- Tour Operator\n" + "- Tourism Marketing Manager\n" + "- Travel Agency Manager\n" + "- Tourism Information Center Manager\n" +
                    "- Guest Relations Manager\n" + "- Airlines Operations Supervisor/Manager\n" + "- Airline Reservations Supervisor/Manager\n" + "- Airline Customer Service Supervisor/Manager\n" +
                    "- Sales and Marketing Supervisor/Manager\n" + "- Recreations Director\n" + "- Destination Manager\n" + "- Ticketing Supervisor/Manager\n" + "- Tourism Operations Officer\n" + "- Travel Specialist/Consultant");
            opportunities.get("Bachelor of Science in Tourism Management (BSTM)").addAll(op1);

            List<String> skills2 = Arrays.asList("- Digital Design\n" + "- Digital Signal Processing\n" + "- Computer Architecture and Organization\n" +
                    "- Embedded Systems\n" + "- Data and Digital Communications\n" + "- Internet of Things (IoT)\n" + "- Circuits and Electronics");
            topSkills.get("Bachelor of Science In Computer Engineering (BSCpE)").addAll(skills2);
            List<String> op2 = Arrays.asList("- Cloud Engineer\n" + "- Computer Network Architect\n" + "- Data Communications Engineer\n" + "- Embedded Systems Engineer\n" + "- Firmware Engineer\n" +
                    "- IoT Developer\n" + "- Network Administrator\n" + "- Network Operations Center (NOC) Engineer\n" + "- Robotics Process Automation (RPA) Developer\n" + "- Software Security Engineer\n" +
                    "- Systems Administrator\n" + "- Quality Assurance Engineer\n" + "- Technical Engineer\n" + "- Telecommunications Engineer\n" + "- Test Engineer");
            opportunities.get("Bachelor of Science In Computer Engineering (BSCpE)").addAll(op2);

            List<String> skills3 = Arrays.asList("- Cloud Computing\n" + "- Data Science and Analytics\n" + "- Cybersecurity\n" +
                    "- Mobile and Web Development\n" + "- Software Development\n" + "- User Experience (UX) Design\n" + "- Information Management");
            topSkills.get("Bachelor of Science in Information Technology (BSIT)").addAll(skills3);
            List<String> op3 = Arrays.asList("- Application Developer\n" + "- Client Support Specialist\n" + "- Cloud Architect\n" + "- Cybersecurity Specialist\n" +
                    "- Information Security Analyst\n" + "- Network Engineer\n" + "- IT Project Manager\n" + "- Software Developer\n" + "- Software Quality Assurance Specialist\n" +
                    "- Systems Administrator\n" + "- Systems Analyst\n" + "- System Support Specialist\n" + "- User Experience (UX) Designer\n" + "- Web Developer");
            opportunities.get("Bachelor of Science in Information Technology (BSIT)").addAll(op3);

            List<String> skills4 = Arrays.asList("- Machine Learning\n" + "- Artificial Intelligence\n" + "- Data Science and Analytics\n" + "- Cloud Computing\n" +
                    "- Programming Languages\n" + "- Software Development\n" + "- Computing Algorithms");
            topSkills.get("Bachelor of Science in Computer Science (BSCS)").addAll(skills4);
            List<String> op4 = Arrays.asList("- Application Developer\n" + "- .NET Developer\n" + "- Business Analyst\n" + "- Cloud Architect\n" + "- Data Analyst\n" +
                    "- Data Scientist\n" + "- Front-End Developer\n" + "- Full Stack Developer\n" + "- Mobile Application Developer\n" + "- Software Developer\n" +
                    "- Software Engineer\n" + "- Software Quality Assurance Specialist\n" + "- Software Tester\n" + "- Systems Analyst\n" + "- Web Developer");
            opportunities.get("Bachelor of Science in Computer Science (BSCS)").addAll(op4);

            List<String> skills5 = Arrays.asList("- Business Management\n" + "- Marketing, Sales, and Customer Service\n" + "- Operations Management\n" +
                    "- Entrepreneurial Management\n" + "- Financial Management\n" + "- Facilities Management\n" + "- Inventory Management\n");
            topSkills.get("Bachelor of Science in Business Administration (BSBA)").addAll(skills5);
            List<String> op5 = Arrays.asList("- Marketing Associate/Manager\n" + "- General and Operations Manager\n" + "- Logistics/facilities Manager\n" + "- Business Developer/Entrepreneur\n" +
                    "- Warehouse Manager\n" + "- Inventory Manager\n" + "- Financial Manager\n" + "- Loan Officer\n" + "- Procurement Officer\n" + "- Office Administrator\n" +
                    "- Account Manager\n" + "- Sales Representative\n" + "- Business Analyst\n" + "- Production Manager\n" + "- Business Researcher\n" + "- Trader\n");
            opportunities.get("Bachelor of Science in Business Administration (BSBA)").addAll(op5);

            List<String> skills6 = Arrays.asList("- Video/Film Editing\n" + "- Video Production\n" + "- 3D Animation\n" + "- Program and App Development\n" + "- Mobile and Device Development\n" + "- Digital Photography\n" +
                    "- Design Concepts\n" + "- Web Content\n" + "- Instructional Design\n" + "- Art Direction\n" + "- Typography and Layout\n" + "- Sound Engineering");
            topSkills.get("Bachelor of Science in Multimedia Arts (BMMA)").addAll(skills6);
            List<String> op6 = Arrays.asList("- 3D Animator/Artist\n" + "- Gameplay Animator/Designer\n" + "- Game Programmer\n" + "- Motion Graphics Animator/Designer\n" + "- Cartoonist\n" + "- Graphic Artist\n" + "- Web Designer\n" + "- Creative Director\n" + 
                    "- Art Director\n" + "- Media Director\n" + "- User Experience Designer\n" + "- Marketing/Advertising Manager\n" + "- Product Development Manager\n" + "- Media Strategist\n" + "- Digital Camera Operator\n" + "- Sound Engineer\n" + "- Multimedia Artist/Producer\n" +
                    "- Film/Video Editor\n" + "- Installation Artist\n" + "- Photographer/Videographer\n" + "- Special Effects Artist\n" + "- VFX Artist\n" + "- Level Designer\n" + "- Digital Marketing Manager\n" + "- Web Developer\n" + "- Digital Imaging Specialist\n" + "- Interactive Designer");
            opportunities.get("Bachelor of Science in Multimedia Arts (BMMA)").addAll(op6);
        }
}
