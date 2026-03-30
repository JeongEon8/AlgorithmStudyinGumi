# [백준 - S5] 11004. K번째 수

## ⏰  **time**
10분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN+KlogN)$

## :round_pushpin: **Logic**
1. 우선순위큐 생성해서 값 담기
```java
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.add(Integer.valueOf(st.nextToken()));
        }
```
2. K보다 작을 때까지만 반복해서 pq에서 값 제거
```java
        int idx = 1;
        while(idx < K) {
            pq.poll();
            idx++;
        }
```
3. K번째 값 출력
```java
System.out.println(pq.poll());
```


## :black_nib: **Review**
- 우선순위큐 최고! 시간복잡도 계산해줘 하다가 본건데 개수를 조절해서 가지고 있는 방법이 더 좋은 거 같다 !

## 📡 Link
https://www.acmicpc.net/problem/11004
