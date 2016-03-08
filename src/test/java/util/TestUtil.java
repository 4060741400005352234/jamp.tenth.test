package util;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Random;

@RunWith(Theories.class)
public class TestUtil {

    @DataPoints
    public static int[][] factorials() {
        return new int[][]{
                {0, 1},
                {2, 2},
                {3, 6},
                {5, 120},
                {10, 3628800}};
    }

    @DataPoints
    public static String[][][] unitedStrings() {
        return new String[][][] {
                {{"a", "b"}, {"ab"}},
                {{"a"}, {"a"}},
                {{"a", ""}, {"a"}},
                {{"a", null}, {"a"}},
                {{"a", "b", "c"}, {"abc"}},
                {{"", "b"}, {"b"}},
                {{null, "b"}, {"b"}}
        };
    }

    @Test
    public void concatenateWordsShouldReturnEmptyResultForEmptyString() {
        String result = Util.concatenateWords("");
        assertEquals("", result);
    }

    @Test
    public void concatenateWordsShouldReturnEmptyResultForNull() {
        String result = Util.concatenateWords(null);
        assertEquals("", result);
    }

    @Test
    public void concatenateWordsShouldReturnEmptyResultForEmptyParameterList() {
        String result = Util.concatenateWords();
        assertEquals("", result);
    }

    @Theory
    public void concatenateWordsShouldReturnUnitedStringForWords(String[][] source) {
        String result = Util.concatenateWords(source[0]);
        assertEquals(source[1][0], result);
    }

    @Test
    public void concatenateWordsShouldReturnWordForWordAndEmptyString() {
        String result = Util.concatenateWords("A", "");
        assertEquals("A", result);
    }

    @Test
    public void concatenateWordsShouldReturnWordForWordAndNull() {
        String result = Util.concatenateWords("A", null);
        assertEquals("A", result);
    }

    @Test
    public void concatenateWordsShouldReturnWordForWord() {
        String result = Util.concatenateWords("A");
        assertEquals("A", result);
    }

    @Theory
    public void computeFactorialShouldReturnRightFactorial(int[] factorialOfNumber) {
        long result = Util.computeFactorial(factorialOfNumber[0]);
        assertEquals(factorialOfNumber[1], result);
    }

    @Theory
    public void computeFactorialShouldReturnRightPositiveNumber(int[] factorialOfNumber) {
        long result = Util.computeFactorial(factorialOfNumber[0]);;
        assertThat(result, greaterThan(0L));
    }

    @Test(timeout = 5)
    public void computeFactorialShouldEndsInTime() {
        Random random = new Random();
        long result = Util.computeFactorial(random.nextInt(20));
        assertThat(result, greaterThan(0L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void computeFactorialShouldThrowExceptionForNegativeParameter() {
        Util.computeFactorial(-5);
    }
}
