package ellipticCurve;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EllipticCurve 
{
	private BigInteger a;
	private BigInteger b;
	private BigInteger p;
	private ArrayList<EllipticCurvePoint> points;

	public EllipticCurve(BigInteger a, BigInteger b, BigInteger p) throws InvalidEllipticCurveException 
	{
		if((new BigInteger("4").multiply( a.pow(3)).add(new BigInteger("27").multiply(b.pow(2)))).modPow(BigInteger.ONE, p) == BigInteger.ZERO)
		{
			throw new InvalidEllipticCurveException();
		}
		this.a = a;
		this.b = b;
		this.p = p;
		this.points = calcPoints();
		System.out.println(this.points);
	}
	
	public ArrayList<EllipticCurvePoint> calcPoints()
	{
		ArrayList<EllipticCurvePoint> points = new ArrayList<EllipticCurvePoint>();
		Map<BigInteger,BigInteger> ySquare = new HashMap<BigInteger, BigInteger>();
		BigInteger two = BigInteger.valueOf(2);
		BigInteger three = BigInteger.valueOf(3);
		for(BigInteger y = BigInteger.ZERO; !y.equals(this.p) ; y=y.add(BigInteger.ONE))
		{
			ySquare.put(y,y.modPow(two, p));
		}
		BigInteger xTempResult;
		for(BigInteger x = BigInteger.ZERO; !x.equals(this.p); x=x.add(BigInteger.ONE))
		{
			xTempResult = x.modPow(three, p).add(this.a.multiply(x)).add(this.b).mod(p);
			for(BigInteger i = BigInteger.ZERO; !i.equals(this.p) ; i=i.add(BigInteger.ONE))
			{
				if(ySquare.get(i).equals(xTempResult))
				{
					points.add(new EllipticCurvePoint(x, i, this));
				}
			}
		}
		
		return points;
	}

	public BigInteger getA() {
		return a;
	}

	public BigInteger getB() {
		return b;
	}

	public BigInteger getP() {
		return p;
	}

	public ArrayList<EllipticCurvePoint> getPoints() {
		return points;
	}
	
}
