def calcMultiplicativeInverse(factor, modulo):
	a,b = factor,modulo
	u,t = 1,1
	v,s = 0,0
	r = lambda x,y:(int(x-(q*y)))
	while(b > 0):
		q,a,b = int((a-a%b)/b),b,a%b
		u,s = s,r(u,s)
		v,t = t,r(v,t)
	return u
	
def CRT(x1,p1,x2,p2):
	invP1 = calcMultiplicativeInverse(p1,p2)%p2
	invP2 = calcMultiplicativeInverse(p2,p1)%p1
	return ((x1*p2*invP2+x2*p1*invP1)%(p1*p2))