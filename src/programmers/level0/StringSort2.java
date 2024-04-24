package programmers.level0;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * 영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때,
 * my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
 *
 * my_string	result
 * "Bcad"	    "abcd"
 * "heLLo"	    "ehllo"
 * "Python"	    "hnopty"
 */
public class StringSort2 {
    public static void main(String[] args) {
        String my_string = "Bcad";
        System.out.println(solution1(my_string));
    }

    public static String solution1(String my_string) {
        char[] chars = my_string.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static String solution2(String myString) {
        return Arrays.stream(myString.toLowerCase(Locale.ROOT).split("")).sorted().collect(Collectors.joining());
    }
}
