package DesignPattern.Creational.Factory.Practice;

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

class Veggie extends Burger{

    @Override
    void prepare() {

    }
}

class Common extends Burger{

    @Override
    void prepare() {

    }
}


abstract class Restaurant{
    public abstract Burger createBurger(String type);
}

class ChickenBurgerRestaurant extends Restaurant{

    @Override
    public Burger createBurger(String type) {
        return new Chicken();
    }
}

class VeggieBurgerRestaurant extends Restaurant{

    @Override
    public Burger createBurger(String type) {
        return new Veggie();
    }
}

class PerryPerryBurgerRestaurant extends Restaurant{

    @Override
    public Burger createBurger(String type) {
        return new PerryPerry();
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