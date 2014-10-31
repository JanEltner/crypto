def multiplicativeInverse(a,b):
	u = 1
	t = 1
	v = 0
	s = 0
	while(b>0):
		tmp = a%b
		q = (a-tmp)/b
		a = b
		b = tmp
		tmp = u-(q*s)
		u = s
		s = tmp
		tmp = v-(q*t)
		v = t
		t = tmp
	return u


def add(x1,x2,y1,y2,p):
	tmp = multiplicativeInverse((x2-x1),p)
	s = ((y2-y1)*tmp)%p
	x3 = ((s*s)-x1-x2)%p
	y3 = (s*(x1-x3)-y1)%p
	return x3,y3

def double(x,y,a,p):
	tmp = multiplicativeInverse((2*y),p)
	s = ((3*x*x + a)*tmp)%p
	x3 = ((s*s)-2*x)%p
	y3 = (s*(x-x3)-y)%p
	return x3,y3

def multiply(d,x,y,a,p):
	xr = x
	yr = y
	binExp=bin(d)[3:]
	for i in binExp:
		xr,yr = double(xr,yr,a,p)
		if(i=="1"):
			xr,yr = add(x,xr,y,yr,p)
	return xr,yr

def STR(a):
	result = ""
	a = str(a)
	for i in range(0,len(a)-1,2):
		result += chr(int(a[i:i+2]))
	print(result)
d = 87441340171043308346177
a = 0
n = 928669833265826932708591
x = 236857987845294655469221
y = 12418605208975891779391
xr,yr = multiply(d,x,y,a,n)
print(STR(xr))
print(STR(yr))
