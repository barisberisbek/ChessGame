package classes;

public class Knight extends Piece {
    public Knight(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        Square destination = location.getChessBoard().getSquareAt(to);

        if (destination == null || isSameColor(destination.getPiece())) {
            return false;  // Invalid destination or occupied by same color
        }

        int currentRow = getLocation().getRow();
        int currentCol = getLocation().getCol();
        int targetRow = destination.getRow();
        int targetCol = destination.getCol();

        int rowDiff = Math.abs(currentRow - targetRow);
        int colDiff = Math.abs(currentCol - targetCol);

        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }


    @Override
    public String toString() {
        return getColor() == ChessBoard.WHITE ? "N" : "n";
    }
}
