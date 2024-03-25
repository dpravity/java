package java01.algorithm.search;

import java.util.stream.IntStream;

public class DFS_1 {
    private static final int[][] RULE = {
            {1,2,3,4,5}
            , {2,1,2,3,2,4,2,5}
            , {3,3,1,1,2,2,4,4,5,5}
    };
    public static void main(String[] args) {
        DFS_1 dfs = new DFS_1();
        int[] answers = {1,2,3,4,5};
        int[] result = dfs.solution(answers);
        for (int i : result) {
            System.out.println(i);
        }
    }
    private int getPicked(int person, int problem){
        int[] rule = RULE[person];
        int index = problem % rule.length;
        return rule[index];
    }
    private int[] solution(int[] answers){
        int[] corrects = new int[3];
        int max = 0;

        for(int problem = 0; problem < answers.length; problem++){
            int answer = answers[problem];

            for (int person = 0; person < RULE.length; person++){
                int picked = getPicked(person, problem);
                if (answer == picked){
                    if(++corrects[person] > max){
                        max = corrects[person];
                    }
                }
            }
        }

        // 가장 많은 답을 맞춘 사람
        final int maxCorrect = max;
        return IntStream.range(0,RULE.length)
                .filter(i -> corrects[i] == maxCorrect)
                .map(i -> i + 1)
                .toArray();
    }

}
