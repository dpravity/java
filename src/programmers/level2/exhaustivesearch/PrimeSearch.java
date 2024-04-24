package programmers.level2.exhaustivesearch;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 *
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
 * 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers 가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers 는 길이 1 이상 7 이하인 문자열입니다.
 * numbers 는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 *
 * 입출력 예
 * numbers	return
 * "17"	    3
 * "011"	2
 *
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 */
public class PrimeSearch {
    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution1(numbers));
    }
    public static int solution1(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        boolean[] visieted = new boolean[numbers.length()];
        dfs(numbers, "", 0, visieted, set);

        for(Integer i : set){
            if(isPrime(i)){
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(String numbers, String s, int depth, boolean[] visited, HashSet<Integer> set){
        if(depth >= numbers.length()){
            return;
        }else{
            for(int i = 0; i < numbers.length(); i++){
                if(!visited[i]){
                    visited[i] = true;
                    String temp = s + numbers.charAt(i);
                    set.add(Integer.parseInt(temp));
                    dfs(numbers, temp, depth + 1, visited, set);
                    visited[i] = false;

                }
            }
        }
    }
    private static boolean isPrime(int value){
        if (value < 2){
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(value); i++) {
            if (value % i == 0){
                return false;
            }
        }
        return true;
    }

    //-----------------
    public static int solution2(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2){
                count++;
            }
            if (a % 2 != 0 && isPrime(a)){
                count++;
            }
        }
        return count;
    }

    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")){
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }
    }
}
