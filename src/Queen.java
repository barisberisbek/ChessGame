package classes;

public class Queen extends Piece {
    public Queen(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        Square targetSquare = location.getChessBoard().getSquareAt(to);

        if (targetSquare == null || isSameColor(targetSquare.getPiece())) {
            return false;
        }

        int currentRow = location.getRow();
        int currentCol = location.getCol();
        int targetRow = targetSquare.getRow();
        int targetCol = targetSquare.getCol();


        // Check if the move is along a diagonal
        if (Math.abs(currentRow - targetRow) == Math.abs(currentCol - targetCol)) {
            int rowDirection = (targetRow - currentRow) > 0 ? 1 : -1;
            int colDirection = (targetCol - currentCol) > 0 ? 1 : -1;

            int row = currentRow + rowDirection;
            int col = currentCol + colDirection;
            while (row != targetRow && col != targetCol) {
                Square currentSquare = location.getChessBoard().getSquareAt(row, col);
                if (currentSquare.getPiece() != null) {
                    return false; // Yol üzerinde bir engel var
                }
                row += rowDirection;
                col += colDirection;
            }
            return true;
        }

        // Check if the move is along a row or column
        if (currentRow == targetRow || currentCol == targetCol) {
            int rowDirection = currentRow == targetRow ? 0 : (targetRow - currentRow) > 0 ? 1 : -1;
            int colDirection = currentCol == targetCol ? 0 : (targetCol - currentCol) > 0 ? 1 : -1;

            // Yol boyunca herhangi bir engel var mı kontrol edelim
            if (rowDirection == 0) {
                int col = currentCol + colDirection;
                while (col != targetCol) {
                    Square currentSquare = location.getChessBoard().getSquareAt(currentRow, col);
                    if (currentSquare.getPiece() != null) {
                        return false; // Yol üzerinde bir engel var
                    }
                    col += colDirection;
                }
            } else {
                int row = currentRow + rowDirection;
                while (row != targetRow) {
                    Square currentSquare = location.getChessBoard().getSquareAt(row, currentCol);
                    if (currentSquare.getPiece() != null) {
                        return false; // Yol üzerinde bir engel var
                    }
                    row += rowDirection;
                }
            }

            return true;
        }

        return false;
    }


    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "Q" : "q";
    }
}

