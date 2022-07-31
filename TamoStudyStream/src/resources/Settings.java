package resources;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Settings {
	private String version;
	private String studyMode;
	private String fontString;
	
	private Color backgroundColor;
	private Color timerBackgroundColor;
	private Color timerBorderColor;
	private Color textColor;
	
	private Font timerFont;
	private Font sessionFont;
	private long timerFontSize;
	private long sessionFontSize;
	
	private int soundIndicator;
	
	public Settings() {
		this.version = "0.1";
		this.studyMode = "pomodoro";
		this.fontString = "Tahoma";
		this.backgroundColor = Color.DARK_GRAY;
		this.timerBackgroundColor = Color.GRAY;
		this.timerBorderColor = Color.BLACK;
		this.textColor = Color.WHITE;
		this.timerFontSize = 90;
		this.timerFont = new Font(fontString, Font.BOLD, (int) timerFontSize);
		this.sessionFontSize = 20;
		this.sessionFont = new Font(fontString, Font.BOLD, (int) sessionFontSize);
		this.soundIndicator = 1;
	}
	
	public Settings(
			String version,
			String studyMode,
			Color backgroundColor,
			Color timerBackgroundColor,
			Color timerBorderColor,
			Color textColor,
			String timerFontString,
			long timerFontSize,
			long sessionFontSize,
			long soundIndicator
	) 
	{
		this.version = version;
		this.studyMode = studyMode;
		this.backgroundColor = backgroundColor;
		this.timerBackgroundColor = timerBackgroundColor;
		this.timerBorderColor = timerBorderColor;
		this.textColor = textColor;
		this.fontString = timerFontString;
		this.timerFontSize = timerFontSize;
		this.sessionFontSize = sessionFontSize;
		this.timerFont = new Font(fontString, Font.BOLD, (int) timerFontSize);
		this.sessionFont = new Font(fontString, Font.BOLD, (int) sessionFontSize);
		this.soundIndicator = (int) soundIndicator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStudyMode() {
		return studyMode;
	}

	public void setStudyMode(String studyMode) {
		this.studyMode = studyMode;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Color getTimerBackgroundColor() {
		return timerBackgroundColor;
	}

	public void setTimerBackgroundColor(Color timerBackgroundColor) {
		this.timerBackgroundColor = timerBackgroundColor;
	}

	public Color getTimerBorderColor() {
		return timerBorderColor;
	}

	public void setTimerBorderColor(Color timerBorderColor) {
		this.timerBorderColor = timerBorderColor;
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public Font getFont() {
		return timerFont;
	}

	public void setFont(Font font) {
		this.timerFont = font;
	}

	public long getTimerFontSize() {
		return timerFontSize;
	}

	public void setTimerFontSize(int timerFontSize) {
		this.timerFontSize = timerFontSize;
	}

	public long getSessionFontSize() {
		return sessionFontSize;
	}

	public void setSessionFontSize(int sessionFontSize) {
		this.sessionFontSize = sessionFontSize;
	}

	public Font getSessionFont() {
		return sessionFont;
	}

	public void setSessionFont(Font sessionFont) {
		this.sessionFont = sessionFont;
	}
	
	public String getFontString() {
		return fontString;
	}
	
	public void setFontString(String fontString) {
		this.fontString = fontString;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getJsonObject() {
		JSONObject obj = new JSONObject();
		obj.put("version", version);
		obj.put("studyMode", studyMode);
		
		ArrayList<Integer> backgroundColorRgb = new ArrayList<Integer>();
		backgroundColorRgb.add(backgroundColor.getRed());
		backgroundColorRgb.add(backgroundColor.getGreen());
		backgroundColorRgb.add(backgroundColor.getBlue());
		obj.put("backgroundColor", backgroundColorRgb);
		
		ArrayList<Integer> timerBackgroundColorRgb = new ArrayList<Integer>();
		timerBackgroundColorRgb.add(timerBackgroundColor.getRed());
		timerBackgroundColorRgb.add(timerBackgroundColor.getGreen());
		timerBackgroundColorRgb.add(timerBackgroundColor.getBlue());
		obj.put("timerBackgroundColor", timerBackgroundColorRgb);
		
		ArrayList<Integer> timerBorderColorRgb = new ArrayList<Integer>();
		timerBorderColorRgb.add(timerBorderColor.getRed());
		timerBorderColorRgb.add(timerBorderColor.getGreen());
		timerBorderColorRgb.add(timerBorderColor.getBlue());
		obj.put("timerBorderColor", timerBorderColorRgb);
		
		ArrayList<Integer> textColorRgb = new ArrayList<Integer>();
		textColorRgb.add(textColor.getRed());
		textColorRgb.add(textColor.getGreen());
		textColorRgb.add(textColor.getBlue());
		obj.put("textColor", textColorRgb);
		
		obj.put("font", fontString);
		obj.put("timerFontSize", timerFontSize);
		obj.put("sessionFontSize", sessionFontSize);
		obj.put("soundIndicator", soundIndicator);
		
		return obj;
	}

	public int getSoundIndicator() {
		return soundIndicator;
	}

	public void setSoundIndicator(int soundIndicator) {
		this.soundIndicator = soundIndicator;
	}

	public String getSoundPath() {
		switch(soundIndicator) {
			case 1:
				return "SOFT_ALARM.wav";
			case 2:
				return "TRAD_ALARM.wav";
			case 3:
				return "PAC_ALARM.wav";
		}
		return null;
	}

	public String getSoundName() {
		switch(soundIndicator) {
			case 0:
				return "Disabled";
			case 1:
				return "Soft Alarm";
			case 2:
				return "Trad Alarm";
			case 3:
				return "Pac Alarm";
		}
		return null;
	}
	
}
