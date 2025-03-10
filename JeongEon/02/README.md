# [백준 - 실버 5] 1789. 수들의 합
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
수학

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 서로 다른 최대한 많은 자연수들을 골라서 합이 S가 되게 하려면, 1부터 하나씩 증가시키면서 더한다.
```cpp
while (1) {
		sum = sum + num;
		cnt++;
		if (sum > S) {
			cnt--;
			break;
		}
		num++;
	}
```

## :black_nib: **Review**
- 생각보다 코드는 짧은데 오래걸리넹...

## 📡 Link
https://www.acmicpc.net/problem/1789
