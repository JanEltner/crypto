def encrypt(plain, a,b):
	result = ""
	for i in plain:
		o = ord(i)
		if(o>=ord("A") and o <= ord("Z")):
			o -= (ord("A"))
			o *= a
			o += b
			o %= 26
			o += ord("A")
		if(o>=ord("a") and o <= ord("z")):
			o -= (ord("a"))
			o *= a
			o += b
			o %= 26
			o += ord("a")
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
			o -= (ord("A"))
			o -= b
			o *= aInvers
			o %= 26
			o += ord("A")
		if(o>=ord("a") and o <= ord("z")):
			o -= (ord("a"))
			o -= b
			o *= aInvers
			o %= 26
			o += ord("a")
		result += chr(o)
	return result

def breakWithKnownPlaintextPairs(m1,c1,m2,c2):
	m1 = ord(m1)
	m2 = ord(m2)
	c1 = ord(c1)
	c2 = ord(c2)
	if(m1>=ord("A") and m1 <= ord("Z")):
		m1 -= (ord("A"))
	if(m1>=ord("a") and m1 <= ord("z")):
		m1 -= (ord("a"))
	if(m2>=ord("A") and m2 <= ord("Z")):
		m2 -= (ord("A"))
	if(m2>=ord("a") and m2 <= ord("z")):
		m2 -= (ord("a"))
	if(c1>=ord("A") and c1 <= ord("Z")):
		c1 -= (ord("A"))
	if(c1>=ord("a") and c1 <= ord("z")):
		c1 -= (ord("a"))
	if(c2>=ord("A") and c2 <= ord("Z")):
		c2 -= (ord("A"))
	if(c2>=ord("a") and c2 <= ord("z")):
		c2 -= (ord("a"))
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
