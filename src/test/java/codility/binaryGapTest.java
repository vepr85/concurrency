package codility;

import codility.iterations.binaryGap;
import codility.iterations.binaryGapPasha;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by abyakimenko on 19.12.2016.
 */
public class binaryGapTest {


    private final Map<Integer, Integer> checkingMap = new HashMap<>();
    private final binaryGap myGap = new binaryGap();
    private final binaryGapPasha gapPasha = new binaryGapPasha();

    @Before
    public void setUp() throws Exception {
        checkingMap.put(20, 1);
        checkingMap.put(1041, 5);
        checkingMap.put(529, 4);
        checkingMap.put(15, 0);
        checkingMap.put(588, 2);
        checkingMap.put(256, 0);
        checkingMap.put(512, 0);
        checkingMap.put(1543, 6);
    }

    @Test
    public void solution() throws Exception {

        checkingMap.entrySet().stream().forEach((map) -> {
            assertEquals(new Integer(myGap.solution(map.getKey())), map.getValue());
        });

        checkingMap.entrySet().stream().forEach((map) -> {
            assertEquals(new Integer(gapPasha.solution(map.getKey())), map.getValue());
        });
    }
}