package classes;

public class Bishop extends Piece {
    public Bishop(int color, Square location) {
        super(color, location);
    }


    @Override
    public boolean canMove(String to) {
        Square destination = location.getChessBoard().getSquareAt(to);

        // Hedef mevcut değil veya kendi taşımızın üzerinde ise hareket geçersiz
        if (destination == null || isSameColor(destination.getPiece())) {
            return false;
        }

        int srcRow = location.getRow();
        int srcCol = location.getCol();
        int destRow = destination.getRow();
        int destCol = destination.getCol();

        // Yatay ve dikey yönlere eşit hareket etmeli
        if (Math.abs(destRow - srcRow) != Math.abs(destCol - srcCol)) {
            return false;
        }

        int rowDirection = destRow > srcRow ? 1 : -1;
        int colDirection = destCol > srcCol ? 1 : -1;

        // Yol boyunca herhangi bir engel var mı kontrol edelim
        int row = srcRow + rowDirection;
        int col = srcCol + colDirection;
        while (row != destRow && col != destCol) {
            Square currentSquare = location.getChessBoard().getSquareAt(row, col);
            if (currentSquare.getPiece() != null) {
                return false; // Yol üzerinde bir engel var
            }
            row += rowDirection;
            col += colDirection;
        }

        return true; // Hareket geçerli
    }


    @Override
    public String toString() {
        return getColor() == ChessBoard.WHITE ? "B" : "b";
    }
}


