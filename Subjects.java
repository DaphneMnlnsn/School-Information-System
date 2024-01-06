import java.util.*;

public interface Subjects {
    Map<String, Map<String, Float>> defaultQuarter = new LinkedHashMap<>(); 
    Map<String, Float> prelimGrades = new LinkedHashMap<>();
    Map<String, Float> midGrades = new LinkedHashMap<>();
    Map<String, Float> prefGrades = new LinkedHashMap<>();
    Map<String, Float> finGrades = new LinkedHashMap<>();
    String[] bstm = {"BSTM Subject 1", "BSTM Subject 2", "BSTM Subject 3", "BSTM Subject 4", "BSTM Subject 5", "BSTM Subject 6", "BSTM Subject 7", "BSTM Subject 8"};
    String[] bstm2 = {"BSTM Subject 9", "BSTM Subject 10", "BSTM Subject 11", "BSTM Subject 12", "BSTM Subject 13", "BSTM Subject 14", "BSTM Subject 15", "BSTM Subject 16"};
    String[] bscpe = {"BSCPE Subject 1", "BSCPE Subject 2", "BSCPE Subject 3", "BSCPE Subject 4", "BSCPE Subject 5", "BSCPE Subject 6", "BSCPE Subject 7", "BSCPE Subject 8"};
    String[] bscpe2 = {"BSCPE Subject 9", "BSCPE Subject 10", "BSCPE Subject 11", "BSCPE Subject 12", "BSCPE Subject 13", "BSCPE Subject 14", "BSCPE Subject 15", "BSCPE Subject 16"};
    String[] bsit = {"BSIT Subject 1", "BSIT Subject 2", "BSIT Subject 3", "BSIT Subject 4", "BSIT Subject 5", "BSIT Subject 6", "BSIT Subject 7", "BSIT Subject 8"};
    String[] bsit2 = {"BSIT Subject 9", "BSIT Subject 10", "BSIT Subject 11", "BSIT Subject 12", "BSIT Subject 13", "BSIT Subject 14", "BSIT Subject 15", "BSIT Subject 16"};
    String[] bscs = {"BSCS Subject 1", "BSCS Subject 2", "BSCS Subject 3", "BSCS Subject 4", "BSCS Subject 5", "BSCS Subject 6", "BSCS Subject 7", "BSCS Subject 8"};
    String[] bscs2 = {"BSCS Subject 9", "BSCS Subject 10", "BSCS Subject 11", "BSCS Subject 12", "BSCS Subject 13", "BSCS Subject 14", "BSCS Subject 15", "BSCS Subject 16"};
    String[] bsba = {"BSBA Subject 1", "BSBA Subject 2", "BSBA Subject 3", "BSBA Subject 4", "BSBA Subject 5", "BSBA Subject 6", "BSBA Subject 7", "BSBA Subject 8"};
    String[] bsba2 = {"BSBA Subject 9", "BSBA Subject 10", "BSBA Subject 11", "BSBA Subject 12", "BSBA Subject 13", "BSBA Subject 14", "BSBA Subject 15", "BSBA Subject 16"};
    String[] bmma = {"BMMA Subject 1", "BMMA Subject 2", "BMMA Subject 3", "BMMA Subject 4", "BMMA Subject 5", "BMMA Subject 6", "BMMA Subject 7", "BMMA Subject 8"};
    String[] bmma2 = {"BMMA Subject 9", "BMMA Subject 10", "BMMA Subject 11", "BMMA Subject 12", "BMMA Subject 13", "BMMA Subject 14", "BMMA Subject 15", "BMMA Subject 16"};
    Map<String, String[]> term1 = new LinkedHashMap<>(){{
            put("1st Term", bstm);
            put("2nd Term", bstm2);
        }};
    Map<String, String[]> term2 = new LinkedHashMap<>(){{
            put("1st Term", bscpe);
            put("2nd Term", bscpe2);
        }};
    Map<String, String[]> term3 = new LinkedHashMap<>(){{
            put("1st Term", bsit);
            put("2nd Term", bsit2);
        }};
    Map<String, String[]> term4 = new LinkedHashMap<>(){{
            put("1st Term", bscs);
            put("2nd Term", bscs2);
        }};
    Map<String, String[]> term5 = new LinkedHashMap<>(){{
            put("1st Term", bsba);
            put("2nd Term", bsba2);
        }};
    Map<String, String[]> term6 = new LinkedHashMap<>(){{
            put("1st Term", bmma);
            put("2nd Term", bmma2);
        }};
    Map<String, Map<String, String[]>> yearLevel1 = new LinkedHashMap<>(){{
            put("1st Year", term1);
            put("2nd Year", term1);
            put("3rd Year", term1);
            put("4th Year", term1);
        }};
    Map<String, Map<String, String[]>> yearLevel2 = new LinkedHashMap<>(){{
            put("1st Year", term2);
            put("2nd Year", term2);
            put("3rd Year", term2);
            put("4th Year", term2);
        }};
    Map<String, Map<String, String[]>> yearLevel3 = new LinkedHashMap<>(){{
            put("1st Year", term3);
            put("2nd Year", term3);
            put("3rd Year", term3);
            put("4th Year", term3);
        }};
    Map<String, Map<String, String[]>> yearLevel4 = new LinkedHashMap<>(){{
            put("1st Year", term4);
            put("2nd Year", term4);
            put("3rd Year", term4);
            put("4th Year", term4);
        }};
    Map<String, Map<String, String[]>> yearLevel5 = new LinkedHashMap<>(){{
            put("1st Year", term5);
            put("2nd Year", term5);
            put("3rd Year", term5);
            put("4th Year", term5);
        }};
    Map<String, Map<String, String[]>> yearLevel6 = new LinkedHashMap<>(){{
            put("1st Year", term6);
            put("2nd Year", term6);
            put("3rd Year", term6);
            put("4th Year", term6);
        }};
    Map<String, Map<String, Map<String, String[]>>> subjectCourse = new LinkedHashMap<>(){{
            put("Bachelor of Science in Tourism Management (BSTM)", yearLevel1);
            put("Bachelor of Science In Computer Engineering (BSCpE)", yearLevel2);
            put("Bachelor of Science in Information Technology (BSIT)", yearLevel3);
            put("Bachelor of Science in Computer Science (BSCS)", yearLevel4);
            put("Bachelor of Science in Business Administration (BSBA)", yearLevel5);
            put("Bachelor of Science in Multimedia Arts (BMMA)", yearLevel6);
        }};
}

interface Grades extends Subjects{
    Map<String, Float> subject = new LinkedHashMap<>(){{
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[0], (float) 97.00);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[1], (float) 98.10);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[2], (float) 95.70);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[3], (float) 96.90);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[4], (float) 98.10);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[5], (float) 98.70);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[6], (float) 94.08);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[7], (float) 95.03);
    }};
    Map<String, Float> subject2 = new LinkedHashMap<>(){{
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[0], (float) 95.00);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[1], (float) 97.10);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[2], (float) 98.70);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[3], (float) 94.90);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[4], (float) 93.10);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[5], (float) 95.70);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[6], (float) 98.08);
        put(subjectCourse.get("Bachelor of Science in Information Technology (BSIT)").get("1st Year").get("1st Term")[7], (float) 99.03);
    }};
    Map<String, Map<String, Float>> quarter = new LinkedHashMap<>(){{
        put("Prelims", subject);
        put("Midterms", subject);
        put("Prefinals", subject);
        put("Finals", subject);
    }};
    Map<String, Map<String, Float>> quarter2 = new LinkedHashMap<>(){{
        put("Prelims", subject2);
        put("Midterms", subject2);
        put("Prefinals", subject2);
        put("Finals", subject2);
    }};
    Map<String, Map<String, Map<String, Float>>> studentGrades = new LinkedHashMap<>(){{
            put("2024-1001", quarter);
            put("2024-1002", quarter2);
    }};
}