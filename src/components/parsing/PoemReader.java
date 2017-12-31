package components.parsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PoemReader
{
    public static String[] readPoem(FileReader poem)
    {
        List<String> text = new ArrayList<>();
        BufferedReader poemIn = new BufferedReader(poem);
        String line;

        try{
            while((line = poemIn.readLine()) != null){
                text.add(line);
            }
        } catch(IOException oops){
            oops.printStackTrace();
        }

        return text.toArray(new String[0]);
    }

    /**
     * Takes in the lines of a poem to clean and tokenize the text
     * Removes punctuation and blank lines and splits the lines up by word
     * @param rawText String[] the text taken in by readPoem()
     * @return String[][] An array which represents each line made up of an array of each word in the line
     */
    public static String[][] cleanRaw(String[] rawText)
    {
        List<String[]> clean = new ArrayList<>();
        for(String line : rawText){
            if(!line.equals("")){ // don't include blank lines
                String[] current = line.replaceAll("[.,-;:?!]", "").split(" "); // filter out punctuation

                clean.add(current);
            }
        }

        return clean.toArray(new String[0][0]); // convert from List to Array
    }

    // TODO: finish this so that it works for more cases
    public static String vowelReplace(String toReplace)
    {
        char[] charArray = toReplace.toCharArray();
        for(int i = 0; i < toReplace.length(); i++){
            if(charArray[i] == '\''){
                if(charArray[i + 1] == 'd'){
                   return toReplace.replace('\'', 'e');
                }
            }
        }
        return toReplace;
    }
}
