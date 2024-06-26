package programmers.level0;

/**
 * 머쓱이네 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라줍니다.
 * 피자 조각 수 slice와 피자를 먹는 사람의 수 n이 매개변수로 주어질 때,
 * n명의 사람이 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
 *
 * 입출력 예 #1
 * 10명이 7조각으로 자른 피자를 한 조각 이상씩 먹으려면 최소 2판을 시켜야 합니다.
 * 입출력 예 #2
 * 12명이 4조각으로 자른 피자를 한 조각 이상씩 먹으려면 최소 3판을 시켜야 합니다.
 */
public class Pizza3 {
    public static void main(String[] args) {
        int n = 12;
        int slice = 4;
        System.out.println(solution(slice, n));
    }

    public static int solution(int slice, int n) {
        return (n + slice - 1) / slice;
    }
}
