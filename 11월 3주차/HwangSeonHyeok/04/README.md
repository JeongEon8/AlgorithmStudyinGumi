# [백준 - G3] 13294. 역팩토리얼

## ⏰ **time**

120분

## :pushpin: **Algorithm**

- 수학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
곱셈에서 오른쪽에 0이 나오는경우는 곱이 10이 되는 경우가 있을 때다. 2의 갯수는 짝수마다 있으므로 지금까지 곱한 5의 갯수와 같다. 이런식으로 답의 범위를 5n ~ 5n+4 사이임을 알 수 있다.  
5n에서의 0을 제외한 팩토리얼의 가장 오른쪽을 숫자들을 일부만 구하고 입력된 숫자와 비교해서 같은 경우를 찾는다.
```java
	static int mod = (int) 1e6;

	static long fact(long a, long b) {
		a *= b;
		while (a % 10 == 0) {
			a /= 10;
		}
		a %= mod;
		return a;

	}

	while (n.charAt(idx) == '0') {
		zeroCnt++;
		idx--;
	}
	int fiveN = 0;
	if (zeroCnt == 0)
		fiveN++;
	while (zeroCnt > 0) {
		fiveN += 5;
		int tmp = fiveN;
		while (tmp % 5 == 0) {
			zeroCnt--;
			tmp /= 5;
		}
	}

	long factNum = 1;
	for (int i = 2; i <= fiveN; i++) {
		factNum = fact(factNum, i);
	}
	String factNumStr = Long.toString(factNum);
	int ans = 1;
	for (int i = 1; i <= 5; i++) {
		int len = factNumStr.length() - 1;
		int tmpIdx = idx;
		int cnt = 0;
		while (len > -1 && factNumStr.charAt(len) == n.charAt(tmpIdx)) {
			cnt++;
			len--;
			tmpIdx--;

		}
		if (cnt > 4 || len == -1) {
			ans = fiveN + i - 1;
			break;
		}
		factNum = fact(factNum, fiveN + i);
		factNumStr = Long.toString(factNum);

	}

```

## :black_nib: **Review**

n!의 자리수가 말이 안되게 커서 아이디어가 안나왔던 문제.  
푼 방법이 정해도 아닌거 같고 명료하게 반례가 없다는 증명도 못하겠다..

## 📡**Link**

https://www.acmicpc.net/problem/13294
