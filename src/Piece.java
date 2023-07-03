package classes;

public abstract class Piece {
    protected int color;
    protected Square location;

    protected boolean captured;

    public Piece(int color, Square location) {
        this.color = color;
        this.location = location;
        this.captured = false;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    public int getColor() {
        return color;
    }

    public Square getLocation() {
        return location;
    }

    public boolean isSameColor(Piece piece) {
        if (piece != null && piece.color == this.color) {
            return true;
        }
        return false;
    }

    public boolean canPieceMove() {
        boolean canMove = false;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                String to = String.valueOf((char)('A' + col)) + (row + 1);
                if (canMove(to)) {
                    canMove = true;
                    break;
                }
            }
        }
        return canMove;
    }


    public abstract boolean canMove(String to);

    public  void move(String to){
        Square destination = location.getChessBoard().getSquareAt(to);
        if (canMove(to)) {
            Piece capturedPiece = destination.getPiece();
            destination.setPiece(this);
            location.clear();
            location = destination;
            // Hedefte taş varsa yakalanmıştır
            if (capturedPiece != null) {
                capturedPiece.setCaptured(true);
            }
            location.getChessBoard().nextPlayer();
        }
    }

    @Override
    public abstract String toString();
}

