package Educative.Inheritence;

public abstract class AbClass {

    int var;
    public abstract void meth();

    public void meth1(){
        System.out.println("meth1");
    }
}

class CabClass extends AbClass{

    @Override
    public void meth() {

    }
}