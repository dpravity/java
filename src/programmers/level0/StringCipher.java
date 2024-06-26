package programmers.level0;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 군 전략가 머쓱이는 전쟁 중 적군이 다음과 같은 암호 체계를 사용한다는 것을 알아냈습니다.
 *
 * 암호화된 문자열 cipher를 주고받습니다.
 * 그 문자열에서 code의 배수 번째 글자만 진짜 암호입니다.
 * 문자열 cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 return 하도록 solution 함수를 완성해주세요.
 *
 * 입출력 예 #1
 * "dfjardstddetckdaccccdegk" 의 4번째, 8번째, 12번째, 16번째, 20번째, 24번째 글자를 합친 "attack"을 return 합니다.
 *
 * 입출력 예 #2
 * "pfqallllabwaoclk" 의 2번째, 4번째, 6번째, 8번째, 10번째, 12번째, 14번째, 16번째 글자를 합친 "fallback"을 return 합니다.
 *
 * 입출력 예
 * cipher	code	result
 * "dfjardstddetckdaccccdegk"	4	"attack"
 * "pfqallllabwaoclk"	2	"fallback"
 */
public class StringCipher {
    public static void main(String[] args) {
        String cipher = "pfqallllabwaoclk";
        int code = 2;
        System.out.println(solution1(cipher, code));
        System.out.println(solution2(cipher, code));
    }
    public static String solution1(String cipher, int code) {
        StringBuffer sb = new StringBuffer();
        char[] chars = cipher.toCharArray();
        for(int i = 1; i <= chars.length; i++){
            if(i % code == 0){
                sb.append(chars[i - 1]);
            }
        }

        return sb.toString();
    }
    public static String solution2(String cipher, int code) {
        return IntStream.range(0, cipher.length())
                .filter(index -> index % code == code - 1)
                .mapToObj(index -> String.valueOf(cipher.charAt(index)))
                .collect(Collectors.joining());
    }
}
