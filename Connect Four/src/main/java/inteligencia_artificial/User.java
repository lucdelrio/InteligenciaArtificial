package inteligencia_artificial;

public abstract class User {

    public abstract int generateMove(int player, Board board);

    public abstract String getPiece();

    public abstract String getUserName();

}
