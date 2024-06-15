import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomizedSelect {
    public static int COUNTER = 0;

    static int partition(ArrayList<Integer> array, int low, int high) {
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

    static Integer randomizedSelect(ArrayList<Integer> array, int low, int high, int q) {
        if(low == high)
                return array.get(low);
        int part = partition(array, low, high);
        int k = part - low + 1;
        if(q == k)
            return (array.get(part));
        if(q < k)
            return randomizedSelect(array, low, part - 1, q);
        else
            return randomizedSelect(array, part + 1, high, q - k);
    }

    static void printArray(ArrayList<Integer> array) {
        int i;
        for (i = 0; i < array.size(); i++)
            System.out.print(array.get(i) + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        ArrayList<Integer> seq = new ArrayList<Integer>();
        for (int i = 1; i <= 1000000; i++)
            seq.add(i);
        Collections.shuffle(seq, new Random());
        //printArray(seq);

        int i = (int) (1 + (Math.random() * seq.size()));

        int small = randomizedSelect(seq, 0, seq.size() - 1, i);
        System.out.println(i + "-th smallest = " + small);

        double e = 4 * seq.size();
        System.out.println("Number of key comparisons X = " + COUNTER);
        System.out.println("The upper bound of the expected number of key comparisons E = " + e);
        System.out.println("X/E = " + COUNTER / e);
    }
}