package inteligencia_artificial;

import java.util.Scanner;

public class Player1 extends User {
    private String name;
    private String piece;

    public Player1(String piece, String name){
        this.piece = piece;
        this.name = name;
    }

    public String getPiece(){
        return this.piece;
    }

    public int generateMove(int player, Board board) {
        System.out.println("Ingrese un número del 1 al 7 donde desee insertar su ficha");
        Scanner scanner = new Scanner(System.in);
        int move = 0;

        while (move == 0){
            int numberScan = scanner.nextInt();
            if (numberScan < 1 || numberScan > 7) {
                System.out.println("Movimiento ilegal, debe ingresar un numero entre 1 y 7");
            }else {
                move = numberScan;
            }
        }

        return move-1;
    }

    @Override
    public String getUserName(){
        return this.name;
    }
}
