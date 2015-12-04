/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  File:    Column.java
  Date:    June 4, 2010
  Author:  Bill Dell'Anno
  Purpose: object that has 6 spaces for pieces to fill
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

public class Column {

    int[] spaces; // array for all 6 spots in the column

    public Column() { // constructor for new column
        spaces = new int[6];
        refreshColumn();
    }

    public void refreshColumn() { // sets all spots in the column = 0 (unoccupied)
        for (int s : spaces) {
            s = 0; // 0 = unocupied
        }
    }

    public int getNumOccupied() { // returns the number of spaces occupied
        int num = 0;
        for (int i : spaces) {
            if (i != 0) {
                num++;
            }
        }
        return num;
    }

    public boolean isOccupied(int spc) { // returns true if space is occupied
        return spaces[spc] != 0;
    }

    public void placePiece(int player, int spc) { // sets space equal to player number
        spaces[spc] = player;
    }

    public int getOccupiedBy(int spc) { // returns which player is occupying a space
        return spaces[spc];
    }

}
