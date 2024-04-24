package programmers.level0;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 머쓱이는 친구에게 모스부호를 이용한 편지를 받았습니다.
 * 그냥은 읽을 수 없어 이를 해독하는 프로그램을 만들려고 합니다.
 * 문자열 letter가 매개변수로 주어질 때, letter 를 영어 소문자로 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
 * 모스부호는 다음과 같습니다.
 *
 * morse = {
 *     '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
 *     '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
 *     '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
 *     '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
 *     '-.--':'y','--..':'z'
 * }
 *
 * 제한사항
 * 1 ≤ letter의 길이 ≤ 1,000
 * return값은 소문자입니다.
 * letter의 모스부호는 공백으로 나누어져 있습니다.
 * letter에 공백은 연속으로 두 개 이상 존재하지 않습니다.
 * 해독할 수 없는 편지는 주어지지 않습니다.
 * 편지의 시작과 끝에는 공백이 없습니다.
 *
 * letter	result
 * ".... . .-.. .-.. ---"	"hello"
 * ".--. -.-- - .... --- -."	"python"
 *
 * a ~ z에 해당하는 모스부호가 순서대로 담긴 배열입니다.
 * {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}
 */
public class MorseCode {
    public static void main(String[] args) {
        String letter = ".... . .-.. .-.. ---";
//        System.out.println(solution1(letter));
        System.out.println(solution2(letter));
    }

    public static String solution1(String letter) {
        // a ~ z에 해당하는 모스부호 26개 (0-25)
        String[] morse = {
                ".-","-...","-.-.","-..",".","..-.","--.","...."
                ,"..",".---","-.-",".-..","--","-.","---",".--.","--.-"
                ,".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        String[] letters = letter.split(" ");

        for(int i = 0; i < morse.length; i++){
            for(int j = 0; j < letters.length; j++){
                if(morse[i].equals(letters[j])){
//                    letters[j] = new String(String.valueOf((char)((byte) '0' + 49 + i)));
                    letters[j] = String.valueOf((char)(97 + i));
                }
            }
        }

        return String.join("", letters);
    }

    public static String solution2(String letter) {
        // a ~ z에 해당하는 모스부호 26개 (0-25)
        String[] morse = {
                ".-","-...","-.-.","-..",".","..-.","--.","...."
                ,"..",".---","-.-",".-..","--","-.","---",".--.","--.-"
                ,".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        AtomicInteger index = new AtomicInteger();
        Map<String, String> map = Arrays.stream(morse)
                .map(i -> new String[]{i, String.valueOf((char)(97 + index.getAndIncrement()))})
                .collect(Collectors.toMap(s -> s[0], s -> s[1]));

        StringBuffer sb = new StringBuffer();
        String[] letters = letter.split(" ");
        for(int i = 0; i < letters.length; i++){
            sb.append(map.get(letters[i]));
        }
        return sb.toString();
    }
}
