package java01.algorithm.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Beautiful Matrix
 * https://codeforces.com/problemset/problem/263/A
 */
public class BeautifulMatrix {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int[][] matrix = new int[5][5];
            int x = 0, y = 0;
            for (int i = 0; i < 5; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                    if (matrix[i][j] == 1) {
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.println(Math.abs(x - 2) + Math.abs(y - 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
