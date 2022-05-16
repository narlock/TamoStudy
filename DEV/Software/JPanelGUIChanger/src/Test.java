import language.EnglishStrategy;
import language.LanguageStrategy;

public class Test {
	public static void main(String[] args) {
		LanguageStrategy lang = new EnglishStrategy();
		
		for(int i = 0; i < lang.text.length; i++) {
			System.out.println(lang.text[i]);
		}
		
	}
}
