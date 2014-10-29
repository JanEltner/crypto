import java.math.BigInteger;

public class SquareAndMultiply 
{
	public static BigInteger modPow(BigInteger base, BigInteger exponent, BigInteger modulo)
	{
		int exponentBitLength = exponent.bitLength();
		BigInteger result = base;
		for(int i = exponentBitLength-2;i>=0;i--)
		{
			result = result.modPow(BigInteger.valueOf(2), modulo);
			if(exponent.testBit(i))
			{
				result = result.multiply(base).mod(modulo);
			}
		}
		return result;
	}
}
