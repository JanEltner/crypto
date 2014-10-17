package ellipticCurve;

import java.math.BigInteger;

public class EllipticCurvePoint implements PointInterface
{
	private BigInteger x;
	private BigInteger y;
	private EllipticCurve curve;
	
	public EllipticCurvePoint(BigInteger x,	BigInteger y,	EllipticCurve curve) 
	{
		this.x = x;
		this.y = y;
		this.curve = curve;
	}
	
	@Override
	public String toString() 
	{
		return "(" + x.toString() + " / " +y.toString() + ")";
	}
	
	
	public BigInteger getX() {
		return x;
	}

	public BigInteger getY() {
		return y;
	}

	public EllipticCurve getCurve() {
		return curve;
	}

	public PointInterface add(EllipticCurvePoint point2)
	{
		EllipticCurvePoint newPoint;
		if(point2.isInfinityPoint())
		{
			newPoint = this;
			System.out.println("p2 is ifty");
		}
		else
		{
			if(this.x.equals(point2.getX()))
			{
				if(this.y.equals(point2.getY()))
				{
					newPoint = this.doublePoint();
					System.out.println("double");
				}
				else
				{
					System.out.println("result is ifty");
					infinitPoint result = new infinitPoint();
					System.out.println(result);
					return  result;
				}
			}	
			else
			{
				BigInteger s = point2.getY().subtract(this.y).divide(point2.getX().subtract(this.x)).mod(this.curve.getP());
				BigInteger newX = s.modPow(BigInteger.valueOf(2), this.curve.getP()).subtract(this.x).subtract(point2.getX()).mod(this.curve.getP());
				BigInteger newY = s.multiply(this.x.subtract(newX)).subtract(this.y).mod(this.curve.getP());
				newPoint = new EllipticCurvePoint(newX, newY, this.curve);
				System.out.println("normal add");
			}
		}
		System.out.println(newPoint);
		return newPoint;
	}
	public EllipticCurvePoint doublePoint()
	{
		EllipticCurvePoint newPoint;
		
		BigInteger s = BigInteger.valueOf(3).multiply(this.x.modPow(BigInteger.valueOf(2), this.curve.getP())).add(this.curve.getA()).divide(this.y.multiply(BigInteger.valueOf(2))).mod(this.curve.getP());
		BigInteger newX = s.modPow(BigInteger.valueOf(2), this.curve.getP()).subtract(this.x).subtract(this.x).mod(this.curve.getP());
		BigInteger newY = s.multiply(this.x.subtract(newX)).subtract(this.y).mod(this.curve.getP());
		newPoint = new EllipticCurvePoint(newX, newY, this.curve);
		System.out.println(newPoint);
		return newPoint;
	}
	
	public EllipticCurvePoint invert()
	{
		return new EllipticCurvePoint(this.x, this.y.multiply(BigInteger.valueOf(-1)).mod(this.curve.getP()), this.curve);
	}
	public boolean isInfinityPoint()
	{
		return false;
	}
}
