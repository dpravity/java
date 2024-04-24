package programmers.level0;

import java.util.stream.IntStream;

/**
 * 약수의 개수가 세 개 이상인 수를 합성수라고 합니다.
 * 자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를 return하도록 solution 함수를 완성해주세요.
 *
 * n	result
 * 10	5
 * 15	8
 *
 * 입출력 예 #1
 * 10 이하 합성수는 4, 6, 8, 9, 10 로 5개입니다. 따라서 5를 return합니다.
 *
 * 입출력 예 #1
 * 15 이하 합성수는 4, 6, 8, 9, 10, 12, 14, 15 로 8개입니다. 따라서 8을 return합니다.
 */
public class NumberComposite {
    public static void main(String[] args) {
        int n = 15;

        System.out.println(solution1(n));
    }

    public static int solution1(int n) {
        int answer = 0;
        for(int i = 4; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                if(i % j == 0){
                    count++;
                }
            }
            if(count > 2){
                answer++;
            }
        }
        return answer;
    }

    public static int solution2(int n) {
        return (int) IntStream.rangeClosed(1, n)
                .filter(i -> (int) IntStream.rangeClosed(1, i).filter(i2 -> i % i2 == 0).count() > 2)
                .count();
    }
}
