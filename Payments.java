public class Payments{
    public static final String GCASH = "(09232139095 NameOfOwner)";
    public static final String BDO = "(0000 0000 0000 000 NameOfOwner)";
    public static final String CHINABANK = "(123456 78910 11 NameOfOwner)";
    public static final String LANDBANK = "(0001 0001 0001 5538 NameOfOwner)";
    public static final String PAYPAL = "(tbdPayments@gmail.com TBDCollege)";
    public static final String EMAILLINK = "name@tbd.edu";

    private static String gcash;
    private static String bdo;
    private static String chinaBank;
    private static String landBank;
    private static String payPal;
    private static String emailLink;

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
