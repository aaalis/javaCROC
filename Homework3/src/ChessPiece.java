public class ChessPiece{

    private String name;
    private int x;
    private int y;

    public ChessPiece(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPieceX() {
        return x;
    }

    public void setPieceX(int x) {
        this.x = x;
    }

    public int getPieceY() {
        return y;
    }

    public void setPieceY(int y) {
        this.y = y;
    }
}
