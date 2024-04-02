package java01.algorithm.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Theatre Square
 * https://codeforces.com/problemset/problem/1/A
 *
 * 수도인 베를란트(Berland)의 극장 광장은 n * m 미터 크기의 직사각형 모양을 하고 있습니다.
 * 도시의 기념일을 맞아 정사각형 화강암 판석으로 광장을 포장하기로 결정했습니다.
 * 각 판석의 크기는 a * a 입니다 .
 * 광장을 포장하는 데 필요한 최소한의 판석 수는 몇 개입니까?
 * 극장광장보다 넓은 면적을 덮는 것은 허용되지만, 광장은 덮어야 한다.
 * 판석을 부수는 것은 허용되지 않습니다.
 * 판석의 측면은 광장의 측면과 평행해야 합니다.
 *
 * 입력
 * 입력의 첫 번째 줄에는 세 개의 양의 정수 n, m 및 a ( 1 <= n, m, a <= 10의 9승 )가 포함됩니다.
 *
 * 산출
 * 필요한 판석 수를 쓰십시오.
 *
 * ex)
 * [input]
 * 6 6 4
 * [output]
 * 4
 */
public class TheatreSquare {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = br.readLine().split(" ");
            long n = Long.parseLong(input[0]);
            long m = Long.parseLong(input[1]);
            long a = Long.parseLong(input[2]);

            // n / a 는 n을 a로 나눈 몫
            long x = n % a == 0 ? n / a : n / a + 1;
            long y = m % a == 0 ? m / a : m / a + 1;

            System.out.println(x * y);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
