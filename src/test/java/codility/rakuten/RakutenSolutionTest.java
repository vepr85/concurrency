package codility.rakuten;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        List<Number> doubles = new ArrayList<>();
        doubles.add(3.0);
        doubles.add(3);
        doubles.add(3L);
        doubles.add(3f);

        List<? extends Number> foo54 = new ArrayList<>(Arrays.asList(2, 3, 4));
        foo54.get(0);

        List<? super Integer> foo4 = new ArrayList<Object>();
        List<? super Integer> foo3 = new ArrayList<Number>();
        foo3.add(3);

        foo3.get(new Integer(0));
    }
}