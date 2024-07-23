package Educative.Inheritence;

public class Base {
    private int var1;

    public String str1;
    private double PI;

    public Base() {
        var1 = 5;
        str1 = "str";
        PI = 3.14;
    }

    public void method(){
        System.out.println("base class");
    }

    public void getSome(AbClass v){
        v.meth();
    }
}

