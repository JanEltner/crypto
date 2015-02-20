def encrypt(plain, a,b):
	result = ""
	for i in plain:
		o = ord(i)
		offset = 0
		if(o>=ord("A") and o <= ord("Z")):
			offset  = ord("A")
		if(o>=ord("a") and o <= ord("z")):
			offset  = ord("a")
		o -= offset
		o *= a
		o += b
		o %= 26
		o += offset
		result += chr(o)
	return result

def invert(a):
	for i in range(1,27):
		if((i*a)%26==1):
			return i
	print("No inverse for " + str(a) ". Calculation will not be correct!")
	return -1

def decrypt(cipher, a,b):
	result = ""
	aInvers = invert(a)
	for i in cipher:
		o = ord(i)
		if(o>=ord("A") and o <= ord("Z")):
			offset  = ord("A")
		if(o>=ord("a") and o <= ord("z")):
			offset  = ord("a")
		o -= offset
		o -= b
		o *= aInvers
		o %= 26
		o += offset
		result += chr(o)
	return result
	
def transformCharToNumber(c):
	i = ord(c)
	if(i>=ord("A") and i <= ord("Z")):
		i -= (ord("A"))
	if(i>=ord("a") and i <= ord("z")):
		i -= (ord("a"))
	return i

def breakWithKnownPlaintextPairs(m1,c1,m2,c2):
	m1 = transformCharToNumber(m1)
	m2 = transformCharToNumber(m2)
	c1 = transformCharToNumber(c1)
	c2 = transformCharToNumber(c2)
	mTmp = (m2-m1) % 26
	mInvers = invert(mTmp)
	cTmp = (c2-c1) % 26
	a = (cTmp * mInvers) % 26
	print("found a: " + str(a))
	b = (c1-m1*a)%26
	print("found b: " +str(b))

plain = "abcdefABCDEFvwxyzVWXYZ"

print(plain)
cipher = encrypt(plain,5,6)
print(cipher)
print(decrypt(cipher,5,6))
breakWithKnownPlaintextPairs(plain[1],cipher[1],plain[2],cipher[2])

cipher = "NQRRCNQPPKOSSD"
print(decrypt(cipher,7,16))

breakWithKnownPlaintextPairs("P","I","O","Z")
cipher = "OSSI://SXQLBAY.VZH/ODIILABM"
print(decrypt(cipher,9,3))
