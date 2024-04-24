package programmers.level0;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * 문자열 my_string이 매개변수로 주어질 때, my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.
 *
 * my_string	result
 * "hi12392"	[1, 2, 2, 3, 9]
 * "p2o4i8gj2"	[2, 2, 4, 8]
 * "abcde0"	    [0]
 */
public class StringSort1 {
    public static void main(String[] args) {
        String my_string = "hi12392";
        StringJoiner sj = new StringJoiner(",");
        for(int i : solution1(my_string)){
            sj.add(String.valueOf(i));
        }
        System.out.println(sj.toString());
    }
    public static int[] solution1(String my_string) {
        String temp = my_string.replaceAll("[^0-9]", "");
        int[] answer = Arrays.stream(temp.split(""))
                .mapToInt(i -> Integer.valueOf(i))
                .sorted()
                .toArray();

        return answer;
    }

    public static int[] solution22(String myString) {
        return Arrays.stream(myString.replaceAll("[^0-9]", "").split(""))
                .sorted()
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[] solution3(String my_string) {
        my_string = my_string.replaceAll("[a-z]","");
        int[] answer = new int[my_string.length()];

        for(int i =0; i<my_string.length(); i++){
            answer[i] = my_string.charAt(i) - '0';
        }
        Arrays.sort(answer);

        return answer;
    }
}
