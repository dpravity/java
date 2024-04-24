package programmers.level0;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
 * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
 * 최빈값이 여러 개면 -1을 return 합니다.
 *
 * array	            result
 * [1, 2, 3, 3, 3, 4]	3
 * [1, 1, 2, 2]	        -1
 * [1]	                1
 */
public class NumberMax {
    public static void main(String[] args) {
//        int[] array = {1, 1, 2, 2};
        int[] array = {1, 2, 3, 3, 3, 4};
//        int[] array = {1};
        System.out.println(solution1(array));
        System.out.println(solution2(array));
        System.out.println(solution3(array));
    }

    public static int solution1(int[] array) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int value : array) {
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }

        int frequencyMax = Collections.max(frequency.values());
        List<Integer> frequencyMaxList = new ArrayList<>();

        frequency.forEach((key, value) -> {
            if (value == frequencyMax){
                frequencyMaxList.add(key);
            }
        });

        if (frequencyMaxList.size() > 1){
            return -1;
        }
        return frequencyMaxList.get(0);
    }
    public static int solution2(int[] array) {
        int answer = 0;
        int[] index = new int[1001];
        Arrays.sort(array);

        for(int i = 0; i < array.length; i++) {
            index[array[i]]++;
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < index.length; i++) {
            if (index[i] > max) {
                max = index[i];
                answer = i;
            } else if (max == index[i]) {
                answer = -1;
            }
        }
        return answer;
    }
    public static int solution3(int[] array) {
        List<Map.Entry<Integer, List<Integer>>> list =
                new ArrayList<>(
                        Arrays.stream(array)
                                .boxed()
                                .collect(Collectors.groupingBy(o -> o))
                                .entrySet()).stream()
                        .sorted((t0, t1) -> Integer.compare(t1.getValue().size(), t0.getValue().size()))
                        .collect(Collectors.toList());
        return list.size() > 1 && list.get(0).getValue().size() - list.get(1).getValue().size() == 0 ? -1 : list.get(0).getKey();
    }
}
