import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSort {
    public static int COUNTER = 0;
    static int partition(ArrayList<Integer> array, int low, int high)
    {
        Integer pivot = array.get(low);
        int i = low;
        for (int j = i + 1; j <= high; j++) {
            COUNTER++;
            if (array.get(j) < pivot) {
                i++;
                Collections.swap(array, j, i);
            }
        }
        Collections.swap(array, low, i);
        return i;
    }

    static void quickSort(ArrayList<Integer> array, int low, int high)
    {
        if (low < high) {
            int part = partition(array, low, high);
            quickSort(array, low, part - 1);
            quickSort(array, part + 1, high);
        }
    }

    static void printArray(ArrayList<Integer> array)
    {
        int i;
        for (i = 0; i < array.size(); i++)
            System.out.print(array.get(i) + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        ArrayList<Integer> seq = new ArrayList<Integer>();
        for (int i = 1; i <= 1000000; i++)
            seq.add(i);
        Collections.shuffle(seq, new Random());

        quickSort(seq, 0, seq.size() - 1);
        System.out.println("Sorted array: ");
        //printArray(seq);
        System.out.println("Number of key comparisons X = " + COUNTER);
        double e = 2 * seq.size() * Math.log(seq.size());
        System.out.println("The upper bound of the expected number of key comparisons E = " + e);
        System.out.println("X/E = " + COUNTER/e);
    }
}
