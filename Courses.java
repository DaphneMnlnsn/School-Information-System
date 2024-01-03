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
        Map<String, LinkedList<String>> topSkills = new LinkedHashMap<>(){{
            put("Bachelor of Science in Tourism Management (BSTM)", new LinkedList<String>());
            put("Bachelor of Science In Computer Engineering (BSCpE)", new LinkedList<String>());
            put("Bachelor of Science in Information Technology (BSIT)", new LinkedList<String>());
            put("Bachelor of Science in Computer Science (BSCS)", new LinkedList<String>());
            put("Bachelor of Science in Business Administration (BSBA)", new LinkedList<String>());
            put("Bachelor of Science in Multimedia Arts (BMMA)", new LinkedList<String>());
        }};
        Map<String, LinkedList<String>> opportunities = new LinkedHashMap<>(){{
            put("Bachelor of Science in Tourism Management (BSTM)", new LinkedList<String>());
            put("Bachelor of Science In Computer Engineering (BSCpE)", new LinkedList<String>());
            put("Bachelor of Science in Information Technology (BSIT)", new LinkedList<String>());
            put("Bachelor of Science in Computer Science (BSCS)", new LinkedList<String>());
            put("Bachelor of Science in Business Administration (BSBA)", new LinkedList<String>());
            put("Bachelor of Science in Multimedia Arts (BMMA)", new LinkedList<String>());
        }};

}
