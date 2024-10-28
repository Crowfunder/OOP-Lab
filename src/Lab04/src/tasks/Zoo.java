package tasks;

import animals.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Zoo {
    Animal[] animals;

    private Animal animalDefinition(int n) {
        switch (n) {
            case 0:
                 return new Mammal();
            case 1:
                 return new Bird();
            case 2:
                 return new Parrot();
            case 3:
                 return new Tiger();
            default:
                return null;
        }
    }

    public Zoo() {
        this.animals = new Animal[100];
        Random rand = new Random();
        Animal animal;
        for (int i = 0; i < this.animals.length; i++) {
            this.animals[i] = animalDefinition(rand.nextInt(4));
        }
    }

    public Animal[] getAnimals() {
        return this.animals;
    }
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        int numberOfLegs = 0;
        int numberOfFur = 0;
        for (int i = 0; i < this.animals.length; i++) {
            report.append(this.animals[i].getName()).append(this.animals[i].getIloscNog()).append("\n");
            numberOfLegs += this.animals[i].getIloscNog();
            if (this.animals[i] instanceof Bird) {
                if (((Bird) this.animals[i]).hasFur) {
                    numberOfFur++;
                }
            }
        }
        report.append(numberOfLegs).append(" nóg.").append("\n");
        report.append(numberOfFur).append(" numer of fur").append("\n");
        return report.toString();
    }
}
