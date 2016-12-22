package codility;

/**
 * Created by abyakimenko on 19.12.2016.
 */
public class binaryGapPasha {

    public int solution(int N) {
        // write your code in Java SE 8
//        System.out.println("N = " + N);
        boolean firstGap = true;
        int gapLength = 0;
        int maxLength = 0;
        while (N != 0) {
            if (isLastZero(N)) {
                gapLength++;
            } else {
                if (!firstGap) {
                    if (gapLength > maxLength) {
                        maxLength = gapLength;
                    }
                } else {
                    /*skip result*/
                    firstGap = false;
                }
                gapLength = 0;
            }
            N = N >> 1;
        }
//        System.out.println("maxLength = " + maxLength);
        return maxLength;
    }

    private boolean isLastZero(int N) {
        return (N & 1) == 0;
    }
}
