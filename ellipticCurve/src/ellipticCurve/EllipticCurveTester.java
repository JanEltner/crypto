package ellipticCurve;

import java.math.BigInteger;
import java.util.ArrayList;

public class EllipticCurveTester {

	public static void main(String[] args) 
	{
		try 
		{
			EllipticCurve curve = new EllipticCurve(BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(17));
			curve.calcPoints();
			ArrayList<EllipticCurvePoint> points = curve.getPoints();
			points.get(0).add(points.get(0));
		} 
		catch (InvalidEllipticCurveException e) 
		{
			e.printStackTrace();
		}		
	}

}
