def calcMultiplicativeInverse(factor, modulo):
	a = factor
	b = modulo
	u = 1
	t = 1
	v = 0
	s = 0
	while(b > 0):
		print("{0} | {1} | {2} | {3} | {4} | {5}".format(b,a,s,v,u,t))
		tmp = a%b
		q = int((a-tmp)/b)
		a = b
		b = tmp
		tmp = int(u - (q*s))
		u = s
		s = tmp
		tmp = int(v - (q*t))
		v = t
		t = tmp
	print("inverses: " +str(u%modulo))
	return u
