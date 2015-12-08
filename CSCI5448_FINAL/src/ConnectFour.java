import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConnectFour extends Game{

	public int[][] gameBoard = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
	//Piece bluePiece = new Piece();
	//Piece orangePiece = new Piece();

	public int playerTurn = 0;

	public ConnectFour(){
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
		
		heading.setText("CONNECT FOUR");
		
		for(int i=0; i<6; i++){
			for(int j=0; j<7; j++){
				cfBoard[i][j]=new JButton();
				this.getContentPane().add(cfBoard[i][j]);
				cfBoard[i][j].addActionListener(this);
				cfBoard[i][j].setBounds(new Rectangle((208+55*j),(125+55*i),55,55));
				cfBoard[i][j].setEnabled(true);
				
			}
		}
		
	}
	
	JButton[][] cfBoard = new JButton[6][7];

}
