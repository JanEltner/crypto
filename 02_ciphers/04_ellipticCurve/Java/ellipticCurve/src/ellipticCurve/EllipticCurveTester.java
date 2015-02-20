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
			ArrayList<PointInterface> points = curve.getPoints();
			EllipticCurvePoint point = (EllipticCurvePoint) points.get(0);
			EllipticCurvePoint point2 = new EllipticCurvePoint(point.getX(), point.getY(), point.getCurve());
			System.out.println(point);
			System.out.println(point2);
			PointInterface test = point2.add(point);
			test = test.add(point);
			test = test.add(point);
			test = test.add(point);
			points.get(0).multiply(BigInteger.valueOf(5));
			
			System.out.println("inv => " +ExtendedEuclideanAlgorithm.getMultiplicativeInverse(BigInteger.valueOf(5),BigInteger.valueOf(17)));
		} 
		catch (InvalidEllipticCurveException e) 
		{
			e.printStackTrace();
		}		
	}

}
