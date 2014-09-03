//$Id$
package learn_crypto.challenge;

import learn_crypto.util.CryptoUtil;

/**
 * <pre>
 * Challenge No.2
 * Write a function that takes two equal-length buffers and produces their XOR combination.
 * 
 * 
 * Given:
 * Str1 : 1c0111001f010100061a024b53535009181c
 * Str2 : 686974207468652062756c6c277320657965
 * 
 * Expected Output:
 * 746865206b696420646f6e277420706c6179
 * </pre>
 * 
 * @see http://cryptopals.com/sets/1/challenges/2/
 * @author adithyan-1244
 *
 */
public class FixedXOR {
	
	private static final String INPUT_STR_1 = "1c0111001f010100061a024b53535009181c";
	
	private static final String INPUT_STR_2 = "686974207468652062756c6c277320657965";
	
	private static final String EXPECTED_OUTPUT = "746865206b696420646f6e277420706c6179";
	
	public static void main(String[] args) throws Exception {
		
		/*
		 * Converting the Hex string to byte array
		 */
		byte[] inputBytes1 = CryptoUtil.BASE16_DECODE(INPUT_STR_1);
		byte[] inputBytes2 = CryptoUtil.BASE16_DECODE(INPUT_STR_2);
		byte[] outBytes = CryptoUtil.doXOR(inputBytes1, inputBytes2);
		String hexStr = CryptoUtil.BASE16_ENCODE(outBytes);
		System.out.println(hexStr);
		if(EXPECTED_OUTPUT.equals(hexStr)) {
			System.out.println("Challenge 2 complete");
		}
	}

}
