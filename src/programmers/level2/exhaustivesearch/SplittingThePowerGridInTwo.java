package programmers.level2.exhaustivesearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 *
 * n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
 * 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
 * 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
 *
 * 송전탑의 개수 n, 그리고 전선 정보 wires 가 매개변수로 주어집니다.
 * 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때,
 * 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * n은 2 이상 100 이하인 자연수입니다.
 * wires 는 길이가 n-1인 정수형 2차원 배열입니다.
 * wires 의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며, 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
 * 1 ≤ v1 < v2 ≤ n 입니다.
 * 전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
 *
 * 입출력 예
 * n	wires	                                            result
 * 9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
 * 4	[[1,2],[2,3],[3,4]]	                                0
 * 7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	            1
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * 다음 그림은 주어진 입력을 해결하는 방법 중 하나를 나타낸 것입니다.
 * 4번과 7번을 연결하는 전선을 끊으면 두 전력망은 각 6개와 3개의 송전탑을 가지며, 이보다 더 비슷한 개수로 전력망을 나눌 수 없습니다.
 * 또 다른 방법으로는 3번과 4번을 연결하는 전선을 끊어도 최선의 정답을 도출할 수 있습니다.
 *
 * 입출력 예 #2
 * 다음 그림은 주어진 입력을 해결하는 방법을 나타낸 것입니다.
 * 2번과 3번을 연결하는 전선을 끊으면 두 전력망이 모두 2개의 송전탑을 가지게 되며, 이 방법이 최선입니다.
 *
 * 입출력 예 #3
 * 다음 그림은 주어진 입력을 해결하는 방법을 나타낸 것입니다.
 * 3번과 7번을 연결하는 전선을 끊으면 두 전력망이 각각 4개와 3개의 송전탑을 가지게 되며, 이 방법이 최선입니다.
 */
public class SplittingThePowerGridInTwo {
    public static void main(String[] args) {
        int n = 9; // result 3
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution1(n, wires));
        System.out.println(solution2(n, wires));
    }
    public static int solution1(int n, int[][] wires) {
        int answer = n;
        // 0 부터 n 까지 사이즈이므로 edges 사이즈는  n + 1
        int[][] edges = new int[n + 1][n + 1];
        for(int i = 0; i < wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            edges[from][to] = 1;
            edges[to][from] = 1;
        }

        for(int i = 0; i < wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            // from - to 연결 끊기
            edges[from][to] = 0;
            edges[to][from] = 0;
            // 탐색
            answer = Math.min(answer, bfs(edges, from, n));
            // from -to 재연결
            edges[from][to] = 1;
            edges[to][from] = 1;
        }
        return answer;
    }

    private static int bfs(int[][] edges, int from, int n){
        boolean[] visited = new boolean[n + 1];
        int count = 1;

        Queue<Integer> queue = new LinkedList<>();
        visited[from] = true;
        queue.offer(from);

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int i = 1; i <= n; i++){
                if(!visited[i] && edges[temp][i] == 1){
                    visited[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }
        // 송전탑 개수 차이 A - B 절대값으로 리턴
        // 끊긴쪽 탐색 카운트 - (전체 - 끊긴 만큼)
        return Math.abs(count - (n - count));
    }

    //#region - practice
    public static int solution2(int n, int[][] wires) {
        int answer = n; // 전체 송전탑 개수
        // 탐색을 위한 간선 생성, 0 부터 n 까지 생성이므로 + 1
        int[][] edges = new int[n + 1][n + 1];
        for(int i = 0; i < wires.length; i++){
            // 간선 양방향 연결
            int from = wires[i][0];
            int to = wires[i][1];
            // 연결 상태 1, 끊김 상태 0 으로 세팅
            edges[from][to] = 1;
            edges[to][from] = 1;
        }

        // 간선 끊고 탐색
        for(int i = 0; i < wires.length; i++){
            // 간선 탐색을 위한 from, to
            int from = wires[i][0];
            int to = wires[i][1];
            // 간선 연결 끊기
            edges[from][to] = 0;
            edges[to][from] = 0;
            // 간선 끊긴 상태로 연결된 노드 탐색, 필요정보 간선, 시작 노드위치, 전체 개수
            // 최소값 갱신
            answer = Math.min(answer, bfs2(edges, from, n));
            // 재탐색을 위한 간선 재연결
            edges[from][to] = 1;
            edges[to][from] = 1;
        }

        return answer;
    }
    private static int bfs2(int[][] edges, int from, int n){
        // 방문여부 간선이 0부터 n까지 이므로 n + 1
        boolean[] visited = new boolean[n + 1];
        // 연결 노드를 확인할 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        // from 노드를 카운트 하고 시작
        int count = 1;
        // 노드 방문 하였으니 방문여부 true
        visited[from] = true;

        // from 과 연결된 노드 전체 탐색
        while(!queue.isEmpty()){
            // 탐색할 시작 지점
            int fromEdge = queue.poll();
            for(int i = 1; i <= n; i++){
                // 방문 노드 체크 && from - i 연결노드 체크
                if(!visited[i] && edges[fromEdge][i] == 1){
                    // 연결된 노드가 있다면 방문 체크
                    visited[i] = true;
                    // 다음 노드 탐색을 위해 큐에 노드 추가
                    queue.offer(i);
                    // 연결된 노드 카운트 추가
                    count++;
                }
            }
        }
        // 노드를 끊고 탐색한 차이 절대값으로 리턴
        // from 에 연결된 노드 카운트 - (전체 - 카운트)
        // 끊긴 노드 수 - (남은 노드 수)
        return Math.abs(count - (n - count));
    }
    //#endregion - practice
}
