
import java.io.BufferedReader;
import java.io.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * File VowelWords.java
 *
 * Finds in the txt file words only with vowel letters.
 *
 * */
public class VowelWords {

    public static void main(String[] args) {


        final String file1 = "C:\\Users\\Asus\\IdeaProjects\\LAB_1\\assets\\example.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file1), "utf8"));

            String text = "";

            for (String line; (line = bufferedReader.readLine()) != null; text += '\n' + line) ;

            String REGEX = "(\\b[AEIOUaeiou]+[AEIOUaeiou]+\\b|^[AEIOUaeiou]+\\b\n|\\b[AEIOUaeiou]+\\b)";
            //regular expressions
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(text);

            System.out.println("Words with only vowel letters:");

            Set<String> hashset = new HashSet<>();

            //add true word to result
            while (matcher.find()) {
                hashset.add(matcher.group(1));

            }
            int i = 1;
            //elements in collection
            for (String s : hashset) {
                System.out.println(i + ". " + s);
                i++;
            }

            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            file1 + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + file1 + "'");
        }

    }
}

