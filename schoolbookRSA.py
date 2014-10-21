#this is schoolbook RSA and should not be used in praxis (e.g. padded must be added...)
#this version ist for demonstration purposes only
plain = 6 #text as number to encrypt

p = 11 #choose to primes, both need to be kept secret
q = 7
n = p*q 
phi = (p-1)*(q-1)
pubkey = 7 #gcd(pubkey,phi)=1
privkey = 43 #pubkey*privkey mod phi = 1

print("plain: " + str(plain))
cipher = plain**pubkey % n
print("cipher: " + str(cipher))
text = cipher**privkey % n
print("plain again:" + str(text))
