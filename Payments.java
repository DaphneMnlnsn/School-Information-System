import java.util.*;

public class Payments{
    public static final String EMAILLINK = "name@tbd.edu";

    private static Stack<String> paymentMethod = new Stack<>(){{
        push("GCash");  push("BDO");    push("China Bank");
        push("Land Bank");  push("PayPal");
    }};
    private static Stack<String> account = new Stack<>(){{
        push("09232139095");  push("0000 0000 0000 000");    push("123456 78910 11");
        push("0001 0001 0001 5538");  push("tbdPayments@gmail.com");
    }};
    private static Stack<String> accountName = new Stack<>(){{
        push("TBD College");  push("Name of Owner");    push("TBD College");
        push("Owner Name");  push("TBDCollege");
    }};
    private static int paymentSize;
    private static int toRetrieve;
    private static String emailLink;

    public String getPaymentMethod() {
        Queue<String> paymentCopy = new LinkedList<String>(paymentMethod);
        String paymentM = "";
        for(int i = 0; i < paymentMethod.size(); i ++){
            if((i+1) == toRetrieve){
                 paymentM = paymentCopy.poll();
            }
            else{
                paymentCopy.poll();
            }
        }
        return paymentM;
    }
    public int getPaymentSize() {
        return Payments.paymentSize;
    }
    public void setPaymentSize(){
        Payments.paymentSize = paymentMethod.size();
    }
    public String getAccount() {
        Queue<String> accountCopy = new LinkedList<String>(account);
        String accountNum = "";
        for(int i = 0; i < account.size(); i ++){
            if((i+1) == toRetrieve){
                 accountNum = accountCopy.poll();
            }
            else{
                accountCopy.poll();
            }
        }
        return accountNum;
    }
    public String getAccountName() {
        Queue<String> accountNCopy = new LinkedList<String>(accountName);
        String accountN = "";
        for(int i = 0; i < accountName.size(); i ++){
            if((i+1) == toRetrieve){
                 accountN = accountNCopy.poll();
            }
            else{
                accountNCopy.poll();
            }
        }
        return accountN;
    }
    public String getEmailLink() {
        return emailLink != null ? emailLink : EMAILLINK;
    }
    public void setToRetrieve(int i){
        Payments.toRetrieve = i;
    }
    public void setEmail(String Email) {
        Payments.emailLink = Email;
    }
    public void setAccount(String newAccount) {
        for(int i = 0; i < account.size(); i ++){
            if((i+1) == toRetrieve){
                 Payments.account.set(i, newAccount);
            }
        }
    }
    public void setAccountName(String newAccountName) {
        for(int i = 0; i < account.size(); i ++){
            if((i+1) == toRetrieve){
                 Payments.accountName.set(i, newAccountName);
            }
        }
    }
    public void setAccount(String newMethod, String newAccount, String newAccountName) {
        Payments.paymentMethod.push(newMethod);
        Payments.account.push(newAccount);
        Payments.accountName.push(newAccountName);
    }
    public void removeAccount(){
        for(int i = 0; i < account.size(); i ++){
            if((i+1) == toRetrieve){
                Payments.paymentMethod.remove(i);
                Payments.account.remove(i);
                Payments.accountName.remove(i);
            }
        }
    }
    public void displayPaymentMethod() {
        Queue<String> paymentCopy = new LinkedList<String>(paymentMethod);
        for(int i = 0; i < paymentMethod.size(); i ++){
            System.out.println((i + 1) + " - " + paymentCopy.poll());
        }
    }
}
