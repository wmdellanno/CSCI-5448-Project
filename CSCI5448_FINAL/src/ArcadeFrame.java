/*
 * FILE:	ARCADEFRAME.JAVA
 * DATE:	12/05/2015
 * AUTHOR:	W.M. DELL'ANNO
 * PURPOSE:	STRATEGY GAME ARCADE FRAME
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.*;
import java.awt.Color;

public class ArcadeFrame extends JFrame implements ActionListener{
	public ArcadeFrame(){
		try {
			jbInit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void actionPerformed (ActionEvent ae){
		
		if (ae.getSource()==g1But){
			//launch game 1
			if(onePlayer.isSelected()) {
				aiUnavailable();
			}
			Chess chs = new Chess();
			chs.setSize(800,600);
			chs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			chs.setTitle("Strategy Game Arcade");
			chs.setVisible(true);
		} else if (ae.getSource()==g2But){
			//launch game 2		
			if(onePlayer.isSelected()) {
				aiUnavailable();
			}
			TicTacToe ttt = new TicTacToe();
			ttt.setSize(800,600);
			ttt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    ttt.setTitle("Strategy Game Arcade");
		    ttt.setVisible(true);
		} else if (ae.getSource()==g3But){
			//launch game 3
			if(onePlayer.isSelected()) {
				aiUnavailable();
			};
			ConnectFour cf = new ConnectFour();
			cf.setSize(800,600);
			cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cf.setTitle("Strategy Game Arcade");
			cf.setVisible(true);
		} else if (ae.getSource()==g4But){
			//launch game 4
			if(onePlayer.isSelected()) {
				aiUnavailable();
			}
			Checkers chk = new Checkers();
			chk.setSize(800,600);
			chk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			chk.setTitle("Strategy Game Arcade");
			chk.setVisible(true);
		} else if (ae.getSource()==g5But){
			//launch game 5
			if(onePlayer.isSelected()) {
				aiUnavailable();
			}
			TowersOfHanoi toh = new TowersOfHanoi();
			toh.setSize(1000,600);
			toh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			toh.setTitle("Strategy Game Arcade");
			toh.setVisible(true);
		} else if (ae.getSource()==g6But){
			//launch game 6
			if(onePlayer.isSelected()) {
				aiUnavailable();
			}
			DotsAndBoxes dab = new DotsAndBoxes();
			dab.setSize(800,600);
			dab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dab.setTitle("Strategy Game Arcade");
			dab.setVisible(true);
		} else if (ae.getSource()==onePlayer){
			if(onePlayer.isSelected()){
				twoPlayers.setEnabled(false);
			} else if (!onePlayer.isSelected()){
				twoPlayers.setEnabled(true);
			}
		} else if (ae.getSource()==twoPlayers){
			if(twoPlayers.isSelected()){
				onePlayer.setEnabled(false);
			} else if (!twoPlayers.isSelected()){
				onePlayer.setEnabled(true);
			}
		}
		
	}
	
	public void aiUnavailable(){
		JOptionPane.showMessageDialog(null,"Computron is tired. You will have to find a human partner.");
	}
	
	private void jbInit() throws Exception{
		this.getContentPane().setLayout(null);
		
		heading.setForeground(Color.BLUE);
        heading.setFont(new java.awt.Font("Dialog", Font.PLAIN, 60));
        heading.setBorder(null);
        heading.setEditable(false);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBounds(new Rectangle(125,25,750,80));
        heading.setText("STRATEGY GAME ARCADE");
        
        players.setForeground(Color.orange);
        players.setFont(new java.awt.Font("Dialog", Font.PLAIN, 40));
        players.setBorder(null);
        players.setEditable(false);
        players.setHorizontalAlignment(SwingConstants.CENTER);
        players.setBounds(new Rectangle(400,125,200,50));
        players.setText("PLAYERS");
        
        select.setForeground(Color.orange);
        select.setFont(new java.awt.Font("Dialog", Font.PLAIN, 40));
        select.setBorder(null);
        select.setEditable(false);
        select.setHorizontalAlignment(SwingConstants.CENTER);
        select.setBounds(new Rectangle(250,250,500,50));
        select.setText("SELECT A GAME TO PLAY");
        
        onePlayer.setVerticalTextPosition(JRadioButton.BOTTOM);
        onePlayer.setHorizontalTextPosition(JRadioButton.CENTER);
        onePlayer.setBounds(new Rectangle(375,175,100,50));
        
        twoPlayers.setVerticalTextPosition(JRadioButton.BOTTOM);
        twoPlayers.setHorizontalTextPosition(JRadioButton.CENTER);
        twoPlayers.setBounds(new Rectangle(550,175,100,50));
        
        g1But.setForeground(Color.BLUE);
        g1But.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
        g1But.setBounds(new Rectangle(200, 325, 250, 75));
        g1But.setEnabled(true);
        g1But.setText("CHESS");
        
        g2But.setForeground(Color.BLUE);
        g2But.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
        g2But.setBounds(new Rectangle(550, 325, 250, 75));
        g2But.setEnabled(true);
        g2But.setText("TIC TAC TOE");
        
        g3But.setForeground(Color.BLUE);
        g3But.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
        g3But.setBounds(new Rectangle(200, 425, 250, 75));
        g3But.setEnabled(true);
        g3But.setText("CONNECT FOUR");
        
        g4But.setForeground(Color.BLUE);
        g4But.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
        g4But.setBounds(new Rectangle(550, 425, 250, 75));
        g4But.setEnabled(true);
        g4But.setText("CHECKERS");
        
        g5But.setForeground(Color.BLUE);
        g5But.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
        g5But.setBounds(new Rectangle(200, 525, 250, 75));
        g5But.setEnabled(true);
        g5But.setText("TOWERS OF HANOI");
        
        g6But.setForeground(Color.BLUE);
        g6But.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
        g6But.setBounds(new Rectangle(550, 525, 250, 75));
        g6But.setEnabled(true);
        g6But.setText("DOTS & BOXES");
        
        this.getContentPane().add(heading);
        this.getContentPane().add(players);
        this.getContentPane().add(select);
        this.getContentPane().add(onePlayer);
        this.getContentPane().add(twoPlayers);
        this.getContentPane().add(g1But);
        this.getContentPane().add(g2But);
        this.getContentPane().add(g3But);
        this.getContentPane().add(g4But);
        this.getContentPane().add(g5But);
        this.getContentPane().add(g6But);
		
        g1But.addActionListener(this);
        g2But.addActionListener(this);
        g3But.addActionListener(this);
        g4But.addActionListener(this);
        g5But.addActionListener(this);
        g6But.addActionListener(this);
        onePlayer.addActionListener(this);
        twoPlayers.addActionListener(this);
	}
	
	
	JTextField heading = new JTextField();
	JTextField players = new JTextField();
	JTextField select = new JTextField();
	JRadioButton onePlayer = new JRadioButton("One Player");
	JRadioButton twoPlayers = new JRadioButton("Two Players");
	JButton g1But = new JButton();
	JButton g2But = new JButton();
	JButton g3But = new JButton();
	JButton g4But = new JButton();
	JButton g5But = new JButton();
	JButton g6But = new JButton();
	

}
