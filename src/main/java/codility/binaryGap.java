package codility;

/**
 * Created by abyakimenko on 19.12.2016.
 */
public class binaryGap {

    public int solution(int n) {

        String binaryString = Integer.toBinaryString(n);

        char[] chars = binaryString.toCharArray();
        char prev = (char)-1;
        boolean start = false, end = false;
        int counter = 0, max = 0;

        for (int i = 0; i < chars.length; i++) {

            char item = chars[i];

            if (prev == '0' && item == '1') {
                start = false;
                end = true;

                if(max < counter) max = counter;

                counter = 0;
            }

            if (prev == '1' && item == '0') {
                start = true;
                end = false;
            }

            if (start && !end) {
                counter++;
            }


            prev = item;
        }

        return max;
    }
}
