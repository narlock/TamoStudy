package resources;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

/**
 * DiscordRP
 * 
 * @author narlock
 *
 * @brief Utilizes Discord Rich Presence JAR
 * to support Rich Presence for TamoStudy
 */
public class DiscordRP {
	private boolean running = true;
	private long created = 0;
	private DiscordEventHandlers handlers;
	
	/**
	 * start
	 * @brief Initiates Rich Presence
	 */
	public void start() {
		if(System.getProperty("os.name").contains("Windows")) {
			System.out.println("started");
			this.created = 	System.currentTimeMillis();
			
			DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
				System.out.println("TamoStudy + Discord Rich Presence ready for  " + user.username + "#" + user.discriminator + "!");
				update("TamoStudy starting...", "");
			}).build();
			
			DiscordRPC.discordInitialize("1056586375484424263", handlers, true);
			
			new Thread("Discord Rich Presence") {
				@Override
				public void run() {
					while(running) {
						DiscordRPC.discordRunCallbacks();
					}
				}
			}.start();
		}
	}
	
	/**
	 * shutdown
	 * @brief shuts down Rich Presence
	 */
	public void shutdown() {
		if(System.getProperty("os.name").contains("Windows")) {
			running = false;
			DiscordRPC.discordShutdown();
		}
	}
	
	/**
	 * update
	 * @brief Updates Rich Presence
	 * @param firstLine
	 * @param secondLine
	 */
	public void update(String firstLine, String secondLine) {
		if(System.getProperty("os.name").contains("Windows")) {
			DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
			b.setBigImage("large", "");
			b.setDetails(firstLine);
			b.setStartTimestamps(created);
			DiscordRPC.discordUpdatePresence(b.build());
		}
	}
}
