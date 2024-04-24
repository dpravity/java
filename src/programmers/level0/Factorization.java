package programmers.level0;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다.
 * 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 따라서 12의 소인수는 2와 3입니다.
 * 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 2 ≤ n ≤ 10,000
 *
 * n	result
 * 12	[2, 3]
 * 17	[17]
 * 420	[2, 3, 5, 7]
 *
 * 입출력 예 #1
 * 12를 소인수분해하면 2 * 2 * 3 입니다. 따라서 [2, 3]을 return 합니다.
 *
 * 입출력 예 #2
 * 17은 소수입니다. 따라서 [17]을 return 해야 합니다.
 *
 * 입출력 예 #3
 * 420을 소인수분해하면 2 * 2 * 3 * 5 * 7 입니다. 따라서 [2, 3, 5, 7]을 return 합니다.
 */
public class Factorization {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(Arrays.toString(solution1(n)));
        System.out.println(Arrays.toString(solution2(n)));
    }

    public static int[] solution1(int n) {
        int limit = 10000;
        boolean[] prime = new boolean[limit + 1];
        prime[0] = false;
        prime[1] = false;

        for(int i = 2; i <= limit; i++){
            prime[i] = true;
        }
        for(int i = 2; i < Math.sqrt(prime.length); i++){
            if(prime[i]){
                for(int j = i * i; j < prime.length; j += i){
                    prime[j] = false;
                }
            }
        }

        int count = 2;
        int temp = n;
        HashSet<Integer> set = new HashSet<>();
        while(temp != 1){
            if(prime[count] && (temp % count == 0)){
                temp /= count;
                set.add(count);
            }else{
                count++;
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    public static int[] solution2(int n) {
        int count = 2;
        int temp = n;
        HashSet<Integer> set = new HashSet<>();
        while(temp != 1){
            if(temp % count == 0){
                temp /= count;
                set.add(count);
            }else{
                count++;
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }


}
