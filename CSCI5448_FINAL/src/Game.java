import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.*;
import java.awt.Color;

public class Game extends JFrame implements ActionListener{
	
	public boolean isComplete = false;
	public Player p1 = new Player();
	public Player p2 = new Player();
	
	public Game(){
		try {
			jbInit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void actionPerformed (ActionEvent ae){
		if(ae.getSource()==newGameBut){
			//start a new instance of the game
		} else if(ae.getSource()==resetScoreBut){
			//reset each player's score
			p1.setScore(0);
			p2.setScore(0);
			p1Score.setText("PLAYER 1: 0");
			p2Score.setText("PLAYER 2: 0");
			tiesScore.setText("TIES: 0");
		} else if(ae.getSource()==menuBut){
			//close this game and return to the main menu
			this.dispose();
		} else if(ae.getSource()==quitBut){
			//quit everything
			System.exit(0);
		}
	}
	
	
	private void jbInit() throws Exception{
		this.getContentPane().setLayout(null);
		
		String label1 = "NEW\nGAME";
		String label2 = "RESET\nSCORE";		
		
		newGameBut.setForeground(Color.BLUE);
        newGameBut.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        newGameBut.setBounds(new Rectangle(25, 75, 100, 100));
        newGameBut.setEnabled(true);
        newGameBut.setText("<html><center>" + label1.replaceAll("\\n", "<br>") + "</center></html>");
        
        resetScoreBut.setForeground(Color.BLUE);
        resetScoreBut.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        resetScoreBut.setBounds(new Rectangle(675, 75, 100, 100));
        resetScoreBut.setEnabled(true);
        resetScoreBut.setText("<html><center>" + label2.replaceAll("\\n", "<br>") + "</center></html>");
        
        menuBut.setForeground(Color.BLUE);
        menuBut.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        menuBut.setBounds(new Rectangle(25, 460, 100, 100));
        menuBut.setEnabled(true);
        menuBut.setText("MENU");
        
        quitBut.setForeground(Color.BLUE);
        quitBut.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        quitBut.setBounds(new Rectangle(675, 460, 100, 100));
        quitBut.setEnabled(true);
        quitBut.setText("QUIT");
        
        p1Score.setForeground(Color.orange);
        p1Score.setFont(new java.awt.Font("Dialog", Font.BOLD, 14));
        p1Score.setBorder(null);
        p1Score.setEditable(false);
        p1Score.setHorizontalAlignment(SwingConstants.CENTER);
        p1Score.setBounds(new Rectangle(170,510,110,30));
        
        
        p2Score.setForeground(Color.blue);
        p2Score.setFont(new java.awt.Font("Dialog", Font.BOLD, 14));
        p2Score.setBorder(null);
        p2Score.setEditable(false);
        p2Score.setHorizontalAlignment(SwingConstants.CENTER);
        p2Score.setBounds(new Rectangle(520,510,110,30));
        
        
        tiesScore.setForeground(Color.black);
        tiesScore.setFont(new java.awt.Font("Dialog", Font.BOLD, 14));
        tiesScore.setBorder(null);
        tiesScore.setEditable(false);
        tiesScore.setHorizontalAlignment(SwingConstants.CENTER);
        tiesScore.setBounds(new Rectangle(345,510,110,30));
        
        
        heading.setForeground(Color.orange);
        heading.setFont(new java.awt.Font("Dialog", Font.BOLD, 60));
        heading.setBorder(null);
        heading.setEditable(false);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBounds(new Rectangle(150,25,500,60));
        
        this.getContentPane().add(newGameBut);
        this.getContentPane().add(resetScoreBut);
        this.getContentPane().add(menuBut);
        this.getContentPane().add(quitBut);
        this.getContentPane().add(p1Score);
        this.getContentPane().add(p2Score);
        this.getContentPane().add(tiesScore);
        this.getContentPane().add(heading);
        
        newGameBut.addActionListener(this);
        resetScoreBut.addActionListener(this);
        menuBut.addActionListener(this);
        quitBut.addActionListener(this);
        
        
	}
	
	JButton newGameBut = new JButton();
	JButton resetScoreBut = new JButton();
	JButton menuBut = new JButton();
	JButton quitBut = new JButton();
	
	JTextField p1Score = new JTextField();
	JTextField p2Score = new JTextField();
	JTextField tiesScore = new JTextField();
	JTextField heading = new JTextField();
	

}
