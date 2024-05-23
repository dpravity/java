package programmers.level2.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 *
 * n개의 음이 아닌 정수들이 있습니다.
 * 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 targetn이 매개변수로 주어질 때
 * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
 * 각 숫자는 1 이상 50 이하인 자연수입니다.
 * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
 *
 * 입출력 예
 * numbers	        target	return
 * [1, 1, 1, 1, 1]	3	    5
 * [4, 1, 2, 1]	    4	    2
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제 예시와 같습니다.
 *
 * 입출력 예 #2
 * +4+1-2+1 = 4
 * +4-1+2-1 = 4
 * 총 2가지 방법이 있으므로, 2를 return 합니다.
 */
public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution1(numbers, target));
        System.out.println(solution2(numbers, target));
    }
    public static int solution1(int[] numbers, int target) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[numbers.length];
        int index = 0;
        queue.add(new Node(numbers[0], index));
        queue.add(new Node(-numbers[0], index));
        visited[0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.index == numbers.length - 1){
                if(node.num == target){
                    answer++;
                }
                continue;
            }
            int temp = node.num + numbers[node.index + 1];
            int temp2 = node.num - numbers[node.index + 1];
            queue.add(new Node(temp, node.index + 1));
            queue.add(new Node(temp2, node.index + 1));

        }

        return answer;
    }

    private static class Node{
        int num;
        int index;

        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    private static int answer2 = 0;
    public static int solution2(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer2;
    }
    private static void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){
            if(target == sum){
                answer2++;
            }
        }else{
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }

}
