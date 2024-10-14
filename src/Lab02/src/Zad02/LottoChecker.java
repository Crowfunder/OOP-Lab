package Zad02;

import java.util.ArrayList;
import java.util.Random;

public class LottoChecker {
    private static ArrayList<Integer> RandomizeLotto() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        Random rand = new Random();
        int randomNumber;
        for (int i = 0; i < 6; i++) {
            do {
                randomNumber = rand.nextInt(50);
            } while (numbers.contains(randomNumber));
            numbers.add(randomNumber);
        }
        return numbers;
    }

    public static void main(String[] args) {

        int iterations = 0;
        int hits = 0;
        long start = System.currentTimeMillis();
        while(hits != 6) {
            iterations++;
            hits = 0;
            ArrayList<Integer> numbers = RandomizeLotto();
            for (int i = 0; i < args.length; i++) {
                if (numbers.contains(Integer.parseInt(args[i]))) {
                    hits++;
                }
            }
        }

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Hits: " + hits);
        System.out.println("Iterations: " + iterations);
        System.out.println("Time Elapsed: " + timeElapsed + "ms");
    }
}
