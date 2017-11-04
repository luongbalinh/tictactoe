# tictactoe

## Convert the non-OO into an object-oriented program
1.  Create:
    * **Cell** class represents a cell of the board.
    * **GameState** enum represents all possible states of the game.
    * **Seed** enum represents all possible statuses of a cell. **toString()** is overwritten to simplify the printing of the board.
    * **Board3x3** class represents the board.
    * **Game** class handles the game.
    * **TTTOO2P3x3** class is the main entry into the game.
    * Classes hide attributes and expose necessary methods.
    

2. Follow good practices: 
    * Meaningful naming, i.e. descriptive and pronounceable names
    * Top-down rule (public methods are on the top, then follow by private dependent methods)
    * Single responsibility principle
    * Avoid code duplication     

## Generalize the 3x3 tic-tac-toe game
The generalized version of tic-tac-toe supports boards of arbitrary sizes (m, n) and win condition (k consecutive cells of the same type).
An important change compared to 3x3 OO version is that 
   ```
   private Cell playerMove(Seed seed) {
   ```
returns a **Cell** instead of **void** that helps the implementation of method 
   ```
   private void updateGame(Cell cell) {
   ```
## Testing
**Board** has a method
```
public static boolean checkWin(Seed[] a, int currentCol, int winLength) {
```
that is used in checking whether a move leads to a win or not. Basically, given a array of seeds (*a*), an position in the array (*index*), 
and a win condition (*winLength*), this method returns **true** if there are *winLength* consecutive elements of **a** that have the same value as *a[index]*.
The idea is that we start from index, move to the left, then the right, and count the number of consecutive cells of value *a[index]*. The algorithm will
be stopped immediately when it found *winLength* such elements.

**JUnitParams** is utilized to test checkWin() for several cases.
   
