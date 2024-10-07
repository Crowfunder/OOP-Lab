package Lab01.Zad02;
import java.util.Arrays;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        int[] numbers = new int[6];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(50);
//            System.out.print(numbers[i] + " ");
        }
        System.out.println(Arrays.toString(numbers));
    }
}
