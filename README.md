# Chess Game ♟️

This game is a chess application that allows users to play chess against each other.

**** This chess game has different features from other chess games ****
```
    ChessBoard                 Square
 ----------------        ----------------
|                  |   1 |  Attributes  |
|                  |-----|   Piece      |
|                  |     |              |
 ----------------        ----------------
          ^
          |
          |              ----------------
          |------------- |   Piece      |
          | 1          1 ----------------
          |              |  Attributes  |
          |              |  Methods     |
          |              ----------------
          |
          |
 ----------------
|      King       |
|      Queen      |
|      Rook       |
|      Bishop     |
|      Knight     |
|      Pawn       |
 ----------------
```
## Usage

1. Start the project by running the `main.java' file.
2. Follow the instructions in the command line to make moves and play the game.

## Features
1. You can end the game when no pieces exist from one color.
2. Pawn can only become a Queen at the last row.
3. Absolute pin: A piece can be played even if it would put the King into check (This means that you can assume Kings can be captured as normal pieces).
4. After a Pawn moves two squares from its starting square, and it could have been captured by an enemy Pawn had it advanced only one square.
5. Pawn is only promoted to Queen.
6. End game control: The game will end when no pieces remain for one color.
7. Promote: Pawns will be automatically promoted to Queens when they reach the last row.
8. Basic movement rules for all pieces: The game allows legal moves for each piece type (excluding complex rules like checkmate, en passant, and absolute pin).

## 🖥️ Board Representation

The chessboard is represented in the command-line interface as a grid of squares. Each square can contain a piece, represented by specific symbols:

- P for White Pawn
- R for White Rook
- N for White Knight
- B for White Bishop
- Q for White Queen
- K for White King
- p for Black Pawn
- r for Black Rook
- n for Black Knight
- b for Black Bishop
- q for Black Queen
- k for Black King

```

   A | B | C | D | E | F | G | H |
  ________________________________
8| r | n | b | q | k | b | n | r |
  ________________________________
7| p | p | p | p | p | p | p | p |
  ________________________________
6|   |   |   |   |   |   |   |   |
  ________________________________
5|   |   |   |   |   |   |   |   |
  ________________________________
4|   |   |   |   |   |   |   |   |
  ________________________________
3|   |   |   |   |   |   |   |   |
  ________________________________
2| P | P | P | P | P | P | P | P |
  ________________________________
1| R | N | B | Q | K | B | N | R |
  ________________________________
   A | B | C | D | E | F | G | H |

```
## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/new-feature`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add a descriptive message about your changes'`).
5. Push your branch (`git push origin feature/new-feature`).
6. Open a Pull Request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more information.

