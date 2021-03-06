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
public ArrayList<Character> getSecretCode() {
	return secretCode;
}
public void setSecretCode(ArrayList<Character> secretCode) {
	this.secretCode = secretCode;
}

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
/*checks to see if they guessed the correct combination
 * Outputs true if the combination is correct
 */
public boolean moveChecker(String move)
{
	//need to check if this move is correct
	
	for(int i = 0; i < move.length(); i ++)
	{
		String currentLetter = move.substring(i, i + 1);
		Character currentSecret = this.secretCode.get(i);
		
		if(!currentLetter.equals(currentSecret))
		{
			return false; //the letters do not match
		}
	}
	return true; //all of the characters matched, so we were able to exit the for loop
}

public int[] pegsMove(String move)
{
	int whitePegs = 0;
	int blackPegs = 0;
	
	for(int i = 0; i < move.length(); i ++)
	{
		String letter = move.substring(i, i+1);
		ArrayList<Character> secret = this.secretCode;
		int same = 0;
		int similar = 0;
		for(int j = 0; j < secret.size(); j ++)
		{
			if(letter.equals(secret.get(j)) && i == j)
			{
				same = same+ 1; //they are in the same place 
			}
			else if(letter.equals(secret.get(j)))
			{
				similar = similar + 1;  //same color in the code, but wrong place
			}
			
		}
		if(similar > 0)
		{
			whitePegs = whitePegs + 1;
		}
		if(same > 0)
		{
			blackPegs = blackPegs + 1;
		}
	
	}
	
	//totalPegs = whitePegs + blackPegs.
	//output the pegs and the guess?
	if(whitePegs > 0 || blackPegs > 0){
	int[] pegArray = new int[2];
	pegArray[0] = whitePegs;
	pegArray[1] = blackPegs;
	
	return pegArray;
	}
	else{return null;}
	
}

}//class
