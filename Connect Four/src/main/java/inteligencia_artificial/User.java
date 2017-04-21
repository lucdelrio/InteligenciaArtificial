package inteligencia_artificial;

/**
 * The abstract User class
 *
 * @author Richard
 */
public abstract class User {
    //public abstract Move generateMove(int player, Board board);
    public abstract int generateMove(int player, Board board);

    public abstract String getPiece();

    public abstract String getUserName();

    public abstract void setUserName(String name);
}
