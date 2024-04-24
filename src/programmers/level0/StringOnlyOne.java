package programmers.level0;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 문자열 s가 매개변수로 주어집니다.
 * s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
 * 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.
 *
 * s	        result
 * "abcabcadc"	"d"
 * "abdc"	    "abcd"
 * "hello"	    "eho"
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * "abcabcadc"에서 하나만 등장하는 문자는 "d"입니다.
 *
 * 입출력 예 #2
 * "abdc"에서 모든 문자가 한 번씩 등장하므로 사전 순으로 정렬한 "abcd"를 return 합니다.
 *
 * 입출력 예 #3
 * "hello"에서 한 번씩 등장한 문자는 "heo"이고 이를 사전 순으로 정렬한 "eho"를 return 합니다.
 */
public class StringOnlyOne {
    public static void main(String[] args) {
        String s = "hello";

        System.out.println(solution1(s));
        System.out.println(solution2(s));
        System.out.println(solution3(s));
    }
    public static String solution1(String s) {
        String[] array = s.split("");
        Arrays.sort(array);

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++){
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }

    public static String solution2(String s) {
        int[] alpha = new int[26];
        for(char c : s.toCharArray()){
            alpha[c - 'a']++;
        }

        StringBuffer answer = new StringBuffer();
        for(int i = 0; i < 26; i++){
            if(alpha[i] == 1){
                answer.append((char)(i + 'a'));
            }
        }
        return answer.toString();
    }

    public static String solution3(String s) {
        return Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(s1 -> s1))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() <= 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.joining());
    }
}
