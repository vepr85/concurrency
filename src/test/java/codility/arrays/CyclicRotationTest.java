package codility.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by abyakimenko on 18.01.2017.
 */
public class CyclicRotationTest {

    @Test
    public void solution() throws Exception {

        CyclicRotation cyclicRotation = new CyclicRotation();

        final int[] A = {-1000, 1, 2, 3, 4, 5, 6, 7, 1000, 700};

        cyclicRotation.solution(new int [0], 1);

        int[] result = cyclicRotation.solution(A, 10);

        result = cyclicRotation.solution(A, 20);
        result = cyclicRotation.solution(A, 0);
        result = cyclicRotation.solution(A, 1);


        assertEquals(result[0], 700);
        assertEquals(result[1], -1000);
        assertEquals(result[9], 1000);

        result = cyclicRotation.solution(A, 3);
        assertEquals(result[0], 7);
        assertEquals(result[1], 1000);
        assertEquals(result[2], 700);
        assertEquals(result[9], 6);

        result = cyclicRotation.solution(A, 95);
        assertEquals(result[0], 5);
        assertEquals(result[9], 4);

        result = cyclicRotation.solution(A, 23);
        assertEquals(result[0], 7);
        assertEquals(result[9], 6);
    }
}