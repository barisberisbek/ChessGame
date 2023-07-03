package classes;

public class Rook extends Piece {
    public Rook(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        Square destination = location.getChessBoard().getSquareAt(to);

        // Hedef mevcut değil veya kendi taşımızın üzerinde ise hareket geçersiz
        if (destination == null || isSameColor(destination.getPiece())) {
            return false;
        }

        int srcRow = getLocation().getRow();
        int srcCol = getLocation().getCol();
        int destRow = destination.getRow();
        int destCol = destination.getCol();

        // Yatay veya dikey yönde hareket etmeli
        if (srcRow != destRow && srcCol != destCol) {
            return false;
        }

        // Yol boyunca herhangi bir engel var mı kontrol edelim
        if (srcRow == destRow) {
            // Yatay hareket
            int colDirection = destCol > srcCol ? 1 : -1;
            int col = srcCol + colDirection;
            while (col != destCol) {
                Square currentSquare = location.getChessBoard().getSquareAt(srcRow, col);
                if (currentSquare.getPiece() != null) {
                    return false; // Yol üzerinde bir engel var
                }
                col += colDirection;
            }
        } else {
            // Dikey hareket
            int rowDirection = destRow > srcRow ? 1 : -1;
            int row = srcRow + rowDirection;
            while (row != destRow) {
                Square currentSquare = location.getChessBoard().getSquareAt(row, srcCol);
                if (currentSquare.getPiece() != null) {
                    return false; // Yol üzerinde bir engel var
                }
                row += rowDirection;
            }
        }

        return true; // Hareket geçerli
    }

    @Override
    public String toString() {
        return getColor() == ChessBoard.WHITE ? "R" : "r";
    }
}

