// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private Block falling_block;
    private int current_block_row;
    private int current_block_column;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.falling_block = null;
        this.current_block_row = 0;
        this.current_block_column = this.columns / 2;
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if ((falling_block != null) &&
                    (col == current_block_column) && (row == current_block_row)) {
                    s += falling_block.toString();
                } else {
                    s += ".";
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

    public void drop(Block b) {
        falling_block = b;
    }
    
}
