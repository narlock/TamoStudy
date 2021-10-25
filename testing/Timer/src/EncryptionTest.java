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
		
		System.out.println(e.encrypt("Marie,2021-10-14,2021-10-14,41837,373,0,default,0,0,0,0,0,Francis,5,5,5,00000100"));
		
		System.out.println(e.decrypt("Sgxok2868737637:26272868737637:2Lxgtioy26262629=926262:7>9=262626266666766"));
		System.out.println(e.decrypt("gtznut2868736?36?2868736?36?2=;?=>?276:?:262jklg{rz26282627262Royg282762;277766667"));
	}
	
}
