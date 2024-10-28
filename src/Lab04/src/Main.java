import animals.*;
import tasks.Zoo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        System.out.printf(zoo.generateReport());
    }
}