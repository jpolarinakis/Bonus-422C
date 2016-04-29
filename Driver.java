import java.util.Scanner;

import javax.swing.JOptionPane;


public class Driver {

	public static void main(String[] args)
	{
		Mastermind game = new Mastermind();
		int moves =0;
		boolean play = false;
		//move everything to console
		//add options to change the board configurations
		
		boolean ready = game.readyToStart();
		if(ready){
		play = true;
		moves = 0;
		game.customize();
		game.generateBoard();
			
		while(play)
		{
			String move = game.getMove();
			moves ++;
			
			//call the move output function : checks how off they are from the input
			boolean didWin = game.moveChecker(move); //check the current move to see if it matches the right answer
			if(didWin){			
				play = game.endGame(true);
			game.generateBoard();
			}
			else if(moves == 12){			
				play = game.endGame(false);
			game.generateBoard();
			}
			else //the game is not over so we need to generate the pegs
			{
				//JOptionPane.showMessageDialog(null, "Your guess: " + move);
				String pegs = game.pegsMove(move);
				String[] pegBW = pegs.split("\\s+"); //split by space
				System.out.println("Your guess: " + move + " Black Pegs: " + pegBW[0] + " White Pegs: " + pegBW[1]);
				
				
			}
			if(moves == 12 && play == true)
			{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
				game.customize();
				System.out.println("Generating secret code...");
				game.generateBoard();
				
			}
		}
		}
		
		System.out.println("Closing MasterMind...Thanks for playing");
		}
	
}