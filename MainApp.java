/**
 * 
 */
package rockpaperscissors;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
*Assignment: A08 Rock Paper Scissors
*Class: MainApp.java
*Programmer: Brandon Robinson
*Date: Apr 6, 2017
*/
public class MainApp extends JFrame {

	/**
	 * JPanel contentPane
	 */
	private JPanel contentPane;
	/**
	 * Player1's icon
	 * JLabel lblP1Icon
	 */
	private JLabel lblP1Icon;
	/**
	 * Computer's Icon
	 * JLabel lblComIcon
	 */
	private JLabel lblComIcon;
	/**
	 * Button for choosing rock
	 * JButton btnRock
	 */
	private JButton btnRock;
	/**
	 * Button for choosing paper
	 * JButton btnPaper
	 */
	private JButton btnPaper;
	/**
	 * Button for choosing scissors
	 * JButton btnScissors
	 */
	private JButton btnScissors;
	/**
	 * text for if you win or lose
	 * JLabel lblWinnerloser
	 */
	private JLabel lblWinnerloser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 932);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);
		
		JPanel panel_2 = new JPanel();
		createBoardPanel(panel_2);
		
		JPanel panel = new JPanel();
		createChoicePanel(panel);
	}

	/**
	 * creates side panel of buttons 
	 * @param panel
	 */
	private void createChoicePanel(JPanel panel) {
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(5, 1, 0, 10));
		
		JLabel lblPickOne = new JLabel("Pick one");
		lblPickOne.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblPickOne.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPickOne);
		
		btnRock = new JButton("Rock");
		btnRock.setFont(new Font("Tahoma", Font.BOLD, 28));
		createBtnRock(panel);
		
		btnPaper = new JButton("Paper");
		btnPaper.setFont(new Font("Tahoma", Font.BOLD, 28));
		createBtnPaper(panel);
		
		btnScissors = new JButton("Scissors");
		btnScissors.setFont(new Font("Tahoma", Font.BOLD, 28));
		createBtnScissors(panel);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 28));
		createBtnNewGame(panel, btnNewGame);
	}

	/**
	 * creates newGame button
	 * @param panel
	 * @param btnNewGame
	 */
	private void createBtnNewGame(JPanel panel, JButton btnNewGame) {
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRock.setEnabled(true);
				btnPaper.setEnabled(true);
				btnScissors.setEnabled(true);
				lblP1Icon.setIcon(null);
				lblComIcon.setIcon(null);
				lblWinnerloser.setText("");
				
			}
		});
		panel.add(btnNewGame);
	}

	/**
	 * creates scissor button
	 * @param panel
	 */
	private void createBtnScissors(JPanel panel) {
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rockPaperScissors computer=comPick();
				lblP1Icon.setIcon(rockPaperScissors.SCISSORS.getImage());
				lblComIcon.setIcon(computer.getImage());
				btnRock.setEnabled(false);
				btnPaper.setEnabled(false);
				btnScissors.setEnabled(false);
				lblWinnerloser.setText(rockPaperScissors.PAPER.evaluate(rockPaperScissors.SCISSORS, computer));
			}
		});
		panel.add(btnScissors);
	}

	/**
	 * creates paper button
	 * @param panel
	 */
	private void createBtnPaper(JPanel panel) {
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rockPaperScissors computer=comPick();
				lblP1Icon.setIcon(rockPaperScissors.PAPER.getImage());
				lblComIcon.setIcon(computer.getImage());
				btnRock.setEnabled(false);
				btnPaper.setEnabled(false);
				btnScissors.setEnabled(false);
				lblWinnerloser.setText(rockPaperScissors.PAPER.evaluate(rockPaperScissors.PAPER, computer));
			}
		});
		panel.add(btnPaper);
	}

	/**
	 * creates rock button
	 * @param panel
	 */
	private void createBtnRock(JPanel panel) {
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rockPaperScissors computer=comPick();
				lblP1Icon.setIcon(rockPaperScissors.ROCK.getImage());
				lblComIcon.setIcon(computer.getImage());
				btnRock.setEnabled(false);
				btnPaper.setEnabled(false);
				btnScissors.setEnabled(false);
				lblWinnerloser.setText(rockPaperScissors.PAPER.evaluate(rockPaperScissors.ROCK, computer));
			}
		});
		panel.add(btnRock);
	}

	/**
	 * creates panel where the icons show up
	 * @param panel_2
	 */
	private void createBoardPanel(JPanel panel_2) {
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblP1Icon = new JLabel("Player 1");
		lblP1Icon.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblP1Icon.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblP1Icon, BorderLayout.SOUTH);
		
		lblComIcon = new JLabel("Computer");
		lblComIcon.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblComIcon.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblComIcon, BorderLayout.NORTH);
		
		lblWinnerloser = new JLabel("");
		lblWinnerloser.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblWinnerloser.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblWinnerloser, BorderLayout.CENTER);
	}


	
	/**
	 * randomizes the computer's choice
	 * @return
	 */
	public rockPaperScissors comPick(){
		Random myRan = new Random();
		rockPaperScissors[] choice = {rockPaperScissors.PAPER, rockPaperScissors.ROCK, rockPaperScissors.SCISSORS};
		
		return choice[myRan.nextInt(3)];
	}

}
