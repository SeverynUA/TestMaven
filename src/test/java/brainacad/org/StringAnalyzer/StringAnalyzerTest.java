package brainacad.org.StringAnalyzer;

import brainacad.org.Models.StringAnalyzer.StringAnalyzer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringAnalyzerTest
{

    StringAnalyzer analyzer = new StringAnalyzer();

    @Test
    public void testIsPalindrome()
    {
        assertTrue(analyzer.isPalindrome("Madam, in Eden, I'm Adam."), "The string should be a palindrome");
        assertFalse(analyzer.isPalindrome("Hello"), "The string should not be a palindrome");
    }

    @Test
    public void testCountVowels()
    {
        assertEquals(8, analyzer.countVowels("Madam, in Eden, I'm Adam."), "The number of vowels should be 8");
        assertEquals(2, analyzer.countVowels("Hello"), "The number of vowels should be 2");
        assertEquals(0, analyzer.countVowels("Thngs"), "The number of vowels should be 0");
    }

    @Test
    public void testCountConsonants()
    {
        assertEquals(9, analyzer.countConsonants("Madam, in Eden, I'm Adam."), "The number of consonants should be 11");

        assertEquals(3, analyzer.countConsonants("Hello"), "The number of consonants should be 3");

        assertEquals(5, analyzer.countConsonants("Thngs"), "The number of consonants should be 4");
    }

    @Test
    public void testCountOccurrences()
    {
        assertEquals(1, analyzer.countOccurrences("Madam, in Eden, I'm Adam.", "adam"), "The word 'adam' should appear 1 time");
        assertEquals(0, analyzer.countOccurrences("Madam, in Eden, I'm Adam.", "hello"), "The word 'hello' should not appear");
        assertEquals(3, analyzer.countOccurrences("apple apple apple", "apple"), "The word 'apple' should appear 3 times");
    }
}
