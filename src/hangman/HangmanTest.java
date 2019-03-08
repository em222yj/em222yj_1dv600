package hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HangmanTest {
	
	Hangman sut = new Hangman();

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@org.junit.Test
	boolean playTest() {
		if(sut.play()) {
			return true;
		}
		return false;
	}
	
	@org.junit.Test
	void randomWordTest() {
		
	}

}
