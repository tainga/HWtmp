import java.math.BigInteger;

public class Tester {

	public static void main(String[] args) {
		//does not do anything rn, just checks if RSA compiles
		RSA test = new RSA();
		test.generateKey();

		BigInteger M = RSAHelper.C4.modPow(RSAHelper.eVince, RSAHelper.nVince);
		
		String X = RSAHelper.recoverTextFromBigInteger(M);
		
		System.out.println(X);
	}

}
