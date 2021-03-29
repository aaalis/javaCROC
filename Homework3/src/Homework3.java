public class Homework3 {
    public static void main(String[] args) {
        //region TestData
        ChessBoard chessBoard = new ChessBoard();

        chessBoard.chessPieces.add(new ChessPiece("Queen",1,1));
        chessBoard.chessPieces.add(new ChessPiece("King",8,8));

        System.out.println(chessBoard.toString());

        System.out.println(chessBoard.MoveChessPiece(0, 2, 2) + "\n");

        System.out.println(chessBoard.toString());

        System.out.println(chessBoard.MoveChessPiece(0, -1, 4) + "\n");

        System.out.println(chessBoard.toString());

        //endregion
    }
}
