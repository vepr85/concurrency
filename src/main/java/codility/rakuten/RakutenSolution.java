package codility.rakuten;

class RakutenSolution {

    private static final int DIVIDER = 1_000_000_007;

    public int solution(int a, int b, int n) {

        // write your code in Java SE 8
        if (a < 0 || b < 0) {
            return 0;
        }

        if (n == 0) {
            return a % DIVIDER;
        }

        if (n == 1) {
            return b % DIVIDER;
        }

        int[] array = new int[n + 1];

        array[0] = a % DIVIDER;
        array[1] = b % DIVIDER;

        for (int i = 2; i <= n; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % DIVIDER;
        }
        return array[n];
    }

    public int solutionRecursive(int a, int b, int n) {

        if (a < 0 || b < 0) {
            return 0;
        }

        if (n == 0) {
            return a % DIVIDER;
        }

        if (n == 1) {
            return b % DIVIDER;
        }

        // write your code in Java SE 8
        return (solution(a, b, n - 1) + solution(a, b, n - 2)) % DIVIDER;
    }
}