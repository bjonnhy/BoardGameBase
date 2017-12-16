package no.bjonnhy.gameBoardBase;

import java.security.SecureRandom;

/**
 * Static class that provides dice throws
 * @author bjonnhy
 */
public final class Dice {
	/** Dice with 6 sides */
	public static final int D6  =  6;
	/** Dice with 12 sides */
	public static final int D12 = 12;
	/** Dice with 16 sides */
	public static final int D16 = 16;
	/** Dice with 18 sides */
	public static final int D18 = 18;
	/** Dice with 20 sides */
	public static final int D20 = 20;

	/**
	 * Private constructor to remoce
	 * default so its practically impossible
	 * to instantiate a object of this class
	 */
	private Dice() {
		// should not do anything
	}

	/**
	 * Generates a random number (throwing a dice) with given
	 * dice
	 * 
	 * @param dice - The dice to throw
	 * @return The value of the thrown dice
	 */
	public static int throwDice(int dice) {
		SecureRandom sr = new SecureRandom();
		// generates a value between 0 (inclusive)
		// and dice (exclusive), thus +1 so we get
		// values from 1 (inclusive) to
		// dice (inclusive)
		return sr.nextInt(dice) + 1;
	}
	
	/**
	 * Throws the given dice the given number of times
	 * @param dice - The dice throw dice
	 * @param numOfTosses - Number of tosses to do
	 * @return An array of ints with the throws
	 */
	public static int[] throwMultipleDices(int dice, int numOfTosses) {
		int[] tosses = new int[numOfTosses];
		
		for(int i = 0; i < numOfTosses; i++) {
			tosses[i] = throwDice(dice);
		}
		
		return tosses;
	}
}
