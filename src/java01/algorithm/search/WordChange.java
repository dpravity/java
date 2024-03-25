package java01.algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 단어 변환
 */
public class WordChange {
    public static void main(String[] args) {
        WordChange wordChange = new WordChange();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(wordChange.solution(begin, target, words));
    }

    /**
     * 단어 변환
     * @param begin 시작 단어
     * @param target 목표 단어
     * @param words 단어 리스트
     * @return 변환할 수 있는 최소 단계 수
     */
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.word.equals(target)){
                return node.step;
            }

            for(int i = 0; i < words.length; i++){
                String nextWord = words[i];
                if(!visited[i] && node.isConvertable(node.word, nextWord)){
                    visited[i] = true;
                    queue.add(new Node(nextWord, node.step + 1));
                }
            }

        }

        return 0;
    }

    private static class Node {
        public final String word;
        public final int step;

        private Node(String word, int step) {
            this.word = word;
            this.step = step;
        }

        private boolean isConvertable(String src, String dst){
            char[] srcChars = src.toCharArray();
            char[] dstChars = dst.toCharArray();
            int diff = 0;
            for(int i = 0; i < srcChars.length; i++){
                if(srcChars[i] != dstChars[i]){
                    diff++;
                }
            }

            return diff == 1;
        }
    }
}
