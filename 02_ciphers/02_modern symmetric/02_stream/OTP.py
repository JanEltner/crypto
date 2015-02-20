message = "test"
key = "abcd"
if not len(message) == len(key):
	print("Key length is not correct!")
else:
	result = ""
	for i in range(len(key)):
		result += chr(ord(message[i])^ord(key[i]))
	print(result)
