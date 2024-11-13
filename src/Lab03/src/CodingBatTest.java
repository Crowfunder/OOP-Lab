import static org.junit.Assert.*;
public class CodingBatTest {

    @org.junit.Test
    public void icyHot() {
        assertTrue(CodingBat.icyHot(120,-1));
        assertFalse(CodingBat.icyHot(2,120));
        assertTrue(CodingBat.icyHot(-1,120));
    }

    @org.junit.Test
    public void has77() {
        assertTrue(CodingBat.has77(new int[]{1,7,7}));
        assertTrue(CodingBat.has77(new int[]{1,7,1,7}));
        assertFalse(CodingBat.has77(new int[]{1, 7, 1, 1, 7}));
    }

    @org.junit.Test
    public void bobThere() {
        assertTrue(CodingBat.bobThere("abcbob"));
        assertTrue(CodingBat.bobThere("b9b"));
        assertFalse(CodingBat.bobThere("bac"));
    }
}