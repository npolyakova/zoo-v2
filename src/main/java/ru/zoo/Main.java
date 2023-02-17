package ru.zoo;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();
        Zookeeper zookeeper = new Zookeeper();

        Cats lion = new Cats("Кузя");
        Cats tiger = new Cats("Жора");
        Hypo hypo = new Hypo("Дося");
        Squirrels squirrelS = new Squirrels("Стрелка");
        Squirrels squirrelL = new Squirrels("Ловкач");

        final List<Animal> animals = List.of(lion, tiger, hypo, squirrelS, squirrelL);

        feeding(zookeeper, animals);

        lion.healthy = false;
        healthChecking(veterinarian, animals);

        timeForLunch(veterinarian, zookeeper);

        makeAnimalsHungry(animals);

        zookeeper.changeWater(hypo);

        feeding(zookeeper, animals);

        tiger.healthy = false;
        lion.healthy = true;
        healthChecking(veterinarian, animals);

        squirrelL.goOut();
        veterinarian.watch(squirrelL);
    }

    public static void timeForLunch(Veterinarian veterinarian, Zookeeper zookeeper) {
        Random r = new Random();
        veterinarian.hungry = r.nextBoolean();
        veterinarian.lunch();
        zookeeper.hungry = r.nextBoolean();
        zookeeper.lunch();
        System.out.println();
    }

    public static void feeding(Zookeeper zookeeper, List<Animal> animals) {
        Random r = new Random();
        animals.forEach(animal -> {
            zookeeper.feed(animal);
            if (r.nextBoolean()) {
                animal.bite(zookeeper);
                zookeeper.makeBandage();
            }
        });
        animals.forEach(Animal::eat);
        System.out.println();
    }

    public static void healthChecking(Veterinarian veterinarian, List<Animal> animals) {
        Random r = new Random();
        animals.forEach(animal -> {
            veterinarian.checkHealth(animal);
            if (r.nextBoolean()) {
                animal.bite(veterinarian);
                veterinarian.makeBandage();
            }
        });
        System.out.println();
    }

    public static void makeAnimalsHungry(List<Animal> animals) {
        animals.forEach(animal -> animal.hungry = true);
    }
}
