package tetris;

public class Tetromino {

    public static final Tetromino T_SHAPE = new Tetromino(new Piece(".T.\nTTT\n..."));

    private Piece piece;
    
    private Tetromino(Piece piece) {
        this.piece = piece;
    }

    public String toString() {
        return piece.toString();
    }

    public Tetromino rotateRight() {
        return new Tetromino(piece.rotateRight());
    }

    public Tetromino rotateLeft() {
        return new Tetromino(piece.rotateLeft());
    }
    
}
