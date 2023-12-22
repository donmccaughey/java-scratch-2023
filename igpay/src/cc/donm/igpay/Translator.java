package cc.donm.igpay;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Translator {
    public static final Pattern WORD_SPLIT = Pattern.compile("\\w+|\\W+");

    public static List<Text> tokenize(String line) {
        var text = new ArrayList<Text>();
        var matcher = WORD_SPLIT.matcher(line);
        while (matcher.find()) {
            Text token = null;
            var match = matcher.group();
            if (match.matches("\\w+")) {
                token = new Word(match);
            } else {
                token = new Space(match);
            }
            text.add(token);
        }
        return text;
    }

    public void run(InputStream input, PrintStream output) {
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                var tokens = tokenize(line);
                for (var token : tokens) {
                    String description = null;
                    if (token instanceof Word) {
                        var text = ((Word) token).word();
                        description = String.format("word: '%s'", text);
                    } else {
                        var space = ((Space) token).space();
                        description = String.format("space: '%s'", space);
                    }
                    output.println(description);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
