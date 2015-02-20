package kAry;

import java.math.BigInteger;
import java.util.HashMap;

public class kAry 
{
	private int windowSize;
	private BigInteger base;
	private BigInteger modulo;
	private HashMap<Integer, BigInteger> lookUpTable = new HashMap<Integer, BigInteger>();
	
	public kAry(int windowSize, BigInteger base, BigInteger modulo) 
	{
		this.windowSize = windowSize;
		this.base = base.mod(modulo);
		this.modulo = modulo;
		this.preComputation();
	}
	
	private void preComputation()
	{
		//Generating Look-up-table
		//values of 0 and 1 are for free ;)
		//value of 2 calculated via square due to lower calculation cost
		//remaining values gets calculated sequential
		int limit = (int)Math.pow(2, this.windowSize);
		this.lookUpTable.put(0, BigInteger.ONE);
		this.lookUpTable.put(1, this.base);
		this.lookUpTable.put(2, this.base.modPow(BigInteger.valueOf(2), this.modulo));
		for(int i=3;i<limit;i++)
		{
			this.lookUpTable.put(i, this.lookUpTable.get(i-1).multiply(this.base).mod(this.modulo));
		}
	}

	
	public BigInteger modPow(BigInteger exponent) 
	{
		int bitlength = exponent.bitLength();
		int t = (int) Math.ceil((float)bitlength/this.windowSize);
		int exp = 0; 
		int maxExponent = (int) Math.pow(2, this.windowSize);
		//init step
		for(int i=(t-1)*this.windowSize;i<bitlength;i++)
		{
			if(i>=0 && exponent.testBit(i))
			{
				exp += Math.pow(2, i-(t-1)*this.windowSize);
			}
		}
		BigInteger result = this.lookUpTable.get(exp);
		//stepping over the windows
		for(int n = 2; n<=t; n++)
		{
			//squaring
			for(int l= 0; l<this.windowSize;l++)
			{
				if(result == null)
				{
					System.out.println("result is null!");
				}
				result = result.modPow(BigInteger.valueOf(2), this.modulo);
			}
			exp = 0;
			//Determine current exponent for the multiplication
			for(int i=0;i<this.windowSize;i++)
			{
				if(exponent.testBit((t-n)*this.windowSize+i))
				{
					exp += Math.pow(2, i);
				}
			}
			exp = exp % maxExponent;
			//multiplication
			if(exp != 0)
			{
				result = result.multiply(this.lookUpTable.get(exp)).mod(this.modulo);
			}
		}
		return result;
	}
}
