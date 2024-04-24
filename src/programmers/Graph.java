package programmers;

/**
 * https://velog.io/@suk13574/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0Java-%EA%B7%B8%EB%9E%98%ED%94%84Graph
 */
public class Graph {
    public static void main(String[] args) {
        int[][] edges = new int[][] {
                {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 5}, {4, 5}
        };

        int n = 5; //정점의 개수

        int[][] matrix = new int[n + 1][n + 1];

        for(int[] edge : edges) {
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }

        //출력
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
