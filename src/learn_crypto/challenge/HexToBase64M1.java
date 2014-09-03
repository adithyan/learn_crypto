//$Id$
package learn_crypto.challenge;

import learn_crypto.util.CryptoUtil;
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
		byte[] inputStrAsBytes = CryptoUtil.BASE16_DECODE(INPUT_STR);
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String encodedStr = base64Encoder.encode(inputStrAsBytes);
		System.out.println(encodedStr);
		if(BASE64_STR.equals(encodedStr)){
			System.out.println("Challenge 1 complete");
		}
	}

}
