package programmers.level0;

/**
 * TODO - 재학습 필요
 * 문제 설명
 * 소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다.
 * 분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다.
 * 유한소수가 되기 위한 분수의 조건은 다음과 같습니다.
 *
 * 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
 * 두 정수 a와 b가 매개변수로 주어질 때, a/b가 유한소수이면 1을, 무한소수라면 2를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * a, b는 정수
 * 0 < a ≤ 1,000
 * 0 < b ≤ 1,000
 *
 * 입출력 예
 * a	b	result
 * 7	20	1
 * 11	22	1
 * 12	21	2
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * 분수 7/20은 기약분수 입니다. 분모 20의 소인수가 2, 5 이기 때문에 유한소수입니다. 따라서 1을 return 합니다.
 *
 * 입출력 예 #2
 * 분수 11/22는 기약분수로 나타내면 1/2 입니다. 분모 2는 소인수가 2 뿐이기 때문에 유한소수 입니다. 따라서 1을 return 합니다.
 *
 * 입출력 예 #3
 * 분수 12/21는 기약분수로 나타내면 4/7 입니다. 분모 7은 소인수가 7 이므로 무한소수입니다. 따라서 2를 return 합니다.
 *
 * Hint
 * 분자와 분모의 최대공약수로 약분하면 기약분수를 만들 수 있습니다.
 * 정수도 유한소수로 분류합니다.
 */
public class FiniteDecimalPoint {
    public static void main(String[] args) {
        int a = 12;
        int b = 21;
        System.out.println(solution1(a, b));
        System.out.println(solution2(a, b));
    }
    public static int solution1(int a, int b) {
        int newB = b / euclidean(a, b);
        // 유한소수 1, 무한소수 2
        while( newB != 1) {
            if(newB % 2 == 0) {
                newB /= 2;
            }else if (newB % 5 == 0) {
                newB /= 5;
            }else {
                return 2;
            }
        }
        return 1;
    }

    private static int euclidean(int a, int b) {
        if (b == 0) {
            return a;
        }
        return euclidean(b, a % b);
    }

    //#region
    private static int solution2(int a, int b) {
        int answer = 2;
        // 약분하기
        for (int i = 1; i < Math.min(a, b) + 1; i++) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }

        // 소인수찾기
        if (check(b)) {
            answer = 1;
        }
        return answer;
    }

    // 소인수 찾기
    private static boolean check(int num){
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
    //#endregion

}
