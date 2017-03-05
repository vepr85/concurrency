package codility;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by abyakimenko on 18.01.2017.
 */
public class ArrayContainsSummTest {

    @Test
    public void solution() throws Exception {

        final int[] test1 = {1, 2, 3, 0, 9, 8};

        ArrayContainsSumm containsSumm = new ArrayContainsSumm();

        assertTrue(containsSumm.solution(test1, 9));
    }

}