package Structural.Decorator;

public class Program {

    public static void main(String[] args) {
        Program p = new Program();
        p.sendNotification();
    }
    public void sendNotification(){
        INotifier decorator =  new WhatsAppNotifier(
                new MobileSmsNotifier(
                        new Notifier("123")));
        decorator.send("Message to send");
    }
}

interface INotifier{
    void send(String message);
    String getUsername();
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

class Notifier implements INotifier{
    private final String username;
    private final DatabaseService1 databaseService1;

    public Notifier(String username) {
        this.username = username;
        this.databaseService1 = new DatabaseService1();
    }

    @Override
    public void send(String message){
        String mailId = databaseService1.getMailByUsername(getUsername());
        System.out.println("Sending "+message+ "by mail to "+ mailId);
    }

    @Override
    public String getUsername() {
        return username;
    }
}

abstract class NotifierDecorator implements INotifier{
    private final INotifier wrapper;
    protected final DatabaseService databaseService;

    public NotifierDecorator(INotifier wrapper) {
        this.wrapper = wrapper;
        this.databaseService = new DatabaseService();
    }

    @Override
    public void send(String message){
        this.wrapper.send(message);
    }

    @Override
    public String getUsername() {
        return this.wrapper.getUsername();
    }
}

class WhatsAppNotifier extends NotifierDecorator{

    public WhatsAppNotifier(INotifier wrapper) {
        super(wrapper);
    }

    @Override
    public void send(String message){
        super.send(message);
        String wp = databaseService.getWhatsAppNumByUsername(getUsername());
        System.out.println("Sending whatsapp notification to "+ wp);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }
}

class MobileSmsNotifier extends NotifierDecorator{

    public MobileSmsNotifier(INotifier wrapper) {
        super(wrapper);
    }

    public void send(String message){
        super.send(message);
        String mobile = databaseService.getMobileNumByUsername(getUsername());
        System.out.println("Sending mobile notification to "+ mobile);
    }
    public String getUsername() {
        return super.getUsername();
    }
}