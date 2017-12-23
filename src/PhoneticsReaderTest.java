import dictionary.Phonetics;
import dictionary.Words;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class PhoneticsReaderTest
{
    public static void main(String[] args) throws IOException
    {
        File cmuSoundList = new File("src/dictionary/files/cmudict.phones.txt");

        Map phonics = Phonetics.readPhonicsMap(cmuSoundList);

        phonics.forEach((key, value) -> System.out.println(key + " -> " + value)); // pretty print

        System.out.println("DONE");

        File cmuDict = new File("src/dictionary/files/cmudict.dict.txt");

        Map words = Words.readDictionary(cmuDict);

        words.forEach((key, value) -> System.out.println(key + " -> " + Arrays.toString((String[]) value))); // pretty print

    }
}