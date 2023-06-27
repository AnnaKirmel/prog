package org.example;

public class Weapon {
    private int id;
    private String type;
    private String name;
    private double range;
    private long container;
    private double weight;
    private double speed;



    public Weapon(int id, String type, String name, double range, long container, double weight, double speed) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.range = range;
        this.container = container;
        this.weight = weight;
        this.speed = speed;
    }

    public Weapon(int id, String field, String field1, int range, int container) {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public long getContainer() {
        return container;
    }

    public void setContainer(long container) {
        this.container = container;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public Weapon(){this.speed=speed;}

    @Override
    public String toString() {
        return "Weapon{"+
                "ID=" + id + " type=" + type +'\''+
                " name=" + name + '\'' + " range= " +range +'\''+ " container=" + container + '\'' + " weight=" +weight +'\''+
                " speed=" + speed + '}';



    }

    //void displayInfo(){
     //  System.out.printf("id: %s \ttype: %s \tname: %s \trange: %s \tcontainer: %s \tweight: %s \tspeed: %s\n", id,type,name,range,container, weight,speed);
   // }


}
