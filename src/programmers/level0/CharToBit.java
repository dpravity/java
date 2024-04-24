package programmers.level0;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 우주여행을 하던 머쓱이는 엔진 고장으로 PROGRAMMERS-962 행성에 불시착하게 됐습니다.
 * 입국심사에서 나이를 말해야 하는데, PROGRAMMERS-962 행성에서는 나이를 알파벳으로 말하고 있습니다.
 * a는 0, b는 1, c는 2, ..., j는 9입니다. 예를 들어 23살은 cd, 51살은 fb로 표현합니다.
 * 나이 age가 매개변수로 주어질 때 PROGRAMMER-962식 나이를 return 하도록 solution 함수를 완성해주세요.
 *
 * age	result
 * 23	"cd"
 * 51	"fb"
 * 100	"baa"
 * 123	"bcd"
 */
public class CharToBit {
    public static void main(String[] args) {
        int age = 23;
        System.out.println(solution1(age));
        System.out.println(solution3(age));
    }

    public static String solution1(int age) {
        StringBuffer sb = new StringBuffer();
        char[] chars = String.valueOf(age).toCharArray();
        for(int i = 0; i < chars.length; i++){
            sb.append((char)(chars[i] + '1'));
        }
        return sb.toString();
    }

    public static String solution2(int age) {
        return String.valueOf(age).chars().mapToObj(operand -> String.valueOf((char) (49 + operand))).collect(Collectors.joining());
    }

    public static String solution3(int age) {
        StringBuilder sb = new StringBuilder();

        while(age > 0) {
            sb.insert(0, (char) ((age % 10) + (int)'a'));
            age /= 10;
        }

        return sb.toString();
    }
}
