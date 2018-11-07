import java.awt.*;

public class Cell {

    Seed state;
    int row, col;

    public Cell(int row, int col) {
        clear();
        this.row = row;
        this.col = col;
    }

    public void clear() {
        state = Seed.EMPTY;
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(GameDriver.SYMBOL_STROKE_WIDTH,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        int x1 = col * GameDriver.CELL_SIZE + GameDriver.CELL_PADDING;
        int y1 = row * GameDriver.CELL_SIZE + GameDriver.CELL_PADDING;

        if (state == Seed.CROSS) {
            int x2 = (col + 1) * GameDriver.CELL_SIZE - GameDriver.CELL_PADDING;
            int y2 = (row + 1) * GameDriver.CELL_SIZE - GameDriver.CELL_PADDING;
            g2d.drawLine(x1, y1, x2, y2);
            g2d.drawLine(x2, y1, x1, y2);
        } else if (state == Seed.NOT) {
            g2d.drawOval(x1, y1, GameDriver.SYMBOL_SIZE, GameDriver.SYMBOL_SIZE);
        }
    }

}