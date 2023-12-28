import java.util.*;

public abstract class Variables {
    boolean loop = true;
    String studentCourse, admitType, studentType, schedule, paymentTerm;
    String yearLevel, yearTerm;
    Map<String, String> studentInfo = new LinkedHashMap<>();
    static Map<Integer, Map<String, String>> enrolled = new LinkedHashMap<>();
    static int sNum = 1000;
    static Map<Integer, Map<String, String>> reserved = new LinkedHashMap<>();
    public static void lineGenerator(){
        for(int i = 0; i < 23; i++){
            System.out.print("-----");
        }
        System.out.println();
    }
}
