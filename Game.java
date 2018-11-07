import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel {

    private Board board;
    private State currentState;
    private Seed currentPlayer;
    private JLabel statusBar;

    public Game() {
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                int rowSelected = mouseY / GameDriver.CELL_SIZE;
                int colSelected = mouseX / GameDriver.CELL_SIZE;

                if (currentState == State.PLAY) {
                    if (rowSelected >= 0 && rowSelected < GameDriver.ROWS
                            && colSelected >= 0 && colSelected < GameDriver.COLS
                            && board.cell[rowSelected][colSelected].state == Seed.EMPTY) {
                        board.cell[rowSelected][colSelected].state = currentPlayer;
                        updateGame(currentPlayer, rowSelected, colSelected);

                        currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOT : Seed.CROSS;
                    }
                } else {
                    initGame();
                }
                repaint();
            }
        });

        statusBar = new JLabel("Welcome to Tic-Tac-Toe.");
        statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
        statusBar.setOpaque(true);
//        statusBar.setBackground(Color.LIGHT_GRAY);

        setLayout(new BorderLayout());
        add(statusBar, BorderLayout.PAGE_END);
        setPreferredSize(new Dimension(GameDriver.CANVAS_W, GameDriver.CANVAS_H + 30));

        board = new Board();
        initGame();
    }

    private void initGame() {
        for (int i = 0;i < GameDriver.ROWS;i++) {
            for (int j = 0;j < GameDriver.ROWS;j++) {
                board.cell[i][j].clear();
            }
        }
        currentState = State.PLAY;
        currentPlayer = Seed.CROSS;
    }

    public void updateGame(Seed theSeed, int row, int col) {
        if (board.hasWon(theSeed, row, col)) {
            currentState = (theSeed == Seed.CROSS) ? State.XWON : State.OWON;
        } else if (board.isDraw()) {
            currentState = State.DRAW;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        board.paint(g);

        if (currentState == State.PLAY) {
//            statusBar.setForeground(Color.BLACK);
            if (currentPlayer == Seed.CROSS) {
                statusBar.setText("X's Turn");
            } else {
                statusBar.setText("O's Turn");
            }
        } else if (currentState == State.DRAW) {
//            statusBar.setForeground(Color.RED);
            statusBar.setText("It's a Draw! Click to play again.");
        } else if (currentState == State.XWON) {
//            statusBar.setForeground(Color.RED);
            statusBar.setText("'X' Won! Click to play again.");
        } else if (currentState == State.OWON) {
//            statusBar.setForeground(Color.RED);
            statusBar.setText("'O' Won! Click to play again.");
        }
    }
}
