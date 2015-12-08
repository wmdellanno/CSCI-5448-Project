/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 File:    TowerModel.java
 Date:    01/24/10
 Author:  Bill Dell'Anno
 Purpose: Creates array of three towers and contains logic to verify moves
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

import javax.swing.*;

public class TowerModel {

    Tower[] towers = new Tower[3]; //array of three towers

    public boolean checkMove(int to, int from) { // returns true if move is legal
        if (towers[from].emptyTower()) { // if tower does not have any discs, gives error message
            JOptionPane.showMessageDialog(null, "There are no discs to move.",
                                          "Movement Error",
                                          JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (towers[to].emptyTower()) { // if destination tower is empty, returns true
            towers[to].addDisc(towers[from].getDisc());
            towers[from].removeDisc();
            return true;
        } else if (towers[from].getDisc() > towers[to].getDisc()) { // if disc is being moved onto a smaller disc, gives error message
            JOptionPane.showMessageDialog(null,
                                          "You cannot move a bigger disc onto a smaller one.",
                                          "Movement Error",
                                          JOptionPane.ERROR_MESSAGE);
            return false;
        } else { // move is legal
            towers[to].addDisc(towers[from].removeDisc()); //adds disc from previous tower to next tower and deletes from previous
            return true;
        }
    }

    public void buildTowers() { // creates instance of three new towers
        towers[0] = new Tower();
        towers[1] = new Tower();
        towers[2] = new Tower();
    }

    public boolean checkWin() { //if left tower is empty and either (not both) right or middle tower is also empty, returns true
        if (towers[0].emptyTower() &&
            (towers[1].emptyTower() || towers[2].emptyTower())) {
            return true;
        } else {
            return false;
        }
    }

}
