package codility;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by abyakimenko on 22.12.2016.
 */
public class EquilibriumTest {


    @Test
    public void solution() throws Exception {

        Equilibrium equilibrium = new Equilibrium();
        final int[] array1 = new int[]{-1, 3, -4, 5, 1, -6, 2, 1};
        final int[] array2 = new int[]{0, -2_147_483_648, -2_147_483_648};
        final int[] array3 = new int[]{0, 2_147_483_647, 2_147_483_647};


        assertTrue(equilibrium.solution(new int[]{1_082_132_608, 0, 1_082_132_608}) == 1);

        int solution = equilibrium.solution(array1);

        assertTrue(solution == 1 || solution == 3 || solution == 7);

        solution = equilibrium.solution(array2);
        assertTrue(solution == -1);

        solution = equilibrium.solution(array3);
        assertTrue(solution == -1);

        solution = equilibrium.solution(array3);
        assertTrue(solution == -1);

        assertTrue(equilibrium.solution(new int[0]) == -1);
        assertTrue(equilibrium.solution(new int[1]) == 0);

    }

}