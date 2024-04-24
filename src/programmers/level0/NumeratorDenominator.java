package programmers.level0;

/**
 * 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1,
 * 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
 * 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 * numer1	denom1	numer2	denom2	result
 * 1	    2	    3	    4	    [5, 4]
 * 9	    2	    1	    3	    [29, 6]
 */
public class NumeratorDenominator {
    public static void main(String[] args) {
        int[] answer = new int[2];
        int numer1 = 1, denom1 = 2, numer2 = 3, denom2 = 4;
        int numerator = numer1 * denom2 + numer2 * denom1;
        int denominator = denom1 * denom2;
        int divide = euclidean(numerator, denominator);
        answer[0] = numerator / divide;
        answer[1] = denominator / divide;

        System.out.println(numerator);
        System.out.println(denominator);
        System.out.println(divide);
        System.out.println(numerator / divide);
        System.out.println(denominator / divide);
    }

    public static int euclidean(int a, int b) {
        if (b == 0) {
            return a;
        }
        return euclidean(b, a % b);
    }
}
