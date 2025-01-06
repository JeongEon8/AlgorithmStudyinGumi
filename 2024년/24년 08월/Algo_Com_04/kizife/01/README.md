# [백준] 14501. 퇴사
 
## ⏰  **time**
30분 

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
168ms

## :round_pushpin: **Logic**
- 현재 날짜가 총 일수를 초과하면, 최대 수익을 갱신하고 함수 종료
```java
if (day > N) {
			max = Math.max(max, profit);
			return;
		}
```

- 상담을 하지 않는 경우, 다음날(day+1)로 넘어가면서 현재수익 그대로 유지
```java
calculateMax(day + 1, profit);
```

- day+T[day]라는 것은, 현재날짜(day)로부터 상담가능한 다음날짜(+T[day)임
- 상담 가능한 다음 날짜를 구하고, 이익 또한 갱신함.
```java
if (day + T[day] - 1 <= N) {
			calculateMax(day + T[day], profit + P[day]);
		}
```


## :black_nib: **Review**
- 구현은 어렵지 않았으나 이런 문제는 경험이 거의 없어서 아이디어를 떠올리지 못했다.

## 📡**Link**
- https://www.acmicpc.net/problem/14501 
