package programmers.level0;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 문제 설명
 * 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다.
 * 이때 n으로 부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다.
 * 정수가 담긴 배열 numlist 와 정수 n이 주어질 때
 * numlist 의 원소를 n으로 부터 가까운 순서대로 정렬한 배열을 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ n ≤ 10,000
 * 1 ≤ numlist의 원소 ≤ 10,000
 * 1 ≤ numlist의 길이 ≤ 100
 * numlist는 중복된 원소를 갖지 않습니다.

 * 입출력 예
 * numlist	                        n	result
 * [1, 2, 3, 4, 5, 6]	            4	[4, 5, 3, 6, 2, 1]
 * [10000,20,36,47,40,6,10,7000]	30	[36, 40, 20, 47, 10, 6, 7000, 10000]

 * 입출력 예 설명
 * 입출력 예 #1
 * 4에서 가까운 순으로 [4, 5, 3, 6, 2, 1]을 return 합니다.
 * 3과 5는 거리가 같으므로 더 큰 5가 앞에 와야 합니다.
 * 2와 6은 거리가 같으므로 더 큰 6이 앞에 와야 합니다.
 *
 * 입출력 예 #2
 * 30에서 가까운 순으로 [36, 40, 20, 47, 10, 6, 7000, 10000]을 return 합니다.
 * 20과 40은 거리가 같으므로 더 큰 40이 앞에 와야 합니다.
 */
public class OddSort {
    public static void main(String[] args) {
        int[] numlist = {1, 2, 3, 4, 5, 6};
        int n = 4;
        System.out.println(Arrays.toString(solution1(numlist, n)));
        System.out.println(Arrays.toString(solution2(numlist, n)));
    }

    // TODO - test case 2개 통과 못함
    private static int[] solution1(int[] numlist, int n) {
        HashMap<Integer, Integer> copy = new HashMap<>();
        for(int i : numlist){
            copy.put(i, Math.abs(i - n));
        }

        return copy.entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if(o1.getValue() < o2.getValue()){
                        return -1;
                    }else if(o1.getValue() == o2.getValue()){
                        if(o1.getKey() > o2.getKey()){
                            return -1;
                        }
                        return 0;
                    }else{
                        return 1;
                    }
                })
                .mapToInt(o -> o.getKey())
                .toArray();
    }
    private static int[] solution2(int[] numlist, int n) {
        Arrays.sort(numlist);

        for(int i = 0; i < numlist.length; i++){
            for(int j = 0; j < numlist.length; j++){
                if(Math.abs(n - numlist[i]) <= Math.abs(n - numlist[j])){
                    int temp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = temp;
                }
            }
        }
        return numlist;
    }

    private static int[] solution3(int[] numList, int n) {
        return Arrays.stream(numList)
                .boxed()
                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
