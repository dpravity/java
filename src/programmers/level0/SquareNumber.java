package programmers.level0;

/**
 * 어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다.
 * 정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.
 *
 * n	result
 * 144	1
 * 976	2
 */
public class SquareNumber {
    public static void main(String[] args) {
        int n = 976;
//        System.out.println(solution1(n));
        solution1(n);
    }

    public static int solution1(int n) {
        return Math.sqrt(n) % 1 == 0 ? 1 : 2;
    }
    public static int solution2(int n) {
        int answer = 2;
        for(int i=1; i<n; i++){
            if(n/i == i && n%i == 0){
                answer = 1;
                break;
            }
        }
        return answer;
    }

}
