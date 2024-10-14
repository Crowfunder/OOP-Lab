package Zad01;

import java.util.Random;
import java.util.ArrayList;

public class Lotto {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        Random rand = new Random();
        int randomNumber;
        for (int i = 0; i < 6; i++) {
            do {
                randomNumber = rand.nextInt(50);
            } while (numbers.contains(randomNumber));
            numbers.add(randomNumber);
        }
        System.out.println(numbers);
    }
}
