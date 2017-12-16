package no.bjonnhy.gameBoardBase.event;

/**
 * Listens to playerchanges
 * @author bjonnhy
 */
public interface PlayerListener extends EventListener {
	
	/**
	 * Handle that a players state has changed
	 * @param event - A {@linkplain PlayerEvent}s
	 */
	public void playerStateChanged(PlayerEvent event);
}
