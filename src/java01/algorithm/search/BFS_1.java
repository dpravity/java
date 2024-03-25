package java01.algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS(Breadth First Search) 알고리즘
 * 미로 최단거리
 * 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
 *
 */
public class BFS_1 {
    private static class Node {
        int x;
        int y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    // 상하좌우
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    /**
     * BFS 알고리즘
     * @param maps
     * @return
     */
    public int solution(int[][] maps){
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Queue<Node> queue = new LinkedList<>();
        // 초기 상태
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            // 전체 탐색 완료
            if(node.y == maps.length -1 && node.x == maps[0].length -1){
                return node.step;
            }

            // 상하좌우 탐색
            for(int d = 0; d < 4; d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                // 범위 검사
                if (ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[0].length) {
                    continue;
                }

                // 장애물 검사
                if(maps[ny][nx] == 0){
                    continue;
                }

                // 중복 검사, 방문 검사
                if(visited[ny][nx]){
                    continue;
                }

                // 방문 처리
                visited[ny][nx] = true;
                // 다음 노드 큐에 추가
                queue.add(new Node(nx, ny, node.step + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] maps = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };

        BFS_1 bfs = new BFS_1();
        System.out.println(bfs.solution(maps));
    }
}
