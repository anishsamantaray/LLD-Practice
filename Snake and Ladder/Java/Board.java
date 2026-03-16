import java.util.*;

class Board {

    List<Snake> snakes = new ArrayList<>();
    List<Ladder> ladders = new ArrayList<>();

    Board() {

        snakes.add(new Snake(17,7));
        snakes.add(new Snake(54,34));

        ladders.add(new Ladder(3,22));
        ladders.add(new Ladder(5,8));
    }
}