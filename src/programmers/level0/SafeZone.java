package programmers.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
 * 지뢰는 2차원 배열 board 에 1로 표시되어 있고 board 에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
 * 지뢰가 매설된 지역의 지도 board 가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * board 는 n * n 배열입니다.
 * 1 ≤ n ≤ 100
 * 지뢰는 1로 표시되어 있습니다.
 * board 에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
 *
 * 입출력 예
 * board	                                                                                                                result
 * [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]	                                16
 * [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]	                                13
 * [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]	0
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * (3, 2)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선 총 8칸은 위험지역입니다. 따라서 16을 return 합니다.
 *
 * 입출력 예 #2
 * (3, 2), (3, 3)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선은 위험지역입니다. 따라서 위험지역을 제외한 칸 수 13을 return 합니다.
 *
 * 입출력 예 #3
 * 모든 지역에 지뢰가 있으므로 안전지역은 없습니다. 따라서 0을 return 합니다.
 */
public class SafeZone {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};
        System.out.println(solution1(board));
        System.out.println(solution2(board));
    }

    private static int solution1(int[][] board) {
        int answer = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int target = board[i][j];
                if(target == 1){
                    checkZone(board, visited, i, j);
                }
            }
        }

        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[0].length; j++){
                if(!visited[i][j]){
                    answer++;
                }
            }
        }

        return answer;
    }
    private static void checkZone(int[][] board, boolean[][] visited, int i, int j){
        int boardX = board[0].length;
        int boardY = board.length;

        for(int x = -1; x < 2; x++){
            for(int y = -1; y < 2; y++){
                // 범위체크 0 보다 작으거나, 크기보다 크면
                if((i + x >= 0) && (boardX > (i + x)) && (j + y >= 0) && (boardY > (j + y))){
                    visited[i + x][j + y] = true;
                }
            }
        }
    }

    @FunctionalInterface
    interface BiConsumer<T> {
        void apply(Integer t1, Integer t2);
    }
    private static int solution2(int[][] board) {
        int answer;
        int[] move = {-1,0,1};
        int[][] chkBoard = new int[board.length][board.length];

        BiConsumer<Integer> drawChk = (x, y) ->{
            Arrays.stream(move)
                    .filter((i)-> 0<= x+i && x+i < board.length)
                    .forEach(i->Arrays.stream(move)
                            .filter(j-> 0 <= j+y && j+y < board.length)
                            .forEach((j)->chkBoard[x+i][y+j] = 1));
        };

        IntStream.range(0, board.length).forEach(i -> IntStream.range(0, board.length).filter(j->board[i][j] == 1).forEach(j->drawChk.apply(i,j)));
        answer = (int)Arrays.stream(chkBoard).mapToLong(i -> Arrays.stream(i).filter(j -> j == 0).count()).sum();
        return answer;
    }


    public int solution(int[][] board) {
        int[] dx = {-1,-1,0,1,1,1,0,-1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};

        int answer = 0;
        int count = 0;

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (board[i][j] == 1) {
                    count++;
                    for (int k=0; k<8; k++) {
                        if (i+dx[k]>=0 && i+dx[k] < board.length && j+dy[k]>=0 && j+dy[k] < board.length && board[i+dx[k]][j+dy[k]] == 0) {
                            board[i+dx[k]][j+dy[k]] = 2;
                            count++;
                        }
                    }
                }
            }
        }

        answer = board.length * board.length - count;

        return answer;
    }
}
