import java.awt.*;

public class Board {

    public Cell cell[][];

    public Board() {
        cell = new Cell[GameDriver.ROWS][GameDriver.COLS];
        for (int i = 0;i < GameDriver.ROWS;++i) {
            for (int j = 0;j < GameDriver.COLS;++j) {
                cell[i][j] = new Cell(i, j);
            }
        }
    }

    public void clear() {
        for (int i = 0;i < GameDriver.ROWS;++i) {
            for (int j = 0;j < GameDriver.COLS;++j) {
                cell[i][j].clear();
            }
        }
    }

    public boolean isDraw() {
        for (int i = 0; i < GameDriver.ROWS; ++i) {
            for (int j = 0; j < GameDriver.COLS; ++j) {
                if (cell[i][j].state == Seed.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(Seed seed, int seedRow, int seedCol) {
        return (cell[seedRow][0].state == seed && cell[seedRow][1].state == seed && cell[seedRow][2].state == seed ||
                cell[0][seedCol].state == seed && cell[1][seedCol].state == seed && cell[2][seedCol].state == seed ||
                seedRow == seedCol && cell[0][0].state == seed && cell[1][1].state == seed && cell[2][2].state == seed ||
                seedRow + seedCol == 2 && cell[0][2].state == seed && cell[1][1].state == seed && cell[2][0].state == seed
        );
    }

    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        for (int i = 1; i < GameDriver.ROWS; ++i) {
            g.fillRoundRect(0, GameDriver.CELL_SIZE * i - GameDriver.GRID_W/2,
                    GameDriver.CANVAS_W - 1, GameDriver.GRID_W,
                    GameDriver.GRID_W, GameDriver.GRID_W);
        }
        for (int j = 1; j < GameDriver.COLS; ++j) {
            g.fillRoundRect(GameDriver.CELL_SIZE * j - GameDriver.GRID_W/2, 0,
                    GameDriver.GRID_W, GameDriver.CANVAS_H - 1,
                    GameDriver.GRID_W, GameDriver.GRID_W);
        }

        for (int i = 0; i < GameDriver.ROWS; ++i) {
            for (int j = 0; j < GameDriver.COLS; ++j) {
                cell[i][j].paint(g);
            }
        }
    }
}