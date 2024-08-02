package DesignPattern.Creational.Factory;

public class Program {
    public static void main(String[] args) {
        Restaurant italian = new ItalianRestaurant();
        italian.createDish().prepare();

        Restaurant chinese = new ChineseRestaurant();
        chinese.createDish().prepare();
    }
}

interface Dish{
    public void prepare();
}

class ItalianDish implements Dish{

    @Override
    public void prepare() {
        System.out.println("Italian Dish is prepared.");
    }
}

class ChineseDish implements Dish{

    @Override
    public void prepare() {
        System.out.println("Chinese Dish is prepared.");
    }
}

interface Restaurant{
    public Dish createDish();
}

class ItalianRestaurant implements Restaurant{

    @Override
    public Dish createDish() {
        return new ItalianDish();
    }
}

class ChineseRestaurant implements Restaurant{

    @Override
    public Dish createDish() {
        return new ChineseDish();
    }
}