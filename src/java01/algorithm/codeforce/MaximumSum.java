package java01.algorithm.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * TODO - 못품
 * Maximum Sum
 * https://codeforces.com/problemset/problem/1946/B
 *
 * [input]
 * 12
 * 2 2
 * -4 -7
 * 3 3
 * 2 2 8
 * 1 7
 * 7
 * 5 1
 * 4 -2 8 -12 9
 * 7 4
 * 8 14 -9 6 0 -1 3
 * 7 100
 * 5 3 -8 12 -5 -9 3
 * 6 1000
 * -1000000000 -1000000000 -1000000000 -1000000000 -1000000000 -1000000000
 * 2 1
 * 1000000000 8
 * 5 4
 * 0 0 0 0 0
 * 6 10
 * 48973 757292 58277 -38574 27475 999984
 * 7 1
 * -1000 1000 -1000 1000 -1000 1000 -1000
 * 10 10050
 * 408293874 -3498597 7374783 295774930 -48574034 26623784 498754833 -294875830 283045804 85938045
 *
 * [output]
 * 999999996
 * 96
 * 896
 * 17
 * 351
 * 716455332
 * 42
 * 2
 * 0
 * 897909241
 * 0
 * 416571966
 *
 */
public class MaximumSum {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                int n = Integer.parseInt(st1.nextToken());
                int k = Integer.parseInt(st1.nextToken());

                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int[] a = new int[n];
                int cnt = 0;
                while (st.hasMoreTokens()) {
                    a[cnt++] = Integer.parseInt(st.nextToken());
                }

                int mod = 1_000_000_000 + 7;
                long os = 0;
                long sum = 0;
                long res = 0;
                for(int j = 0; j < n; j++){
                    res = (res + a[j]);
                    if(res < 0){
                        res = 0;
                    }
                    sum = Math.max(res,sum);
                    os += a[j];
                }
                os %= mod;
                sum %= mod;
                for(int m = 0; m < k; m++){
                    if(os < 0) os += mod;
                    os=(os + sum) % mod;
                    sum=(2 * sum) % mod;
                }
                System.out.println(os);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
