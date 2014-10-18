package ellipticCurve;

import java.math.BigInteger;

public interface PointInterface 
{
	public boolean isInfinityPoint();
	public PointInterface add(PointInterface point2);
	public PointInterface doublePoint();
	public PointInterface multiply(BigInteger factor);
}
