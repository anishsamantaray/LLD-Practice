class Board {

    char[][] grid;

    Board(int size) {
        grid = new char[size][size];
    }

    boolean placeMove(int row, int col, char symbol) {

        if (grid[row][col] != '\0') {
            return false;
        }

        grid[row][col] = symbol;
        return true;
    }

    void printBoard() {

        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}