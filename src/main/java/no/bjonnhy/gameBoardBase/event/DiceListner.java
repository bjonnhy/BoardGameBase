package no.bjonnhy.gameBoardBase.event;

/**
 * Listens for dicethrows
 * @author bjonnhy
 */
public interface DiceListner extends EventListener{
	
	/**
	 * Handle that a dice has been thrown
	 * @param event - A {@linkplain DiceEvent}
	 */
	public void diceThrown(DiceEvent event);
}
