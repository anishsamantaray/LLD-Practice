class Game {

    Board board;
    Dice dice;
    Player[] players;
    int currentPlayer = 0;

    Game() {

        board = new Board();
        dice = new Dice();

        players = new Player[]{
                new Player("P1"),
                new Player("P2")
        };
    }

   void playTurn() {

    Player player = players[currentPlayer];

    int roll = dice.roll();
    int newPosition = player.position + roll;

    if (newPosition > 100) {
        currentPlayer = (currentPlayer + 1) % players.length;
        return;
    }

    for(Snake snake : board.snakes){
        if(snake.head == newPosition){
            newPosition = snake.tail;
        }
    }

    for(Ladder ladder : board.ladders){
        if(ladder.start == newPosition){
            newPosition = ladder.end;
        }
    }

    player.position = newPosition;

    System.out.println(player.name + " rolled " + roll + " → position " + player.position);

    if (player.position == 100) {
        System.out.println(player.name + " wins!");
        System.exit(0);
    }

    currentPlayer = (currentPlayer + 1) % players.length;
}
}
