package tetris;

public class Piece {

    private static final String TWO_BLOCK_PIECE_VERTICAL   = ".X.\n.X.\n";
    private static final String TWO_BLOCK_PIECE_HORIZONTAL = "XX\n";
    
    private String piece;
    
    public Piece(String piece) {
        this.piece = piece;
    }

    public String toString() {
        return piece;
    }

    public Piece rotateRight() {
        return new Piece("...\n" + Piece.TWO_BLOCK_PIECE_HORIZONTAL + "...\n");
    }

}
