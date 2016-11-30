import java.math.BigInteger;

public class Tester {

	public static void main(String[] args) {
		//does not do anything rn, just checks if RSA compiles
		RSA test = new RSA();
		test.generateKey();

		BigInteger M = RSAHelper.C4.modPow(RSAHelper.eVince, RSAHelper.nVince);
		
		String X = RSAHelper.recoverTextFromBigInteger(M);
		
		System.out.println(X);
		
		//encode string answer into BigInteger
		BigInteger encodedAnswer = RSAHelper.encodeMessageAsBigInteger("Rivest, Shamir and Adleman.");
		
		//Uhh, am I doing this right?
		//"signed" our answer by encrypting with our private key
		BigInteger signedAnswer = encodedAnswer.modPow(RSA.privateKey[0],RSA.privateKey[1]);
		
		//Encrypt our encrypted answer with his public key
		BigInteger signedEncryptedAnswer = signedAnswer.modPow(RSAHelper.eVince, RSAHelper.nVince);
	}

}
