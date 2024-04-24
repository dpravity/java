package programmers;

public class Euclidean {
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
