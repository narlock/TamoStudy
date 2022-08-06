package resources;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.json.simple.JSONObject;

public class Settings {
	private String version;
	private String studyMode;
	private String tamoStudyProfileString;
	private Color backgroundColor;
	private Color textColor;
	private int soundIndicator;
	private boolean showWindowAdapter;
	
	/**
	 * Timer Settings
	 * 
	 * Colors
	 * Border
	 * Font
	 */
	private Color timerBackgroundColor;
	private Color timerBorderColor;
	
	private String timerBorderType;
	private long timerBorderThickness;
	
	private String fontString;
	private String subFontString;
	private Font timerFont;
	private Font timerSubFont;
	private long timerFontSize;
	private long timerSubFontSize;
	
	/**
	 * Clock Settings
	 * 
	 * General
	 * Colors
	 * Border
	 * Font
	 */
	private Color clockBackgroundColor;
	private Color clockBorderColor;
	private String clockBorderType;
	private long clockBorderThickness;	
	private boolean clockEnabled;
	
	public Settings() {
		this.version = "0.1";
		this.studyMode = "Pomodoro";
		this.backgroundColor = Color.DARK_GRAY;
		this.textColor = Color.WHITE;
		this.soundIndicator = 1;
		this.showWindowAdapter = true;
		this.tamoStudyProfileString = "null";
		
		this.timerBackgroundColor = Color.GRAY;
		this.timerBorderColor = Color.BLACK;
		this.timerBorderType = "Rounded";
		this.timerBorderThickness = 8;
		
		this.timerFontSize = 90;
		this.timerSubFontSize = 20;
		this.fontString = "Tahoma";
		this.subFontString = "Tahoma";
		this.timerFont = new Font(fontString, Font.BOLD, (int) timerFontSize);
		this.timerSubFont = new Font(subFontString, Font.BOLD, (int) timerSubFontSize);
		
		this.clockBackgroundColor = Color.GRAY;
		this.clockBorderColor = Color.BLACK;
		this.clockBorderType = "Rounded";
		this.clockBorderThickness = 8;
		this.clockEnabled = false;
	}
	
	public Settings(
			String version,
			String studyMode,
			String tamoStudyProfileString,
			Color backgroundColor,
			Color textColor,
			long soundIndicator,
			boolean showWindowAdapter,
			Color timerBackgroundColor,
			Color timerBorderColor,
			String timerBorderType,
			long timerBorderThickness,
			String fontString,
			String subFontString,
			long timerFontSize,
			long timerSubFontSize,
			Color clockBackgroundColor,
			Color clockBorderColor,
			String clockBorderType,
			long clockBorderThickness,
			boolean clockEnabled
	) 
	{
		this.version = version;
		this.studyMode = studyMode;
		this.tamoStudyProfileString = tamoStudyProfileString;
		this.backgroundColor = backgroundColor;
		this.textColor = textColor;
		this.soundIndicator = (int) soundIndicator;
		this.showWindowAdapter = showWindowAdapter;
		
		this.timerBackgroundColor = timerBackgroundColor;
		this.timerBorderColor = timerBorderColor;
		this.timerBorderType = timerBorderType;
		this.timerBorderThickness = timerBorderThickness;
		this.fontString = fontString;
		this.subFontString = subFontString;
		this.timerFontSize = timerFontSize;
		this.timerSubFontSize = timerSubFontSize;
		
		this.clockBackgroundColor = clockBackgroundColor;
		this.clockBorderColor = clockBorderColor;
		this.clockBorderType = clockBorderType;
		this.clockBorderThickness = clockBorderThickness;
		this.clockEnabled = clockEnabled;
		
		this.timerFont = new Font(fontString, Font.BOLD, (int) timerFontSize);
		this.timerSubFont = new Font(subFontString, Font.BOLD, (int) timerSubFontSize);
	}
	
	public void setTimerBorder(JPanel panel) {
		if(timerBorderType.equals("Rounded")) {
			panel.setBorder(new RoundedBorder(timerBorderColor, (int) timerBorderThickness, 20, 10, true));
		} else {
			panel.setBorder(new NormalBorder(timerBorderColor, (int) timerBorderThickness, 20, 10, true));
		}
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
	
	@SuppressWarnings("unchecked")
	public JSONObject getJsonObject() {
		JSONObject obj = new JSONObject();
		obj.put("version", version);
		obj.put("studyMode", studyMode);
		obj.put("tamoStudyProfileString", tamoStudyProfileString);
		
		ArrayList<Integer> backgroundColorRgb = new ArrayList<Integer>();
		backgroundColorRgb.add(backgroundColor.getRed());
		backgroundColorRgb.add(backgroundColor.getGreen());
		backgroundColorRgb.add(backgroundColor.getBlue());
		obj.put("backgroundColor", backgroundColorRgb);
		
		ArrayList<Integer> textColorRgb = new ArrayList<Integer>();
		textColorRgb.add(textColor.getRed());
		textColorRgb.add(textColor.getGreen());
		textColorRgb.add(textColor.getBlue());
		obj.put("textColor", textColorRgb);
		
		obj.put("soundIndicator", soundIndicator);
		obj.put("showWindowAdapter", showWindowAdapter);
		
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
		
		obj.put("timerBorderType", timerBorderType);
		obj.put("timerBorderThickness", timerBorderThickness);
		obj.put("fontString", fontString);
		obj.put("subFontString", subFontString);
		obj.put("timerFontSize", timerFontSize);
		obj.put("timerSubFontSize", timerSubFontSize);
		
		ArrayList<Integer> clockBackgroundColorRgb = new ArrayList<Integer>();
		clockBackgroundColorRgb.add(clockBackgroundColor.getRed());
		clockBackgroundColorRgb.add(clockBackgroundColor.getGreen());
		clockBackgroundColorRgb.add(clockBackgroundColor.getBlue());
		obj.put("clockBackgroundColor", clockBackgroundColorRgb);
		
		ArrayList<Integer> clockBorderColorRgb = new ArrayList<Integer>();
		clockBorderColorRgb.add(clockBorderColor.getRed());
		clockBorderColorRgb.add(clockBorderColor.getGreen());
		clockBorderColorRgb.add(clockBorderColor.getBlue());
		obj.put("clockBorderColor", clockBorderColorRgb);
		
		obj.put("clockBorderType", clockBorderType);
		obj.put("clockBorderThickness", clockBorderThickness);
		obj.put("clockEnabled", clockEnabled);
		
		return obj;
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
		return timerSubFontSize;
	}

	public void setSessionFontSize(int sessionFontSize) {
		this.timerSubFontSize = sessionFontSize;
	}

	public Font getSessionFont() {
		return timerSubFont;
	}

	public void setSessionFont(Font sessionFont) {
		this.timerSubFont = sessionFont;
	}
	
	public String getFontString() {
		return fontString;
	}
	
	public void setFontString(String fontString) {
		this.fontString = fontString;
	}

	public int getSoundIndicator() {
		return soundIndicator;
	}

	public void setSoundIndicator(int soundIndicator) {
		this.soundIndicator = soundIndicator;
	}
	
	public long getTimerBorderThickness() {
		return timerBorderThickness;
	}
	
	public void setTimerBorderThickness(long borderThickness) {
		this.timerBorderThickness = borderThickness;
	}
	
	public String getBorderType() {
		return timerBorderType;
	}
	
	public void setBorderType(String borderType) {
		this.timerBorderType = borderType;
	}
	
	public boolean isShowWindowAdapter() {
		return showWindowAdapter;
	}

	public void setShowWindowAdapter(boolean showWindowAdapter) {
		this.showWindowAdapter = showWindowAdapter;
	}

	public Color getClockBackgroundColor() {
		return clockBackgroundColor;
	}

	public void setClockBackgroundColor(Color clockBackgroundColor) {
		this.clockBackgroundColor = clockBackgroundColor;
	}

	public Color getClockBorderColor() {
		return clockBorderColor;
	}

	public void setClockBorderColor(Color clockBorderColor) {
		this.clockBorderColor = clockBorderColor;
	}

	public String getClockBorderType() {
		return clockBorderType;
	}

	public void setClockBorderType(String clockBorderType) {
		this.clockBorderType = clockBorderType;
	}

	public long getClockBorderThickness() {
		return clockBorderThickness;
	}

	public void setClockBorderThickness(long clockBorderThickness) {
		this.clockBorderThickness = clockBorderThickness;
	}

	public boolean isClockEnabled() {
		return clockEnabled;
	}

	public void setClockEnabled(boolean clockEnabled) {
		this.clockEnabled = clockEnabled;
	}

	public String getTamoStudyProfileString() {
		return tamoStudyProfileString;
	}

	public void setTamoStudyProfileString(String tamoStudyProfileString) {
		this.tamoStudyProfileString = tamoStudyProfileString;
	}

	public String getSubFontString() {
		return subFontString;
	}

	public void setSubFontString(String subFontString) {
		this.subFontString = subFontString;
	}
	
}
