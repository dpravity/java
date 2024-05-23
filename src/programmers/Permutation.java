package programmers;

import java.util.Arrays;

/**
 * 문자열 순열 조합
 */
public class Permutation {
    public static void main(String[] args) {
        String[] spell = {"z", "d", "x"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};
        System.out.println("단어 : " + Arrays.toString(spell) + ", 순열 조합 : " + spell.length);
        permutation1(spell, 0, spell.length, spell.length);
        System.out.println("========");
        int[] arr = {1, 2, 3};
        int r = 2;
        permutation(arr, new int[r], new boolean[arr.length], 0, r);
        System.out.println("========");
        intDuplicatePermutation(arr, new int[r], 0, r);
        System.out.println("========");
        combination(arr, new boolean[arr.length], 0, 0, r);
        System.out.println("========");
        duplicateCombination(arr, new int[r], 0, 0, r);
        System.out.println("========");
    }

    private static void permutation1(String[] spell, int depth, int n, int r){
        if(depth == r){
            System.out.println(String.join("", spell));
        }else{
            for(int i = depth; i < n; i++){
                swapSpell(spell, depth, i);
                permutation1(spell, depth + 1, n, r);
                swapSpell(spell, depth, i);
            }
        }
    }

    private static void swapSpell(String[] spell, int depth, int i){
        String temp = spell[depth];
        spell[depth] = spell[i];
        spell[i] = temp;
    }

    /**
     * 순열 : 서로 다른 n개 에서 r개를 뽑아서 정렬하는 경우의 수
     */
    private static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r){
        if(depth == r){
            System.out.println("순열 : " + Arrays.toString(out));
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }
    /**
     * 중복 순열 : 서로 다른 n개 에서 중복이 가능하게 r개를 뽑아서 정렬하는 경우의 수
     */
    private static void intDuplicatePermutation(int[] arr, int[] out, int depth, int r){
        if(depth == r){
            System.out.println("중복 순열 : " + Arrays.toString(out));
            return;
        }
        for(int i=0; i < arr.length; i++){
            out[depth] = arr[i];
            intDuplicatePermutation(arr, out, depth + 1, r);
        }
    }

    /**
     * 조합 : 서로 다른 n개 에서 순서 없이 r개를 뽑는 경우의 수
     */
    private static void combination(int[] arr, boolean[] visited, int start, int depth, int r){
        if(depth == r){
            System.out.print("조합 : ");
            for(int i = 0; i < arr.length; i++){
                if(visited[i]){
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
            return;
        }
        for(int i = start; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(arr, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    /**
     * 중복 조합 : 서로 다른 n개 에서 순서 없이, 중복이 가능하게 r개를 뽑는 경우의 수
     */
    private static void duplicateCombination(int[] arr, int[] out, int start, int depth, int r){
        if(depth == r){
            System.out.print("중복 조합 : ");
            for(int num : out){
                System.out.print(num);
            }
            System.out.println();
            return;
        }
        for(int i = start; i < arr.length; i++){
            out[depth] = arr[i];
            duplicateCombination(arr, out, i, depth + 1, r);
        }
    }

}
