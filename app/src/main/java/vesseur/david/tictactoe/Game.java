package vesseur.david.tictactoe;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;

import java.util.Random;

/**
 * Created by Gebruiker on 17-4-2018.
 */


public class Game {
    final private int BOARD_SIZE = 3;
    private Tile[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }
    public void reset() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        playerOneTurn = true;
        gameOver = false;


    }

    public int [] computerMove(){
        int row = 0;
        int column = 0;
        int turn = 0;
        while(turn == 0){
            Random rand = new Random();
            row = rand.nextInt(3);
            rand = new Random();
            column = rand.nextInt(3);
            if (board[row][column] == Tile.BLANK){
                if (playerOneTurn){
                    board[row][column] = Tile.CROSS;
                    turn = 1;
                    playerOneTurn = false;
                }
                else{
                    board[row][column] = Tile.CIRCLE;
                    turn = 2;
                    playerOneTurn = true;
                }

            }
        }

        return new int[]{row, column, turn};
    }

    public Tile draw(int row, int column) {

        if (board[row][column] == Tile.BLANK){

            if (playerOneTurn == true){
                movesPlayed += 1;
                board[row][column] = Tile.CROSS;
                playerOneTurn = false;
                return Tile.CROSS;
            }
            if (playerOneTurn == false){
                movesPlayed += 1;
                board[row][column] = Tile.CIRCLE;
                playerOneTurn = true;
                return Tile.CIRCLE;
            }
        }
        return Tile.INVALID;
    }

    public int checkWin(){


        int countX = 0;
        int countO = 0;
        // check for three in a row vertical
        for (int j = 0; j < BOARD_SIZE; j++) {

            countX = 0;
            countO = 0;
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[i][j] == Tile.CROSS) {
                    countX += 1;
                }
                if (board[i][j] == Tile.CIRCLE) {
                    countO += 1;
                }
                if (countX == 3) {
                    return 2;
                }
                if (countO == 3) {
                    return 3;
                }
            }
        }
        // check for three in a row horizontal
        for (int j = 0; j < BOARD_SIZE; j++) {

            countX = 0;
            countO = 0;
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[j][i] == Tile.CROSS) {
                    countX += 1;
                }
                if (board[j][i] == Tile.CIRCLE) {
                    countO += 1;
                }
                if (countX == 3) {
                    return 2;
                }
                if (countO == 3) {
                    return 3;
                }
            }
        }
        // check for three in a row diagonal
        countX = 0;
        countO = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {

            if (board[i][i] == Tile.CROSS) {
                countX += 1;
            }
            if (board[i][i] == Tile.CIRCLE) {
                countO += 1;
            }
            if (countX == 3) {
                return 2;
            }
            if (countO == 3) {
                return 3;
            }
        }
        countX = 0;
        countO = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {

            if (board[BOARD_SIZE - 1 - i][BOARD_SIZE - 1 - i] == Tile.CROSS) {
                countX += 1;
            }
            if (board[BOARD_SIZE - 1 - i][BOARD_SIZE - 1 - i] == Tile.CIRCLE) {
                countO += 1;
            }
            if (countX == 3) {
                return 2;

            }
            if (countO == 3) {
                return 3;
            }
        }
        // return 1 when draw
        if (movesPlayed == 9){
            return 1;
        }
        return 0;
    }
}
