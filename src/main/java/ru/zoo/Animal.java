package ru.zoo;

public class Animal {

    //Кусаются и могут болеть
    boolean healthy = true;

    public boolean hungry = true;

    public String name;

    String cage = "в вольере";

    public void bite(Human human) {
        human.hurt = true;
        System.out.println("Животное " + name + " покусало " + human.profession);
    }

    public void eat() {
        if(this.hungry) {
            this.hungry = false;
            System.out.println("Животное " + name + " поело ");
        } else {
            this.hungry = true;
        }
    }

    public Animal(String name) {
        this.name = name;
    }
}
