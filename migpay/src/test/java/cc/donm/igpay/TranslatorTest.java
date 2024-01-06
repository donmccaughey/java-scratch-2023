package cc.donm.igpay;

import static cc.donm.igpay.Translator.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TranslatorTest {

    @Test
    public void testIsVowel() {
        assertTrue(isVowel('a'));
        assertTrue(isVowel('A'));

        assertFalse(isVowel('b'));
        assertFalse(isVowel('B'));

        assertFalse(isVowel(' '));
        assertFalse(isVowel(' '));
    }

    @Test
    public void testLeadingConsonants() {
        assertEquals("", leadingConsonants(""));
        assertEquals("t", leadingConsonants("t"));
        assertEquals("f", leadingConsonants("foo"));
        assertEquals("cr", leadingConsonants("crap"));
        assertEquals("sfx", leadingConsonants("sfx"));
        assertEquals("str", leadingConsonants("strength"));
    }

    @Test
    public void testToPigLatin() {
        assertEquals("", toPigLatin(""));

        // start with lower case letter
        assertEquals("away", toPigLatin("a"));
        assertEquals("appleway", toPigLatin("apple"));

        assertEquals("tay", toPigLatin("t"));
        assertEquals("igpay", toPigLatin("pig"));
        assertEquals("apcray", toPigLatin("crap"));

        // starts with a capital letter
        assertEquals("Away", toPigLatin("A"));
        assertEquals("Appleway", toPigLatin("Apple"));

        assertEquals("Tay", toPigLatin("T"));
        assertEquals("Igpay", toPigLatin("Pig"));
        assertEquals("Apcray", toPigLatin("Crap"));
    }

}
