package hangman;

public class HangmanMain {

	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		
		while(hangman.play()) {
			int input = hangman.gameMenu();
			
			switch(input) {
			case 1: hangman.playGame(); 
					break;
					
			case 2: hangman.quitGame(); 
					break;
					
			default: System.out.println("Incorrect number"); break;
			}
		}

	}

}
