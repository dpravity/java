package java01.algorithm.codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Watermelon
 * https://codeforces.com/problemset/problem/4/A
 *
 * ex)
 * [input]
 * 8
 * [output]
 * YES
 */
public class Watermelon {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int weight = Integer.parseInt(br.readLine());
            System.out.println(weight % 2 == 0 && weight > 2 ? "YES" : "NO");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
