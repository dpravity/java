package java01.algorithm.search;

import java.util.Arrays;

/**
 * 탐욕 알고리즘
 */
public class Greedy_Coin {
    public static void main(String[] args) {
        int[] coinTypes = {500, 100, 50, 10};
        int change = 1260;
        int count = 0;

        int[] coins = {1, 5, 10, 25}; // 사용 가능한 동전
        int amount = 63; // 거슬러 줘야 할 금액
//        solution1(coins, amount);
        solution1(coinTypes, change);
        System.out.println("=====================================");

        count = solution2(coinTypes, change);
        System.out.println(count);

    }
    public static int solution1(int[] coins, int amount) {
        Arrays.sort(coins); // 동전을 오름차순으로 정렬

        int count = 0; // 사용된 동전의 총 개수
        for (int i = coins.length - 1; i >= 0; i--) { // 가장 큰 단위의 동전부터 시작
            int coin = coins[i];
            int used = amount / coin; // 현재 동전으로 거슬러 줄 수 있는 최대 개수
            amount -= used * coin; // 남은 금액 갱신
            count += used; // 사용된 동전의 개수 갱신

            System.out.println(coin + "원 동전 " + used + "개 사용");
        }

        System.out.println("총 사용된 동전의 개수: " + count);
        return count;
    }


    public static int solution2(int[] coinTypes, int change) {
        int count = 0;

        for (int i = 0; i < coinTypes.length; i++) {
            count += change / coinTypes[i];
            change %= coinTypes[i];
        }

        return count;
    }
}
