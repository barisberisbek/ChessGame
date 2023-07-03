 # ChessGame
This game is a chess application that allows users to play chess against each other.

**** This chess game has different features from other chess games ****



    ChessBoard                 Square
 ----------------        ----------------
|                  |   1  |  attributes  |
|                  |----- |   Piece      |
|                  |     |              |
 ----------------        ----------------
          ^
          |
          |               ----------------
          |-------------- |   Piece      |
          | 1          1  ----------------
          |              |  attributes  |
          |              |  methods     |
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

## Usage

1. Start the project by running the `main.java'
2. Follow the instructions in the command line to make moves and play the game.

## Features
1.You can end the game when no pieces exist from one color
2.Pawn can only becomes a Queen at the last row.
3.Absolute pin: a piece can be played even it would put the King into check (This means that you can assume Kings can be captured as normal pieces.)
4.After a Pawn moves two squares from its starting square, and it could have been captured by an enemy Pawn had it advanced only one square.
5.Pawn is only promoted to Queen

## Contributing

1. Fork the repository 
2. Create a new branch (`git checkout -b feature/new-feature`)
3. Make your changes
4. Commit your changes (`git commit -am 'Add a descriptive message about your changes'`)
5. Push your branch (`git push origin feature/new-feature`)
6. Open a Pull Request

## License

This project is licensed under the MIT License. See the `LICENSE` file for more information.
