a1, b1 = map(int, input().split())
a2, b2 = map(int, input().split())

B = b1*b2
A = a1*b2 + a2*b1

def gcd(x, y):
    while y:
        x, y = y, x%y
    return x

gcd = gcd(A, B)
print(int(A/gcd), int(B/gcd))