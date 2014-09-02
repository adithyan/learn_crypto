//$Id$
package learn_crypto;

import sun.misc.BASE64Encoder;

/**
 * <pre>
 * Challenge No.1 
 * Need to convert the given hex to base64
 * 
 * The string:
 * 49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d
 * 
 * Should produce:
 * SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t
 * 
 * </pre>
 * 
 * @author adithyan-1244
 *
 */
public class HexToBase64M1 {
	
	private static final String INPUT_STR = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
	
	private static final String BASE64_STR = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t";
	
	public static void main (String[] args) {
		byte[] inputStrAsBytes = BASE16_DECODE(INPUT_STR);
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String encodedStr = base64Encoder.encode(inputStrAsBytes);
		System.out.println(encodedStr);
		if(BASE64_STR.equals(encodedStr)){
			System.out.println("Challenge 1 complete");
		}
	}
	
	public static byte[] BASE16_DECODE(String b16str) {
		int len = b16str.length();
		byte[] out = new byte[len / 2];
		int j = 0;
		for (int i = 0; i < len; i += 2) {
			int c1 = INT(b16str.charAt(i));
			int c2 = INT(b16str.charAt(i + 1));
			int bt = c1 << 4 | c2;
			out[j++] = (byte) bt;
		}
		return out;
	}
	
	// to convert the char of HEX array to integer
	/**
	 * TODO: need to check why unable to return "Integer" as return value, now it is converted to "int" 
	 * @param c
	 * @return
	 */
	public static int INT(char c) {
		return Integer.parseInt(Integer.decode("0x" + c).toString());
	}

}
