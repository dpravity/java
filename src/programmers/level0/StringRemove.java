package programmers.level0;

/**
 * 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다.
 * 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return 하도록 solution 함수를 완성해주세요.
 *
 * my_string	        result
 * "bus"	            "bs"
 * "nice to meet you"	"nc t mt y"
 */
public class StringRemove {
    public static void main(String[] args) {
        String my_string = "nice to meet you adfklnwifndslkn dfalkdfwifh df adsdkbnalcmkqp qwpoeidl lsasd nice to meet you adfklnwifndslkn dfalkdfwifh df adsdkbnalcmkqp qwpoeidl lsasd";
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println(solution1(my_string));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("1 시간차이(m) : "+secDiffTime);

        beforeTime = System.currentTimeMillis();
        System.out.println(solution2(my_string));
        afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("2 시간차이(m) : "+secDiffTime);

        beforeTime = System.currentTimeMillis();
        System.out.println(solution3(my_string));
        afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("3 시간차이(m) : "+secDiffTime);
    }

    public static String solution1(String my_string) {
        char[] chars = my_string.toCharArray();

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            char ch = chars[i];
            if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static String solution2(String myString) {
        return myString.replaceAll("a|e|i|o|u", "");
    }
    public static String solution3(String my_string) {
        String answer = "";
        answer = my_string.replaceAll("[aeiou]", "");
        return answer;
    }
}
