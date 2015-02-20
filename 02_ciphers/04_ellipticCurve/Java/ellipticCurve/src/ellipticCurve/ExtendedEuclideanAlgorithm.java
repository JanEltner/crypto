package ellipticCurve;

import java.math.BigInteger;

public class ExtendedEuclideanAlgorithm 
{
	public static BigInteger getMultiplicativeInverse(BigInteger a, BigInteger b)
	{
		BigInteger q,tmp,s,t,u,v;
		u = BigInteger.ONE;
		t = BigInteger.ONE;
		v = BigInteger.ZERO;
		s = BigInteger.ZERO;
		while(b.compareTo(BigInteger.ZERO)>0)
		{
			tmp = a.mod(b);
			q = a.subtract(tmp).divide(b);
			a=b;
			b=tmp;
			
			tmp = u.subtract(q.multiply(s));
			u=s;
			s=tmp;
			
			tmp = v.subtract(q.multiply(t));
			v=t;
			t=tmp;
		}
		return u;
	}
}
