package brainacad.org.Models.StringAnalyzer;


public class StringAnalyzer
{
    public boolean isPalindrome(String str)
    {
        String cleaned = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public int countVowels(String str)
    {
        return (int) str.toLowerCase().chars()
                .filter(ch -> "aeiou".indexOf(ch) != -1)
                .count();
    }

    public int countConsonants(String str)
    {
        String cleanedStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        return (int) cleanedStr.chars()
            .filter(ch -> "bcdfghjklmnpqrstvwxyz".indexOf(ch) != -1)
            .count();
    }

    public int countOccurrences(String text, String word)
    {
        String cleanedText = text.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
        String cleanedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

        String[] words = cleanedText.split("\\s+");
        int count = 0;
        for (String w : words) {
            if (w.equals(cleanedWord)) {
                count++;
            }
        }
        return count;
    }
}
