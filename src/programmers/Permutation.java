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
    }

    public static void permutation1(String[] spell, int depth, int n, int r){
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

    public static void swapSpell(String[] spell, int depth, int i){
        String temp = spell[depth];
        spell[depth] = spell[i];
        spell[i] = temp;
    }

}
