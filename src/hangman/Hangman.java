package hangman;

import java.util.*;

public class Hangman {
	
	public Hangman() {};
	
	private int tryAmount = 10;
	private String shownWord = "";
	private String hiddenWord = "";
	Scanner scan = new Scanner(System.in);
	private boolean menu = true;
	
	public void playGame() {
		randomWord();
		char charGuess = ' ';
		System.out.println("\nWelcome to Hangman!");
		
		while(this.tryAmount > 0) {
			
			System.out.println("Guess the word: \n" + hiddenWord + "\n");
			System.out.println("Guess a character: ");
			charGuess = scan.next().charAt(0);
			boolean correct = false;
			
			for(int i = 0; i < this.shownWord.length(); i++) {
				if(charGuess == this.shownWord.charAt(i)) {
					correct = true;
				}
			}
			
			if(correct == true) {
				int position = this.shownWord.indexOf(charGuess);
				while(position >= 0) {
					replaceChar(charGuess, position);
					position = this.shownWord.indexOf(charGuess, position + 1);
				}
				System.out.println("\nCorrect Guess!");
				
			} else if (correct == false) {
				System.out.println("\nWrong character! Try again!");
				tryAmount--;
			}
			
			System.out.println("You have " + tryAmount + " tries left\n");
			
			if(this.tryAmount == 0) {
				System.out.println("Out of tries!");
				this.menu = false;
			} else if (this.hiddenWord.contains("-") == false) {
				System.out.println("You won!\n");
				this.tryAmount = 0;
				this.menu = false;
			}
		}
	}
	
	public void replaceChar(char str, int pos) {
		StringBuilder sb = new StringBuilder(this.hiddenWord);
		sb.setCharAt(pos, str);
		this.hiddenWord = sb.toString();
	}
	
	public void quitGame() {
		System.out.println("Goodbye!");
	}
	
	public void randomWord() {
		String[] wordToGuess = {"zombie", "vodka", "chewbacca", "queue", "jelly", "jukebox", "skywalker", "microwave", "banjo", "whiskey", "blizzard", "stormtrooper"};
		Random rand = new Random();
		int index = rand.nextInt(wordToGuess.length);
		this.shownWord = wordToGuess[index];
		
		for(int i = 0; i < this.shownWord.length(); i++) {
			this.hiddenWord += "-";
		}
	}
	
	public boolean play() {
		return this.menu;
	}
	
	public int gameMenu() {
		System.out.println("-----------\n"
						 + "| 1: Play |\n"
						 + "| 2: Quit |\n"
						 + "-----------");
		System.out.print("Select a number: ");
		return scan.nextInt();
	}
}
