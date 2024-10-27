# [백준 - S1] 14222. 배열과 연산

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

각각의 수가 몇개가 있는지 카운트한다. 만약 입력받은 수가 n보다 크면 답을 구할 수 없다.  
각각의 수마다 1개보다 많이 있으면 그 수를 1개만 남기고 나머지를 k씩 더해준다. 이런식으로 n까지 진행하면서 중간에 0개인 수가 없으면된다.

```java
for (int i = 0; i < n; i++) {
	int num = Integer.parseInt(split[i]);
	if (num > n) {
		isComplete = false;
		break;
	}
	has[num]++;

}
if (isComplete) {
	for (int i = 1; i <= n; i++) {
		if (has[i] == 0) {
			isComplete = false;
			break;
		} else if (has[i] > 1 && i + k <= n) {
			while (has[i] > 1) {
				has[i]--;
				has[i + k]++;
			}
		}
	}

}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/14222
