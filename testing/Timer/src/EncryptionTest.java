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
		
		System.out.println(e.decrypt("vuru6r2868736=37:26262}yG262;2;2868736=37:262jklg{rz282:"));
		System.out.println(e.decrypt("zkyz2868736=36<2868736=36<2<6:>662???9<??2:2mxkkt26262626262zkyz282;276277777676"));
	}
	
}
