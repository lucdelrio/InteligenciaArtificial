package inteligencia_artificial;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int TOTALOFROWS = 6;
    public static final int TOTALOFCOLUMNS = 7;

    private int[][] board;

    protected int[] boardIndex;

    protected List<String> rows;
    protected List<String> cols;
    protected List<String> diagonals;

    public int[][][] position_to_down_left_diagonal;
    public int[][][] position_to_down_right_diagonal;

    public Board() {

        board = new int[TOTALOFROWS][TOTALOFCOLUMNS];
        boardIndex = new int[7];

        rows = new ArrayList();
        cols = new ArrayList();
        diagonals = new ArrayList();
        position_to_down_left_diagonal = new int[TOTALOFROWS][TOTALOFCOLUMNS][2];
        position_to_down_right_diagonal = new int[TOTALOFROWS][TOTALOFCOLUMNS][2];
        refreshBoard();
    }

    @Override
    public String toString() {
        String result = new String();
        result += "===============\n";
        for(int row = TOTALOFROWS -1; row >= 0; row--) {
            result += " ";
            for(int column = 0; column < TOTALOFCOLUMNS; column++) {
                switch(board[row][column]) {

                    case 1:
                        result += "O";
                        break;
                    case 2:
                        result += "X";
                        break;
                    default:
                        result += "-";
                        break;
                }
                if (column != TOTALOFCOLUMNS -1) {
                    result += " ";
                }
            }
            result += "\n";
        }
        result += " 1 2 3 4 5 6 7\n===============";
        return result;
    }

    public void makeMove(int player_piece, int move_position) {

        int row = boardIndex[move_position];
        if (row != TOTALOFROWS) {
            board[row][move_position] = player_piece;
            boardIndex[move_position]++;

            refreshRCD2(player_piece, row, move_position);
            return;
        }
        throw new RuntimeException("Movimiento ilegal");
    }
    private void refreshRCD2(int piece, int row, int col) {
        char newPiece = (char)(piece+48);

        String r = rows.get(row);
        char[] rt = r.toCharArray();
        rt[col] = newPiece;
        rows.set(row, new String(rt));

        String c = cols.get(col);
        char[] ct = c.toCharArray();
        ct[row] = newPiece;
        cols.set(col, new String(ct));

        int[] d1 = position_to_down_left_diagonal[row][col];
        int[] d2 = position_to_down_right_diagonal[row][col];

        if (d1[0]==0&&d1[1]==0 && !(row == 3 && col == 0)) {

        } else {
            String dd1 = diagonals.get(d1[0]);
            char[] dd1t = dd1.toCharArray();
            dd1t[d1[1]] = newPiece;
            diagonals.set(d1[0], new String(dd1t));
        }

        if (d2[0] == 0 && d2[1] == 0) {

        } else {
            String dd2 = diagonals.get(d2[0]);
            char[] dd2t = dd2.toCharArray();
            dd2t[d2[1]] = newPiece;
            diagonals.set(d2[0], new String(dd2t));
        }
    }
    public void undoMove(int player_piece, int move_position) {

        int row = boardIndex[move_position];
        if (row == 0 || row > TOTALOFROWS) {
            throw new RuntimeException("Illegal undoMove("
                    +player_piece + "," + move_position + ")");
        }
        boardIndex[move_position]--;
        board[row-1][move_position] = 0;
        refreshRCD2(0, row-1, move_position);
    }

    //return: 0 for no win, 1 for player 1 win, 2 for player 2 win
    public int isGameOver() {

        for (String s : rows) {
            if (s.contains("1111")) {
                return 1;
            }
            else if(s.contains("2222")) {
                return 2;
            }
        }
        for (String s : cols) {
            if (s.contains("1111")) {
                return 1;
            }
            else if(s.contains("2222")) {
                return 2;
            }
        }
        for (String s : diagonals) {
            if (s.contains("1111")) {
                return 1;
            }
            else if(s.contains("2222")) {
                return 2;
            }
        }
        return 0;
    }

    public List<Integer> getPossibleMoves() {
        List<Integer> result = new ArrayList();
        for(int column = 0; column < TOTALOFCOLUMNS; column++) {

            if (boardIndex[column] != TOTALOFROWS) {
                result.add(column);
            }
        }
        return result;
    }

    protected void refreshBoard() {
        rows = getRowsAsString();
        cols = getColumnsAsString();
        diagonals = getDiagonalsAsString();
    }
    protected List<String> getRowsAsString() {
        List<String> result = new ArrayList();
        for(int row = 0; row < TOTALOFROWS; row++) {
            String character = "";
            for (int column = 0; column < TOTALOFCOLUMNS; column++) {
                character += board[row][column];
            }
            result.add(character);
        }
        return result;
    }

    protected List<String> getColumnsAsString() {
        List<String> result = new ArrayList();
        for (int columns = 0; columns < TOTALOFCOLUMNS; columns++) {
            String character = "";
            for(int row = 0; row < TOTALOFROWS; row++) {
                character += board[row][columns];
            }
            result.add(character);
        }
        return result;
    }
    protected List<String> getDiagonalsAsString()  {
        List<String> result = new ArrayList();

        int row = 3;
        int columns = 0;
        for (int i = 0; i < 6; i++) {
            String character = "";
            int row_c = row;
            int col_c = columns;
            int count = 0;
            while (row_c >= 0 && col_c < TOTALOFCOLUMNS) {
                position_to_down_right_diagonal[row_c][col_c][0] = i;
                position_to_down_right_diagonal[row_c][col_c][1] = count;
                character += board[row_c][col_c];
                row_c--;
                col_c++;
                count++;
            }

            if (row != TOTALOFROWS - 1) {
                row++;
            } else {

                columns++;
            }
            result.add(character);
        }

        row = 3;
        columns = TOTALOFCOLUMNS -1;
        for (int i = 0; i < 6; i++) {
            String character = "";
            int row_c = row;
            int col_c = columns;
            int count = 0;
            while (row_c >= 0 && col_c >= 0) {
                position_to_down_left_diagonal[row_c][col_c][0]
                        = i+6;
                position_to_down_left_diagonal[row_c][col_c][1]
                        = count;
                character += board[row_c][col_c];
                count++;
                row_c--;
                col_c--;
            }

            if (row != TOTALOFROWS - 1) {
                row++;
            } else {
                columns--;
            }
            result.add(character);
        }

        return result;
    }

}
