package programmers.level3.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 *
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
 * 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 *
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers 가 매개변수로 주어질 때,
 * 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 *
 * 제한사항
 * 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
 * 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
 * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
 * computer[i][i]는 항상 1입니다.
 *
 * 입출력 예
 * n	computers	                        return
 * 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
 * 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 */
public class Network {
    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;
        System.out.println(solution1(n, computers));
    }
    public static int solution1(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }

        return answer;
    }

    /**
     * i 의 j 만큼 반복 체크
     * 방문하지 않았고 && i == j 자기 자신 체크 제외 && i - j 연결 여부
     */
    private static void dfs(int[][] computers, boolean[] visited, int i){
        visited[i] = true;
        for(int j = 0; j < computers.length; j++) {
            if (!visited[j] && i != j && computers[i][j] == 1) {
                dfs(computers, visited, j);
            }
        }
    }

}
