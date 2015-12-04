/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 File:    Tower.java
 Date:    01/24/10
 Author:  Bill Dell'Anno
 Purpose: Holds stack of discs for each tower
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

public class Tower {

    private ArrayListStack discs; //each tower has its own stack of discs

    public Tower() { //constructor creats a new stack of discs
        discs = new ArrayListStack();
    }

    public void addDisc(int val) { // val is added to tower
        discs.push((Integer) val);
    }

    public int removeDisc() { // top value is removed
        return (Integer)discs.pop();
    }

    public int getDisc() { // returns value of disc on top of tower
        return (Integer) discs.peekTop();
    }

    public boolean emptyTower() { // returns true if no discs on tower
        return discs.isEmpty();
    }

    public void fillTower() { // three values (discs) are added to tower
        discs.push(3);
        discs.push(2);
        discs.push(1);
    }
}
