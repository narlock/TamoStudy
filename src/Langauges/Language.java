package Langauges;

/*
 * @author Anthony Narlock
 * This abstract Language class defines what each type of Langauge will outline
 * 
 * Each profile will be assigned an integer value that will determine their language
 * The language can be modified afterwards.
 * 
 * Example:
 * 
 * 1 - English
 * 2 - Spanish
 * 3 - Portuguese
 */

public abstract class Language {

	private String lang;
	
	public Language(String lang) {
		this.lang = lang;
	}
	
	/*
	 * getText(int num) is a method that will return a string of text in the preferred language
	 * the num parameter indicates the message number that will be returned.
	 */
	
	public String getText(int num) {
		return null;
	}
}
