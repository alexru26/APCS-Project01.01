import static org.junit.Assert.*;

/**
 * Tests cases by running it through romanToDecimal method
 * @author Alex Ru
 * @version 10.11.23
 */
public class RomanToDecimalTest {

    /**
     * Tests different cases by using assertEquals
     */
    @org.junit.Test
    public void romanToDecimalTest() {
        // valid tests
        assertEquals(14, RomanToDecimal.romanToDecimal("XIV"));
        assertEquals(29, RomanToDecimal.romanToDecimal("XXIX"));
        assertEquals(40, RomanToDecimal.romanToDecimal("XL"));
        assertEquals(59, RomanToDecimal.romanToDecimal("LIX"));
        assertEquals(95, RomanToDecimal.romanToDecimal("xcv"));
        assertEquals(115, RomanToDecimal.romanToDecimal("cxv"));
        assertEquals(364, RomanToDecimal.romanToDecimal("CcCLxIV"));
        assertEquals(921, RomanToDecimal.romanToDecimal("CMxxi"));
        assertEquals(3412, RomanToDecimal.romanToDecimal("MMMCDXII"));
        assertEquals(6044, RomanToDecimal.romanToDecimal("MMMMMMXLIV"));

        // incorrect tests
        assertEquals(27, RomanToDecimal.romanToDecimal("IXIXIX"));
        assertEquals(13, RomanToDecimal.romanToDecimal("IVIX"));
        assertEquals(3800, RomanToDecimal.romanToDecimal("MCMMCM"));
        assertEquals(400, RomanToDecimal.romanToDecimal("CCCC"));

        // invalid tests
        assertEquals(-1, RomanToDecimal.romanToDecimal("yooooo"));
        assertEquals(-1, RomanToDecimal.romanToDecimal("howdydoody"));
        assertEquals(-1, RomanToDecimal.romanToDecimal("SMMMMMM"));
        assertEquals(-1, RomanToDecimal.romanToDecimal("IIIIIIIIIIIIIG"));

        // not equals tests
        assertNotEquals(1234, RomanToDecimal.romanToDecimal("your_mom"));
        assertNotEquals(-1, RomanToDecimal.romanToDecimal("MCMMMMXIIIIIVVVVVVVVVL"));
    }
}