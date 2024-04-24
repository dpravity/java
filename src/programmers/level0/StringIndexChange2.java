package programmers.level0;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문자열 before와 after가 매개변수로 주어질 때,
 * before의 순서를 바꾸어 after를 만들 수 있으면 1을, 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.
 *
 * before	after	result
 * "olleh"	"hello"	1
 * "allpe"	"apple"	0
 *
 * 입출력 예 #1
 * "olleh"의 순서를 바꾸면 "hello"를 만들 수 있습니다.
 *
 * 입출력 예 #2
 * "allpe"의 순서를 바꿔도 "apple"을 만들 수 없습니다.
 */
public class StringIndexChange2 {
    public static void main(String[] args) {
        String before = "olleh";
        String after = "hello";
//        String before = "allpe";
//        String after = "apple";
//        System.out.println(solution1(before, after));
//        System.out.println(solution2(before, after));
        System.out.println(solution3(before, after));
    }

    public static int solution1(String before, String after) {
        if(before.length() != after.length()){
            return 0;
        }

        char[] beforeChars = before.toCharArray();
        char[] afterChars = after.toCharArray();
        char[] temp = new char[afterChars.length];
        boolean[] visited = new boolean[afterChars.length];
        int index = 0;
        for(int i = 0; i < after.length(); i++){
            for(int j = 0; j < beforeChars.length; j++){
                if(!visited[j] && afterChars[i] == beforeChars[j]){
                    visited[j] = true;
                    temp[index++] = beforeChars[j];
                    break;
                }
            }
        }

        return String.join("", String.valueOf(temp)).equals(after) ? 1 : 0;
    }

    public static int solution2(String before, String after) {
        char[] a = before.toCharArray();
        char[] b = after.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return new String(a).equals(new String(b)) ? 1 :0;
    }

    public static int solution3(String before, String after) {
        for(int i = 0; i < before.length(); i++){
            after = after.replaceFirst(before.substring(i,i+1),"");
            System.out.println(after);
        }
        return after.length() == 0? 1: 0;
    }

    // --
    public static int solution4(String before, String after) {
        return isCheck(getList(before), getList(after)) ? 1 : 0;
    }

    private static boolean isCheck(List<Integer> first, List<Integer> second) {
        for (int i = 0; i < first.size(); i++) {
            if (first.get(i) != second.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getList(String str) {
        return Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(s -> s))
                .values()
                .stream()
                .map(List::size)
                .collect(Collectors.toList());
    }
    // --
}

