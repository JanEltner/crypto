import math

def encrypt(text, offset):
	length = len(text)
	count = int(math.ceil(length/offset))
	tmp = 0
	result = ""
	for i in range(count):
		tmp = i
		while(tmp < length):
			result += text[tmp]
			tmp += offset
	return result

def decrypt(text, offset):
	length = len(text)
	count = int(math.ceil(length/offset))
	tmp = 0
	n = 0
	result = list("_"*length)
	for i in range(count):
		tmp = i
		while(tmp < length):
			result[tmp] = text[n]
			n += 1
			tmp += offset
	return ''.join(result)

plain = "abcdefghijklmnopqrstuvwxyz"
offset = 5
cipher = encrypt(plain, offset)
plainAgain = decrypt(cipher, offset)
print plain
print cipher
print plainAgain
