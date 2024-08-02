package DesignPattern.Creational.AbstractFactory;

public class Program {
}

interface IProductA{
    void createProductA();
}

class ProductAType1 implements IProductA{

    @Override
    public void createProductA() {

    }
}

class ProductAType2 implements IProductA{

    @Override
    public void createProductA() {

    }
}

class ProductAType3 implements IProductA{

    @Override
    public void createProductA() {

    }
}


interface IProductB{
    void createProductB();
}

class ProductBType1 implements IProductB{

    @Override
    public void createProductB() {

    }
}

class ProductBType2 implements IProductB{

    @Override
    public void createProductB() {

    }
}

class ProductBType3 implements IProductB{

    @Override
    public void createProductB() {

    }
}


interface Factory{
    IProductA getProductA();
    IProductB getProductB();
}

class Type1Factory implements Factory{

    @Override
    public IProductA getProductA() {
        return new ProductAType1();
    }

    @Override
    public IProductB getProductB() {
        return new ProductBType1();
    }
}

class Type2Factory implements Factory{

    @Override
    public IProductA getProductA() {
        return new ProductAType2();
    }

    @Override
    public IProductB getProductB() {
        return new ProductBType2();
    }
}

class Type3Factory implements Factory{

    @Override
    public IProductA getProductA() {
        return new ProductAType3();
    }

    @Override
    public IProductB getProductB() {
        return new ProductBType3();
    }
}