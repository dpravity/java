package copliottest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Tic Tac Toe 게임을 만들어보자.
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
// 판을 보여줄 때는 java swing 을 사용한다.
public class TicTacToe2 {
    private char currentSymbol;
    private JButton[] buttons;
    private JFrame frame;

    public TicTacToe2() {
        frame = new JFrame("Tic Tac Toe");
        buttons = new JButton[9];
        currentSymbol = 'X';

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setPreferredSize(new Dimension(60, 60));
            buttons[i].setText("");
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    button.setText(String.valueOf(currentSymbol));
                    button.setEnabled(false);
                    checkGame();
                    switchSymbol();
                }
            });
            panel.add(buttons[i]);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void switchSymbol() {
        currentSymbol = (currentSymbol == 'X') ? 'O' : 'X';
    }

    private void checkGame() {
        // Check for game over conditions
    }

    public static void main(String[] args) {
        new TicTacToe2();
    }
}
