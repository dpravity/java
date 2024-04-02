package java01.algorithm.ibm;

import java.util.HashMap;

/**
 * 함수 getMaxOccurrences를 사용하여 주어진 예제에서 문자열 'abcde' 내에서 조건을 만족하는 부분 문자열의 최대 발생 횟수를 찾았습니다.
 * 이 경우, minLength = 2, maxLength = 3,
 * 그리고 maxUnique = 3을 만족하는 부분 문자열은 'ab', 'bc', 'cd', 'de', 'abc', 'bcd', 'cde' 등이 있습니다.
 * 각각의 부분 문자열은 단 한 번씩만 발생하기 때문에, 최대 발생 횟수는 1입니다.
 *
 * 이 코드는 다음 단계를 따릅니다:
 * 주어진 문자열의 모든 가능한 부분 문자열을 생성하되, minLength 와 maxLength 의 조건을 만족하도록 합니다.
 * 각 부분 문자열에 대해 고유 문자의 수가 maxUnique 이하인지 확인합니다.
 * 조건을 만족하는 모든 부분 문자열의 발생 횟수를 계산합니다.
 * 발생 횟수 중 최댓값을 찾아 반환합니다.
 * 이 접근 방식은 주어진 예제에 대해 올바르게 작동하며, 부분 문자열의 최대 발생 횟수가 1임을 확인할 수 있습니다.
 */
public class SubstringOccurrences {
    public static int getMaxOccurrences(String components, int minLength, int maxLength, int maxUnique) {
        HashMap<String, Integer> occurrenceMap = new HashMap<>();
        int maxOccurrences = 0;

        for (int i = 0; i < components.length(); i++) {
            for (int j = i + minLength; j <= i + maxLength && j <= components.length(); j++) {
                String sub = components.substring(i, j);
                if (isValid(sub, maxUnique)) {
                    occurrenceMap.put(sub, occurrenceMap.getOrDefault(sub, 0) + 1);
                    maxOccurrences = Math.max(maxOccurrences, occurrenceMap.get(sub));
                }
            }
        }

        return maxOccurrences;
    }

    private static boolean isValid(String sub, int maxUnique) {
        int[] charCount = new int[26]; // Assuming components consists of lowercase English letters
        int uniqueChars = 0;

        for (char c : sub.toCharArray()) {
            if (charCount[c - 'a'] == 0){
                uniqueChars++;
            }
            charCount[c - 'a']++;
        }

        return uniqueChars <= maxUnique;
    }

    public static void main(String[] args) {
        String components = "abcdeab";
        int minLength = 2;
        int maxLength = 3;
        int maxUnique = 3;
        System.out.println(getMaxOccurrences(components, minLength, maxLength, maxUnique));
        // Expected output: 1
    }

}
