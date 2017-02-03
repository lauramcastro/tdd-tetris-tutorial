package tetris;

public class Piece {

    private static final String TWO_BLOCK_PIECE_VERTICAL_CENTERED = ".X.\n.X.\n";
    private static final String TWO_BLOCK_PIECE_HORIZONTAL_LEFT = "XX.\n";
    private static final String TWO_BLOCK_PIECE_HORIZONTAL_RIGHT = ".XX\n";
    
    private String piece;
    
    public Piece(String piece) {
        this.piece = piece;
    }

    public String toString() {
        return piece;
    }

    public Piece rotateRight() {
        if (piece.indexOf(Piece.TWO_BLOCK_PIECE_VERTICAL_CENTERED) != -1) {
            return new Piece("...\n" +
                             Piece.TWO_BLOCK_PIECE_HORIZONTAL_RIGHT +
                             "...\n");
        }
        return new Piece(piece);
    }

    public Piece rotateLeft() {
        if (piece.indexOf(Piece.TWO_BLOCK_PIECE_VERTICAL_CENTERED) != -1) {
            return new Piece("...\n" +
                             Piece.TWO_BLOCK_PIECE_HORIZONTAL_LEFT +
                             "...\n");
        }
        return new Piece(piece);
    }

}
