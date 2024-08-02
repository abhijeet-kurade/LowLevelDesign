package DesignPattern.Creational.Singleton;

public class Program {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        a.x = 100;
        Singleton b = Singleton.getInstance();
        System.out.println(b.x);
        System.out.println();

    }
}

class Singleton{
    private static Singleton instance;
    int x;
    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
