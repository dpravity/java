package programmers.level0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 가위는 2 바위는 0 보는 5로 표현합니다.
 * 가위 바위 보를 내는 순서대로 나타낸 문자열 rsp가 매개변수로 주어질 때,
 * rsp에 저장된 가위 바위 보를 모두 이기는 경우를 순서대로 나타낸 문자열을 return 하도록 solution 함수를 완성해보세요.
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        String rsp = "205"; // result 052
        char[] chars = rsp.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            if('2' == chars[i]) {
                sb.append("0");
            } else if('0' == chars[i]){
                sb.append("5");
            }else{
                sb.append("2");
            }
        }
        System.out.println(sb.toString());
    }

    public static String solution1(String rsp) {
        return Arrays.stream(rsp.split("")).map(s -> s.equals("2") ? "0" : s.equals("0") ? "5" : "2").collect(Collectors.joining());
    }
    public static String solution2(String rsp) {
        //2 - 가위, 0 - 바위, 5 - 보
        Map<String, String> winNumbers = new HashMap<>();
        winNumbers.put("2", "0");
        winNumbers.put("0", "5");
        winNumbers.put("5", "2");

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < rsp.length(); i++) {
            answer.append(winNumbers.get(rsp.substring(i, i+1)));
        }

        return answer.toString();
    }
}
