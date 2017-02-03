package tetris;

public class Block {

    private final char block;

    public Block(char block) {
        this.block = block;
    }

    public String toString() {
        char block_as_string[] = { block };
        return new String(block_as_string);
    }

}
