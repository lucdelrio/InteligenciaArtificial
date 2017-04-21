package inteligencia_artificial;

/**
 * Represents a Connect Four game
 *
 * @author Richard
 */
public class Game {
    private User[] players;

    private Board board;

    //turn will oscillate between 1 and 2.
    private int turn = 1;
    private int true_turn = 1;

    private int isGameOver;

    public Game(User one, User two) {
        players = new User[2];
        if (one.getPiece() == "O"){
            players[0] = one;
            players[1] = two;
        }else {
            players[0] = two;
            players[1] = one;
        }
        isGameOver = 0;

        board = new Board();
        System.out.println(board);

        while(isGameOver==0) {
            System.out.println("\n*****Turn: " +true_turn + "*****");

            int move = players[turn-1].generateMove(turn, board);

            board.makeMove(turn, move);
            System.out.println(board);

            this.isGameOver = board.isGameOver();

            true_turn++;
            turn++;
            if (turn == 3) {
                turn = 1;
            }
        }
        System.out.println("Player " + isGameOver
                + (isGameOver == 1 ? " (X)" : " (O)") + " wins!");

    }
}
