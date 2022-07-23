import java.awt.Color;
import java.awt.Font;

public class Settings {
	private String version;
	private String studyMode;
	
	private Color backgroundColor;
	private Color timerBackgroundColor;
	private Color timerBorderColor;
	private Color textColor;
	
	private Font font;
	private int timerFontSize;
	private int sessionFontSize;
	
	public Settings(
			String version,
			String studyMode,
			Color backgroundColor,
			Color timerBackgroundColor,
			Color timerBorderColor,
			Color textColor,
			Font font,
			int timerFontSize,
			int sessionFontSize
	) 
	{
		this.version = version;
		this.studyMode = studyMode;
		this.backgroundColor = backgroundColor;
		this.timerBackgroundColor = timerBackgroundColor;
		this.timerBorderColor = timerBorderColor;
		this.textColor = textColor;
		this.font = font;
		this.timerFontSize = timerFontSize;
		this.sessionFontSize = sessionFontSize;
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
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public int getTimerFontSize() {
		return timerFontSize;
	}

	public void setTimerFontSize(int timerFontSize) {
		this.timerFontSize = timerFontSize;
	}

	public int getSessionFontSize() {
		return sessionFontSize;
	}

	public void setSessionFontSize(int sessionFontSize) {
		this.sessionFontSize = sessionFontSize;
	}
	
	
}
