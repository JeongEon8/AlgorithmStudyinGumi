# [백준 - S1] 1105. 팔

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**

두 수의 자리수가 다르면 무조건 $10^n$을 지나가므로 0개다.  
두 수의 자릿수 왼쪽부터 두 수의 연속된 같은부분은 변하지 않는다. 변할 수 있으면 무조건 8이 아닌 수가 될 수 있음.
즉 왼쪽부터 연속된 같은 부분에서 8의 개수를 구하면 답이다.

```
int ans = 0;
if (start.length() == end.length()) {
	for (int i = 0; i < start.length(); i++) {
		if (start.charAt(i) != end.charAt(i)) {
			break;
		}
		if (start.charAt(i) == '8') {
			ans++;
		}
	}
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1105
