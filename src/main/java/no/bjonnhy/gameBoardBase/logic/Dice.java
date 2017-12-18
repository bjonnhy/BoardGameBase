package no.bjonnhy.gameBoardBase.logic;

import java.security.SecureRandom;

import no.bjonnhy.gameBoardBase.enums.DiceType;

/**
 * Static class that provides dice throws
 * @author bjonnhy
 */
public final class Dice {

	/**
	 * Private constructor to remove the 
	 * default so its practically impossible
	 * to instantiate a object of this class
	 */
	private Dice() {
		// should not do anything
	}

	/**
	 * Generates a random number (throwing a dice) with
	 * the given dice
	 * 
	 * @param diceType - The {@linkplain DiceType} to throw
	 * @return The value of the thrown dice
	 */
	public static int throwDice(DiceType diceType) {
		SecureRandom sr = new SecureRandom();
		// generates a value between 0 (inclusive)
		// and dice (exclusive), thus +1 so we get
		// values from 1 (inclusive) to
		// dice (inclusive)
		return sr.nextInt(diceType.getSides()) + 1;
	}
	
	/**
	 * Throws the given dice the given number of times
	 * @param diceType - The {@linkplain DiceType} to throw
	 * @param numOfTosses - Number of tosses to do
	 * @return An array of ints with the throws
	 */
	public static int[] throwMultipleDices(DiceType diceType, int numOfTosses) {
		int[] tosses = new int[numOfTosses];
		
		// call the "one time toss" for the number
		// of tosses we want. Store the values in the array
		for(int i = 0; i < numOfTosses; i++) {
			tosses[i] = throwDice(diceType);
		}
		
		return tosses;
	}
}
