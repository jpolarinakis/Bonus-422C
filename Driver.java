import javax.swing.JOptionPane;


public class Driver {

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
		while(play)
		{
			game.generateBoard();
			
			
			String move = game.getMove();
			moves ++;
			
			//call the move output function : checks how off they are from the input
			boolean didWin = game.moveChecker(move); //check the current move to see if it matches the right answer
			if(didWin)			
				play = game.endGame(true);
			
			else if(moves == 12)			
				play = game.endGame(false);
			
			else //the game is not over so we need to generate the pegs
			{
				//JOptionPane.showMessageDialog(null, "Your guess: " + move);
				String pegs = game.pegsMove(move);
				String[] pegBW = pegs.split("\\s+"); //split by space
				JOptionPane.showMessageDialog(null, "Your guess: " + move + " Black Pegs: " + pegBW[0] + " White Pegs: " + pegBW[1]);
				
				
			}
		}
	}
}