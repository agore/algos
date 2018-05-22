import java.util.*;

public class Robot {
    public static void main(String[] argv) {
        
    }

    private boolean[][] grid;
    private List<Point> route;
    private RobotPos robotPosition = new RobotPos(0, 0);
    private int gridRows;
    private int gridCols;

    public Robot(boolean[][] grid) {
        this.grid = grid;
        gridRows = grid.length;
        gridCols = grid[0].length;
    }

    public void mapRoute() {
        for (int i = robotPosition.r; i < gridRows; i++) {
            for (int j = robotPosition.c; j < gridCols; j++) {
                if (grid[i][j]) {
                    robotPosition.c = j;
                } else {
                }
            }
        }
    }

    private static class RobotPos {
        private RobotPos(int row, int col) {
            r = row;
            c = col;
        }

        int r;
        int col;
    }
}
