package programmers.level0;

import java.util.Arrays;
import java.util.Map;

/**
 * 영어가 싫은 머쓱이는 영어로 표기되어있는 숫자를 수로 바꾸려고 합니다.
 * 문자열 numbers가 매개변수로 주어질 때, numbers를 정수로 바꿔 return 하도록 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * numbers는 소문자로만 구성되어 있습니다.
 * numbers는 "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" 들이 공백 없이 조합되어 있습니다.
 * 1 ≤ numbers의 길이 ≤ 50
 * "zero"는 numbers의 맨 앞에 올 수 없습니다.
 *
 * 입출력 예
 * numbers	                                result
 * "onetwothreefourfivesixseveneightnine"	123456789
 * "onefourzerosixseven"	                14067
 *
 * 입출력 예 #1
 * "onetwothreefourfivesixseveneightnine"를 숫자로 바꾼 123456789를 return 합니다.
 *
 * 입출력 예 #1
 * "onefourzerosixseven"를 숫자로 바꾼 14067를 return 합니다.
 */
public class EnglishHate {
    public static void main(String[] args) {
        String numbers = "onefourzerosixseven";
        System.out.println(solution1(numbers));
        System.out.println(solution2(numbers));
    }

    public static long solution1(String numbers) {
        numbers = numbers.replaceAll("zero", "0");
        numbers = numbers.replaceAll("one", "1");
        numbers = numbers.replaceAll("two", "2");
        numbers = numbers.replaceAll("three", "3");
        numbers = numbers.replaceAll("four", "4");
        numbers = numbers.replaceAll("five", "5");
        numbers = numbers.replaceAll("six", "6");
        numbers = numbers.replaceAll("seven", "7");
        numbers = numbers.replaceAll("eight", "8");
        numbers = numbers.replaceAll("nine", "9");
        return Long.parseLong(numbers);
    }
    public static long solution2(String numbers) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < words.length; i++){
            numbers = numbers.replaceAll(words[i], String.valueOf(i));
        }

        return Long.parseLong(numbers);
    }
    public static long solution3(String numbers) {
        final Map<String, Integer> NUMBERS = Map.of(
                "zero", 0,
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9);

        return Long.parseLong(NUMBERS.keySet().stream()
                .reduce(numbers, (before, current) -> before.replaceAll(current, String.valueOf(NUMBERS.get(current)))));
    }
}
