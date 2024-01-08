import java.util.*;

public class About{

    private static Stack<String> about = new Stack<>(){{
        push("History of TBD");  push("Contact Details");    
        push("School Policies");
    }};
    private static Stack<String> policies = new Stack<>(){{
        push("Attendance Policy");  
        push("Bullying Policy");
        push("Dress Code Policy");
        push("Fighting Policy");
        push("Student Discipline");
    }};
    private String policiesPrint = "";
    private static Stack<String> policyContent = new Stack<>(){{
        push("""
            TBD College emphasizes the importance of regular attendance for students' academic success and well-being. The school has developed an 
            attendance policy that outlines the following rules:

            a. Absences: Students are expected to attend school daily unless ill or have a family emergency. Parents or guardians must notify the 
            school if their child will be absent. Tardiness is crucial for the smooth running of the school day and effective lesson delivery. Truancy 
            is a serious violation of school rules and can result in detention, suspension, or disciplinary action.
            
            b. Make-up work: Students are responsible for making up missed work, and teachers will provide necessary assignments and materials upon 
            return. Excused absences, such as illness or family emergencies, are considered excuses, while unexcused absences, without a valid reason,
            may lead to loss of privileges or detention.
            
            TBD College is committed to supporting students struggling with attendance, offering school counselors and support staff to address any
            issues. The goal is to create an environment where all students can attend school regularly and thrive academically and socially.
            """);  
        push("""
            Bullying is a global issue that requires a comprehensive policy to ensure the safety and well-being of students. TBD School is committed 
            to creating a positive and inclusive learning environment. The policy defines bullying as repetitive, aggressive behavior that 
            intentionally causes harm or distress, and includes physical, verbal, emotional, and cyberbullying. Any form of bullying is unacceptable 
            and will not be tolerated. Students who experience or witness bullying are encouraged to report it to a trusted adult, who will 
            investigate and take responsibility for the incident. 
            
            TBD College will also focus on preventative measures, such as implementing anti-bullying curriculum, providing resources, and organizing
            awareness campaigns. The success of this policy depends on the collaboration and support of all members of the school community, 
            including parents, teachers, students, and staff.
            """);
        push("""
            TBD College has proposed a dress code policy to create a safe, respectful, and positive learning environment for students. The policy 
            includes guidelines for tops, bottoms, footwear, accessories, and head coverings. Tops must cover the midsection and shoulders, while
            bottoms must be appropriate length. Closed-toe shoes are required, and flip-flops or sandals are not allowed. Accessory items like hats, 
            caps, jewelry, and visible body piercings are not allowed. 
            
            The policy will be enforced during school hours and events, and students who do not comply may face disciplinary actions. TBD School 
            acknowledges individuality but also aims to create a professional environment. It is expected to be supported by students and parents.
            """);
        push("""
            A school fighting policy is crucial for creating a safe and secure learning environment for students and staff. TBD College has developed
            a comprehensive policy to prevent fighting and violence on campus. The policy includes prevention and education measures, immediate 
            response protocols, disciplinary action, support and rehabilitation, and parental involvement.

            Preventive measures include promoting conflict resolution and peaceful communication among students. TBD College will educate students 
            about the negative consequences of fighting and teach them appropriate conflict handling strategies. The school will confiscate weapons 
            and provide emergency medical assistance if necessary. Discipline will be taken against students involved in fighting, and any incidents 
            will be thoroughly investigated.
            
            After a fight, TBD College will provide support and resources to all parties involved, including counseling, conflict resolution sessions, 
            and anger management classes. Parental involvement is also essential, with parents being notified of incidents and expected to attend 
            meetings to develop a plan for addressing the issue.
            """);
        push("""
            TBD College emphasizes the importance of student discipline in fostering a positive learning environment. A code of conduct outlines 
            expectations and consequences for behavior, guiding students to make informed choices. TBD College also implements progressive discipline, 
            escalating consequences for inappropriate behavior, such as verbal warnings, detention, parent-teacher conferences, and suspension or 
            expulsion. A support system is in place for students struggling to meet the code of conduct, offering counseling services, mentorship 
            programs, and additional resources. 
            
            Consistency in disciplinary measures ensures fair treatment and timely resolution of inappropriate behavior. TBD College's commitment to 
            student discipline is evident in its commitment to promoting positive behavior and academic success. This approach prepares students for 
            success both in and out of the classroom.
            """);
    }};
    private static Stack<String> aboutContent = new Stack<>(){{
        push("""
            TBD College, founded in 2018, is a leading educational institution known for its high academic standards and nurturing environment. It 
            aims to prepare students for future challenges. As the school expanded, it adopted new teaching methods and technological advancements,
            attracting more students and attracting top universities and employers.
            
            TBD College has core values of academic excellence, creativity, and character development have been a testament to its success.
            Today, the school offers a wide range of programs and extracurricular activities, with state-of-the-art facilities and dedicated faculty.
            
            TBD College continues to demonstrate the power of education to transform lives and shape the future.
            """);
        push("""
            Facebook - TBD College
            Email - TBDOfficial@gmail.com
            Phone - +6334733901""");
        push("");
    }};
    private static int aboutSize;
    private static int policySize;
    private static int toRetrieve;

    public int getAboutSize() {
        return About.aboutSize;
    }
    public void setAboutSize(){
        About.aboutSize = about.size();
    }
    public int getPolicySize() {
        return About.policySize;
    }
    public void setPolicySize(){
        About.policySize = policies.size();
    }
    public String getAbout() {
        Queue<String> aboutCopy = new LinkedList<String>(about);
        String aboutString = "";
        for(int i = 0; i < about.size(); i ++){
            if((i+1) == toRetrieve){
                 aboutString = aboutCopy.poll();
            }
            else{
                aboutCopy.poll();
            }
        }
        return aboutString;
    }
    public String getAboutContent() {
        Queue<String> aboutContentCopy = new LinkedList<String>(aboutContent);
        String aboutCString = "";
        for(int i = 0; i < aboutContent.size(); i ++){
            if((i+1) == toRetrieve){
                 aboutCString = aboutContentCopy.poll();
            }
            else{
                aboutContentCopy.poll();
            }
        }
        return aboutCString;
    }
    public String getPolicy() {
        Queue<String> policyCopy = new LinkedList<String>(policies);
        String policyString = "";
        for(int i = 0; i < policies.size(); i ++){
            if((i+1) == toRetrieve){
                 policyString = policyCopy.poll();
            }
            else{
                policyCopy.poll();
            }
        }
        return policyString;
    }
    public String getPolicyContent() {
        Queue<String> policyContentCopy = new LinkedList<String>(policyContent);
        String policyCString = "";
        for(int i = 0; i < policyContent.size(); i ++){
            if((i+1) == toRetrieve){
                 policyCString = policyContentCopy.poll();
            }
            else{
                policyContentCopy.poll();
            }
        }
        return policyCString;
    }
    public void setToRetrieve(int i){
        About.toRetrieve = i;
    }
    public void setAbout(String newAbout) {
        for(int i = 0; i < about.size(); i ++){
            if((i+1) == toRetrieve){
                 About.about.set(i, newAbout);
            }
        }
    }
    public void setAboutContent(String newContent) {
        for(int i = 0; i < aboutContent.size(); i ++){
            if((i+1) == toRetrieve){
                 About.aboutContent.set(i, newContent);
            }
        }
    }
    public void setAbout(String newAbout, String newContent) {
        About.about.push(newAbout);
        About.aboutContent.push(newContent);
    }
    public void setPolicy(String newPolicy) {
        for(int i = 0; i < policies.size(); i ++){
            if((i+1) == toRetrieve){
                 About.policies.set(i, newPolicy);
            }
        }
    }
    public void setPolicyContent(String newContent) {
        for(int i = 0; i < policyContent.size(); i ++){
            if((i+1) == toRetrieve){
                 About.policyContent.set(i, newContent);
            }
        }
    }
    public void setPolicy(String newPolicy, String newContent) {
        About.policies.push(newPolicy);
        About.policyContent.push(newContent);
    }
    public void removeAbout(){
        for(int i = 0; i < about.size(); i ++){
            if((i+1) == toRetrieve){
                About.about.remove(i);
                About.aboutContent.remove(i);
            }
        }
    }
    public void removePolicy(){
        for(int i = 0; i < policies.size(); i ++){
            if((i+1) == toRetrieve){
                About.policies.remove(i);
                About.policyContent.remove(i);
            }
        }
    }
    public String getPoliciesPrint() {
        return this.policiesPrint;
    }
    public void setPoliciesPrint() {
        Queue<String> policiesCopy = new LinkedList<String>(policies);
        for(int i = 0; i < policies.size(); i ++){
            this.policiesPrint = policiesPrint.concat("\n" + (i + 1) + " - " + policiesCopy.poll());
        }
    }
    public int getIndex(){
        Queue<String> aboutCopy = new LinkedList<String>(about);
        int counter = 0;
        for (String about : aboutCopy) {
            if (about == "School Policies") {
                break;
            }
            else counter++;
        }
        return counter+1;
    }
    public void displayAbout() {
        Queue<String> aboutCopy = new LinkedList<String>(about);
        for(int i = 0; i < about.size(); i ++){
            System.out.println((i + 1) + " - " + aboutCopy.poll());
        }
    }
}
