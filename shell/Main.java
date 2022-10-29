package shell;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[500];
        Random rn = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(3, 10000);
        }
        System.out.println(Arrays.toString(array));
        System.out.println();
        MultiThreads.createThreads(array, 5);
    }
}