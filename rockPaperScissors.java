/**
 * 
 */
package rockpaperscissors;

import javax.swing.ImageIcon;

/**
*Assignment: A08 Rock Paper Scissors
*Class: rockPaperScissors.java
*Programmer: Brandon Robinson
*Date: Apr 6, 2017
*/
public enum rockPaperScissors {ROCK("rock.png"), PAPER("paper.png"), SCISSORS("scissors.png");
	
	/**
	 * image assigned to the enum variable
	 * ImageIcon image
	 */
	private ImageIcon image;
	
	/**
	 * constructor assigns image
	 * @param s
	 */
	private rockPaperScissors(String s){
		
		image= new ImageIcon(getClass().getResource(s));
		
		
	}
	
	/**
	 * decides whether the player wins, loses, or draws
	 * @param p1
	 * @param com
	 * @return
	 */
	String evaluate(rockPaperScissors p1, rockPaperScissors com){
		
		
		
		if (p1==rockPaperScissors.ROCK && com==rockPaperScissors.SCISSORS ||
			p1==rockPaperScissors.PAPER && com ==rockPaperScissors.ROCK ||
			p1==rockPaperScissors.SCISSORS && com ==rockPaperScissors.PAPER){
			
			return "Winner";
		}
		
		else if (p1==rockPaperScissors.ROCK && com==rockPaperScissors.PAPER ||
				p1==rockPaperScissors.PAPER && com ==rockPaperScissors.SCISSORS ||
				p1==rockPaperScissors.SCISSORS && com ==rockPaperScissors.ROCK){
				
				return "Loser";
			}
		else{
			return "Draw";
		}
			
		
	}

	/**
	 * returns image
	 * @return the image
	 */
	ImageIcon getImage() {
		return image;
	}

	
	
	

}
