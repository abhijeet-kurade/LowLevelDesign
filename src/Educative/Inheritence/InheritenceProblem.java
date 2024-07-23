package Educative.Inheritence;

import java.util.HashMap;
import java.util.Map;

public class InheritenceProblem {
    public static void main(String[] args) {
        Animal a1 = new Animal(2, 2);



    }

    public static void m(Animal c){}

}

class Animal{
    int legs;
    int eyes;


    public Animal(int legs, int eyes) {
        this.legs = legs;
        this.eyes = eyes;
    }

    public void sleep(){
        System.out.println("Animal is sleeping.");
    }
}

class Cat extends Animal{
    public Cat(int l, int e) {
        super(l,e);
        System.out.println();
    }
    @Override
    public void sleep(){
        System.out.println("Cat is sleeping.");
        super.sleep();
    }
}



interface AB1{
    int var = 10;
    void m1();

    void m2();
}

interface AB2 extends AB1{
    int var = 11;
    void m1();
    //Map<Integer, Integer> m = new HashMap<>();
}

// Definition
// Implementation
class C implements AB2{

    public void m1(){

    }

    @Override
    public void m2() {

    }

}
