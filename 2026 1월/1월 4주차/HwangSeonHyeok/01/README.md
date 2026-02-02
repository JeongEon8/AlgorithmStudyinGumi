# [백준 - S3] 2075. N번째 큰 수

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 자료 구조
- 우선순위 큐

## ⏲️**Time Complexity**

$O(N^2logN)$

## :round_pushpin: **Logic**
n*n개중 n번째로 큰 수를 찾아야 한다.  
메모리 제한이 걸린 문제이므로 우선순위큐의 갯수를 n개를 유지하면서 숫자들을 받아 넣어준다.  
우선순의큐에 가장 작은 n개의 수만 남으므로 답을 찾을 수 있다.
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
for (int i = 0; i < n; i++) {
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int j = 0; j < n; j++) {
        pq.add(Integer.parseInt(st.nextToken()));
        if (pq.size() > n)
            pq.poll();
    }
}
```

## :black_nib: **Review** 
면접때 질문받은 내용.

## 📡**Link**
https://www.acmicpc.net/problem/2075