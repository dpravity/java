package programmers.level0;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 문자열 배열 strlist가 매개변수로 주어집니다.
 * strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.
 *
 * strlist	                        result
 * ["We", "are", "the", "world!"]	[2, 3, 3, 6]
 * ["I", "Love", "Programmers."]	[1, 4, 12]
 */
public class StringArrayLength {
    public static void main(String[] args) {
        String[] strlist = {"We", "are", "the", "world!"};
        StringJoiner sj = new StringJoiner(",");
        for(int i : solution1(strlist)){
            sj.add(String.valueOf(i));
        }
        System.out.println(sj.toString());

    }

    public static int[] solution1(String[] strlist) {
        int[] answer = new int[strlist.length];

        for(int i = 0; i < strlist.length; i++){
            answer[i] = strlist[i].length();
        }

        return answer;
    }

    public static int[] solution2(String[] strList) {
        return Arrays.stream(strList)
                .mapToInt(String::length)
                .toArray();
    }

    public static int[] solution3(String[] strlist) {
        return Arrays.stream(strlist)
                .map(element -> element.length())
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
