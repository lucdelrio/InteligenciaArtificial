package inteligencia_artificial;

import java.util.Scanner;

public class Program {

    private static Scanner scanner;
    private final static int Player1 = 1;
    private final static int PC = 2;
    private static String Player1Piece;
    private static String ComputerPiece;

    public static void main(String args[]) {

        System.out.println("Bienvenido al Cuatro en Línea");
        System.out.println("Seleccione quién comienza el juego");
        System.out.println("----------------------------------");
        System.out.println("1 - Comienza Player1");
        System.out.println("2 - Comienza PC");

        int option = 0;
        scanner = new Scanner(System.in);
        option = Integer.parseInt(scanner.nextLine());

        switch (option){
            case 1:
                Game connectFourComputerStart = new Game(new Player1(Player1Piece = "O"),new Computer(
                        ComputerPiece = "X"));

                System.out.println("Ingrese un número del 1 al 7 donde desee insertar su ficha");
                break;
            case 2:
                Game connectFourPlayer1Start = new Game(new Computer(
                        ComputerPiece = "X"), new Player1(Player1Piece = "O"));

                break;

            default:
                System.out.println("Seleccione una opción válida");
                System.out.println("Seleccione quién comienza el juego");
                System.out.println("----------------------------------");
                System.out.println("1 - Comienza Player1");
                System.out.println("2 - Comienza PC");
                scanner.nextLine();

                break;
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
