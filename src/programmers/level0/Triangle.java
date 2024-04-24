package programmers.level0;

import java.util.Arrays;

/**
 * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
 * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
 * 삼각형의 세 변의 길이가 담긴 배열 sides 이 매개변수로 주어집니다.
 * 세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2를 return 하도록 solution 함수를 완성해주세요.
 *
 * 입출력 예 #1
 * 가장 큰 변인 3이 나머지 두 변의 합 3과 같으므로 삼각형을 완성할 수 없습니다. 따라서 2를 return 합니다.
 *
 * 입출력 예 #2
 * 가장 큰 변인 6이 나머지 두 변의 합 5보다 크므로 삼각형을 완성할 수 없습니다. 따라서 2를 return 합니다.
 *
 * 입출력 예 #3
 * 가장 큰 변인 222가 나머지 두 변의 합 271보다 작으므로 삼각형을 완성할 수 있습니다. 따라서 1을 return 합니다.
 *
 * 입출력 예
 * sides	        result
 * [1, 2, 3]	    2
 * [3, 6, 2]	    2
 * [199, 72, 222]	1
 */
public class Triangle {
    public static void main(String[] args) {
        int[] sides = {1, 2, 3};
        System.out.println(solution1(sides));
    }
    public static int solution1(int[] sides) {
        Arrays.sort(sides);
        int max = sides[sides.length - 1];
        int sum = 0;
        for(int i = 0; i < sides.length - 1; i++){
            sum += sides[i];
        }
        if(sum == max || sum < max){
            return 2;
        }else{
            return 1;
        }
    }
    public static int solution2(int[] sides) {
        Arrays.sort(sides);
        return sides[2] >= sides[0] + sides[1] ? 2 : 1;
    }

}
