package programmers.level0;

/**
 * 문자열 str1, str2가 매개변수로 주어집니다. str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.
 *
 * str1	                    str2	result
 * "ab6CDE443fgh22iJKlmn1o"	"6CD"	1
 * "ppprrrogrammers"	    "pppp"	2
 * "AbcAbcA"	            "AAA"	2
 */
public class StringContains {
    public static void main(String[] args) {
        String str1 = "ppprrrogrammers";
        String str2 = "pppp";

        System.out.println(solution1(str1, str2));
    }

    public static int solution1(String str1, String str2) {
        return str1.contains(str2) ? 1 : 2;
    }
}
