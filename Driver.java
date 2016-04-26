import javax.swing.JOptionPane;


public class Driver {

	void main(int[] args)
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
			moves++;
			//TODO: call movechecking function;
			//call the move output function : checks how off they are from the input
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
				//TODO ask the player if they want to play again
			}
		}
	}
}
