import java.util.*;

public class Blog{

    private static Stack<String> headline = new Stack<>(){{
        push("TBD wins InterMath competition on US");  push("TBD opens new campus building");    
        push("TBD hosts BULPRISA 2023");    push("TBD conducts 2023 graduation");
    }};
    private static Stack<String> article = new Stack<>(){{
        push("TBD College wins first place in the US InterMathematics Competition! Competitor Juan Dela Cruz feels proud for his best achievement so far. 'Super nakaka-proud po kasi talagang pinag-practicean ko 'to.', Dela Cruz says.");  
        push("TBD College opens new campus building, expanding the campus canteen and giving students more classrooms to learn in.");
        push("TBD College hosts the BULPRISA for the first time. Several campus officers conducted an initial meeting to plan the programs for BULPRISA and the venues to be used.");
        push("TBD College conducts the Tertiary Graduation in the Philippine International Convention Center (PICC) for A.Y. 2022-23.");
    }};
    private static int articleSize;
    private static int toRetrieve;

    public int getArticleSize() {
        return Blog.articleSize;
    }
    public void setArticleSize(){
        Blog.articleSize = headline.size();
    }
    public String getHeadline() {
        Queue<String> headlineCopy = new LinkedList<String>(headline);
        String headlineString = "";
        for(int i = 0; i < headline.size(); i ++){
            if((i+1) == toRetrieve){
                 headlineString = headlineCopy.poll();
            }
            else{
                headlineCopy.poll();
            }
        }
        return headlineString;
    }
    public String getArticle() {
        Queue<String> articleCopy = new LinkedList<String>(article);
        String articleString = "";
        for(int i = 0; i < article.size(); i ++){
            if((i+1) == toRetrieve){
                 articleString = articleCopy.poll();
            }
            else{
                articleCopy.poll();
            }
        }
        return articleString;
    }
    public void setToRetrieve(int i){
        Blog.toRetrieve = i;
    }
    public void setHeadline(String newHeadline) {
        for(int i = 0; i < headline.size(); i ++){
            if((i+1) == toRetrieve){
                 Blog.headline.set(i, newHeadline);
            }
        }
    }
    public void setArticle(String newArticle) {
        for(int i = 0; i < article.size(); i ++){
            if((i+1) == toRetrieve){
                 Blog.article.set(i, newArticle);
            }
        }
    }
    public void setHeadline(String newHeadline, String newArticle) {
        Blog.headline.push(newHeadline);
        Blog.article.push(newArticle);
    }
    public void removeHeadline(){
        for(int i = 0; i < headline.size(); i ++){
            if((i+1) == toRetrieve){
                Blog.headline.remove(i);
                Blog.article.remove(i);
            }
        }
    }
    public void displayBlog() {
        Queue<String> headlineCopy = new LinkedList<String>(headline);
        for(int i = 0; i < headline.size(); i ++){
            System.out.println((i + 1) + " - " + headlineCopy.poll());
        }
    }
}
