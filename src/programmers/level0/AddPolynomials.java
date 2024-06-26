package programmers.level0;

import java.util.HashMap;
import java.util.StringJoiner;

/**
 * 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다.
 * 다항식을 계산할 때는 동류항끼리 계산해 정리합니다.
 * 덧셈으로 이루어진 다항식 polynomial 이 매개변수로 주어질 때,
 * 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요.
 * 같은 식이라면 가장 짧은 수식을 return 합니다.
 *
 * 제한사항
 * 0 < polynomial에 있는 수 < 100
 * polynomial에 변수는 'x'만 존재합니다.
 * polynomial은 양의 정수, 공백, ‘x’, ‘+'로 이루어져 있습니다.
 * 항과 연산기호 사이에는 항상 공백이 존재합니다.
 * 공백은 연속되지 않으며 시작이나 끝에는 공백이 없습니다.
 * 하나의 항에서 변수가 숫자 앞에 오는 경우는 없습니다.
 * " + 3xx + + x7 + "와 같은 잘못된 입력은 주어지지 않습니다.
 * 0으로 시작하는 수는 없습니다.
 * 문자와 숫자 사이의 곱하기는 생략합니다.
 * polynomial 에는 일차 항과 상수항만 존재합니다.
 * 계수 1은 생략합니다.
 * 결괏값에 상수항은 마지막에 둡니다.
 * 0 < polynomial 의 길이 < 50
 *
 * 입출력 예
 * polynomial	    result
 * "3x + 7 + x"	    "4x + 7"
 * "x + x + x"	    "3x"

 * 입출력 예 설명
 * 입출력 예 #1
 * "3x + 7 + x"에서 동류항끼리 더하면 "4x + 7"입니다.

 * 입출력 예 #2
 * "x + x + x"에서 동류항끼리 더하면 "3x"입니다.
 *
 */
public class AddPolynomials {
    public static void main(String[] args) {
        String polynomial = "3x + 7 + x";
        System.out.println(solution1(polynomial));
        System.out.println(solution2(polynomial));
    }

    // TODO - test case 두개 통과 못함
    private static String solution1(String polynomial) {
        String[] arr = polynomial.split(" \\+ ");
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i].contains("x")){
                int xInt = 1;
                if(arr[i].length() > 1){
                    xInt = Integer.parseInt(arr[i].replace("x", ""));
                }
                map.put("x", map.getOrDefault("x", 0) + xInt);
            }else{
                map.put("num", map.getOrDefault("num", 0) + Integer.parseInt(arr[i]));
            }
        }
        StringJoiner sj = new StringJoiner(" + ");
        if(map.containsKey("x")){
            sj.add(map.get("x") + "x");
        }
        if(map.containsKey("num")){
            sj.add(String.valueOf(map.get("num")));
        }

        return sj.toString();
    }

    private static String solution2(String polynomial) {
        int xNum = 0;
        int num = 0;

        for (String s : polynomial.split(" ")) {
            if (s.contains("x")) {
                xNum += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
            }
            else if (!s.equals("+"))
                num += Integer.parseInt(s);
        }

        return (xNum != 0 ? xNum > 1 ? xNum + "x" : "x" : "")
                + (num != 0 ? (xNum != 0 ? " + " : "")
                + num : xNum == 0 ? "0" : "");
    }

    private static String solution3(String polynomial) {
        int xCount = 0;
        int num = 0;

        for (String s : polynomial.split(" ")) {
            if (s.contains("x")) {
                xCount += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
            } else if (!s.equals("+")) {
                num += Integer.parseInt(s);
            }
        }
        return (xCount != 0 ? xCount > 1 ? xCount + "x" : "x" : "") + (num != 0 ? (xCount != 0 ? " + " : "") + num : xCount == 0 ? "0" : "");
    }

}
