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
		System.out.println(e.decrypt("Sgxok286873773772868836;38;2:;27;>=879289672:2mxk2626262<2926262Lxgtioy272762;2777776772<h"));
		System.out.println(e.encrypt("anthony,2021-09-09,2022-01-09,1438945,19740,0,default,0,2,0,1,0,Lisa,2,10,5,11100001"));
		
		System.out.println("Luv");
		System.out.println(e.decrypt("h:462r{|2868836;38=262828><968:27?:=<26262626262826262726262huumok2923"));
		System.out.println(e.encrypt("b4.0,luv,2021-12-30,2022-05-28,19476,2863024,4,0,0,boogie,5,5,3,0,000000100000,01234,2,0,0,0,1"));
		System.out.println(e.decrypt("h:462Sgxok286873773772868836;38>2896727;>=8792:26262Lxgtioy2>29272:277766676666626:2629262627"));
	}
}
