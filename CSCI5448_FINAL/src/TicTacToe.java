import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TicTacToe extends Game{

	public int[] gameBoard={0,0,0,0,0,0,0,0,0};
	Piece[] pieces = new Piece[2];

	private final int xWin = 3;
	private final int oWin = -3;

	public int playerTurn = 1;
	public int movesMade = 0;
	public int tiedGames = 0;

	public TicTacToe(){
		try{
			setup();
			drawBoard();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}

	public void actionPerformed (ActionEvent ae){
		if(ae.getSource()==r0c0But){
			makeMove(0);
		} else if (ae.getSource()==r0c1But){
			makeMove(1);
		} else if (ae.getSource()==r0c2But){
			makeMove(2);
		} else if (ae.getSource()==r1c0But){
			makeMove(3);
		} else if (ae.getSource()==r1c1But){
			makeMove(4);
		} else if (ae.getSource()==r1c2But){
			makeMove(5);
		} else if (ae.getSource()==r2c0But){
			makeMove(6);
		} else if (ae.getSource()==r2c1But){
			makeMove(7);
		} else if (ae.getSource()==r2c2But){
			makeMove(8);
		} else if (ae.getSource()==newGameBut){
			resetGame();
		} else if (ae.getSource()==resetScoreBut){
			tiedGames=0;
			super.actionPerformed(ae);
		} else {
			super.actionPerformed(ae);
		}

	}

	public void setup(){
		pieces[0] = new Piece();
		pieces[0].setValue(1);
		pieces[0].setName("X");
		pieces[0].setColor(Color.BLUE);

		pieces[1] = new Piece();
		pieces[1].setValue(-1);
		pieces[1].setName("O");
		pieces[1].setColor(Color.orange);
		
		p1Score.setText("PLAYER 1: 0");
		p2Score.setText("PLAYER 2: 0");
		tiesScore.setText("TIES: 0");
		
		int temp = 2;
		if (playerTurn<0){
		JOptionPane.showMessageDialog(null,"Player " + temp + " makes the first move.");
		} else {
			JOptionPane.showMessageDialog(null,"Player " + playerTurn + " makes the first move.");
		}
	}

	public void makeMove(int pos){
		if(gameBoard[pos]!=0 || isComplete == true){
		} else {
			gameBoard[pos]=playerTurn;
			if(playerTurn<0){
				updateBoard(pos, 0);
			} else {
				updateBoard(pos, playerTurn);
			}
			
			if(checkWin()==0 && movesMade < 9){
				playerTurn*=(-1);
			} else if (checkWin()==0 && movesMade > 8){
				tiedGames++;
				tiesScore.setText("TIES: " + tiedGames);
				gameCompleted (0);
			}else{
				if(playerTurn>0){
					p1.setScore(p1.getScore()+1);
					p1Score.setText("PLAYER 1: " + p1.getScore());
					gameCompleted(1);
				} else {
					p2.setScore(p2.getScore()+1);
					p2Score.setText("PLAYER 2: " + p2.getScore());
					gameCompleted(2);
				}

			}
		}
	}

	public void updateBoard(int pos, int plyr){
		if (pos==0){
			r0c0But.setForeground(pieces[plyr].getColor());
			r0c0But.setFont(new java.awt.Font("Dialog", Font.BOLD, 80));
			r0c0But.setText(pieces[plyr].getName());
		} else if(pos==1){
			r0c1But.setForeground(pieces[plyr].getColor());
			r0c1But.setFont(new java.awt.Font("Dialog", Font.BOLD, 80));
			r0c1But.setText(pieces[plyr].getName());
		} else if(pos==2){
			r0c2But.setForeground(pieces[plyr].getColor());
			r0c2But.setFont(new java.awt.Font("Dialog", Font.BOLD, 80));
			r0c2But.setText(pieces[plyr].getName());
		} else if(pos==3){
			r1c0But.setForeground(pieces[plyr].getColor());
			r1c0But.setFont(new java.awt.Font("Dialog", Font.BOLD, 80));
			r1c0But.setText(pieces[plyr].getName());
		} else if(pos==4){
			r1c1But.setForeground(pieces[plyr].getColor());
			r1c1But.setFont(new java.awt.Font("Dialog", Font.BOLD, 80));
			r1c1But.setText(pieces[plyr].getName());
		} else if(pos==5){
			r1c2But.setForeground(pieces[plyr].getColor());
			r1c2But.setFont(new java.awt.Font("Dialog", Font.BOLD, 80));
			r1c2But.setText(pieces[plyr].getName());
		} else if(pos==6){
			r2c0But.setForeground(pieces[plyr].getColor());
			r2c0But.setFont(new java.awt.Font("Dialog", Font.BOLD, 80));
			r2c0But.setText(pieces[plyr].getName());
		} else if(pos==7){
			r2c1But.setForeground(pieces[plyr].getColor());
			r2c1But.setFont(new java.awt.Font("Dialog", Font.BOLD, 80));
			r2c1But.setText(pieces[plyr].getName());
		} else if(pos==8){
			r2c2But.setForeground(pieces[plyr].getColor());
			r2c2But.setFont(new java.awt.Font("Dialog", Font.BOLD, 80));
			r2c2But.setText(pieces[plyr].getName());
		}
		movesMade++;
	}

	public int checkWin(){
		int[] rows = new int[3];
		int[] columns = new int[3];
		int[] diagonals = new int[3];

		for (int i=0; i<3; i++){
			rows[i]=gameBoard[i*3]+gameBoard[i*3+1]+gameBoard[i*3+2];
			columns[i]=gameBoard[i]+gameBoard[i+3]+gameBoard[i+6];
		}
		diagonals[0]=gameBoard[0]+gameBoard[4]+gameBoard[8];
		diagonals[1]=gameBoard[2]+gameBoard[4]+gameBoard[6];

		for (int i=0; i<3; i++){
			if (rows[i]==xWin || columns[i]==xWin){
				return pieces[0].getValue();
			} else if (rows[i]==oWin || columns[i]==oWin){
				return pieces[0].getValue();
			}
		}

		if (diagonals[0]==xWin || diagonals[1]==xWin){
			return pieces[0].getValue();
		} else if (diagonals[0]==oWin || diagonals[1]==oWin){
			return pieces[0].getValue();
		} else {
			return 0;
		}
		
	}
	
	public void gameCompleted(int winner){
		isComplete = true;
		if (winner==0){
			
			JOptionPane.showMessageDialog(null,"The game was a tie!");
		} else {
			JOptionPane.showMessageDialog(null,"Player " + winner + " won the game!");
		}
	}
	
	public void resetGame(){
		playerTurn*=-1;
		movesMade=0;
		
		r0c0But.setText("");
		r0c1But.setText("");
		r0c2But.setText("");
		r1c0But.setText("");
		r1c1But.setText("");
		r1c2But.setText("");
		r2c0But.setText("");
		r2c1But.setText("");
		r2c2But.setText("");
		
		for (int i=0; i<9; i++){
			gameBoard[i]=0;
		}
		
		isComplete = false;
		
		int temp = 2;
		if (playerTurn<0){
		JOptionPane.showMessageDialog(null,"Player " + temp + " makes the first move.");
		} else {
			JOptionPane.showMessageDialog(null,"Player " + playerTurn + " makes the first move.");
		}
	}


	public void drawBoard(){

		this.getContentPane().add(r0c0But);
		this.getContentPane().add(r0c1But);
		this.getContentPane().add(r0c2But);
		this.getContentPane().add(r1c0But);
		this.getContentPane().add(r1c1But);
		this.getContentPane().add(r1c2But);
		this.getContentPane().add(r2c0But);
		this.getContentPane().add(r2c1But);
		this.getContentPane().add(r2c2But);

		heading.setText("TIC TAC TOE");

		r0c0But.setBounds(new Rectangle(210, 100, 120, 120));
		r0c0But.setEnabled(true);

		r0c1But.setBounds(new Rectangle(340, 100, 120, 120));
		r0c1But.setEnabled(true);

		r0c2But.setBounds(new Rectangle(470, 100, 120, 120));
		r0c2But.setEnabled(true);

		r1c0But.setBounds(new Rectangle(210, 230, 120, 120));
		r1c0But.setEnabled(true);

		r1c1But.setBounds(new Rectangle(340, 230, 120, 120));
		r1c1But.setEnabled(true);

		r1c2But.setBounds(new Rectangle(470, 230, 120, 120));
		r1c2But.setEnabled(true);

		r2c0But.setBounds(new Rectangle(210, 360, 120, 120));
		r2c0But.setEnabled(true);

		r2c1But.setBounds(new Rectangle(340, 360, 120, 120));
		r2c1But.setEnabled(true);

		r2c2But.setBounds(new Rectangle(470, 360, 120, 120));
		r2c2But.setEnabled(true);

		r0c0But.addActionListener(this);
		r0c1But.addActionListener(this);
		r0c2But.addActionListener(this);
		r1c0But.addActionListener(this);
		r1c1But.addActionListener(this);
		r1c2But.addActionListener(this);
		r2c0But.addActionListener(this);
		r2c1But.addActionListener(this);
		r2c2But.addActionListener(this);

	}

	JButton r0c0But = new JButton();
	JButton r0c1But = new JButton();
	JButton r0c2But = new JButton();
	JButton r1c0But = new JButton();
	JButton r1c1But = new JButton();
	JButton r1c2But = new JButton();
	JButton r2c0But = new JButton();
	JButton r2c1But = new JButton();
	JButton r2c2But = new JButton();



}
