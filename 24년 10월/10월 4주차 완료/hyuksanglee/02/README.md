# [백준 - G3] 1766.문제집
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
O(NlogN+M)

## :round_pushpin: **Logic**
1. 문제를 풀기전에 풀어야하는 문제를 담는 2차원 arraylist 배열 생성,  b문제를 풀기전에 풀어야하는 문제 수 체크하는 배열 생성
   
2. 사용자에 입력을 받을때 a를 먼저 풀면 b를 풀수 있도록 a 인덱스 배열안에 b를 추가해주고 문제 수 체크 배열에서 해당 인덱스 칸에 수를 1증가 시킨다.

3. 1번째 부터 for문을 돌면서 문제 수가 0인 인덱스를 우선순위 큐에 넣는다.

4. 큐에서 하나씩 빼서 해당 문제를 풀면 풀수 있는 문제를 문제수 체크하는 배열에서 1감소한다.
   
5. 문제수 체크하는 배열에서 해당 문제가 값이 0이면 큐에서 넣어준다.

6. 4,5번을 큐가 비어있을때 까지 반복한다.
	
```java
	// 우선순위 큐 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i); // 진입 차수가 0인 문제를 큐에 추가
            }
        }
```



## :black_nib: **Review**
- 처음에 dfs로 풀었다가 메모리 초과 떴어요

## 📡**Link**
- https://www.acmicpc.net/problem/1766
