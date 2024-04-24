package programmers.level0;

/**
 *문자열 my_string이 매개변수로 주어집니다. my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
 * my_string	    result
 * "aAb1B2cC34oOp"	10
 * "1a2b3c4d123"	16
 */
public class StringNumberSum {
    public static void main(String[] args) {
        String my_string = "aAb1B2cC34oOp"; // 10
        System.out.println(solution(my_string));
        System.out.println(solution2(my_string));

    }
    public static int solution(String my_string) {
        int sum = 0;
        char[] chars = my_string.replaceAll("[^0-9]","").toCharArray();
        for(char ch : chars){
            sum += Character.getNumericValue(ch);
        }
        return sum;
    }
    public static int solution2(String myString) {
        return myString.chars()
                .mapToObj(i -> (char) i)
                .filter(Character::isDigit)
                .map(String::valueOf)
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
