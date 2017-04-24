package inteligencia_artificial;

import java.util.ArrayList;
import java.util.List;

public class Computer extends User {

    private String name;

    private int player_me;

    private String piece;

    public Computer(String piece, String name){
        this.piece = piece;
        this.name = name;
    }

    public String getPiece(){
        return this.piece;
    }

    public String getUserName(){
        return this.name;
    }

    public int generateMove(int player, Board board) {
        player_me = player;
        return alphabetaHelper(player, board);
    }

    public int alphabetaHelper(int player, Board board) {
        List<Integer> moves = board.getPossibleMoves();
        List<Double> values = new ArrayList();

        double alpha = Double.NEGATIVE_INFINITY;
        double beta = Double.POSITIVE_INFINITY;

        int bestMove = -1;
        double bestValue = (player_me == player) ? alpha : beta;
        int depth = 6;

        //depth is depth +1
        switch(moves.size()) {
            case 7: depth = 6; break;
            case 6: depth = 7; break;
            case 5: depth = 8; break;
            case 4: depth = 9; break;
            case 3: depth = 12;break;
            case 2: depth = 19;break;
            default: depth = 7;
        }

        for(int m : moves) {
            board.makeMove(player, m);
            double score = alphabeta(
                        otherPlayer(player), board, alpha, beta, depth);
            board.undoMove(player, m);
            
            score += (double)(weights[board.boardIndex[m]][m])/100;
            
            values.add(score);

            if(player_me == player) {
                if (score > bestValue) {
                    bestValue = score;
                    bestMove = m;
                }
            } else {
                if (score < bestValue) {
                    bestValue = score;
                    bestMove = m;
                }
            }
        }
        return bestMove;
    }

    public double alphabeta(int player, Board node,double alpha, double beta, int depth) {

        if (depth == 0 || node.isGameOver() != 0) {
            return evaluate(player, node, depth);
        }

        if (player == player_me) {
            double score = alpha;
            for(int move : node.getPossibleMoves()) {
                node.makeMove(player, move);
                score = alphabeta(
                        otherPlayer(player), node, alpha, beta, depth-1);
                node.undoMove(player, move);

                if (score > alpha)
                    alpha = score;
                if (alpha >= beta)
                    return alpha;
            }
            return alpha;
        }
        else {
            double score = beta;
            for(int move : node.getPossibleMoves()) {
                node.makeMove(player, move);
                score = alphabeta(
                        otherPlayer(player), node, alpha, beta, depth-1);
                node.undoMove(player, move);

                if (score < beta)
                    beta = score;
                if (alpha >= beta)
                    return beta;
            }
            return beta;
        }
    }

    public static final int[][] weights =
        { {0, 1, 2, 3, 2, 1, 0}, {1, 2, 3, 4, 3, 2, 1}, {2, 3, 4, 5, 4, 3, 2},
        {3, 4, 5, 6, 5, 4, 3}, {2, 3, 4, 5, 4, 3, 2}, {1, 2, 3, 4, 3, 2, 1}};

    public double evaluate(int player, Board board, int depth) {

        List<String> mega = new ArrayList();
        mega.addAll(board.rows);
        mega.addAll(board.cols);
        mega.addAll(board.diagonals);

        double result = 0;

        if (player_me == 1) {
            megasearch:
            for (String s : mega) {
                if (s.contains("1111")) {
                    result = 1000;
                    break megasearch;
                }
                else if(s.contains("2222")) {
                    result = -1000;
                    break megasearch;
                }
                if (s.contains("01110")) {
                    result += 150;
                }
                else if(s.contains("0111") || s.contains("1110")) {
                    result += 100;
                }
                else if(s.contains("1011") || s.contains ("1101")) {
                    result += 90;
                }
                else if (s.contains("1100") || s.contains("0011")) {
                    result += 10;
                }
                else if (s.contains("0110")) {
                    result += 10;
                }
                if (s.contains("2111") || s.contains("1112")) {
                    result -= 50;
                }
                else if (s.contains("1211") || s.contains("1121")) {
                    result -= 45;
                }
                if(s.contains("02220")) {
                    result -= 152;
                }
                else if(s.contains("2220") || s.contains("2220")) {
                    result -= 102;
                }
                else if(s.contains("2022") || s.contains ("2202")) {
                    result -= 92;
                }
                else if (s.contains("2200") || s.contains("0022")) {
                    result -= 10;
                }
                else if (s.contains("0220")) {
                    result -= 10;
                }
            }
        } else {
            megasearch:
            for (String s : mega) {
                if (s.contains("2222")) {
                    result = 1000;
                    break megasearch;
                }
                else if(s.contains("1111")) {
                    result = -1000;
                    break megasearch;
                }
                if (s.contains("02220")) {
                    result += 150;
                }
                else if(s.contains("0222") || s.contains("2220")) {
                    result += 100;
                }
                else if(s.contains("2022") || s.contains ("2202")) {
                    result += 90;
                }
                else if (s.contains("220") || s.contains("022")) {
                    result += 10;
                }
                if (s.contains("1222") || s.contains("2111")) {
                    result -= 50;
                }
                else if (s.contains("2122") || s.contains("2212")) {
                    result -= 45;
                }
                if (s.contains("01110")) {
                    result -= 152;
                }
                else if(s.contains("1110") || s.contains("1110")) {
                    result -= 102;
                }
                else if(s.contains("1011") || s.contains ("1101")) {
                    result -= 92;
                }
                else if (s.contains("110") || s.contains("011")) {
                    result -= 10;
                }
            }

        }
        if (result > 0) {
            result += (double)depth/10;
        } else {
            result -= (double) depth/10;
        }
        return result;
    }
    public int otherPlayer(int player) {
        return (player == 1) ? 2 : 1;
    }
}
