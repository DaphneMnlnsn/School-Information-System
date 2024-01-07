import java.util.*;

public class Request extends Variables{
    Request(){
        System.out.println("--------------------------------------------------------- DOCUMENT REQUEST ---------------------------------------------------------------");
        Scanner scn = new Scanner(System.in);
        lineGenerator();
        System.out.println("Enter your full name (Last Name, First Name, Middle Name, Suffix Name)(NA if no middle or suffix name): ");
        System.out.println("Please follow the format");
        String fullName = scn.nextLine();
		
        String[] names = fullName.split(",");

        String lastName = names[0].trim();
        String firstName = names[1].trim();
        String middleName = names[2].trim();
        String suffixName = names[3].trim();
        reqInfo.put("First Name", firstName);
        reqInfo.put("Middle Name", middleName);
        reqInfo.put("Last Name", lastName);
        reqInfo.put("Suffix", suffixName);
    
        System.out.print("When did you graduate? ");
        String yrGraduate = scn.nextLine();
        reqInfo.put("Year Graduated", yrGraduate);
        System.out.print("Program/Course enrolled in: ");
        String alCourse = scn.nextLine();
        reqInfo.put("Program", alCourse);
        System.out.print("Specific Record Requested (Transcript, Diploma, Form 136, Certification): ");
        String dataRequest = scn.nextLine();
        reqInfo.put("Record Requested", dataRequest);
        System.out.print("Briefly, what is the purpose of this Request? ");
        String dataPurpose = scn.nextLine();
        reqInfo.put("Purpose", dataPurpose);
        System.out.println("To ensure we can contact you for additional necessary details, could you please provide an email address where we can direct our response?");
        String emailRequest = scn.nextLine();
        reqInfo.put("Email Address", emailRequest);
        System.out.print("What is your contact number in case we cannot reach your email? ");
        String contactRequest = scn.nextLine();
        reqInfo.put("Contact Number", contactRequest);
        lineGenerator();
        System.out.println("Thank you for providing the requested information. ");
        lineGenerator();
        System.out.println("First Name: " + firstName);
        System.out.println("Middle Name: " + middleName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Suffix Name: " + suffixName);
        System.out.println("Year graduated: " + yrGraduate);
        System.out.println("Program/Course enrolled: " + alCourse);
        System.out.println("Requested Data: " + dataRequest);
        System.out.println("Purpose of the request: " + dataPurpose);
        System.out.println("Email address: " + emailRequest);
        System.out.println("Contact Number: " + contactRequest);
        System.out.println("Could you please confirm if all the details you've filled in are accurate?");
        System.out.println("Your confirmation ensures that we process your request correctly. Thank you for your attention to this matter.");
        lineGenerator();
        while(true){
            System.out.print("Press Y for yes and N to re-fill out the form: ");
            char proceed = scn.next().toUpperCase().charAt(0);
            if(proceed == 'Y'){
                lineGenerator();
                System.out.println("Thank you. Please wait for our reply in the email you provided");
                lineGenerator();
                rNum = rNum+1;
                docuRequest.put(rNum, reqInfo);
                System.out.print("Press any key to go back: ");
                String back = scn.next();
                if(back != null){
                    new Main();
                }
                break;
            }
            if(proceed == 'N'){
                Set<String> keys = new HashSet<>();
                for(Map.Entry e : reqInfo.entrySet()){
                    keys.add(e.getKey().toString());
                }
                reqInfo.keySet().removeAll(keys);
                new Request();
                break;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
