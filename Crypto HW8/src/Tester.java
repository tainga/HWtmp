import java.math.BigInteger;

public class Tester {

	public static void main(String[] args) {
		//does not do anything rn, just checks if RSA compiles
		RSA test = new RSA();
		test.generateKey();

		//decrypt question
		BigInteger M = RSAHelper.C4.modPow(RSAHelper.eVince, RSAHelper.nVince);
		
		String X = RSAHelper.recoverTextFromBigInteger(M);
		System.out.println(X);
		
		//encode string answer into BigInteger
		BigInteger encodedAnswer = RSAHelper.encodeMessageAsBigInteger("Rivest, Shamir and Adleman.");
		
		//"signed" our answer by encrypting with our private key
		BigInteger signedAnswer = encodedAnswer.modPow(RSA.privateKey[0],RSA.privateKey[1]);
		
		//Encrypt our encrypted answer with his public key
		BigInteger signedEncryptedAnswer = signedAnswer.modPow(RSAHelper.eVince, RSAHelper.nVince);
		
		//encrypted message in decimal
		//System.out.println(signedEncryptedAnswer);
		
		//e
		//System.out.println(RSA.publicKey[0].toString());
		
		//n
		//System.out.println(RSA.publicKey[1].toString());
		
		//decrypt our answer
		BigInteger decryptedAnswer = signedAnswer.modPow(RSA.publicKey[0],RSA.publicKey[1]);
		String H = RSAHelper.recoverTextFromBigInteger(decryptedAnswer);
		System.out.print("Answer: " + H);
		
	}

}
