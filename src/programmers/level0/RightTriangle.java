package programmers.level0;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * "*"의 높이와 너비를 1이라고 했을 때, "*"을 이용해 직각 이등변 삼각형을 그리려고합니다.
 * 정수 n 이 주어지면 높이와 너비가 n 인 직각 이등변 삼각형을 출력하도록 코드를 작성해보세요.
 *
 * 입력 #1
 * 3
 *
 * 출력 #1
 * *
 * **
 * ***
 */
public class RightTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        solution1(n);
//        solution2(n);
        solution3(n);
    }

    public static void solution1(int n){
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                sb.append("*");
            }
            if(i != n){
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static void solution2(int n){
        for(int i=1; i<=n; i++){
            System.out.println("*".repeat(i));
        }
    }
    public static void solution3(int n){
        IntStream.rangeClosed(0, n)
                .forEach(idx -> {
                    System.out.println("*".repeat(idx));
                });
    }
}
