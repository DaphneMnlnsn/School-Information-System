import java.util.*;

public interface Courses {
        Map<Integer, String> courses = new LinkedHashMap<>(){{
            put(1, "Bachelor of Science in Tourism Management (BSTM)");
            put(2, "Bachelor of Science In Computer Engineering (BSCpE)");
            put(3, "Bachelor of Science in Information Technology (BSIT)");
            put(4, "Bachelor of Science in Computer Science (BSCS)");
            put(5, "Bachelor of Science in Business Administration (BSBA)");
            put(6, "Bachelor of Science in Multimedia Arts (BMMA)");
        }};
        Map<String, String> topSkills = new LinkedHashMap<>(){{
            put("Bachelor of Science in Tourism Management (BSTM)", "- Customer Service\n- Communication\n- Business Acumen and Commercial Awareness\n- Events Planning\n- Tour and Travel Management and Operations\n- Tourism Sales and Marketing\n- Airline Management and Operations");
            put("Bachelor of Science In Computer Engineering (BSCpE)", "- Digital Design\n" + "- Digital Signal Processing\n" + "- Computer Architecture and Organization\n" +
            "- Embedded Systems\n" + "- Data and Digital Communications\n" + "- Internet of Things (IoT)\n" + "- Circuits and Electronics");
            put("Bachelor of Science in Information Technology (BSIT)", "- Cloud Computing\n" + "- Data Science and Analytics\n" + "- Cybersecurity\n" +
            "- Mobile and Web Development\n" + "- Software Development\n" + "- User Experience (UX) Design\n" + "- Information Management");
            put("Bachelor of Science in Computer Science (BSCS)", "- Machine Learning\n" + "- Artificial Intelligence\n" + "- Data Science and Analytics\n" + "- Cloud Computing\n" +
            "- Programming Languages\n" + "- Software Development\n" + "- Computing Algorithms");
            put("Bachelor of Science in Business Administration (BSBA)", "- Business Management\n" + "- Marketing, Sales, and Customer Service\n" + "- Operations Management\n" +
            "- Entrepreneurial Management\n" + "- Financial Management\n" + "- Facilities Management\n" + "- Inventory Management\n");
            put("Bachelor of Science in Multimedia Arts (BMMA)", "- Video/Film Editing\n" + "- Video Production\n" + "- 3D Animation\n" + "- Program and App Development\n" + "- Mobile and Device Development\n" + "- Digital Photography\n" +
            "- Design Concepts\n" + "- Web Content\n" + "- Instructional Design\n" + "- Art Direction\n" + "- Typography and Layout\n" + "- Sound Engineering");
        }};
        Map<String, String> opportunities = new LinkedHashMap<>(){{
            put("Bachelor of Science in Tourism Management (BSTM)", "- Flight Attendant\n" + "- Events Manager\n" + "- Tour Operator\n" + "- Tourism Marketing Manager\n" + "- Travel Agency Manager\n" + "- Tourism Information Center Manager\n" +
            "- Guest Relations Manager\n" + "- Airlines Operations Supervisor/Manager\n" + "- Airline Reservations Supervisor/Manager\n" + "- Airline Customer Service Supervisor/Manager\n" +
            "- Sales and Marketing Supervisor/Manager\n" + "- Recreations Director\n" + "- Destination Manager\n" + "- Ticketing Supervisor/Manager\n" + "- Tourism Operations Officer\n" + "- Travel Specialist/Consultant");
            put("Bachelor of Science In Computer Engineering (BSCpE)", "- Cloud Engineer\n" + "- Computer Network Architect\n" + "- Data Communications Engineer\n" + "- Embedded Systems Engineer\n" + "- Firmware Engineer\n" +
            "- IoT Developer\n" + "- Network Administrator\n" + "- Network Operations Center (NOC) Engineer\n" + "- Robotics Process Automation (RPA) Developer\n" + "- Software Security Engineer\n" +
            "- Systems Administrator\n" + "- Quality Assurance Engineer\n" + "- Technical Engineer\n" + "- Telecommunications Engineer\n" + "- Test Engineer");
            put("Bachelor of Science in Information Technology (BSIT)", "- Application Developer\n" + "- Client Support Specialist\n" + "- Cloud Architect\n" + "- Cybersecurity Specialist\n" +
            "- Information Security Analyst\n" + "- Network Engineer\n" + "- IT Project Manager\n" + "- Software Developer\n" + "- Software Quality Assurance Specialist\n" +
            "- Systems Administrator\n" + "- Systems Analyst\n" + "- System Support Specialist\n" + "- User Experience (UX) Designer\n" + "- Web Developer");
            put("Bachelor of Science in Computer Science (BSCS)", "- Application Developer\n" + "- .NET Developer\n" + "- Business Analyst\n" + "- Cloud Architect\n" + "- Data Analyst\n" +
            "- Data Scientist\n" + "- Front-End Developer\n" + "- Full Stack Developer\n" + "- Mobile Application Developer\n" + "- Software Developer\n" +
            "- Software Engineer\n" + "- Software Quality Assurance Specialist\n" + "- Software Tester\n" + "- Systems Analyst\n" + "- Web Developer");
            put("Bachelor of Science in Business Administration (BSBA)", "- Marketing Associate/Manager\n" + "- General and Operations Manager\n" + "- Logistics/facilities Manager\n" + "- Business Developer/Entrepreneur\n" +
            "- Warehouse Manager\n" + "- Inventory Manager\n" + "- Financial Manager\n" + "- Loan Officer\n" + "- Procurement Officer\n" + "- Office Administrator\n" +
            "- Account Manager\n" + "- Sales Representative\n" + "- Business Analyst\n" + "- Production Manager\n" + "- Business Researcher\n" + "- Trader");
            put("Bachelor of Science in Multimedia Arts (BMMA)", "- 3D Animator/Artist\n" + "- Gameplay Animator/Designer\n" + "- Game Programmer\n" + "- Motion Graphics Animator/Designer\n" + "- Cartoonist\n" + "- Graphic Artist\n" + "- Web Designer\n" + "- Creative Director\n" + 
            "- Art Director\n" + "- Media Director\n" + "- User Experience Designer\n" + "- Marketing/Advertising Manager\n" + "- Product Development Manager\n" + "- Media Strategist\n" + "- Digital Camera Operator\n" + "- Sound Engineer\n" + "- Multimedia Artist/Producer\n" +
            "- Film/Video Editor\n" + "- Installation Artist\n" + "- Photographer/Videographer\n" + "- Special Effects Artist\n" + "- VFX Artist\n" + "- Level Designer\n" + "- Digital Marketing Manager\n" + "- Web Developer\n" + "- Digital Imaging Specialist\n" + "- Interactive Designer");
        }};

}
