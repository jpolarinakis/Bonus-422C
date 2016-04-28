import java.awt.Component;
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
	this.secretCode = new ArrayList<Character>();
	history = new ArrayList<ArrayList<String>>(); 
	attemptsRemain = 12;
	for(int i =0; i < 4; i++)
	{
		int color = (int)(Math.random() * 5);//random.nextInt()%5;
		switch(color)
		{
		case 0:
			secretCode.add(this.orange);
			break;
		case 1:
			secretCode.add(this.blue);
			break;
		case 2:
			secretCode.add(this.purple);
			break;
		case 3:
			secretCode.add(this.red);
			break;
		case 4:
			secretCode.add(this.yellow);
			break;
		case 5:
			secretCode.add(this.green);
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
String message = "you have " + Integer.toString(attemptsRemain - 1) + " \n";
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

public int getAttemptsRemain() {
	return attemptsRemain;
}
public void setAttemptsRemain(int attemptsRemain) {
	this.attemptsRemain = attemptsRemain;
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
/* *
 * i think this is redundant because we implement this basic sequence in driver
 * */
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
		String currentS = Character.toString(currentSecret);
		
		if(!currentLetter.equals(currentS))
		{
			return false; //the letters do not match
		}
	}
	return true; //all of the characters matched, so we were able to exit the for loop
}

public String pegsMove(String move)
{
	int bPegs =0;
	int wPegs =0;
	ArrayList<String> s = new ArrayList<String>();
	for(int i =0; i < this.secretCode.size();i++)
	{
		s.add(Character.toString(this.secretCode.get(i)));
	}
	for(int i =0; i < move.length(); i++)
	{
	int place = move.indexOf(s.get(i));	
	if(place != -1)
	{
		s.set(i, null);
		if(place == i)
			bPegs++;
		else
		{
			wPegs++;			
		}
	}
	}
	String ret = Integer.toString(bPegs) + " " + Integer.toString(wPegs);
	return ret;
	}
	
	//totalPegs = whitePegs + blackPegs.
	//output the pegs and the guess?
	
public boolean endGame(boolean win)
{
	boolean ret = false;
	Object[] options = {"OK"};
	JFrame frame = new JFrame();	

	if(win)
	{
	    int n = JOptionPane.showOptionDialog(frame,
                "You win!! ","Dank Games Inc.",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
	}
	else{
	    int n = JOptionPane.showOptionDialog(frame,
                "You lost :( ","Dank Games Inc.",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
		
	}
	int result = JOptionPane.showConfirmDialog(null, 
			   "Great game, let's play another?",null, JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
			    ret = true;
			}
			return ret;
}

}//class