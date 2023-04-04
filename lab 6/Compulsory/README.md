Graphical User Interfaces (Swing, JavaFX)
Consider a positional game played on board containing a number of dots placed on a circle. Some dots are connected to other dots using lines. Initially, the existing lines are gray (not colored).
Two players take turns coloring any uncolored lines. One player colors in one color (red), and the other colors in another color (blue).
Variant 1: Each player tries to create a triangle made solely of his color. The player who succeeds, wins the game.
Variant 2: Each player tries to avoid the creation of a triangle made solely of his color. The player who cannot avoid creating such a triangle, loses the game.

In order to create a graphical user interface for the game, you may use either Swing or JavaFX.

https://profs.info.uaic.ro/~acf/java/labs/game.png

- Create the object oriented model of the game. Consider implementing a retained mode for drawing the game board.
- Implement the logic of the game. Use a mouse listener in order to select the line which must be colored, either by selecting the dots or the line itself. Validate the moves, according to the game rules. Determine the winner of the game.
- Export the current image of the game board into a PNG file.
- Use object serialization in order to save and restore the current status of the game.
