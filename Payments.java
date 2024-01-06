public class Payments{
    public static String GCASH = "(09232139095 NameOfOwner)";
    public static String BDO = "(0000 0000 0000 000 NameOfOwner)";
    public static String CHINABANK = "(123456 78910 11 NameOfOwner)";
    public static String LANDBANK = "(0001 0001 0001 5538 NameOfOwner)";
    public static String PAYPAL = "(AA11 BB22 CC33 DD44)";
    public static String EMAILLINK = "name@tbd.edu";

    private String gcash;
    private String bdo;
    private String chinaBank;
    private String landBank;
    private String payPal;
    private String emailLink;

    public String getGCash() {
        return gcash != null ? gcash : GCASH;
    }

    public String getBDO() {
        return bdo != null ? bdo : BDO;
    }

    public String getChinaBank() {
        return chinaBank != null ? chinaBank : CHINABANK;
    }

    public String getLandBank() {
        return landBank != null ? landBank : LANDBANK;
    }

    public String getPayPal() {
        return payPal != null ? payPal : PAYPAL;
    }
    
    public String getEmailLink() {
        return emailLink != null ? emailLink : EMAILLINK;
    }
    
    public void setEmail(String Email) {
        this.emailLink = Email;
    }

    public void setGCash(String gcash) {
        this.gcash = gcash;
    }

    public void setBDO(String bdo) {
        this.bdo = bdo;
    }

    public void setChinaBank(String chinaBank) {
        this.chinaBank = chinaBank;
    }

    public void setLandBank(String landBank) {
        this.landBank = landBank;
    }

    public void setPayPal(String payPal) {
        this.payPal = payPal;
    }

    public String getPaymentMethod() {
        return "\n1 - GCash" + "\n2 - BDO" + "\n3 - ChinaBank"
                + "\n4 - nLandBank" + "\n5 - PayPal";
    }
}
