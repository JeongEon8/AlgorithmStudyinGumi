# [백준 - S4] 11332. 시간초과

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 수학
- 구현
- 많은 조건 분기

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
각 Big-O조건마다 분기를 나눠서 처리한다  
long범위를 초과하는 $2^N$은 $log_2(max/t)$로 한다.  
$N!$은 1~N팩까지 진행하면서 max보다 큰 경우 정지하고 TLE로 한다.  
$N^3$은 $N$을 하나 우항으로 넘겨서 $N^2*t>max/N$이면 TLE를 하였다.
```java

static double logN(int num, int n) {
	return Math.log(num) / Math.log(n);
}


if (bigO.equals("O(N)")) {
	if (n * t > max) {
		isTLE = true;
	}
} else if (bigO.equals("O(2^N)")) {
	if (n > logN(max / t, 2)) {
		isTLE = true;
	}

} else if (bigO.equals("O(N!)")) {
	long fact = 1L;
	for (int j = 2; j <= n; j++) {
		fact *= j;
		if (fact * t > max) {
			isTLE = true;
			break;
		}
	}

} else if (bigO.equals("O(N^3)")) {
	if (n * n * t > max / n) {
		isTLE = true;
	}

} else {
	if (n * n * t > max) {
		isTLE = true;
	}
}

if (isTLE) {
	sb.append("TLE!").append("\n");
} else {
	sb.append("May Pass.").append("\n");
}
```


## :black_nib: **Review**  
long범위를 초과할 수 있어서 약간의 수학이 들어간 문제이다.
## 📡**Link**

https://www.acmicpc.net/problem/11332
