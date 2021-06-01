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
		Encryption e = new Encryption();
		
		String test = e.encrypt("kath,2021-06-01,33,0,kathkath,0,5,5,2021-06-01,0,default,2,0");
		
		System.out.println(test);
		
		System.out.println(e.decrypt("Gtznut2868736;39729262Royg262;2;2868736;397262jklg{rz2826"));
		//System.out.println(e.decrypt(e.encrypt("123")));
		//System.out.println(e.decrypt("Rkyork2vgyy2868736;39726262Zkyz262;2;2868736;397262jklg{rz2726"));
	}
	
}
