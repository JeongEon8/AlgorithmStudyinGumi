# [백준 - S2] 25333. 개구리

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 정수론
- 유클리드 호제법


## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
ax+by는 항상 a,b의 최대공약수의 배수이므로 gcd(a,b)를 유클리드 호제법으로 구하고 개수를 구하면 된다.
```java
static int gcd(int a, int b) {
	if (a % b == 0) {
		return b;
	}
	return gcd(b, a % b);
}

String[] split = in.readLine().split(" ");
int a = Integer.parseInt(split[0]);
int b = Integer.parseInt(split[1]);
int x = Integer.parseInt(split[2]);
int GCD = gcd(a, b);
sb.append(x / GCD).append('\n');
```

## :black_nib: **Review**  

## 📡**Link**

https://www.acmicpc.net/problem/25333
