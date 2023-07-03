package classes;

import java.util.Objects;

public class ChessBoard {
    public static final int WHITE = 0;
    public static final int BLACK = 1;

    private Square[][] squares;
    private boolean whitePlaying;
    private boolean gameEnded;

    public ChessBoard() {
        whitePlaying = true;
        gameEnded = false;
        initializeSquares();
        initializeBoard();
    }

    public void checkGameEnd() {
        boolean whiteHasPieces = false;
        boolean blackHasPieces = false;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square square = squares[row][col];
                if (!square.isEmpty()) {
                    if (square.getPiece().getColor() == BLACK) {
                        blackHasPieces = true;
                    } else {
                        whiteHasPieces = true;
                    }
                }
            }
        }

        gameEnded = !(whiteHasPieces && blackHasPieces);
    }

    public void initializeBoard() {
        squares[0][0].setPiece(new Rook(BLACK, squares[0][0]));
        squares[0][1].setPiece(new Knight(BLACK, squares[0][1]));
        squares[0][2].setPiece(new Bishop(BLACK, squares[0][2]));
        squares[0][3].setPiece(new Queen(BLACK, squares[0][3]));
        squares[0][4].setPiece(new King(BLACK, squares[0][4]));
        squares[0][5].setPiece(new Bishop(BLACK, squares[0][5]));
        squares[0][6].setPiece(new Knight(BLACK, squares[0][6]));
        squares[0][7].setPiece(new Rook(BLACK, squares[0][7]));

        squares[7][0].setPiece(new Rook(WHITE, squares[7][0]));
        squares[7][1].setPiece(new Knight(WHITE, squares[7][1]));
        squares[7][2].setPiece(new Bishop(WHITE, squares[7][2]));
        squares[7][3].setPiece(new Queen(WHITE, squares[7][3]));
        squares[7][4].setPiece(new King(WHITE, squares[7][4]));
        squares[7][5].setPiece(new Bishop(WHITE, squares[7][5]));
        squares[7][6].setPiece(new Knight(WHITE, squares[7][6]));
        squares[7][7].setPiece(new Rook(WHITE, squares[7][7]));

        for (int i = 0; i < 8; i++) {
            squares[1][i].setPiece(new Pawn(BLACK, squares[1][i]));
            squares[6][i].setPiece(new Pawn(WHITE, squares[6][i]));
        }
    }


    public boolean isWhitePlaying() {
        return whitePlaying;
    }

    public boolean isGameEnded() {
        checkGameEnd();
        return gameEnded;
    }

    public void nextPlayer() {
        whitePlaying = !whitePlaying;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    A   B   C   D   E   F   G   H\n");
        sb.append("  ________________________________\n");

        for (int row = 0; row < 8; row++) {
            sb.append(8 - row + " |");
            for (int col = 0; col < 8; col++) {
                Square square = squares[row][col];
                if (square.isEmpty()) {
                    sb.append("   |");
                } else {
                    sb.append(" " + square.getPiece().toString() + " |");
                }
            }
            sb.append(" " + (8 - row));
            sb.append("\n");
            sb.append("  ________________________________\n");
        }
        sb.append("    A   B   C   D   E   F   G   H\n");
        return sb.toString();
    }


    private void initializeSquares() {
        squares = new Square[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squares[row][col] = new Square(row, col, this);
            }
        }
    }

    public Square getSquareAt(String location) {
        int col = location.toLowerCase().charAt(0) - 'a';
        int row = 8 - (location.charAt(1) - '0');
        if (isValidSquare(row, col)) {
            return squares[row][col];
        }
        return null;
    }

    public Square getSquareAt(int row, int col) {
        return squares[row][col];
    }

    public Piece getPieceAt(String location) {
        Square square = getSquareAt(location);
        if (square != null) {
            return square.getPiece();
        }
        return null;
    }


    private boolean isValidSquare(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public Square[] getSquaresBetween(Square startSquare, Square endSquare) {
        int startRow = startSquare.getRow();
        int startCol = startSquare.getCol();
        int endRow = endSquare.getRow();
        int endCol = endSquare.getCol();

        int rowDistance = Math.abs(endRow - startRow);
        int colDistance = Math.abs(endCol - startCol);
        int squaresCount = Math.max(rowDistance, colDistance) - 1;
        Square[] squaresBetween = new Square[squaresCount];

        int rowDirection = rowDistance == 0 ? 0 :endRow > startRow ? 1 : -1;
        int colDirection = colDistance == 0 ? 0 : endCol > startCol ? 1 : -1;

        int currentRow = startRow + rowDirection;
        int currentCol = startCol + colDirection;

        for (int i = 0; i < squaresCount; i++) {
            squaresBetween[i] = squares[currentRow][currentCol];
            currentRow += rowDirection;
            currentCol += colDirection;
        }

        return squaresBetween;
    }
}

