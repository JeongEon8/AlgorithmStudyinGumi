# [백준 - S2] 1541. 잃어버린 괄호
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- `-` 기준으로 문자열을 분리
- 각 덩어리는 내부적으로 `+` 연산이 있을 수 있음 → 모두 더한 뒤
- 첫 번째 덩어리는 그대로 더하고, 이후 덩어리는 모두 빼줌


```java
for(int i = 0; i < sub.length; i++) {

	int sum = 0;
	String[] add = sub[i].split("\\+");
	for(int j = 0; j < add.length; j++) {
		sum += Integer.parseInt(add[j]);
	}

	if (i == 0) ans += sum;
	else ans -= sum;
}

```

## :black_nib: **Review**
- "+"를 기준으로 split할 때는 `\\+`처럼 이스케이프 필요


## 📡**Link**
- https://www.acmicpc.net/problem/1541
