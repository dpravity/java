package java01.algorithm.search;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS_Queue {
    static class Graph {
        private int V; // 그래프의 정점 수
        private LinkedList<Integer> adj[]; // 인접 리스트

        // 생성자: 그래프 초기화
        public Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) { // 각 정점에 대한 인접 리스트 초기화
                adj[i] = new LinkedList();
            }
        }

        // 간선 추가 함수
        void addEdge(int v, int w) {
            adj[v].add(w); // 정점 v의 인접 리스트에 w 추가
        }

        // BFS 구현 함수
        void bfs(int s) {
            // 모든 정점을 방문하지 않은 상태로 초기화
            boolean visited[] = new boolean[V];

            // BFS를 위한 큐 생성
            LinkedList<Integer> queue = new LinkedList<>();

            // 현재 노드를 방문 처리하고 큐에 삽입
            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                // 큐에서 정점을 뽑아 출력하고
                s = queue.poll();
                System.out.print(s + " ");

                // 뽑은 정점의 모든 인접 정점에 대하여
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    // 인접 정점을 방문하지 않았다면 방문 처리 후 큐에 삽입
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

    // BFS 실행 예제
    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Breadth First Traversal starting from vertex 2:");

        g.bfs(2);
    }
}
