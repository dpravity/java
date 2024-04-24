package programmers.level0;

/**
 * 정수 num과 k가 매개변수로 주어질 때,
 * num을 이루는 숫자 중에 k가 있으면 num의 그 숫자가 있는 자리 수를 return하고 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
 *
 * num	    k	result
 * 29183	1	3
 * 232443	4	4
 * 123456	7	-1
 */
public class NumberSearch {
    public static void main(String[] args) {
        int num = 232443;
        int k = 4;
        System.out.println(solution1(num, k));
        System.out.println(solution2(num, k));
    }

    public static int solution1(int num, int k) {
        int answer = -1;
        int temp = num;
        int index = (int) Math.log10(num) + 1;
        while(temp > 0){
            if(temp % 10 == k){
                answer = index;
            }
            temp /= 10;
            index--;
        }
        return answer;
    }
    public static int solution2(int num, int k) {
        return ("-" + num).indexOf(String.valueOf(k));
    }
}
