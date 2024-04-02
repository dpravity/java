package java01.algorithm.codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Way Too Long Words
 * https://codeforces.com/problemset/problem/71/A
 *
 * ex) 10
 * [input]
 * 4
 * word
 * localization
 * internationalization
 * pneumonoultramicroscopicsilicovolcanoconiosis
 *
 * [output]
 * word
 * l10n
 * i18n
 * p43s
 */
public class WayTooLongWords {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            int n = Integer.parseInt(input);

            for(int i = 0; i < n; i++){
                String word = br.readLine();

                if(word.length() > 10) {
                    System.out.println(word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1));
                } else {
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
