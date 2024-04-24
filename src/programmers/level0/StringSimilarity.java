package programmers.level0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 두 배열이 얼마나 유사한지 확인해보려고 합니다. 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * s1	            s2	                            result
 * ["a", "b", "c"]	["com", "b", "d", "p", "c"]	    2
 * ["n", "omg"]	    ["m", "dot"]	                0
 */
public class StringSimilarity {
    public static void main(String[] args) {
        String[] s1 = {"a", "b", "c"};
        String[] s2 = {"com", "b", "d", "p", "c"};
//        String[] s1 = {"n", "omg"};
//        String[] s2 = {"m", "dot"};
        System.out.println(solution(s1, s2));
        System.out.println(solution1(s1, s2));

    }

    public static int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String temp1 : s1){
            for(String temp2 : s2){
                if(temp1.equals(temp2)){
                    answer++;
                    // 중복 안될 경우 break
                }
            }
        }
        return answer;
    }
    public static int solution1(String[] s1, String[] s2) {
        List<String> s1List = Arrays.asList(s1);
        List<String> s2List = Arrays.asList(s2);

        return (int) s1List.stream()
                .filter(s -> s2List.stream().anyMatch(Predicate.isEqual(s)))
                .count();
    }
    public static int solution2(String[] s1, String[] s2) {
        Set<String> set = new HashSet<>(Arrays.asList(s1));
        return (int)Arrays.stream(s2).filter(set::contains).count();
    }

    public static int solution3(String[] s1, String[] s2) {
        return (int) Arrays.stream(s1)
                .map(s -> Arrays.stream(s2).collect(Collectors.toList()).contains(s))
                .filter(b -> b)
                .count();
    }
}
