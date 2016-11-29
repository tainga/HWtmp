import java.math.BigInteger;


public class Example {

	
	public static void main(String[] args) {
		// Let's say that you've used my public key to 
		// confirm my signature.  You will end up with 
		// a BigInteger object.  Let's say your variable is
		// named plaintext.  You can find the plaintext that
		// it represents with: 
		// BigInteger plaintext = result of decrypting my signed message;
		// String message = RSAHelper.recoverTextFromBigInteger(plaintext);
		// If, when you print message, it doesn't look like English language
		// text, then either you decrypted incorrectly or the real message
		// from me is one of the others.
		
		
		// Let's say your answer to the signed question was:  "Hello World!"
		// You can get a BigInteger object that encodes that String with:
		BigInteger M = RSAHelper.encodeMessageAsBigInteger("Hello World!");
		
		// You'd then sign M with by encrypting with your private key.
		// This would give you another BigInteger, perhaps called S.
		
		// You'd then encrypt that with my public key to secure the message.
		// This would give you another BigInteger C.
		
		// To give me that encrypted message, you can print the decimal
		// representation of your BigInteger C with: System.out.println(C);
		
		// Likewise, you can do the same to print the BigInteger objects
		// that correspond to your public key which you will need to send to me.
		// As well as your private key which you will need to retain for yourself.
		
		
		// If you'd like to send these back to me, in the form of 
		// variables within your Java file (in the same way that I sent
		// my public key to you) that is fine (and preferred).
		
		// Simply have your program print them out, and then copy and
		// paste them into your Java file.
		
		// Don't send me your private key.  Only the public key and
		// your signed and encrypted message.

	}

}
