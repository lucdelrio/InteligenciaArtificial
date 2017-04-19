package com.connectfour;

import java.util.Scanner;

public class Program {

    private static Scanner scanner;
    private final static int J1 = 1;
    private final static int PC = 2;
    private static String J1Piece;
    private static String PCPiece;

    public static void main(String args[]) {

        System.out.println("Bienvenido al Cuatro en Línea");
        System.out.println("Seleccione quién comienza el juego");
        System.out.println("----------------------------------");
        System.out.println("1 - Comienza J1");
        System.out.println("2 - Comienza PC");

        int option = 0;
        scanner = new Scanner(System.in);
        option = Integer.parseInt(scanner.nextLine());

        switch (option){
            case 1:
                J1Piece = "O";
                PCPiece = "X";
                System.out.println("Ingrese un número del 1 al 7 donde desee insertar su ficha");
                break;
            case 2:
                PCPiece = "O";
                J1Piece = "X";
                break;

            default:
                System.out.println("Seleccione una opción válida");
                clearScreen();
                System.out.println("Seleccione quién comienza el juego");
                System.out.println("----------------------------------");
                System.out.println("1 - Comienza J1");
                System.out.println("2 - Comienza PC");

        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
