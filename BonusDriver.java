import javax.swing.JOptionPane;


public class BonusDriver {

	public static void main(String[] args)
	{
		Mastermind game = new Mastermind();
		int moves =0;
		boolean play = false;
		String message = "This is a text version of the classic board game Mastermind. \n The computer will think of a secret code. The code consists of 4 colored pegs. \n The pegs may be one of six colors: blue, green, orange, purple, red, or yellow. \n A color may appear more than once in the code. \n You try to guess what colored pegs are in the code and what order they are in. \n After you make a valid guess the result (feedback) will be displayed. \n The result consists of a black peg for each peg you have guessed exactly correct \n (color and position) in your guess. For each peg in the guess that is the correct color \n , but is out of position, you get a white peg. For each peg, which is fully incorrect, you get no feedback.\n Only the first letter of the color is displayed. B for Blue, R for Red, and so forth. \nWhen entering guesses you only need to enter the first character of each color as a capital letter.\n You have 12 guesses to figure out the secret code or you lose the game.\n Are you ready to play? (Y/N):";
		int result = JOptionPane.showConfirmDialog(null, 
				   message,null, JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
				    play = true;
				    moves =0;
				} 
		game.generateBoard();
		while(play)
		{
			//game.generateBoard();
			String move = game.getMove();
			if(!move.equals("HISTORY"))
				moves++;
			//call the move output function : checks how off they are from the input
			boolean didWin = game.moveChecker(move); //check the current move to see if it matches the right answer
			if(didWin){			
				play = game.endGame(true);
				game.generateBoard();
			}
			else if(moves == 12){			
				play = game.endGame(false);
				game.generateBoard();}
			
			else //the game is not over so we need to generate the pegs
			{
				game.pegsMove(move);
			}
		}
	}
}