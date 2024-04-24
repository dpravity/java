package programmers.level0;

import java.util.stream.Collectors;

/**
 * 문자열 my_string이 매개변수로 주어질 때, 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.
 *
 * 입출력 예
 * my_string	result
 * "cccCCC"	    "CCCccc"
 * "abCdEfghIJ"	"ABcDeFGHij"
 */
public class StringUpperLower2 {
    public static void main(String[] args) {
        String my_string = "cccCCC";
        System.out.println(solution1(my_string));
        System.out.println(solution2(my_string));
    }

    public static String solution1(String my_string) {
        StringBuffer sb = new StringBuffer();
        char[] chars = my_string.toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(Character.isUpperCase(chars[i])){
                sb.append(Character.toLowerCase(chars[i]));
            }else{
                sb.append(Character.toUpperCase(chars[i]));
            }
        }
        return sb.toString();
    }

    public static String solution2(String myString) {
        return myString
                .chars()
                .mapToObj(operand -> String.valueOf(
                        (char) (Character.isLowerCase(operand) ? Character.toUpperCase(operand) : Character.toLowerCase(operand)))
                )
                .collect(Collectors.joining());
    }
}
