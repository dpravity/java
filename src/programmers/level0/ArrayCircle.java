package programmers.level0;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다.
 * 배열 numbers의 원소를 direction 방향으로 한 칸씩 회전시킨 배열을 return 하도록 solution 함수를 완성해주세요.
 *
 * numbers	                    direction	result
 * [1, 2, 3]	                "right"	    [3, 1, 2]
 * [4, 455, 6, 4, -1, 45, 6]	"left"	    [455, 6, 4, -1, 45, 6, 4]
 */
public class ArrayCircle {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        String direction = "right";
//        int[] numbers = {4, 455, 6, 4, -1, 45, 6};
//        String direction = "left";
        System.out.println(Arrays.toString(solution1(numbers, direction)));
//        System.out.println(Arrays.toString(solution2(numbers, direction)));
    }
    public static int[] solution1(int[] numbers, String direction) {
        int size = numbers.length;
        int[] answer = new int[size];

        if(direction.equals("right")){
            int right = numbers[size - 1];

            for(int i = size - 1; i > 0; i--) {
                answer[i] = numbers[i - 1];
            }
            answer[0] = right;
        }else{
            int left = numbers[0];

            for(int i = 0; i < size - 1; i++) {
                answer[i] = numbers[i + 1];
            }
            answer[size - 1] = left;
        }

        return answer;
    }

    public static int[] solution2(int[] numbers, String direction) {
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        if (direction.equals("right")) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        } else {
            list.add(list.size(), list.get(0));
            list.remove(0);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
