package programmers.level0;

/**
 * 어떤 세균은 1시간에 두배만큼 증식한다고 합니다.
 * 처음 세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때 t시간 후 세균의 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * n	t	result
 * 2	10	2048
 * 7	15	229,376
 */
public class NumberDouble {
    public static void main(String[] args) {
        int n = 7;
        int t = 15;

        System.out.println(solution1(n, t));
        System.out.println(solution2(n, t));
    }

    public static int solution1(int n, int t) {
        int answer = n;
        for(int i = 0; i < t; i++){
            answer *= 2;
        }
        return answer;
    }
    public static int solution2(int n, int t) {
        return n << t;
    }
}
