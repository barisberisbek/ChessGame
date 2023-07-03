package classes;

public class Square {
    private int row;
    private int col;
    private Piece piece;

    private ChessBoard chessBoard;

    public Square(int row, int col, ChessBoard chessBoard) {
        this.row = row;
        this.col = col;
        this.piece = null;
        this.chessBoard = chessBoard;
    }

    public void putNewQueen(int color) {
        setPiece(new Queen(color, this));
    }


    public int getRowDistance(Square otherSquare) {
        return otherSquare.getRow() - this.getRow();
    }

    public boolean isNeighborColumn(Square otherSquare) {
        int colDifference = Math.abs(this.getCol() - otherSquare.getCol());
        return colDifference == 1;
    }

    public boolean isAtLastRow(int color) {
        int row = getRow();
        return (color == ChessBoard.WHITE && row == 0) ||
                (color == ChessBoard.BLACK && row == 7);
    }

    public boolean isAtSameColumn(Square otherSquare) {
        return this.getCol() == otherSquare.getCol();
    }

    public ChessBoard getChessBoard(){
        return chessBoard;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void clear() {
        piece = null;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    @Override
    public String toString() {
        if (piece != null) {
            return piece.toString();
        } else {
            return "-";
        }
    }
}
