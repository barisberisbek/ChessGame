package classes;

import java.util.ArrayList;

public class Pawn extends Piece {
    boolean initialLocation = true;

    public Pawn(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getChessBoard().getSquareAt(to);
        if (targetLocation == null || isSameColor(targetLocation.getPiece())) {
            return false;
        }
        int rowDistance = targetLocation.getRowDistance(location);

        if (this.location.isAtSameColumn(targetLocation)) {
            if (color == ChessBoard.WHITE && rowDistance > 0 && rowDistance <= 2) {
                if (rowDistance == 2) {
                    Square[] between = location.getChessBoard().getSquaresBetween(location, targetLocation);
                    if (initialLocation) {
                        validMove = targetLocation.isEmpty() && between[0].isEmpty();
                    }
                } else {
                    validMove = targetLocation.isEmpty();
                }
            } else if (color == ChessBoard.BLACK && rowDistance < 0 && rowDistance >= -2) {
                if (rowDistance == -2) {
                    Square[] between = location.getChessBoard().getSquaresBetween(location, targetLocation);
                    if (initialLocation) {
                        validMove = targetLocation.isEmpty() && between[0].isEmpty();
                    }
                } else {
                    validMove = targetLocation.isEmpty();
                }
            }
        } else if (this.location.isNeighborColumn(targetLocation)) {
            if (color == ChessBoard.WHITE && rowDistance == 1) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() == ChessBoard.BLACK;
            } else if (color == ChessBoard.BLACK && rowDistance == -1) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() == ChessBoard.WHITE;
            }
        }

        return validMove;
    }

    @Override
    public void move(String to) {
        Square destination = location.getChessBoard().getSquareAt(to);
        if (canMove(to)) {
            Piece capturedPiece = destination.getPiece();
            if (destination.isAtLastRow(color)) {
                destination.putNewQueen(color);
            } else {
                destination.setPiece(this);
            }

            location.clear();
            location = destination;
            // Hedefte taş varsa yakalanmıştır
            if (capturedPiece != null) {
                capturedPiece.setCaptured(true);
            }
            if (initialLocation) {
                initialLocation = false;
            }
            location.getChessBoard().nextPlayer();
        }
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "P" : "p";
    }
}
