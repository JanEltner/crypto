def calcMultiplicativeInverse(factor, modulo):
	a,b = factor,modulo
	u,t = 1,1
	v,s = 0,0
	while(b > 0):
		print("{0} | {1} | {2} | {3} | {4} | {5}".format(b,a,s,v,u,t))
		q,a,b = int((a-a%b)/b),b,a%b
		u,s = s,int(u - (q*s))
		v,t = t,int(v - (q*t))
	print("multiplicative inverses: {:d}".format(u%modulo))
	print("gcd({:d},{:d}) = {:d}".format(factor,modulo,a))
	print("{:d} = {:d}*{:d} + ({:d})*{:d}".format(a,u,factor,v,modulo))
	return u
calcMultiplicativeInverse(5, 7)
