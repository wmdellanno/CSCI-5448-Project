import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Chess extends Game{

	public int[][] gameBoard = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
	//Piece bluePiece = new Piece();
	//Piece orangePiece = new Piece();

	public int playerTurn = 0;

	public Chess(){
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
		
		heading.setText("CHESS");
		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				chessBoard[i][j]=new JButton();
				this.getContentPane().add(chessBoard[i][j]);
				chessBoard[i][j].addActionListener(this);
				chessBoard[i][j].setBounds(new Rectangle((200+50*j),(100+50*i),50,50));
				chessBoard[i][j].setEnabled(true);
				
			}
		}
		
	}
	
	JButton[][] chessBoard = new JButton[8][8];

}
