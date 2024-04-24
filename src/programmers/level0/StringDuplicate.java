package programmers.level0;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/**
 * 문자열 my_string이 매개변수로 주어집니다.
 * my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.
 *
 * my_string	        result
 * "people"	            "peol"
 * "We are the world"	"We arthwold"
 *
 * 입출력 예 #1
 * "people"에서 중복된 문자 "p"와 "e"을 제거한 "peol"을 return합니다.
 *
 * 입출력 예 #2
 * "We are the world"에서 중복된 문자 "e", " ", "r" 들을 제거한 "We arthwold"을 return합니다.
 */
public class StringDuplicate {
    public static void main(String[] args) {
        String my_string = "We are the world";

        System.out.println(solution1(my_string));
        System.out.println(solution2(my_string));
        System.out.println(solution3(my_string));
    }

    public static String solution1(String my_string) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(String str : my_string.split("")){
            set.add(str);
        }
        return String.join("", set);
    }

    public static String solution2(String my_string) {
        return my_string.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
    }

    public static String solution3(String my_string) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < my_string.length(); i++){
            if(i == my_string.indexOf(my_string.charAt(i)))
                sb.append(my_string.charAt(i));
        }

        return sb.toString();
    }

    public static String solution4(String myString) {
        return Arrays.stream(myString.split("")).distinct().collect(Collectors.joining());
    }
}
