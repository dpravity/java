package programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다.
 * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
 * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * spell과 dic의 원소는 알파벳 소문자로만 이루어져있습니다.
 * 2 ≤ spell의 크기 ≤ 10
 * spell의 원소의 길이는 1입니다.
 * 1 ≤ dic의 크기 ≤ 10
 * 1 ≤ dic의 원소의 길이 ≤ 10
 * spell의 원소를 모두 사용해 단어를 만들어야 합니다.
 * spell의 원소를 모두 사용해 만들 수 있는 단어는 dic에 두 개 이상 존재하지 않습니다.
 * dic과 spell 모두 중복된 원소를 갖지 않습니다.

 * spell	            dic	                                    result
 * ["p", "o", "s"]	    ["sod", "eocd", "qixm", "adio", "soo"]	2
 * ["z", "d", "x"]	    ["def", "dww", "dzx", "loveaw"]	        1
 * ["s", "o", "m", "d"]	["moos", "dzx", "smm", "sunmmo", "som"]	2

 * 입출력 예 #1
 * "p", "o", "s" 를 조합해 만들 수 있는 단어가 dic에 존재하지 않습니다. 따라서 2를 return합니다.

 * 입출력 예 #2
 * "z", "d", "x" 를 조합해 만들 수 있는 단어 "dzx"가 dic에 존재합니다. 따라서 1을 return 합니다.

 * 입출력 예 #3
 * "s", "o", "m", "d" 를 조합해 만들 수 있는 단어가 dic에 존재하지 않습니다. 따라서 2을 return 합니다.
 */
public class StringDictionary {
    public static void main(String[] args) {
        String[] spell = {"z", "d", "x"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};

//        System.out.println(solution1(spell, dic));
//        System.out.println(solution2(spell, dic));
        System.out.println(solution3(spell, dic));

    }

    public static int solution1(String[] spell, String[] dic) {
        int answer = 2;
        ArrayList<String> list = new ArrayList<>();
        permutation(spell, 0, spell.length, spell.length, list);
        System.out.println(list);
        for(String str : list){
            for(String word : dic){
                if(str.equals(word)){
                    answer = 1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void permutation(String[] arr, int depth, int n, int r, ArrayList<String> list) {
        if (depth == r) {
            System.out.println("r : + " + r + " , arr : " + Arrays.toString(arr));
            list.add(String.join("", arr));
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r, list);
            swap(arr, depth, i);
        }
    }

    public static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static int solution2(String[] spell, String[] dic) {
        return Arrays.stream(dic)
                .map(s -> s.chars().sorted().mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining()))
                .collect(Collectors.toList())
                .contains(Arrays.stream(spell).sorted().collect(Collectors.joining())) ? 1 : 2;
    }

    public static int solution3(String[] spell, String[] dic) {
        int answer = 2;
        Arrays.sort(spell);
        String target = String.join("", spell);

        boolean exist = false;
        for(int i = 0; i < dic.length; i++){
            char[] chars = dic[i].toCharArray();
            Arrays.sort(chars);
            dic[i] = new String(chars);

            for(int j = 0; j < spell.length; j++){
                if(dic[i].equals(target)){
                    exist = true;
                    answer = 1;
                    break;
                }
            }
            if(exist){
                break;
            }
        }

        System.out.println(Arrays.toString(spell));
        System.out.println(Arrays.toString(dic));

        return answer;
    }

    public static int solution4(String[] spell, String[] dic) {
        for(int i=0;i<dic.length;i++){
            int answer = 0;
            for(int j=0;j<spell.length;j++){
                if(dic[i].contains(spell[j])) answer ++;
            }
            if(answer==spell.length) return 1;
        }
        return 2;
    }

}
