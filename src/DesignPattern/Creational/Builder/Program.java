package DesignPattern.Creational.Builder;

public class Program {
}

class House{
    int stories;
    int bedRooms;
    String doorType;
    String roofType;

    public House(){

    }

    public House(HouseBuilder builder){
        this.stories = builder.stories;
        this.bedRooms = builder.bedRooms;
        this.doorType = builder.doorType;
        this.roofType = builder.roofType;
    }
}

class HouseBuilder{
    int stories;
    int bedRooms;
    String doorType;
    String roofType;

    public HouseBuilder(){
        this.stories = 0;
        this.bedRooms = 0;
        this.doorType = null;
        this.roofType = null;
    }

    public HouseBuilder setStories(int stories){
        this.stories = stories;
        return this;
    }

    public HouseBuilder setBedRooms(int bedRooms){
        this.bedRooms = bedRooms;
        return this;
    }

    public HouseBuilder setDoorType(String doorType){
        this.doorType = doorType;
        return this;
    }

    public HouseBuilder setRoofType(String roofType){
        this.roofType = roofType;
        return this;
    }

    public House build(){
        return new House(this);
    }
}


class Director{
    HouseBuilder builder;
    public Director(HouseBuilder builder){
        this.builder = builder;
    }

    public House getFrenchTypeHouse(){
        return this.builder.setStories(2).setBedRooms(3).setDoorType("Double").setRoofType("Pointy").build();
    }

    public House getIndianTypeHouse(){
        return this.builder.setStories(4).setBedRooms(1).setDoorType("Single").setRoofType("Flat").build();
    }
}