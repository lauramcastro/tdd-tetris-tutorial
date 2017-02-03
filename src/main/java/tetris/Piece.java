package tetris;

public class Piece {

    private Block[][] blocks;
    
    public Piece(String piece) {
        String[] rows = piece.split("\n");
        for (int i=0; i<rows.length; i++) {
            char[] column = rows[i].toCharArray();
            for (int j=0; j<column.length; j++) {
                if ((i==0) && (j==0)) {
                    blocks = new Block[rows.length][column.length];
                }
                blocks[i][j] = new Block(column[j]);
            }
        }
    }

    public String toString() {
        String s = "";
        if (blocks != null) {
            for (int i=0; i<blocks.length; i++) {
                for (int j=0; j<blocks[i].length; j++) {
                    s += blocks[i][j].toString();
                }
            s += "\n";
            }
        }
        return s;
    }

    public Piece rotateRight() { // transpose + reverse each row
        Block[][] transposedBlocks = transpose(blocks);
        Block[][] newBlocks = new Block[transposedBlocks.length][transposedBlocks[0].length];
        for (int i=0; i<transposedBlocks.length; i++) {
            for (int j=0; j<transposedBlocks[i].length; j++) {
                newBlocks[i][j] = transposedBlocks[i][transposedBlocks[i].length-j-1];
            }
        }
        return new Piece(newBlocks);
    }

    public Piece rotateLeft() { // transpose + reverse each column
        Block[][] transposedBlocks = transpose(blocks);
        Block[][] newBlocks = new Block[transposedBlocks.length][transposedBlocks[0].length];
        for (int i=0; i<transposedBlocks.length; i++) {
            for (int j=0; j<transposedBlocks[i].length; j++) {
                newBlocks[i][j] = transposedBlocks[transposedBlocks.length-i-1][j];
            }
        }
        return new Piece(newBlocks);
    }

    private Block[][] transpose(Block blocks[][]) {
        Block[][] transposedBlocks = new Block[blocks.length][blocks[0].length];
        for (int i=0; i<blocks.length; i++) {
            for (int j=0; j<blocks[i].length; j++) {
                transposedBlocks[j][i] = blocks[i][j];
            }
        }
        return transposedBlocks;
    }

    private Piece(Block blocks[][]) {
        this.blocks = blocks;
    }
    
}
