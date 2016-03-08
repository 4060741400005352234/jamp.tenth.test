package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUtil {

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

    @Test
    public void concatenateWordsShouldReturnUnitedStringForWords() {
        String result = Util.concatenateWords("A", "B");
        assertEquals("AB", result);
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
}
