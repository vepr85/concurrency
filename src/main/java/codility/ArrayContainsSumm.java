package codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abyakimenko on 18.01.2017.
 */
public class ArrayContainsSumm {

    public boolean solution(int[] array, int summ) {

        int[] arratInts = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0};
        int[] arratIntsRes = new int[arratInts.length];
        int newIndex = arratInts.length - 1;

        for (int i = 0; i < arratInts.length; i++) {
            if (arratInts[i] == 1) {
                arratIntsRes[newIndex--] = 1;
            }
        }


        Map<Integer, Integer> summs = new HashMap<>();

        for (int item : array) {

            if (summs.containsKey(item)) {
                return true;
            }
            summs.put(summ - item, summ - item);
        }

        return false;
    }
}
