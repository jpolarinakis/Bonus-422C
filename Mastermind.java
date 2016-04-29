import java.awt.Component;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Mastermind {
	/* *
	 * History output:
	 * "guess" + "peg output"
	 * */
private int numMoves;
private Random random = new Random();
private ArrayList<ArrayList<String>> history;
private ArrayList<Character> secretCode;
private static int attemptsRemain;
private static int numColors;
private static int numPegs;
private static int numGuesses;
private final char  orange = 'O'; 
private final char blue = 'B';
private final char purple = 'P';
private final char red = 'R';
private final char yellow = 'Y';
private final char green = 'G';
private ArrayList<Character> Colors;
private final String empty = "Z";


public boolean readyToStart()
{
	this.Colors = new ArrayList<Character>();
	this.numColors = 6;
	this.numGuesses = 12;
	this.numPegs = 4; 
	addColors();
	System.out.println("Welcome to Mastermind. Here are the rules.\n");
	System.out.println("This is a text version of the classic board game Mastermind.\n"
			+ "The computer will think of a secret code. The code consists of 4 colored pegs.\n" 
			+ "The pegs may be one of six colors: blue, green, orange, purple, red, or yellow.\n"
					+ "A color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in.\n"
					+ "After you make a valid guess the result (feedback) will be displayed.\n"
					+ "The result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.\n"
					+ "For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n"
					+ "For each peg, which is fully incorrect, you get no feedback.\n "
					+ "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n"
					+ "When entering guesses you only need to enter the first character of each color as a capital letter.\n "
					+ "You have 12 guesses to figure out the secret code or you lose the game. Are you ready to play? (Y/N): ");
	Scanner input = new Scanner(System.in);
	String answer = input.nextLine();
	boolean read = false;
	boolean wantToPlay = false;
	while(!read)
	{
		
		if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("Y"))
		{
		
			System.out.println("Yay! Let's begin...");
			read = true;
			wantToPlay = true;
			
		}
		else if(answer.equalsIgnoreCase("No")||answer.equalsIgnoreCase("N"))
		{
			
			System.out.println("That's too bad...See you next time!");
			read = true;
		}
		else
		{
			
			System.out.println("Please answer Y or N\n");
			System.out.println("Are you ready to play? (Y/N): ");
			answer = input.nextLine();
		}
		
	}
	return wantToPlay;
}

public void customize()
{
	System.out.println("~~~~~~~~~~~~");
	System.out.println("Main Menu:");
	System.out.println("Start");
	System.out.println("Settings");
	System.out.println("~~~~~~~~~~~~");
	System.out.println("Type 'Start' if you are ready. Type 'Settings' to customize your game.\n");
	
	Scanner input = new Scanner(System.in);
	String answer = input.nextLine();
	boolean read = false;
	if(answer.equalsIgnoreCase("Start"))
	{
		System.out.println("Settings: " + this.numColors + " Colors " + this.numPegs + " Pegs " + this.numGuesses + " Guesses" );
		return;
	}
	while(!read)
	{
		if(answer.equalsIgnoreCase("Play"))
		{
			System.out.println("Settings: " + this.numColors + " Colors " + this.numPegs + " Pegs " + this.numGuesses + " Guesses" );
			read = true;
		}
		else if(answer.equalsIgnoreCase("Settings"))
		{
			System.out.println("Welcome to Settings");
			System.out.println("------------------------");
			System.out.println("Type what you would like to modify: Colors, Pegs, Guesses?" + "\n" + "Type 'Done' to return");
			answer = input.nextLine();
			while(!answer.equalsIgnoreCase("Done"))
			{
					if (answer.equalsIgnoreCase("Colors")) {
						System.out.println("Please enter the color you would like to add:");
						answer = input.nextLine();
						while (!answer.equalsIgnoreCase("Exit")) {
							Character firstletter = answer.substring(0, 1).charAt(0);
							firstletter.toUpperCase(firstletter);
							
							boolean doesExist = letterExists(firstletter);

							if (doesExist) {
								System.out.println("Please use a color that doesn't start with " + firstletter + ".");
							} else {
								Colors.add(firstletter); // add the first letter of the color to the string.
								System.out.println(
										"Added your color. Please use the first letter of your color to reference it in the game.");
								System.out.println(
										"To keep adding colors, type the colors name you wish to add. Type 'Exit' to exit Color Settings.");

							}
							answer = input.nextLine();
						}
					
				}
				else if(answer.equalsIgnoreCase("Pegs"))
				{
					System.out.println("Choose the number of Pegs you want: 4, 6, 8. Or type Exit to go back to Settings.");
					answer = input.nextLine();
					boolean pickedPeg = false;
					while(!pickedPeg){
					if(answer.equalsIgnoreCase("4")|| answer.equals("6")|| answer.equals("8"))
					{
						System.out.println("You chose:" + " " + answer + " Pegs");
						this.numPegs = Integer.parseInt(answer);
						pickedPeg = true;
					}
					else
					{
						System.out.println("Please input only 4, 6, or 8:");
						answer = input.nextLine();
					}
					
					}
					
				}
				else if(answer.equalsIgnoreCase("Guesses"))
				{
					System.out.println("How many guesses would you like? (Pick any number from 1 to 99)");
					answer = input.nextLine();
						boolean guessSet = false;
						while (!guessSet) {
							if (answer.matches("\\d+\\d") || answer.matches("\\d")) {

								this.numGuesses = Integer.parseInt(answer);
								guessSet = true;
								System.out.println("Your guess number has increased to: " + this.numGuesses);
							} else {
								System.out.println("Please enter a number from 1 to 99");
							
								answer = input.nextLine();
							}
						}
				}
				else
				{
					System.out.println("Error: Illegal Settings Command.");
				
				}
				System.out.println("--------------------------------");
				System.out.println("Type what you would like to modify: Colors, Pegs, Guesses?" + "\n" + "Type 'Done' to return");
				answer = input.nextLine();
			}
			
		}
		else
		{
			System.out.println("Please type 'Play' or 'Settings'");
			answer = input.nextLine();
		}
		
		
		
	}

}

public boolean letterExists(Character letter)
{
	
	for(int i = 0; i < Colors.size(); i ++)
	{
		if(Colors.get(i).equals(letter))
		{
			return true;
		}
	}
	return false;
}
/* *
 * fill the various randomly generated pieces of the game as well as initializes variables
 * for the player
 * */
public void generateBoard()
{	

	this.numMoves = 0;
	this.secretCode = new ArrayList<Character>();
	this.history = new ArrayList<ArrayList<String>>(); 
	attemptsRemain = this.numGuesses;
	for(int i =0; i < 12; i++)
	{
		ArrayList<String> toAdd = new ArrayList<String>();
		history.add(toAdd);
	}
	/*for(int i =0; i < 4; i++)
	{
		int color = random.nextInt()%5;
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
		default:
			secretCode.add(this.green);
		}*/
		for(int i = 0; i < this.numPegs; i ++)
		{
			int color = (int) (Math.random()*Colors.size());
			this.secretCode.add(Colors.get(color));
		}
	}


public void addColors()
{
	Colors.add('O');
	Colors.add('P');
	Colors.add('B');
	Colors.add('Y');
	Colors.add('G');
	Colors.add('R');
	
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
String message = "you have " + Integer.toString(attemptsRemain) + " moves remaining" + " \n";
JFrame frame = new JFrame();	
String ret = "";
boolean valid = false;

while (!valid){
System.out.println(message + " Please enter your guess: ");
Scanner input = new Scanner(System.in);
String move = input.nextLine();
if(confirmMove(move) == true)
{
ret = move.toUpperCase();
valid = true;
}
}
attemptsRemain--;
return ret;
}

private boolean confirmMove(String move) {
	move = move.toUpperCase();
	if(move.equals("HISTORY"))
		return true;
	else if(move.length() != this.numPegs)
		return false;
	else{
		for(int i =0; i < this.numPegs; i++)
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
public static int getNumColors() {
	return numColors;
}

public static void setNumColors(int numColors) {
	Mastermind.numColors = numColors;
}

public static int getNumPegs() {
	return numPegs;
}

public static void setNumPegs(int numPegs) {
	Mastermind.numPegs = numPegs;
}

public static int getNumGuesses() {
	return numGuesses;
}

public static void setNumGuesses(int numGuesses) {
	Mastermind.numGuesses = numGuesses;
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
	for(int i =0; i< this.secretCode.size();i++)
	{
		s.add(Character.toString(this.secretCode.get(i)));
	}
	for(int i =0; i < move.length(); i++)
	{
	int place = move.indexOf(s.get(i));	
	if(place != -1)
	{
		String test = s.get(place);
		String test2 = s.get(i);
		if(s.get(place).equals(s.get(i)))
		{
			bPegs++;
			s.set(place, empty);
			move = move.substring(0,place)+"X"+move.substring(place+1,move.length());
		}
		else
		{
			move = move.substring(0,place)+"X"+move.substring(place+1,move.length());
			//s.set(place, this.empty);
			wPegs++;			
		}
	}
	}
	String histAdd = bPegs + " black pegs and " + wPegs + " white pegs";
	history.get(numMoves).add(histAdd);
	numMoves++;
	String ret = Integer.toString(bPegs) + " " + Integer.toString(wPegs);
	return ret;
	}

public boolean endGame(boolean win)
{
	boolean ret = false;
	//Object[] options = {"OK"};
	//JFrame frame = new JFrame();	

	if(win)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~You win!!~~~~~~~");
	  /*  int n = JOptionPane.showOptionDialog(frame,
                "You win!! ","Dank Games Inc.",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);*/
	}
	else{
		System.out.println("You lost :( \n");
		System.out.println("The secret code was: " + this.secretCode); 
	    /*int n = JOptionPane.showOptionDialog(frame,
                "You lost :( ","Dank Games Inc.",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);*/
		
	}
	/*int result = JOptionPane.showConfirmDialog(null, 
			   "Great game, let's play another?",null, JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
			    ret = true;
			}*/
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("Hit any key to play again. Hit 'Q' to quit.");
	Scanner input = new Scanner(System.in);
	String playAgain = input.nextLine();
			if(!playAgain.equalsIgnoreCase("Q"))
			{
				ret = true;
			
			}
		return ret;
}

}//class