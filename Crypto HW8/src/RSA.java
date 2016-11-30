import java.math.BigInteger;
import java.security.SecureRandom;


public class RSA {
	
	private BigInteger[] privateKey;
	public BigInteger[] publicKey;
	
	public void generateKey() {
		BigInteger p = BigInteger.probablePrime(1024, new SecureRandom());
		BigInteger q = BigInteger.probablePrime(1024, new SecureRandom());
		BigInteger temp1 = p.subtract(BigInteger.ONE);
		BigInteger temp2 = q.subtract(BigInteger.ONE);
		BigInteger fn = temp1.multiply(temp2);
		BigInteger e = findE(fn);
		BigInteger d = e.modInverse(fn);
		
		BigInteger pq = p.multiply(q);
		publicKey = new BigInteger[2];
		publicKey[0] = e;
		publicKey[1] = pq;
		privateKey = new BigInteger[2];
		privateKey[0] = d;
		privateKey[1] = pq;

	}
	
	private BigInteger findE(BigInteger fn) {

		while (true) {
			BigInteger e = new BigInteger(1023, new SecureRandom());
			if (fn.gcd(e).equals(BigInteger.ONE)) return e;
		}
	}
	

}
