package classes;

public class King extends Piece {
    public King(int color, Square location) {
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

        // Hedef konum ile kaynak konum arasındaki mesafe
        int rowDistance = Math.abs(destRow - srcRow);
        int colDistance = Math.abs(destCol - srcCol);

        // Sadece tek bir kare ileri/geri, sola/sağa veya çapraz hareket edebilir
        return rowDistance <= 1 && colDistance <= 1;
    }



    @Override
    public String toString() {
        return getColor() == ChessBoard.WHITE ? "K" : "k";
    }
}
