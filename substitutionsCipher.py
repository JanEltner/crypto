transformationMap = {'A':'X','B':'C','C':'f','D':'I','E':'t','F':'k','G':'N','H':'Z','I':'w','J':'a','K':'v','L':'c','M':'q','N':'Q','O':'J','P':'n','Q':'F','R':'z','S':'b','T':'u','U':'K','V':'p','W':'A','X':'B','Y':'l','Z':'x','a':'d','b':'T','c':'y','d':'E','e':'h','f':'O','g':'s','h':'R','i':'U','j':'W','k':'G','l':'V','m':'Y','n':'P','o':'g','p':'j','q':'e','r':'H','s':'L','t':'i','u':'m','v':'M','w':'o','x':'S','y':'r','z':'D'}

plaintext = "substitutionsChiffrenSindNichtSehrSicher"

cipher =""
plainagain = ""

for i in plaintext:
	cipher += transformationMap.get(i,'')

for j in cipher:
	for key,value in transformationMap.items():
		if value == j:
			plainagain += key
print(plaintext)
print(cipher)
print(plainagain)
