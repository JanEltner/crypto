#this is schoolbook RSA and should not be used in praxis (e.g. padded must be added...)
#this version ist for demonstration purposes only
#this version uses Square and Multiply for the exponentiation

plain = 6 #text as number to encrypt

p = 11 #choose to primes, both(p and q) need to be kept secret
q = 7
n = p*q
phi = (p-1)*(q-1)
pubkey = 7 #gcd(pubkey,phi)=1
privkey = 43 #pubkey*privkey mod phi = 1

def exp(base, exponent, prim):
	result = base
	binExp=bin(exponent)[3:]
	for i in binExp:
		result = result * result
		if(i):
			result = base * result
		result = result % prim
	return result

print("plain: " + str(plain))
cipher = exp(plain,pubkey,n)
print("cipher: " + str(cipher))
text = exp(cipher,privkey,n)
print("plain again:" + str(text))
