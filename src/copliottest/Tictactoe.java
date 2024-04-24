package copliottest;

// Q tic tac toe game 을 만들어
// 3x3 판을 만들어
// 2명의 플레이어가 번갈아가면서 O 또는 X 를 채워넣는 게임을 만들어보자.
// 판이 꽉 차거나 한 줄이 다 채워지면 게임이 끝난다.
// 게임이 끝나면 승자를 알려주고, 다시 게임을 할 것인지 물어본다.
// 게임을 다시 할 것이라고 하면 판을 초기화하고 다시 게임을 시작한다.
// 게임을 끝낼 것이라고 하면 프로그램을 종료한다.
// 게임을 시작할 때 판을 보여주고, O 또는 X 를 입력할 수 있게 한다.
// 판은 1부터 9까지 번호가 붙어있고, 번호를 입력하면 해당 위치에 O 또는 X 를 채워넣는다.
// 판을 보여줄 때는 1부터 3까지, 4부터 6까지, 7부터 9까지 순서대로 보여준다.
// 판을 보여줄 때 O 또는 X 가 채워진 위치는 O 또는 X 로 보여주고, 빈 위치는 번호로 보여준다.
public class Tictactoe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        char currentPlayer = 'X';
        boolean isGameEnd = false;
        int count = 0;

        while (!isGameEnd) {
            printBoard(board);

            int position = getPosition(board, currentPlayer);
            int row = (position - 1) / 3;
            int col = (position - 1) % 3;

            board[row][col] = currentPlayer;
            count++;

            if (isWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println(currentPlayer + " wins!");
                isGameEnd = true;
            } else if (count == 9) {
                printBoard(board);
                System.out.println("It's a tie!");
                isGameEnd = true;
            }

            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == 0 ? (i * 3 + j + 1) : board[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static int getPosition(char[][] board, char currentPlayer) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int position = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Player " + currentPlayer + ", enter your position (1-9): ");
            position = scanner.nextInt();

            if (position < 1 || position > 9) {
                System.out.println("Invalid position. Please enter a number between 1 and 9.");
            } else {
                int row = (position - 1) / 3;
                int col = (position - 1) % 3;

                if (board[row][col] != 0) {
                    System.out.println("Position already taken. Please choose another position.");
                } else {
                    isValid = true;
                }
            }
        }

        return position;
    }

    private static boolean isWin(char[][] board, char currentPlayer) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }
}
