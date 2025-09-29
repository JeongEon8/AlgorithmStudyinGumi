
# [백준- G4] 1744. 수 묶기

## ⏰  **time**
60분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**

1. 숫자 중 음수와 양수를 각각 나누어 리스트에 넣는다.
2. 음수와 양수를 순서대로 정렬한다.
3. 음수는 가장 작은 수를 2개씩 곱하고, 홀수일 경우 그냥 더한다.
4. 양수도 마찬가지로 큰 수 2개를 순서대로 곱하고, 개수가 홀수인 경우 남은 수 하나를 더한다.



```java
Collections.sort(positive, Collections.reverseOrder());
Collections.sort(negative);

int sum = 0;
for (int i = 0; i < positive.size() - 1; i += 2) {
	if (positive.get(i) + positive.get(i + 1) >= positive.get(i) * positive.get(i + 1)) {
		sum += positive.get(i) + positive.get(i + 1);
	} else {
		sum += positive.get(i) * positive.get(i + 1);
	}
}

for (int i = 0; i < negative.size() - 1; i += 2) {
	if (negative.get(i) + negative.get(i + 1) >= negative.get(i) * negative.get(i + 1)) {
		sum += negative.get(i) + negative.get(i + 1);
	} else {
		sum += negative.get(i) * negative.get(i + 1);
	}
}
	
if (positive.size() % 2 == 1)
	sum += positive.get(positive.size() - 1);
if (negative.size() % 2 == 1)
	sum += negative.get(negative.size() - 1);
```


## :black_nib: **Review**

처음에는 전체 정렬을 했었는데, 예시를 잘 생각하기


## 📡**Link**
- https://www.acmicpc.net/problem/1744

