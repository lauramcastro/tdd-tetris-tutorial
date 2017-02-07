// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    public static final String ALREADY_FALLING = "already falling";
    
    private final int rows;
    private final int columns;
    private BoardPiece falling_block;
    private BoardPiece board[][];
    private int current_block_row;
    private int current_block_column;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.falling_block = null;
        this.board = new Block[rows][columns];
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if ((falling_block != null) &&
                    (col == current_block_column) && (row == current_block_row)) {
                    s += falling_block.toString();
                } else {
                    if (board[row][col] != null) {
                        s += board[row][col].toString();
                    } else {
                        s += ".";
                    }
                }
            }
            s += "\n";
        }
        return s;
    }

    public boolean hasFalling() {
        if (falling_block == null) {
            return false;
        } else {
            return true;
        }
    }

    public void drop(BoardPiece b) throws IllegalStateException {
        if (falling_block == null) {
            falling_block = b;
            current_block_row = 0;
            current_block_column = this.columns / 2;
        } else {
            throw new IllegalStateException(Board.ALREADY_FALLING);
        }
    }

    public void tick() {
        if (falling_block != null) {
            current_block_row++;
            if ((current_block_row == rows) ||
                (board[current_block_row][current_block_column] != null)) {
                board[current_block_row-1][current_block_column] = falling_block;
                falling_block = null;
            }
        }
    }
    
}
