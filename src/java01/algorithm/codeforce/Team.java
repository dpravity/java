package java01.algorithm.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Team
 * https://codeforces.com/problemset/problem/231/A
 *
 * 입력
 * 첫 번째 입력 줄에는 단일 정수 n ( 1 <= n <= 1000 )(경연 대회의 문제 수)이 포함됩니다.
 * 그런 다음 n 줄에는 각각 세 개의 정수가 포함되며 각 정수는 0 또는 1 입니다 .
 * 줄의 첫 번째 숫자가 1 이면 Petya는 문제의 해결책을 확신하고 그렇지 않으면 확신하지 못하는 것입니다.
 * 두 번째 숫자는 솔루션에 대한 Vasya의 견해를 나타내고, 세 번째 숫자는 Tonya의 견해를 나타냅니다.
 * 줄의 숫자는 공백으로 구분됩니다.
 *
 * 산출
 * 단일 정수를 출력하세요 — 친구들이 대회에서 구현할 문제의 수입니다.
 *
 * ex)
 * [input]
 * 3
 * 1 1 0
 * 1 1 1
 * 1 0 0
 * [output]
 * 2
 *
 * [input]
 * 2
 * 1 0 0
 * 0 1 1
 *
 * [output]
 * 1
 */
public class Team {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int sum = 0;
                for (String s : input) {
                    sum += Integer.parseInt(s);
                }
                if (sum >= 2) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
