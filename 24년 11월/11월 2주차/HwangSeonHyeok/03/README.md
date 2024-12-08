# [백준 - S4] 14381. 숫자세는 양 (Large)

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학
- 분할 정복을 이용한 거듭제곱

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**

각 수들을 n씩 곱해가면서 각 수들을 비트로 기록한다. 10개의 비트가 모두 켜지면 출력.  
n=0일땐 예외처리해준다

```java
	if (n == 0) {
		sb.append("Case #" + tc + ": INSOMNIA\n");
		continue;
	}
	int see = 0;
	int cnt = 0;
	int find = ((1 << 10) - 1);
	while (see != find) {
		cnt++;
		long tmp = n * cnt;
		while (tmp > 0) {
			see |= 1 << (tmp % 10);
			tmp /= 10;
		}
	}

```

## :black_nib: **Review**

지난주 코드로도 시간복잡도내에 해결 가능해서 날먹했습니다..

## 📡**Link**

https://www.acmicpc.net/problem/14382
