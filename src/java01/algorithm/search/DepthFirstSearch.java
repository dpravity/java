package java01.algorithm.search;

import java.util.LinkedList;

/**
 * 깊이 우선 탐색 DFS(Depth First Search) 알고리즘
 * 정점(Vertex or Node) 데이터를 저장하는 위치
 * 간선(Edge) : 정점(노드)를 연결하는 선. 링크(Link) 또는 브랜치(branch) 로도 불린다.
 * 인접 정점(adjacent vertex) : 간선에 의해 직접 연결된 정점을 의미한다. 위의 그림에서 1과 2는 인접 정점이다.
 * 단순 경로(simple path) : 경로 중에서 반복되는 정점이 없는 경우를 의미한다. 한붓 그리기와 같이 같은 간선을 지나가지 않는 경로를 의미한다.
 * 차수(degree) : 무방향 그래프에서 하나의 정점에 인접한 정점의 수를 의미한다. 1의 차수는 2이다.
 * 진출 차수(in-degree) : 방향 그래프에서 외부로 향하는 간선의 수를 의미한다.
 * 진입 자수(out-degree) : 방향 그래프에서 외부에서 들어오는 간선의 수를 의미한다.
 * 경로 길이(path length) : 경로를 구성하는데 사용된 간선의 수를 의미한다.
 * 사이클(cycle) : 단순 경로의 시작 정점과 종료 정점이 동일한 경우를 의미한다.
 */
public class DepthFirstSearch {
    // 그래프 클래스 정의
    static class Graph {
        private int V; // 그래프의 정점 개수 (vertex)
        private LinkedList<Integer>[] adj; // 인접 리스트(adjacent vertex list)

        // 그래프 생성자
        @SuppressWarnings("unchecked")
        Graph(int v) {
            V = v;
            adj = new LinkedList[V];
            for (int i = 0; i < V; ++i)
                adj[i] = new LinkedList<>();
        }

        /**
         * 그래프에 간선 추가
         * @param v
         * @param w
         */
        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        /**
         * 깊이 우선 탐색 재귀적 메서드
         * @param v
         * @param visited
         */
        void DFSUtil(int v, boolean[] visited) {
            visited[v] = true; // 현재 노드를 방문한 것으로 표시
            System.out.print(v + " "); // 현재 노드 출력

            // 현재 노드와 인접한 모든 미방문 노드에 대해 재귀 호출
            for (int n : adj[v]) {
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        /**
         * 깊이 우선 탐색 메서드
         * @param v
         */
        void DFS(int v) {
            boolean[] visited = new boolean[V]; // 방문 여부 배열 초기화
            DFSUtil(v, visited); // 재귀적으로 깊이 우선 탐색 수행
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4); // 그래프 생성
        g.addEdge(0, 1); // 간선 추가
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal starting from vertex 2:");
        g.DFS(2); // 정점 2에서 시작하는 깊이 우선 탐색 수행
    }
}
