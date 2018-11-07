import javax.swing.*;

public class GameDriver {

    public static final double VERSION = 0.1;
    public static final int ROWS = 3;
    public static final int COLS = 3;
    public static final int CELL_SIZE = 100;
    public static final int CANVAS_W = CELL_SIZE * COLS;
    public static final int CANVAS_H = CELL_SIZE * ROWS;
    public static final int CELL_PADDING = CELL_SIZE/6;
    public static final int SYMBOL_STROKE_WIDTH = 2;
    public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
    public static final int GRID_W = 2;

    public static void main(String []args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JFrame frame = new JFrame("Tic-Tac-Toe v." + VERSION);
                frame.setVisible(true);
                frame.setSize(400, 400);

                Game game = new Game();

                frame.setContentPane(game);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });

    }

}
