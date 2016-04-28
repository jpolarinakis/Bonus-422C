import java.util.Scanner;

import javax.swing.JOptionPane;


public class Driver {

	void main(int[] args)
	{
		Mastermind game = new Mastermind();
		int moves =0;
		boolean play = false;
		boolean restart = false;
		int result = JOptionPane.showConfirmDialog(null, 
				   "Are you ready to play some Mastermind???",null, JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
				    play = true;
				    moves =0;
				} 
		while(play)
		{
			game.generateBoard();
			String move = game.getMove();
			moves++;
			System.out.println("Your guess: " + move + " "); //print out their move.			
			boolean didWin = game.moveChecker(move); //check the current move to see if it matches the right answer
			//TODO: if win call game ending function with "win" option
			if(didWin)
			{
				//execute win protocols
				
			}
			//TODO still if win, ask the player if they want to play again
			else if(moves == 12)
			{
				
				//TODO: call game ending function, with "lose" option
				System.out.println("/n");
				System.out.println("Game Over" + " The secret code is: " + game.getSecretCode() + "/n");
				System.out.println("Do you want to play again? Y/N : ");
				boolean answered = false;
				while(!answered){
				Scanner yesno = new Scanner(System.in);
				String answer = yesno.nextLine();
				if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes"))
				{
					System.out.println(answer + "/n");
					restart = true;
					answered = true;
				}
				else if(answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("No"))
				{
					System.out.println(answer+ "/n");
					play = false; 
					answered = true;
				}
				else
				{
					System.out.println(answer + "/n");
					System.out.println("Please answer Y or N: ");
					answered = false; //not really needed here, but left it anyway
				}
				}
				//TODO ask the player if they want to play again
			}
			else
			{
				int[] pegs = game.pegsMove(move); //get the pegs in an integer array
				//print out the number of pegs for each if pegs is not empty.
				if(pegs.length != 0){
				System.out.println("Pegs:  " + pegs[0] + " white " + pegs[1] + " black/n");
				}
				else //no pegs--their guess is completely off
				{
					System.out.println("Pegs: None/n");
				}
			}
		}
	}
}
