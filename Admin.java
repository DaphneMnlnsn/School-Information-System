import java.util.*;

public abstract class Admin extends Variables implements Courses  {
    Admin(){
    }
    //Edit Programs
    public int addCourse(String newCourse, String topSkill, String opportunity){
        LinkedList<Integer> list = new LinkedList<>(courses.keySet());
        int newKey = list.getLast()+1;
        courses.put(newKey, newCourse);
        topSkills.put(newCourse, topSkill);
        opportunities.put(newCourse, opportunity);
        return newKey;
    }
    public void addSkill(int courseNum, String skill){
        topSkills.replace(courses.get(courseNum), topSkills.get(courses.get(courseNum)).concat("\n- " + skill));
    }
    public void addOpp(int courseNum, String opp){
        opportunities.replace(courses.get(courseNum), opportunities.get(courses.get(courseNum)).concat("\n- " + opp));
    }
    public void removeCourse(int courseNum){
        opportunities.remove(courses.get(courseNum));
        topSkills.remove(courses.get(courseNum));
        courses.remove(courseNum);   
    }
}