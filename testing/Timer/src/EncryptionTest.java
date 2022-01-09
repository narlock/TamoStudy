/**
 * 
 * @author Anthony Narlock
 * @description Encrypts files so users can't "cheat" system
 *
 */

public class EncryptionTest {
	
	protected int key = 6;
	
	/*
	 * Simple Encryption algorithm by me:
	 * 
	 * Essentially, this just returns an incremented amount of ascii characters as the same message.
	 * Meaning the Letter "H" corresponds to the encrypted letter "N"
	 * Since in the alphabet, H 1 2 3 4 5 N(6), N is the 6th letter after H.
	 * 
	 */
	
	//Encrypts the string and returns it
	public String encrypt(String message) {
		
		char[] chars = message.toCharArray();
		for(int i = 0; i < message.length(); i++) {
			chars[i] += key;
		}
		
		String encryptedMessage = new String(chars);
		return encryptedMessage;
		
		
	}
	
	//Decrypts the string and returns it
	public String decrypt(String message) {
		char[] chars = message.toCharArray();
		for(int i = 0; i < message.length(); i++) {
			chars[i] -= key;
		}
		
		String encryptedMessage = new String(chars);
		return encryptedMessage;
	}
	
	
	public static void main(String[] args) {
		EncryptionTest e = new EncryptionTest();

		System.out.println("2.0");
		System.out.println(e.decrypt("gtznut2868736?36?2868736?36?27:9>?:;27?=:6262jklg{rz26282627262Royg282762;277766667"));
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
		System.out.println(e.decrypt("gtznut2868736?36?2868736?36?27:9>?:;27?=:6262jklg{rz26282627262Royg282762;277766667"));
		System.out.println(e.encrypt("anthony,2021-09-09,2022-01-09,1438945,19740,0,default,0,2,0,1,0,Lisa,2,10,5,11100001"));
		
		System.out.println(e.decrypt("zkyz2868836736?2626287262;2;2868836736?262jklg{rz2926"));
		System.out.println(e.encrypt("tq121,2022-01-09,2021-12-31,0,0,0,default,0,0,0,0,0,23121,2,5,5,00000000"));
	}
	
}
