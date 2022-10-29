package shell;

public class ShellSort implements Runnable {
    private int[] array;
    private Thread thread;
    private int start;
    private int end;

    public ShellSort(int[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public int[] getArray() {
        return array;
    }

    @Override
    public void run() {
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (array[c] > array[c + gap]) {
                        swap(array, c, c + gap);
                    }
                }
            }
            gap = gap / 2;
        }
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}