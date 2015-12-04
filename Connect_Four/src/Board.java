/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 File:    Board.java
 Date:    6/4/10
 Author:  Bill Dell'Anno
 Purpose: Creates a board object with an array of 7 column objects
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/


public class Board {

    Column[] columns = new Column[7];

    public Column getColumn(int col) {
        return columns[col];
    }

    public void buildColumns() { // creates instance of 7 new towers
        columns[0] = new Column();
        columns[1] = new Column();
        columns[2] = new Column();
        columns[3] = new Column();
        columns[4] = new Column();
        columns[5] = new Column();
        columns[6] = new Column();
    }

}
