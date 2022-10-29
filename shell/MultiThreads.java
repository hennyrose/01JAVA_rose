package shell;

import java.util.Arrays;

public class MultiThreads {

    public static void createThreads(int[] array, int number) {
        ShellSort[] shellSort = new ShellSort[number];
        for (int i = 0; i < shellSort.length; i++) {
            int size = array.length / number;
            int begin = size * i;
            int end = ((i + 1) * size);
            if ((array.length - end) < size) {
                end = array.length;
            }
            int[] temp = Arrays.copyOfRange(array, begin, end);
            shellSort[i] = new ShellSort(temp, begin, end);
        }

        for (int i = 0; i < shellSort.length; i++) {
            try {
                shellSort[i].getThread().join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Arrays.toString(mergeAllArrays(shellSort)));
    }

    public static int[] mergeAllArrays(ShellSort shellSort[]) {
        int[] result = new int[shellSort.length];

        for (int i = 0; i < shellSort.length / 2; i++) {
            int[] temp = merge(shellSort[i].getArray(), shellSort[shellSort.length - i - 1].getArray());
            if (i == 0) {
                result = temp;
            } else {
                result = merge(result, temp);
            }
        }
        if (shellSort.length % 2 == 1) {
            int f = shellSort.length / 2;
            result = merge(result, shellSort[f].getArray());
        }

        return result;
    }


    public static int[] merge(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length + secondArray.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < result.length; i++) {
            if (l >= firstArray.length) {
                result[i] = secondArray[r];
                r += 1;
            } else if (r >= secondArray.length) {
                result[i] = firstArray[l];
                l += 1;
            } else if (firstArray[l] < secondArray[r]) {
                result[i] = firstArray[l];
                l += 1;
            } else {
                result[i] = secondArray[r];
                r += 1;
            }
        }
        return result;

    }
}