package programmers.level0;

/**
 * 문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때,
 * my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
 *
 * my_string	num1	num2	result
 * "hello"	    1	    2	    "hlelo"
 * "I love you"	3	    6	    "I l veoyou"
 */
public class StringIndexChange {
    public static void main(String[] args) {
        String my_string = "hello";
        int num1 = 1;
        int num2 = 2;
        System.out.println(solution1(my_string, num1, num2));
        System.out.println(solution2(my_string, num1, num2));
    }

    public static String solution1(String my_string, int num1, int num2) {
        String[] array = my_string.split("");
        String temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
        return String.join("", array);
    }

    public static String solution2(String my_string, int num1, int num2) {
        char[] chars = my_string.toCharArray();
        chars[num1] = my_string.charAt(num2);
        chars[num2] = my_string.charAt(num1);

        return String.valueOf(chars);
    }
}
