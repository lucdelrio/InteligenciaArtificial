package inteligencia_artificial;

import java.util.Scanner;

/**
 * Represents a human player in Connect Four.
 * This is a commandline game, so we scan from in
 *
 * @author Richard
 */
public class Player1 extends User {
    private String name;
    private String piece;

    public Player1(String piece){
        this.piece = piece;
    }

    public String getPiece(){
        return this.piece;
    }

    public int generateMove(int player, Board board) {

        System.out.println("Ingrese un número del 1 al 7 donde desee insertar su ficha");
        Scanner scanner = new Scanner(System.in);
        int move = scanner.nextInt();

        return move;
    }
    @Override
    public void setUserName(String name){
        this.name = name;
    }

    @Override
    public String getUserName(){
        return this.name;
    }
}
