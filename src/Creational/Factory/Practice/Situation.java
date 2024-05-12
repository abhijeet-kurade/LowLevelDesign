package Creational.Factory.Practice;

public class Situation {
}

abstract class Burger{
    abstract void prepare();
}
class Chicken extends Burger{

    @Override
    void prepare() {

    }
}

class PerryPerry extends Burger{

    @Override
    void prepare() {

    }
}

class Common extends Burger{

    @Override
    void prepare() {

    }
}


class Restaurant{
    SimpleBurgerFactory factory;
    public Burger createBurger(String type){
        Burger b = factory.createBurger(type);
        b.prepare();
        return b;
    }
}

class SimpleBurgerFactory{
    public Burger createBurger(String type){
        Burger b;
        if(type.equals("Chicken")){
            b = new Chicken();
        }
        else if(type.equals("PerryPerry")){
            b = new PerryPerry();
        }
        else {
            b = new Common();
        }
        return b;
    }
}