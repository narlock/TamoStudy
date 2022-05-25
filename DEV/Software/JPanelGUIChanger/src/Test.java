import java.util.Arrays;
import java.util.stream.Collectors;

import language.EnglishStrategy;
import language.LanguageStrategy;
import profile.Profile;
import profile.ProfileReaderWriter;
import resources.Encryption;

public class Test {
	public static void main(String[] args) {
		Encryption e = new Encryption();

		System.out.println("2.0");
		System.out.println(e.decrypt("Gtznut2868836;38;2868836;38;2626262jklg{rz26262926262Royg292;2;266666666"));
		/*
		 *  * Key Guide:
			 * [2] -> New Login String
			 * [3] -> Total Time Studied in seconds
			 * [4] -> Total Money
			 * [5] -> Current Background Indicator
			 * [6] -> GUI Background Color Indicator
			 * 
			 * [8] -> Settings / Focus Mode Indicator
			 * [9] -> Settings / Language Indicator
			 * [10] -> Settings / Session Sound Indicator
			 * [11] -> Settings / Background Sound Indicator
			 * [12] -> Tamo Name (string)
			 * [13] -> Tamo ID (corresponding to Tamo Image)
			 * [14] -> Tamo Happiness Integer
			 * [15] -> Tamo Hunger Integer
			 * [16] -> Achievement Indicator String
		 */
		
		System.out.println("3.0");
		System.out.println(e.decrypt("g2868836;38;2868836;38;262626262jklg{rz262626262626262j292;2;26666666623"));
		System.out.println(e.encrypt("anthony,2021-09-09,2022-01-09,1438945,19740,0,default,0,2,0,1,0,Lisa,2,10,5,11100001"));
		
		System.out.println("Reemz");
		System.out.println(e.decrypt("Qgxosg2868836:3762868836:379262629276?;8;2767>26262626262626262626262623"));
	}
}
