package ellipticCurve;

public class InvalidEllipticCurveException extends Exception {

	private static final long serialVersionUID = 6296681455618667516L;
	public InvalidEllipticCurveException() 
	{
		super("Elliptic curves need to fulfil the equation 4*a^3+ 27*b^2 mod p != 0");
	}

}
