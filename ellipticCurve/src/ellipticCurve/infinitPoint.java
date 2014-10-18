package ellipticCurve;

import java.math.BigInteger;


public class infinitPoint implements PointInterface{

	@Override
	public String toString() 
	{
		return "infty";
	}

	public boolean isInfinityPoint()
	{
		return true;
	}

	@Override
	public PointInterface add(PointInterface point2) 
	{
		return point2;
	}

	@Override
	public PointInterface doublePoint() 
	{
		return this;
	}

	@Override
	public PointInterface multiply(BigInteger factor) 
	{
		return this;
	}
}
