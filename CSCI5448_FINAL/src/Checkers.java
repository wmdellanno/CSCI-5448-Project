import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Checkers extends Game{

	public int[][] gameBoard = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
	Piece bluePiece = new Piece();
	Piece orangePiece = new Piece();

	public int playerTurn = 0;

	public Checkers(){
		try{
			drawBoard();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}

	public void actionPerformed (ActionEvent ae){
		super.actionPerformed(ae);
	}

	public void drawBoard(){
		
		heading.setText("CHECKERS");
		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				checkersBoard[i][j]=new JButton();
				this.getContentPane().add(checkersBoard[i][j]);
				checkersBoard[i][j].addActionListener(this);
				checkersBoard[i][j].setBounds(new Rectangle((200+50*j),(100+50*i),50,50));
				checkersBoard[i][j].setEnabled(true);
				
			}
		}
		
	}
	
	JButton[][] checkersBoard = new JButton[8][8];

}
