package cc.donm.igpay;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TranslatorTest {

    @Test
    public void testIsVowel() {
        assertTrue(Translator.isVowel('a'));
        assertTrue(Translator.isVowel('A'));

        assertFalse(Translator.isVowel('b'));
        assertFalse(Translator.isVowel('B'));

        assertFalse(Translator.isVowel(' '));
        assertFalse(Translator.isVowel(' '));
    }
}
