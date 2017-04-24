package inteligencia_artificial;

import java.util.Scanner;

public class Program {

    private static Scanner scanner;

    public static void main(String args[]){

        System.out.println("Bienvenido al Cuatro en Línea");

        System.out.println("Ingrese su nombre");
        String playerName;
        scanner = new Scanner(System.in);
        playerName = scanner.nextLine();

        System.out.println("Seleccione quién comienza el juego");
        System.out.println("----------------------------------");

        System.out.println("1 - " + "Comienza "+ playerName );
        System.out.println("2 - Comienza PC");

        int option = 0;
        scanner = new Scanner(System.in);
        option = Integer.parseInt(scanner.nextLine());

        switch (option){
            case 1:
                Game connectFourPlayer1Start = new Game(new Player1("O", playerName),new Computer(
                        "X", "PC"));

                break;

            case 2:
                Game connectFourComputerStart = new Game(new Computer(
                        "O", "PC"), new Player1("X", playerName));

                break;

            default:
                System.out.println("Seleccione una opción válida");
                System.out.println("Seleccione quién comienza el juego");
                System.out.println("----------------------------------");
                System.out.println("1 - " + "Comienza " + playerName);
                System.out.println("2 - Comienza PC");
                scanner.nextLine();

                break;
        }
    }
}