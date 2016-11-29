import java.math.BigInteger;
import java.security.SecureRandom;


public class RSA {

	public static void main(String args[]) {
		generateKey();
	}
	
	public static void generateKey() {
		BigInteger p = BigInteger.valueOf(17);
		BigInteger q = BigInteger.valueOf(11);
		BigInteger temp1 = p.subtract(BigInteger.ONE);
		BigInteger temp2 = q.subtract(BigInteger.ONE);
		BigInteger fn = temp1.multiply(temp2);
		System.out.println(fn.toString() + " " + findE(fn));
	}
	
	private static BigInteger findE(BigInteger fn) {

		while (true) {
			BigInteger e = new BigInteger(1023, new SecureRandom());
			if (fn.gcd(e).equals(BigInteger.ONE)) return e;
		}
	}
	

}
