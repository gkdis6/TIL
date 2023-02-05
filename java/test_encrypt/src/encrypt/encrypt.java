package encrypt;

public class encrypt {

	public static void main(String[] args) {
		String passString = ("12222");
		
		System.out.println(encrypt("admin"));
		System.out.println(encrypt("admin").equals("8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918"));
		
		System.out.println("UY19PLKl2R8UrdlAFKGFrvX+mu6i9mtbTBq8ZhHyA0uFgw6YF35RewfYD/KTnQwMlJ1PwpLyr1QLfQGVvNqI9hBidIYynFQWPi0h7f/hpSVoXXpEOUJ62nk5Tqxaypwq3ME6QRvQGDv2oN+ljx1yaYZiYrAS9Wg2B7GhV5yGV3iAY9IRm9C4jiu6nmVqa0H2vQAROhLcfnLY6J9j+Xvtewrvx/brR66/cdNAd/WFVWx6FW0P+BBf+rYz7ZNum4E45trLQHqdUJMWmKVCtD+9QLvsWb59aAGyrPbX44tpHP74cn4Lfx7W4tSaaLXuu7W+ZCIi089KK4/U1ZhrcerwGA\\u003d\\u003d".length());
		System.out.println("QD5skBvFt/KsXdlrXnTgRT6UBf8y7qhFHBsysIXFYMF2FP3WCMFP3IDGq7bindRN0M8ob78ExiVOzI/lB+c2RxaQUasf48fE+KxEOxdKOWZogYzjsCWZ+klDSH6l5QmrLDLL2GJWArrt4j8nLPFDn0OQ1g7Sv4/lPALI9Cps/Q9PCPN93rqigaLYgLOyfZu1pJnzG09CgalY9EE6BU2evxQvwpY4MMxJJ9skAKFyTE6CWaPmLVcIVc8g7tHs1x1LlfmfYry80JaGi+njj0nxXrXVTp8IPx5EpQYKauhtJ6dAcjBg3+xDAk9WkjK+2l0vaLyluDixtagFam4Psb0j4A\\u003d\\u003d".length());
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
