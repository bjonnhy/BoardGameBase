package no.bjonnhy.gameBoardBase.event;

/**
 * Listens for dicethrows
 * @author bjonnhy
 */
public interface DiceListener extends EventListener{
	
	/**
	 * Handle that a dice has been thrown
	 * @param event - A {@linkplain DiceEvent}
	 */
	public void diceThrown(DiceEvent event);
}
