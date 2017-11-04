package oo.generalized;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import oo.Seed;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BoardTest extends TestCase {

    private Object[] getValidElevation() {
        // 3 consecutive CROSS
        Seed[] a1 = {Seed.CROSS, Seed.CROSS, Seed.CROSS, Seed.EMPTY, Seed.EMPTY};
        Seed[] a2 = {Seed.EMPTY, Seed.CROSS, Seed.CROSS, Seed.CROSS, Seed.EMPTY};
        Seed[] a3 = {Seed.EMPTY, Seed.EMPTY, Seed.CROSS, Seed.CROSS, Seed.CROSS};

        // 3 CROSS, but not consecutive
        Seed[] a4 = {Seed.CROSS, Seed.EMPTY, Seed.CROSS, Seed.CROSS, Seed.EMPTY};
        Seed[] a5 = {Seed.CROSS, Seed.EMPTY, Seed.CROSS, Seed.EMPTY, Seed.CROSS};
        Seed[] a6 = {Seed.EMPTY, Seed.CROSS, Seed.CROSS, Seed.EMPTY, Seed.CROSS};

        // 2 CROSS
        Seed[] a7 = {Seed.CROSS, Seed.CROSS, Seed.EMPTY, Seed.EMPTY, Seed.NOUGHT};
        Seed[] a8 = {Seed.CROSS, Seed.EMPTY, Seed.CROSS, Seed.EMPTY, Seed.NOUGHT};
        Seed[] a9 = {Seed.CROSS, Seed.EMPTY, Seed.EMPTY, Seed.CROSS, Seed.NOUGHT};
        Seed[] a10 = {Seed.CROSS, Seed.EMPTY, Seed.EMPTY, Seed.NOUGHT, Seed.CROSS};

        return new Object[]{
                // a1
                new Object[]{a1, 0, 3, true},
                new Object[]{a1, 1, 3, true},
                new Object[]{a1, 2, 3, true},
                new Object[]{a1, 3, 3, false},
                new Object[]{a1, 4, 3, false},
                // a2
                new Object[]{a2, 0, 3, false},
                new Object[]{a2, 1, 3, true},
                new Object[]{a2, 2, 3, true},
                new Object[]{a2, 3, 3, true},
                new Object[]{a2, 4, 3, false},
                // a3
                new Object[]{a3, 0, 3, false},
                new Object[]{a3, 1, 3, false},
                new Object[]{a3, 2, 3, true},
                new Object[]{a3, 3, 3, true},
                new Object[]{a3, 4, 3, true},
                // a4
                new Object[]{a4, 0, 3, false},
                new Object[]{a4, 1, 3, false},
                new Object[]{a4, 2, 3, false},
                new Object[]{a4, 3, 3, false},
                new Object[]{a4, 4, 3, false},
                // a5
                new Object[]{a5, 0, 3, false},
                new Object[]{a5, 1, 3, false},
                new Object[]{a5, 2, 3, false},
                new Object[]{a5, 3, 3, false},
                new Object[]{a5, 4, 3, false},
                // a6
                new Object[]{a6, 0, 3, false},
                new Object[]{a6, 1, 3, false},
                new Object[]{a6, 2, 3, false},
                new Object[]{a6, 3, 3, false},
                new Object[]{a6, 4, 3, false},
                // a7
                new Object[]{a7, 0, 3, false},
                new Object[]{a7, 1, 3, false},
                new Object[]{a7, 2, 3, false},
                new Object[]{a7, 3, 3, false},
                new Object[]{a7, 4, 3, false},
                // a8
                new Object[]{a8, 0, 3, false},
                new Object[]{a8, 1, 3, false},
                new Object[]{a8, 2, 3, false},
                new Object[]{a8, 3, 3, false},
                new Object[]{a8, 4, 3, false},
                // a9
                new Object[]{a9, 0, 3, false},
                new Object[]{a9, 1, 3, false},
                new Object[]{a9, 2, 3, false},
                new Object[]{a9, 3, 3, false},
                new Object[]{a9, 4, 3, false},
                // a10
                new Object[]{a10, 0, 3, false},
                new Object[]{a10, 1, 3, false},
                new Object[]{a10, 2, 3, false},
                new Object[]{a10, 3, 3, false},
                new Object[]{a10, 4, 3, false},
        };
    }

    @Test
    @Parameters(method = "getValidElevation")
    public void testCheckWin(Seed[] a, int index, int winLength, boolean result) {
        assertEquals(Board.checkWin(a, index, winLength), result);
    }
}