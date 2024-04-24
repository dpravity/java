package programmers.level0;

/**
 * 문자열 my_string이 매개변수로 주어집니다.
 * my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. my_string안의 자연수들의 합을 return 하도록 solution 함수를 완성해주세요.
 *
 * my_string	    result
 * "aAb1B2cC34oOp"	37
 * "1a2b3c4d123Z"	133
 *
 * 입출력 예 #1
 * "aAb1B2cC34oOp"안의 자연수는 1, 2, 34 입니다. 따라서 1 + 2 + 34 = 37 을 return 합니다.
 *
 * 입출력 예 #2
 * "1a2b3c4d123Z"안의 자연수는 1, 2, 3, 4, 123 입니다. 따라서 1 + 2 + 3 + 4 + 123 = 133 을 return 합니다.
 */
public class NumberSum {
    public static void main(String[] args) {
        String my_string = "aAb1B2cC34oOp";

        System.out.println(solution1(my_string));
    }
    public static int solution1(String my_string) {
        int answer = 0;
        String[] temp = my_string.split("[^0-9]+");
        for(String str : temp){
            if(!str.isEmpty()){
                answer += Integer.parseInt(str);
            }
        }
        return answer;
    }
}
