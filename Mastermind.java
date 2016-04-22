import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


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
private final char green = 'G';

/* *
 * fill the various randomly generated pieces of the game as well as initializes variables
 * for the player
 * */
public void generateBoard()
{
	history = new ArrayList<ArrayList<String>>(); 
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
		case 5:
			secretCode.add(green);
			break;
		}
		
	}
}
public void generateHistory()
{
	for(int i =0; i < history.size(); i++)
	{
		
		System.out.print("The guess was: ");
		System.out.print(history.get(i).get(0));
		System.out.println(", and the feedback was: ");
		System.out.println(history.get(i).get(1));
		System.out.println("---------------------------------");
	}
}
public String getMove()
{
String message = "you have " + Integer.toString(attemptsRemain) + " \n";
JFrame frame = new JFrame();	
String ret = "";
boolean valid = false;

while (!valid){
String move = JOptionPane.showInputDialog(frame, message + "What is your move?");
if(confirmMove(move) == true)
{
ret = move;
valid = true;
}
}

return ret;
}

private boolean confirmMove(String move) {
	move = move.toUpperCase();
	if(move.equals("HISTORY"))
		return true;
	else if(move.length() != 4)
		return false;
	else{
		for(int i =0; i < 4; i++)
		{
			char test = move.charAt(i);
			switch(test)
			{
			case 'O':
			case 'R':
			case 'P':
			case 'G':
			case 'B':
			case 'Y':
					break;
			default: return false;
			}
		}
	}
	return true;
}
public void play()
{
for(int i = attemptsRemain; i != 0; i--)
{
String move = getMove();
if(move.equals("HISTORY"))
	generateHistory();
/* *
 * TODO: implement function to check output
 * TODO: implement function to generate flags
 * TODO: implement "win" routine and lose routine
 * */
}	

}

}//class
