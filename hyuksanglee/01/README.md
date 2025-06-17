# [백준- G4] 13975. 파일 합치기 3
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**
- 가장 작은 값 2개를 더하는 것이 최소값을 구하는 방식으로 생각해서 우선순위 큐 사용
  1. 입력 받은 값을 우선순위 큐에 추가
  2. 우선순위 큐에서 2개의 값을 꺼내어 더해준다
  3. 그 값을 최종값에 더해주고 다시 우선순위 큐에 넣어준다.
  4. 2,3번을 큐에정수가 한개가 남을때까지 반복한다.

```java
while(que.size()>1) {
				long a = que.poll();
				long b = que.poll();
				long total = a+b;
				sum += total;
				que.add(total);
			}
```

## :black_nib: **Review**
처음에는 데이터 타입을 int형으로 풀었지만 틀렸어요. 데이터 타입을 계산해서 코드를 작성해야할거 같아요

## 📡**Link**
- https://www.acmicpc.net/problem/13975
