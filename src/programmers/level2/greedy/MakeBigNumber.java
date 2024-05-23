package programmers.level2.greedy;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 *
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
 * 이 중 가장 큰 숫자는 94 입니다.
 * 문자열 형식으로 숫자 number 와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
 * number 에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 조건
 * number 는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number 의 자릿수 미만인 자연수입니다.
 *
 * 입출력 예
 * number	    k	return
 * "1924"	    2	"94"
 * "1231234"	3	"3234"
 * "4177252841"	4	"775841"
 */
public class MakeBigNumber {
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;
//        System.out.println(solution1(number, k));
//        System.out.println(solution2(number, k));
        System.out.println(solution3(number, k));
    }
    public static String solution1(String number, int k) {
        char[] chars = number.toCharArray();
        StringBuffer sb = new StringBuffer();
        int length = chars.length - k;
        // 문자 비교를 시작하는 인덱스를 나타내는 start 변수
        int start = 0;
        for(int i = 0; i < length; i++){
            char max = '0';
            for(int j = start; j <= i + k; j++){
                // 가장 큰수를 골라서 그 다음 인덱스를 시작 인덱스로 설정하기
                if(chars[j] > max){
                    max = chars[j];
                    start = j + 1;
                }
            }
            // 가장 큰 문자를 String에 넣어주기
            sb.append(max);
        }
        // k개의 수를 제거할 때 얻을 수 있는 가장 큰 숫자를 구하려 한다
        return sb.toString();
    }
    public static String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    //#region - practice
    public static String solution3(String number, int k) {
        char[] chars = number.toCharArray();
        int length = number.length() - k;
        int start = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; i++){
            char max = '0';
            for(int j = start; j <= i + k; j++){
                if(chars[j] > max){
                    max = chars[j];
                    start = j + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
    //#endregion - practice

}
