import java.util.*;

public abstract class Variables {
    boolean loop = true;
    String studentCourse, admitType;
    String yearLevel, yearTerm;
    Map<String, String> studentInfo = new LinkedHashMap<>();
    static Map<Integer, Map<String, String>> enrolled = new LinkedHashMap<>();
    static int sNum = 001;
}
