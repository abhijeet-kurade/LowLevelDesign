package DesignPattern.Structural.Decorator;

public class Situation {
}

class DatabaseService1 {
    public String getMailByUsername(String username){
        return username+"@outlook.com";
    }

    public String getWhatsAppNumByUsername(String username){
        return username+"@whatsapp.com";
    }

    public String getMobileNumByUsername(String username){
        return username+"@mobile";
    }
}
class Notifier1 {
    private final String username;
    protected final DatabaseService1 databaseService1;
    public Notifier1(String username) {
        this.username = username;
        this.databaseService1 = new DatabaseService1();
    }

    public void send(String message){
        String mailId = databaseService1.getMailByUsername(getUsername());
        System.out.println("Sending "+message+ "by mail to "+ mailId);
    }
    public String getUsername() {
        return username;
    }
}

/**
 * Customer is expecting more ways to more ways to get
 * notifies like whatsapp and mobile sms
 *
 */

class WhatsappNotifies extends Notifier1 {

    public WhatsappNotifies(String username) {
        super(username);
    }

    @Override
    public void send(String message) {
        String whatsapp = databaseService1.getWhatsAppNumByUsername(getUsername());
        System.out.println("Sending whatsapp notification to " + whatsapp);
    }
}

class SMSNotifies extends Notifier1 {

    public SMSNotifies(String username) {
        super(username);
    }

    @Override
    public void send(String message) {
        String mobile = databaseService1.getMobileNumByUsername(getUsername());
        System.out.println("Sending whatsapp notification to " + mobile);
    }
}


/**
 * Now customer wants to get notifies by both sms and whatsapp
 * and more.
 * This will result in explosion of classes
 */