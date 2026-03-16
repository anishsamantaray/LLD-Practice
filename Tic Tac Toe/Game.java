class Game {

    Board board;
    Player[] players;
    int currentPlayer = 0;

    Game() {

        board = new Board(3);

        players = new Player[]{
                new Player("Player1", 'X'),
                new Player("Player2", 'O')
        };
    }

    void play(int row, int col) {

        Player player = players[currentPlayer];

        boolean success = board.placeMove(row, col, player.symbol);

        if (!success) {
            System.out.println("Invalid move");
            return;
        }

        if (checkWinner(player.symbol)) {
            System.out.println(player.name + " wins!");
            return;
        }

        currentPlayer = 1 - currentPlayer;
    }

    boolean checkWinner(char symbol) {

    char[][] g = board.grid;

    for (int i = 0; i < 3; i++) {

        if (g[i][0] == symbol && g[i][1] == symbol && g[i][2] == symbol)
            return true;

        if (g[0][i] == symbol && g[1][i] == symbol && g[2][i] == symbol)
            return true;
    }

    if (g[0][0] == symbol && g[1][1] == symbol && g[2][2] == symbol)
        return true;

    if (g[0][2] == symbol && g[1][1] == symbol && g[2][0] == symbol)
        return true;

    return false;
}