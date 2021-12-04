package encrypt;

public class encrypt {

	public static void main(String[] args) {
		String passString = ("12222");
		
		System.out.println(encrypt(passString));

	}
	
	public static String encrypt(String plainText) {
	    byte[] bytes = plainText.getBytes();
	    byte[] pszDigest = new byte[32];
	    KISA_SHA256.SHA256_Encrpyt(bytes, bytes.length, pszDigest);
	    StringBuffer encrypted = new StringBuffer();
	    for (int i = 0; i < 32; i++) {
	      encrypted.append(String.format("%02x", pszDigest[i]));
	    }
	    return encrypted.toString();
   }
}
