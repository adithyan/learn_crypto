//$Id$
package learn_crypto.util;

public class CryptoUtil {

	public static byte[] BASE16_DECODE(String b16str) {
		int len = b16str.length();
		byte[] out = new byte[len / 2];
		int j = 0;
		for (int i = 0; i < len; i += 2) {
			int c1 = CryptoUtil.INT(b16str.charAt(i));
			int c2 = CryptoUtil.INT(b16str.charAt(i + 1));
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
