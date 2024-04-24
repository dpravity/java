package programmers.level0;

/**
 * i팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다.
 * 예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다.
 * 정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성해주세요.
 *
 * i! ≤ n
 *
 * n	    result
 * 3628800	10
 * 7	    3
 *
 * 입출력 예 #1
 * 10! = 3,628,800입니다. n이 3628800이므로 최대 팩토리얼인 10을 return 합니다.
 *
 * 입출력 예 #2
 * 3! = 6, 4! = 24입니다. n이 7이므로, 7 이하의 최대 팩토리얼인 3을 return 합니다.
 */
public class Factorial {
    public static void main(String[] args) {
        int n = 3628800;
        System.out.println(solution1(n));
        System.out.println(solution2(n));
    }

    public static int solution1(int n) {
        if(n <= 7){
            return 3;
        }
        int answer = 0;

        for(int i = 1; i <= 10; i++){
            if(n >= factorial(i)){
                answer = i;
            }else{
                break;
            }
        }

        return answer;
    }

    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static int solution2(int n) {
        int answer = 1;
        int factorial = 1;
        while(n >= factorial) {
            factorial *= ++answer;
        }
        return answer - 1;
    }
}
