/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 File:    ConnectFourFrame.java
 Date:    6/4/10
 Author:  Bill Dell'Anno
 Purpose: GUI frame for connect four game
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Rectangle;
import java.awt.Font;
import java.util.ArrayList;

public class ConnectFourFrame extends JFrame implements ActionListener {

    Board gameBoard = new Board();
    private ReadGameFile reader;
    private boolean autoPlay;
    private boolean firstMove = true;
    private int playCount = 0;
    private JButton[] spots = new JButton[42];
    JButton startBUT = new JButton();

    public ConnectFourFrame(boolean auto) {
        //gameBoard = new Board();
        reader = new ReadGameFile();
        autoPlay = auto;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startBUT) {
            startGame();
            if (autoPlay == true) { // all code for autoplay game
                ArrayList<String> temp = getAutoMoves();
                for (int i = 0; i < temp.size(); i++) {
                    if (!makeMove(Integer.parseInt(temp.get(i)), (i % 2) + 1)) { // checks for validity of move
                        System.out.println("Dude you can't do that!");
                        temp.remove(i);
                        i--;
                    }
                    int winner = checkForWin();
                    if (winner != 0) {
                        System.out.println("The winner is player " + winner);
                        return;
                    }
                }
            }
        } else { // all code for two player (manual) game
            if (firstMove) {
                startGame();
            }
            firstMove = false;
            for (int i = 0; i < spots.length; i++) {
                if (e.getSource() == spots[i]) {
                    playCount++;
                    int col = i % 7;
                    int player = playCount % 2 + 1;
                    if (!makeMove(col, player)) {
                        System.out.println("Dude you can't do that!");
                        playCount--;
                    }
                }
                int winner = checkForWin();
                if (winner != 0) {
                    System.out.println("The winner is player " + winner);

                    startGame();
                    return;
                }

            }
        }
    }


    public int checkForWin() {
        //check all verticle wins
        int player = 0;
        for (Column c : gameBoard.columns) { //loops thru all coulumns in board
            int count = 1;
            player = c.getOccupiedBy(0);
            for (int i = 1; i < c.spaces.length; i++) { // looks at all spaces in column
                if (count > 3 && player != 0) {
                    return player;
                } else if (player == c.getOccupiedBy(i)) { // two of same players pieces in a row
                    count++;
                } else {
                    player = c.getOccupiedBy(i);
                    count = 1;
                }

            }
        }
        //check all horizontal wins
        for (int k = 0; k < 6; k++) { // loops through all of the rows on the board
            int count = 1;
            player = gameBoard.columns[0].getOccupiedBy(k);
            for (int j = 1; j < gameBoard.columns.length; j++) { // loops thru all of the columns on the board
                if (count > 3 && player != 0) {
                    return player;
                } else if (player == gameBoard.columns[j].getOccupiedBy(k)) { // two of the same pieces in a row
                    count++;
                } else {
                    player = gameBoard.columns[j].getOccupiedBy(k);
                    count = 1;
                }
            }
        }
        //checks all diagonal wins
        //--orange check---
        for (int i = 3; i < gameBoard.columns.length; i++) { // loops thru columns
            int currentCol = i;
            int count = 1;
            int nextPlayer;
            player = gameBoard.columns[i].getOccupiedBy(0);
            for (int k = 1; k < 6; k++) { // loops thru spaces in each column
                if (count > 3 && player != 0) {
                    return player;
                } else if (currentCol - 1 < 0) {
                    break;
                } else {
                    nextPlayer = gameBoard.columns[currentCol -
                                 1].getOccupiedBy(k);
                }
                if (player == nextPlayer) {
                    count++;
                    currentCol -= 1;
                    player = nextPlayer;
                } else {
                    count = 1;
                    player = nextPlayer;
                    currentCol -= 1;
                }
            }

        }
        //--green check--
        for (int i = 3; i >= 0; i--) { // loops thru columns
            int currentCol = i;
            int count = 1;
            int nextPlayer;
            player = gameBoard.columns[i].getOccupiedBy(5);
            for (int k = 4; k >= 0; k--) { // loops thru spaces in each column
                if (count > 3 && player != 0) {
                    return player;
                } else if (currentCol + 1 > 6) {
                    break;
                } else {
                    nextPlayer = gameBoard.columns[currentCol +
                                 1].getOccupiedBy(k);
                }
                if (player == nextPlayer) {
                    count++;
                    currentCol += 1;
                    player = nextPlayer;
                } else {
                    count = 1;
                    currentCol += 1;
                    player = nextPlayer;
                }
            }

        }
        //--blue check--
        for (int i = 3; i >= 0; i--) { // loops thru columns
            int currentCol = i;
            int count = 1;
            int nextPlayer;
            player = gameBoard.columns[i].getOccupiedBy(0);
            for (int k = 1; k < 6; k++) { // loops thru spaces in each column
                if (count > 3 && player != 0) {
                    return player;
                } else if (currentCol + 1 > 6) {
                    break;
                } else {
                    nextPlayer = gameBoard.columns[currentCol +
                                 1].getOccupiedBy(k);
                }
                if (player == nextPlayer) {
                    count++;
                    currentCol += 1;
                    player = nextPlayer;
                } else {
                    count = 1;
                    currentCol += 1;
                    player = nextPlayer;
                }
            }

        }
        //----pink check----
        for (int i = 3; i < gameBoard.columns.length; i++) { // loops thru columns
            int currentCol = i;
            int count = 1;
            int nextPlayer;
            player = gameBoard.columns[i].getOccupiedBy(5);
            for (int k = 4; k > 0; k--) { // loops thru spaces in each column
                if (count > 3 && player != 0) {
                    return player;
                } else if (currentCol - 1 < 0) {
                    break;
                } else {
                    nextPlayer = gameBoard.columns[currentCol -
                                 1].getOccupiedBy(k);
                }
                if (player == nextPlayer) {
                    count++;
                    currentCol -= 1;
                    player = nextPlayer;
                } else {
                    count = 1;
                    currentCol -= 1;
                    player = nextPlayer;
                }
            }

        }

        return 0;
    }

    public void startGame() {
        gameBoard.buildColumns();
        for (JButton jb : spots) {
            jb.setBackground(Color.LIGHT_GRAY);
        }
    }

    public boolean makeMove(int col, int player) { // makes a move on GUI and in program
        int spc = gameBoard.getColumn(col).getNumOccupied(); // returns the space the piece will go to in the column
        if (spc > 5) { // player is attempting to put too many pieces in column
            return false;
        }
        gameBoard.getColumn(col).placePiece(player, spc); // puts the piece in that space in the object
        int buttonIndex = ((5 - spc) * 7) + col; // determines the index of the button in spots
        if (player == 1) {
            spots[buttonIndex].setBackground(Color.RED);
            return true;
        } else if (player == 2) {
            spots[buttonIndex].setBackground(Color.BLUE);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getAutoMoves() {
        ArrayList<String> temp = new ArrayList<String>();
        String file = "";
        while (file.equals("")) {
            file = JOptionPane.showInputDialog(null,
                                               "What is the name of the file?",
                                               "");
        }
        temp = reader.loadMoves(file);
        return temp;
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        for (int i = 1, h = 25, k = 75; i < spots.length + 1; i++, h += 50) {
            spots[i - 1] = new JButton();
            spots[i - 1].setBounds(new Rectangle(h, k, 50, 50));
            spots[i - 1].setFont(new java.awt.Font("Tahoma", Font.BOLD, 15));
            if (i % 7 == 0) {
                h = -25;
                k += 50;
            }
        }

        for (int i = 0; i < spots.length; i++) {
            this.getContentPane().add(spots[i]);
            spots[i].addActionListener(this);
        }
        startBUT.setBounds(new Rectangle(125, 25, 150, 35));
        startBUT.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));
        startBUT.setText("Start Game");
        this.getContentPane().add(startBUT);
        startBUT.addActionListener(this);
    }

}
