package ellipticCurve;

import java.math.BigInteger;
import java.util.ArrayList;

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

	public PointInterface add(PointInterface point2)
	{
		EllipticCurvePoint newPoint;
		if(point2.isInfinityPoint())
		{
			newPoint = this;
		}
		else
		{
			EllipticCurvePoint ellipticPoint = (EllipticCurvePoint)point2;
			if(this.x.equals(ellipticPoint.getX()))
			{
				if(this.y.equals(ellipticPoint.getY()))
				{
					newPoint = (EllipticCurvePoint)this.doublePoint();
				}
				else
				{
					infinitPoint result = new infinitPoint();
					return  result;
				}
			}	
			else
			{
				BigInteger s = ellipticPoint.getY().subtract(this.y).multiply(ExtendedEuclideanAlgorithm.getMultiplicativeInverse(ellipticPoint.getX().subtract(this.x),this.curve.getP())).mod(this.curve.getP());
				BigInteger newX = s.modPow(BigInteger.valueOf(2), this.curve.getP()).subtract(this.x).subtract(ellipticPoint.getX()).mod(this.curve.getP());
				BigInteger newY = s.multiply(this.x.subtract(newX)).subtract(this.y).mod(this.curve.getP());
				newPoint = new EllipticCurvePoint(newX, newY, this.curve);
			}
		}
		return newPoint;
	}
	public PointInterface doublePoint()
	{
		EllipticCurvePoint newPoint;
		
		BigInteger s = BigInteger.valueOf(3).multiply(this.x.modPow(BigInteger.valueOf(2), this.curve.getP())).add(this.curve.getA()).multiply(ExtendedEuclideanAlgorithm.getMultiplicativeInverse(this.y.multiply(BigInteger.valueOf(2)),this.curve.getP())).mod(this.curve.getP());
		BigInteger newX = s.modPow(BigInteger.valueOf(2), this.curve.getP()).subtract(this.x).subtract(this.x).mod(this.curve.getP());
		BigInteger newY = s.multiply(this.x.subtract(newX)).subtract(this.y).mod(this.curve.getP());
		newPoint = new EllipticCurvePoint(newX, newY, this.curve);
		return newPoint;
	}
	
	public EllipticCurvePoint invert()
	{
		return new EllipticCurvePoint(this.x, this.y.multiply(BigInteger.valueOf(-1)).mod(this.curve.getP()), this.curve);
	}
	
	public PointInterface multiply(BigInteger factor)
	{
		if(factor.equals(BigInteger.ZERO))
		{
			return new infinitPoint();
		}
		else if(factor.equals(BigInteger.ONE)) 
		{
			return this;
		}
		else
		{
			PointInterface result = new EllipticCurvePoint(this.x,this.y,this.curve);
			factor = factor.mod(this.curve.getP());
			ArrayList<Boolean> bits = new ArrayList<Boolean>();
			while(!factor.equals(BigInteger.ZERO))
			{
				bits.add(factor.mod(BigInteger.valueOf(2)).intValue()==1);
				factor = factor.shiftRight(1);
			}
			for(int i = bits.size()-1; i>=0;i--)
			{
				result = result.doublePoint();
				if(bits.get(i))
				{
					result = result.add(this);
				}
			}
			return result;			
		}
	}
	
	public boolean isInfinityPoint()
	{
		return false;
	}
}
