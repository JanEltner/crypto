plain="AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz"
offset = 3
cipher = ""

def crypt(text,offset,encrypt):
	result = ""
	for i in text:
		if(encrypt):
			order = ord(i) + offset
			if(order > ord("Z") and order<ord("a")):
				order -=26
			elif(order > ord("z")):
				order -=26
		else:
			order = ord(i) - offset
			if(order < ord("A")):
				order += 26
			elif(order < ord("a") and order > ord("Z")):
				order +=26 
		result += chr(order)
	return result

def encrypt(text, offset):
	return crypt(text,offset,True)
def decrypt(text, offset):
	return crypt(text, offset, False)

cipher = encrypt(plain, offset)
plainAgain = decrypt(cipher,offset)
print plain
print cipher
print plainAgain
