import javax.swing.JOptionPane;


public class BonusDriver {

	public static void main(String[] args)
	{
		Mastermind game = new Mastermind();
		int moves =0;
		boolean play = false;
		int result = JOptionPane.showConfirmDialog(null, 
				   "Are you ready to play some Mastermind???",null, JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
				    play = true;
				    moves =0;
				} 
		game.generateBoard();
		while(play)
		{
			//game.generateBoard();
			String move = game.getMove();
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