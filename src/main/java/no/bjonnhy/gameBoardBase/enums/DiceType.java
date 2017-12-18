package no.bjonnhy.gameBoardBase.enums;

/**
 * Different types of dices used in games
 * @author bjonnhy
 */
public enum DiceType {
	D6   (6),
	D12 (12),
	D14 (14),
	D16 (16),
	D18 (18),
	D20 (20);
	
	/** Number of sides on the dice */
	private int sides;
	
	/** Just for private use. Sets the number
	 * of sides a DiceType has
	 * @param sides - Number of sides
	 */
	private DiceType(int sides) {
		this.sides = sides;
	}
	
	/**
	 * Gets the number of sides a DiceType has
	 * @return The number of sides
	 */
	public int getSides() {
		return this.sides;
	}
}
