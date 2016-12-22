package codility.rakuten;

class RakutenSolution {

    final int divider = 1_000_000_007;

    public int solution(int A, int B, int N) {

        // write your code in Java SE 8
        if (A < 0 || B < 0) {
            return 0;
        }

        if (N == 0) {
            return A % divider;
        }

        if (N == 1) {
            return B % divider;
        }

        int[] array = new int[N + 1];

        array[0] = A % divider;
        array[1] = B % divider;

        for (int i = 2; i <= N; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % divider;
        }
        return array[N];
    }

    public int solutionRecursive(int A, int B, int N) {

        if (A < 0 || B < 0) {
            return 0;
        }

        if (N == 0) {
            return A % divider;
        }

        if (N == 1) {
            return B % divider;
        }

        // write your code in Java SE 8
        return (solution(A, B, N - 1) + solution(A, B, N - 2)) % divider;
    }
}