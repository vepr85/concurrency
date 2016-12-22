package codility;

/**
 * A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such
 * that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e.
 * A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
 * Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
 * <p>
 * For example, consider the following array A consisting of N = 8 elements:
 * <p>
 * A[0] = -1
 * A[1] =  3
 * A[2] = -4
 * A[3] =  5
 * A[4] =  1
 * A[5] = -6
 * A[6] =  2
 * A[7] =  1
 * P = 1 is an equilibrium index of this array, because:
 * <p>
 * A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
 * P = 3 is an equilibrium index of this array, because:
 * <p>
 * A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]
 * P = 7 is also an equilibrium index, because:
 * <p>
 * A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0
 * and there are no elements with indices greater than 7.
 * <p>
 * P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. The function should return −1 if no equilibrium index exists.
 * <p>
 * For example, given array A shown above, the function may return 1, 3 or 7, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */
class Equilibrium {

    public int solution(int[] A) {

        // write your code in Java SE 8
        if (A.length == 0) {
            return -1;
        }

        if (A.length == 1) {
            return 0;
        }


        int size = A.length;
        // check border conditions: summ elements == 0
        long leftBorder = summPartOfArray(1, size - 1, A);
        if (leftBorder == 0) {
            return 0;
        }

        long rightBorder = summPartOfArray(0, size - 2, A);
        if (rightBorder == 0) {
            return size - 1;
        }

        long sumLeft = 0;
        long arraySum = summPartOfArray(0, size - 1, A);
        for (int i = 0; i < size; i++) {

            arraySum -= A[i];
            if (sumLeft == arraySum) {
                return i;
            }

            sumLeft = sumLeft + A[i];
        }

        return -1;
    }

    private long summPartOfArray(int start, int end, int[] array) {

        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public int solutionOn2(int[] A) {

        // write your code in Java SE 8
        if (A.length == 0) return -1;

        if (A.length == 1) return 0;

        long sumLeft;
        long sumRight;

        int size = A.length;

        // check border conditions: summ elements == 0
        long leftBorder = summPartOfArray(1, size - 1, A);
        if (leftBorder == 0) {
            return 0;
        }

        long rightBorder = summPartOfArray(0, size - 2, A);
        if (rightBorder == 0) {
            return size - 1;
        }

        for (int i = 1; i < size - 1; i++) {

            sumLeft = summPartOfArray(0, i - 1, A);
            sumRight = summPartOfArray(i + 1, A.length - 1, A);

            if (sumLeft == sumRight) {
                return i;
            }
        }

        return -1;
    }
}



















