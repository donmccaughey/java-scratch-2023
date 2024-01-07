package cc.donm.igpay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

@RestController
public class TranslationController {

    Translator translator = new Translator();

    @GetMapping("/translation")
    public Translation translate(
            @RequestParam(value = "english", defaultValue = "") String english
    )
    {
        var englishStream = new StringBufferInputStream(english);
        var pigLatinBytes = new ByteArrayOutputStream();
        var pigLatinStream = new PrintStream(pigLatinBytes);
        translator.run(englishStream, pigLatinStream);
        var pigLatin = pigLatinBytes.toString();
        return new Translation(english, pigLatin);
    }

}
