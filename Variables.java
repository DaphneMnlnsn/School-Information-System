import java.util.*;

public abstract class Variables {
    boolean loop = true;
    String studentCourse, admitType, studentType, schedule, paymentTerm;
    String yearLevel, yearTerm;
    Map<String, String> studentInfo = new LinkedHashMap<>();
    static Map<Integer, Map<String, String>> enrolled = new LinkedHashMap<>();
    static int sNum = 1000;
    static Map<Integer, Map<String, String>> reserved = new LinkedHashMap<>();
    String teacherUser[] = {"mauricio.123", "manalansan.456", "lagula.789", "cabangon.038"};
    String teacherPass[] = {"mau0000", "man0000", "lag0000", "cab0000"};
    public static void lineGenerator(){
        for(int i = 0; i < 23; i++){
            System.out.print("-----");
        }
        System.out.println();
    }
}
