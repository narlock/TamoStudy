import java.util.Arrays;
import java.util.stream.Collectors;

import language.EnglishStrategy;
import language.LanguageStrategy;

public class Test {
	public static void main(String[] args) {
		String[] myArr = {"0","1","2","3"};
		
		int indicator = 4;
		
		StringBuilder builder = new StringBuilder();
		for(String s : myArr) {
		    builder.append(s);
		}
		String str = builder.toString();
		
		System.out.println(str);
	}
}
