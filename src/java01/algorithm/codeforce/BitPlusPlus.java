package java01.algorithm.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Bit++
 * https://codeforces.com/problemset/problem/282/A
 *
 * Bit++ 언어의 명령문은 정확히 하나의 연산과 하나의 변수 x 로 구성된 시퀀스입니다 .
 * 명령문은 공백 없이 작성됩니다. 즉, "+", "-", "X" 문자만 포함할 수 있습니다.
 * 명령문을 실행한다는 것은 그 명령문에 포함된 작업을 적용하는 것을 의미합니다.
 * Bit++의 프로그램은 일련의 명령문으로, 각 명령문은 실행되어야 합니다. 프로그램을 실행한다는 것은 그 안에 포함된 모든 명령문을 실행하는 것을 의미합니다.
 * Bit++ 언어로 된 프로그램이 제공됩니다. x 의 초기값은 0 입니다.
 * 프로그램을 실행하고 최종 값(이 프로그램이 실행될 때 변수의 값)을 찾습니다.
 *
 * 입력
 * 첫 번째 줄에는 프로그램의 명령문 수인 단일 정수 n (1 <= n <= 150)이 포함됩니다.
 * 다음 n 줄에는 각각 문이 포함됩니다.
 * 각 명령문에는 정확히 하나의 연산( ++ 또는 -- )과 정확히 하나의 변수 x (문자 « X »로 표시됨)가 포함됩니다.
 * 따라서 빈 명령문이 없습니다. 연산과 변수는 어떤 순서로든 쓸 수 있습니다.
 *
 * 산출
 * 단일 정수( x 의 최종 값)를 인쇄합니다 .
 *
 * ex)
 * [input]
 * 1
 * ++X
 * [output]
 * 1
 *
 * [input]
 * 2
 * X++
 * --X
 * [output]
 * 0
 */
public class BitPlusPlus {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int x = 0;
            for(int i = 0; i < n; i++){
                String input = br.readLine();
                if(input.contains("++")){
                    x++;
                }else{
                    x--;
                }
            }
            System.out.println(x);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
