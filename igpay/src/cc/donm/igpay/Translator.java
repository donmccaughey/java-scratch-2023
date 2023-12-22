package cc.donm.igpay;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Translator {
    public static final Pattern SPLIT = Pattern.compile("\\w+|\\W+");

    public static boolean isVowel(char ch) {
        var lower = Character.toLowerCase(ch);
        return switch (lower) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    public static List<Text> tokenize(String line) {
        var text = new ArrayList<Text>();
        var matcher = SPLIT.matcher(line);
        while (matcher.find()) {
            var match = matcher.group();
            if (match.matches("\\w+")) {
                text.add(new Word(match));
            } else {
                text.add(new Space(match));
            }
        }
        return text;
    }

    public static String toPigLatin(String word) {
        if (word.isEmpty()) {
            return word;
        }

        var first = word.charAt(0);
        if (isVowel(first)) {
            return word + "way";
        } else {
            if (word.length() == 1) {
                return word + "ay";
            }
            if (Character.isUpperCase(first)) {
                return word.substring(1, 2).toUpperCase()
                        + word.substring(2) 
                        + Character.toLowerCase(first) + "ay";
            } else {
                return word.substring(1) + first + "ay";
            }
        }
    }

    public static String translate(Text text) {
        if (text instanceof Word) {
            var word = ((Word) text).word();
            return toPigLatin(word);
        } else if (text instanceof Space) {
            return ((Space) text).space();
        }
        throw new RuntimeException(
                String.format("Unexpected class for text '%s': %s",
                        text, text.getClass())
        );
    }

    public void run(InputStream input, PrintStream output) {
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                var tokens = tokenize(line);
                for (var token : tokens) {
                    output.print(translate(token));
                }
                output.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
