import java.util.ArrayList;
import java.util.Random;


public class Mastermind {
	/* *
	 * History output:
	 * "guess" + "peg output"
	 * */
private Random random = new Random();
private ArrayList<ArrayList<String>> history;
private ArrayList<Character> secretCode;
private int attemptsRemain;
private final char  orange = 'O'; 
private final char blue = 'B';
private final char purple = 'P';
private final char red = 'R';
private final char yellow = 'Y';

/* *
 * fill the various randomly generated pieces of the game as well as initializes variables
 * for the player
 * */
public void generateBoard()
{
	attemptsRemain = 12;
	for(int i =0; i < 4; i++)
	{
		int color = random.nextInt()%5;
		switch(color)
		{
		case 0:
			secretCode.add(orange);
			break;
		case 1:
			secretCode.add(blue);
			break;
		case 2:
			secretCode.add(purple);
			break;
		case 3:
			secretCode.add(red);
			break;
		case 4:
			secretCode.add(yellow);
			break;
		}
		
	}
}
public void generateHistory()
{
	for(int i =0; i < history.size(); i++)
	{
		
	}
}

}//class
