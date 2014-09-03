//$Id$
package learn_crypto.util;

public class CryptoUtil {

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
	
	/**
     * Bytes to hexa value
     * 
     * @param b byte array
     * @return
     */
    public static String BASE16_ENCODE(byte[] b){
    	StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
    }

	/**
	 * To convert the char of HEX array to integer
	 * TODO: Need to check why unable to return "Integer" as return value, now it is converted to "int" 
	 * Works in JDK 6 but not in 7 Need to check why.
	 * 
	 * @param c
	 * @return
	 */
	public static int INT(char c) {
		return Integer.decode("0x" + c);
	}
	
	/**
	 * Takes to Equal length byte array and does the XOR.
	 * @see http://en.wikipedia.org/wiki/XOR_gate
	 * 
	 * @param b1
	 * @param b2
	 * @return
	 * @throws Exception 
	 */
	public static byte[] doXOR (byte[] b1, byte[] b2) throws Exception {
		if(b1.length != b2.length) {
			throw new Exception("Input array should be of equal length");
		} else {
			byte[] outByte = new byte[b1.length];
			for(int i = 0; i < b1.length; i ++) {
				outByte[i] = (byte) (doAND(b1[i], doNOT(b2[i])) + doAND(doNOT(b1[i]), b2[i]));
			}
			return outByte;
		}
	}
	
	/**
	 * Does NOT operation
	 * 
	 * @param b
	 * @return
	 */
	private static byte doNOT (byte b) {
		return (byte) ~b;
	}
	
	/**
	 * Does AND operation
	 * @param b1
	 * @param b2
	 * @return
	 */
	private static byte doAND (byte b1, byte b2) {
		return (byte) (b1 & b2);
	}
	
	/**
	 * For debugging purpose
	 * @see http://stackoverflow.com/questions/12310017/how-to-convert-a-byte-to-its-binary-string-representation
	 * 
	 * @param b
	 */
	@SuppressWarnings("unused")
	private static void printBinaryString (byte b) {
		String s1 = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
		System.out.println(s1);
	}
	
}
