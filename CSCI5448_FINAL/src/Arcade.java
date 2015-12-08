/*
 * FILE:	ARCADE.JAVA
 * DATE:	12/05/2015
 * AUTHOR:	W.M. DELL'ANNO
 * PURPOSE:	CREATES INSTANCE OF ARCADEFRAME
 */

import javax.swing.JFrame;

public class Arcade {

	public static void main(String[] args) {
		ArcadeFrame arcade = new ArcadeFrame();
		arcade.setSize(1000,800);
		arcade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    arcade.setTitle("Strategy Game Arcade");
	    arcade.setVisible(true);
	}
}
