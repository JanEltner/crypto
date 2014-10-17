package ellipticCurve;

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
}
