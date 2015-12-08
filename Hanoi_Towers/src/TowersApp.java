/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 File:    TowersApp.java
 Date:    1/22/10
 Author:  Bill Dell'Anno
 Purpose: Creates instance of TowersFrame
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

import java.awt.*;
import javax.swing.JFrame;

public class TowersApp {
    public static void main(String[] args) {
        TowersFrame f = new TowersFrame();
        f.setSize(650,390);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Towers of Hanoi");
        f.setVisible(true);
    }
}
