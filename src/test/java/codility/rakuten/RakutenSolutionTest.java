package codility.rakuten;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by abyakimenko on 22.12.2016.
 */
public class RakutenSolutionTest {


    @Test
    public void solution() throws Exception {

        RakutenSolution rakutenSolution = new RakutenSolution();

        assertEquals(rakutenSolution.solution(3, 4, 0), 3);
        assertEquals(rakutenSolution.solution(3, 4, 1), 4);

        assertEquals(rakutenSolution.solution(3, 4, 2), 7);
        assertEquals(rakutenSolution.solution(3, 4, 3), 11);
        assertEquals(rakutenSolution.solution(3, 4, 4), 18);
        assertEquals(rakutenSolution.solution(3, 4, 5), 29);
        assertEquals(rakutenSolution.solution(2_147_483_647, 4, 900_000), 909838742);
    }
}