package java01.algorithm.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Next Round
 * https://codeforces.com/problemset/problem/158/A
 */
public class NextRound {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (scores[i] >= scores[k - 1] && scores[i] > 0) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
