// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    public  static final String ALREADY_FALLING = "already falling";
    private static final char   EMPTY = '.';
    
    private final int rows;
    private final int columns;
    private BoardPiece falling_block;
    private int current_block_row;
    private int current_block_column;
    private char board[][];
    private boolean last_tick;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.falling_block = null;
        this.board = new char[rows][columns];
        fill_with(board, Board.EMPTY);
        this.last_tick = false;
    }

    public String toString() {
        String s = "";
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (falling_block_is_at(i,j)) {
                    char block[][] = new char[falling_block.width()][falling_block.height()];
                    fill_with(block, falling_block.toString());
                    s += block[(i-current_block_row)][(j-current_block_column)];
                } else {
                    char c[] = { board[i][j] };
                    s += new String(c);
                }
            }
            s += "\n";
        }
        return s;
    }

    public boolean hasFalling() {
        return ((falling_block != null) || last_tick);
    }

    public void drop(BoardPiece b) throws IllegalStateException {
        if ((falling_block == null) || (last_tick)) {
            falling_block = b;
            current_block_row = 0;
            current_block_column = (this.columns / 2) - (b.width() / 2);
        } else {
            throw new IllegalStateException(Board.ALREADY_FALLING);
        }
    }

    public void tick() {
        if (falling_block != null) {
            current_block_row++;
            if (reached_bottom() || touched_another_block()) {
                fill_with(board, toString());
                falling_block = null;
                last_tick = true;
            }
        } else {
            last_tick = false;
        }
    }

    private void fill_with(char matrix[][], char c) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[i][j] = c;
            }
        }
    }

    private void fill_with(char matrix[][], String s) {
        String[] rows = s.split("\n");
        for (int i=0; i<rows.length; i++) {
            char[] column = rows[i].toCharArray();
            for (int j=0; j<column.length; j++) {
                matrix[i][j] = column[j];
            }
        }
    }

    private boolean reached_bottom() {
        int reached_row = current_block_row;
        String[] s = falling_block.toString().split("\n");

        for (int i=0; i<s.length; i++) {
            if (s[i].replace(Board.EMPTY, ' ').trim().length() != 0) {
                reached_row++;
            }
        }

        return (reached_row == rows);
    }

    private boolean touched_another_block() {
        for (int i=0; i<rows-1; i++) {
            for (int j=0; j<columns; j++) {
                if ((board[i+1][j] != Board.EMPTY) &&
                    falling_block_is_at(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean falling_block_is_at(int row, int column) {
        if (falling_block != null) {
            return ((current_block_row <= row) &&
                    (row < current_block_row + falling_block.height()) &&
                    (current_block_column <= column) &&
                    (column < current_block_column + falling_block.width()));
        } else {
            return false;
        }
    }
    
}
