import java.math.BigInteger;


public class SchoolbookRSA 
{
	
	
	public static BigInteger crypt(String message, BigInteger exp, BigInteger modulo) 
	{
		BigInteger m = new BigInteger(message.getBytes());
		return m.modPow(exp, modulo);
	}
	
	public static void main(String[] args) 
	{
		//Schoolbook RSA should not be used because it is not really safe!
		//For realistic texts the modulo needs to be much bigger...
		BigInteger pubKey = new BigInteger("7");
		BigInteger privKey = new BigInteger("43");
		BigInteger p = new BigInteger("7");
		BigInteger q = new BigInteger("11");
		BigInteger modulo = p.multiply(q);
		String plain = "5";
		String cipher = new String(crypt(plain, pubKey, modulo).toByteArray());
		String plainagain = new String(crypt(cipher, privKey, modulo).toByteArray());
		System.out.println("plain: " + plain);
		System.out.println("cipher: " + crypt(plain, pubKey, modulo));
		System.out.println("plain again: " + plainagain);
	}

}
