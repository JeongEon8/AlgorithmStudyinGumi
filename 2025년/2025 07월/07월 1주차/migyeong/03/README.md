# [백준- G5] 15686. 치킨 배달
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
브루트포스, 조합

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- M개의 치킨집을 구하는 조합 만들기
```java
if (count == M) {
	int distance = calculateDistance();
	return Math.min(minDistance, distance);
}

for (int i = start; i < chicken.size(); i++) {
	isSelected[i] = true;
	minDistance = selectChicken(i + 1, count + 1, minDistance);
	isSelected[i] = false;
}
```

## :black_nib: **Review**
- 조합 만들기 어렵네여...

## 📡**Link**
- https://www.acmicpc.net/problem/15686
