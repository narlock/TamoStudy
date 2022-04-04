
public class SubstringTest {
	public static void main(String[] args) {
		String str = "0100";
		
		String[] arr = new String[4];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = str.substring(i,i+1);
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
	}
}
