def exp(base, exponent):
	binExp = []
	count = 0
	result = 1
	if exponent > 0:
		result*=base
	while(exponent > 0):
		binExp.append(exponent%2)
		exponent = exponent>>1
		count += 1
	for i in range(count-2,-1,-1):
		result *= result
		if binExp[i] == 1:
			result *= base
	return result
