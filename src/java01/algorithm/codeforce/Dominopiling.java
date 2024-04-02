package java01.algorithm.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Domino piling
 * https://codeforces.com/problemset/problem/50/A
 *
 */
public class Dominopiling {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            System.out.println(m * n / 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
