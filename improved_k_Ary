package kAry;

import java.math.BigInteger;
import java.util.HashMap;

public class ImprovedKAry {
	private int windowSize;
	private BigInteger base;
	private BigInteger modulo;
	private HashMap<Integer, BigInteger> lookUpTable = new HashMap<Integer, BigInteger>();
	
	public ImprovedKAry(int windowSize, BigInteger base, BigInteger modulo) 
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
		this.lookUpTable.put(1, this.base);
		this.lookUpTable.put(2, this.base.modPow(BigInteger.valueOf(2), this.modulo));
		for(int i=3;i<limit;i+=2)
		{
			this.lookUpTable.put(i, this.lookUpTable.get(i-2).multiply(this.lookUpTable.get(2)).mod(this.modulo));
		}
	}

	
	public BigInteger modPow(BigInteger exponent) 
	{
		int bitlength = exponent.bitLength();
		int t = (int) Math.ceil((float)bitlength/this.windowSize);
		int exp = 0;
		int maxExponent = (int) Math.pow(2, this.windowSize);
		for(int i=(t-1)*this.windowSize;i<bitlength;i++)
		{
			if(i>=0 && exponent.testBit(i))
			{
				exp += Math.pow(2, i-(t-1)*this.windowSize);
			}
		}
		BigInteger result = this.lookUpTable.get(exp);
		int currentWindow;
		//stepping over the windows
		for(int n = 2; n<=t; n++)
		{
			currentWindow = this.windowSize;
			for(int x = 0; x < this.windowSize;x++)
			{
				if(exponent.testBit((t-n)*this.windowSize+x))
				{
					break;
				}
				currentWindow --;
			}
			//squaring
			for(int l= 0; l<currentWindow;l++)
			{
				if(result == null)
				{
					System.out.println("result is null!");
				}
				result = result.modPow(BigInteger.valueOf(2), this.modulo);
			}
			//Determine current exponent for the multiplication
			exp = 0;
			for(int i=0;i<currentWindow;i++)
			{
				if(exponent.testBit((t-n+1)*this.windowSize+i-currentWindow))
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
			//making the missing squarings
			for(int l= 0; l<this.windowSize - currentWindow;l++)
			{
				if(result == null)
				{
					System.out.println("result is null!");
				}
				result = result.modPow(BigInteger.valueOf(2), this.modulo);
			}
		}
		return result;
	}
}
