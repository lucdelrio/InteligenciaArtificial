package com.connectfour;

/**
 * Created by lucas on 19/04/17.
 */
public class Board {

    private String[][] board = new board[6][7];
    private boolean juegoTerminado = false;
    private MaxMin maxMin = new MaxMin();

    public Board(){
        setInitialBoard();
    }

    public void startJ1(){
        final String J1 = "O";
        final String PC = "X";
    }

    public void startPC(){
        final String PC = "O";
        final String J1 = "X";
    }

    private void setInitialBoard(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = "-";
            }
        }
    }

    public void setPosition(int column, String playerPiece) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][column - 1] == "-") {
                    board[i][column - 1] = playerPiece;
                }
                else if((board[i][column - 1] == "O")|| (board[i][column - 1] == "X")) {
                    System.out.println("No se permiten mas fichas en esta columna");
                }
            }
        }
    }

    public void validateColumn (int column){
        if (column < 1 || column > 7){
            System.out.println("Elige un numero entre 1-7 para insertar tu ficha");
        }
    }

}
