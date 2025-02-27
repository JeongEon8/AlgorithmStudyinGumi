# [백준 - S5] 25496. 장신구 명장 임스

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
피로도를 오름차순으로 정렬하여 피로도가 200이상이 될때까지 피로도가 적게드는 장신구부터 만들고 만든 장신구를 센다.

```java
Arrays.sort(arr);
int ans = 0;
int idx = 0;
while (p < 200 && idx < m) {
	p += arr[idx];
	ans++;
	idx++;
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25496
