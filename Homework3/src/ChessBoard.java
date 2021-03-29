import java.util.ArrayList;

public class ChessBoard{

    private final int x = 8;
    private final int y = 8;
    public ArrayList<ChessPiece> chessPieces;

    public ChessBoard() {
        chessPieces = new ArrayList<>();
    }

    private boolean CheckArgument(int arg) throws IllegalArgumentException{
        if (arg > 8 | arg < 1)
            throw new IllegalArgumentException("Значения выходят за пределы шахматной доски");
        else
            return true;
    }

    public String MoveChessPiece(int index, int increaseX, int increaseY){
        ChessPiece tempChessPiece = chessPieces.get(index);
        int newX = tempChessPiece.getPieceX() + increaseX;
        int newY = tempChessPiece.getPieceY() + increaseY;
        if (CheckArgument(newX) & CheckArgument(newY)) {
            tempChessPiece.setPieceX(newX);
            tempChessPiece.setPieceY(newY);
            return "Фигура '" + tempChessPiece.getName()
                    + "' передвинута на позицию "
                    + ConvertToAlphabet(tempChessPiece.getPieceX())
                    + tempChessPiece.getPieceY();
        }
        return null;
    }

    private String ConvertToAlphabet(int i){
        return  String.valueOf((char)(i + 'A' - 1));
    }

    @Override
    public String toString() {
        String report = "Текущие фигуры: \n";
        for (ChessPiece cp: chessPieces) {
            report = report + cp.getName() + " с координатами "
                    + ConvertToAlphabet(cp.getPieceX())
                    + cp.getPieceY() + "\n";
        }
        return report;
    }
}
