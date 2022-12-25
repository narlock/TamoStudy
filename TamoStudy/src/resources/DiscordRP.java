package resources;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

public class DiscordRP {
	private boolean running = true;
	private long created = 0;
	
	public void start() {
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
	
	public void shutdown() {
		running = false;
		DiscordRPC.discordShutdown();
	}
	
	public void update(String firstLine, String secondLine) {
		DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
		b.setBigImage("large", "");
		b.setDetails(firstLine);
		b.setStartTimestamps(created);
		DiscordRPC.discordUpdatePresence(b.build());
	}
}
