def exp(base, exponent,prime):
	result = base
	binExp=bin(exponent)[3:]
	for i in binExp:
		result = result * result
		if(i):
			result = base * result
		result = result % prim
	return result
