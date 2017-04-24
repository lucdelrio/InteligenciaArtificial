package inteligencia_artificial;

public class Game {
    private User[] players;

    private Board board;

    private int turn = 1;
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

        while(isGameOver==0) {
            System.out.println("\nJuega: " + players[turn-1].getUserName());

            int move = players[turn-1].generateMove(turn, board);

            board.makeMove(turn, move);

            System.out.println(board);

            this.isGameOver = board.isGameOver();

            turn++;
            if (turn == 3) {
                turn = 1;
            }
        }
        if (isGameOver == 2){
            System.out.println(players[1].getUserName() + " gana!");
        }else if (isGameOver == 1){
            System.out.println(players[0].getUserName() + " gana!");
        }
    }
}