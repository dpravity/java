package programmers.level0;

/**
 * 머쓱이는 구슬을 친구들에게 나누어주려고 합니다.
 * 구슬은 모두 다르게 생겼습니다.
 * 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때,
 * balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.
 *
 *제한사항
 * 1 ≤ balls ≤ 30
 * 1 ≤ share ≤ 30
 * 구슬을 고르는 순서는 고려하지 않습니다.
 * share ≤ balls
 *
 * 입출력 예
 * balls	share	result
 * 3	    2	    3
 * 5	    3	    10
 *
 * 입출력 예 #1
 * 서로 다른 구슬 3개 중 2개를 고르는 경우의 수는 3입니다.
 *
 * 입출력 예 #2
 * 서로 다른 구슬 5개 중 3개를 고르는 경우의 수는 10입니다.
 *
 * Hint # 순열 조합 #
 * 서로 다른 n개 중 m개를 뽑는 경우의 수 공식은 다음과 같습니다.
 * n!/((n - m)! * m!)
 */
public class NumberOfWaysToDivideBeads {
    public static void main(String[] args) {
        int balls = 5;
        int share = 3;
//        System.out.println(solution1(balls, share));
        System.out.println(combination(balls, share));
    }

    //#region - TODO 안됨
    public static int solution1(int balls, int share) {
        int n = factorial(balls);
        int m = factorial(share);
        int nm = factorial(balls - share);

        return n / (nm * m);
    }

    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial((n - 1));
    }
    public static int factorial2(int n){
        int result = 1;
        for(int i = n; i > 0; i--){
            result *= i;
        }
        return result;
    }
    //#endregion

    public static int combination(int n, int r) {
        if(n == r || r == 0){
            return 1;
        } else{
            return combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }

    public static long solution2(int balls, int share) {
        share = Math.min(balls - share, share);

        if (share == 0){
            return 1;
        }

        long result = solution2(balls - 1, share - 1);
        result *= balls;
        result /= share;

        return result;
    }

}
