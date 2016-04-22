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
			//TODO: if win call game ending function with "win" option
			//TODO still if win, ask the player if they want to play again
			if(moves == 12)
			{
				
				//TODO: call game ending function, with "lose" option
				//TODO ask the player if they want to play again
			}
		}
	}
}
