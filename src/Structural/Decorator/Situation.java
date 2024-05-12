package Structural.Decorator;

import java.sql.DatabaseMetaData;

public class Situation {
}

class DatabaseService{
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
class Notifier{
    private final String username;
    protected final DatabaseService databaseService;
    public Notifier(String username) {
        this.username = username;
        this.databaseService = new DatabaseService();
    }

    public void send(String message){
        String mailId = databaseService.getMailByUsername(getUsername());
        System.out.println("Sending "+message+ "by mail to "+ mailId);
    }
    public String getUsername() {
        return username;
    }
}

/**
 * Customer is expecting more ways to more ways to get notifies like whatsapp and mobile sms
 *
 */

class WhatsappNotifies extends Notifier{

    public WhatsappNotifies(String username) {
        super(username);
    }

    @Override
    public void send(String message) {
        super.send(message);
    }
}

class SMSNotifies extends Notifier{

    public SMSNotifies(String username) {
        super(username);
    }

    @Override
    public void send(String message) {
        super.send(message);
    }
}


/**
 * Now customer wants to get notifies by both sms and whatsapp
 * and more.
 * This will result in explosion of classes
 */