# [백준- S3] 14235. 크리스마스 선물
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(nlogn)$

## :round_pushpin: **Logic**
- 우선순위 큐 내림차순 정렬
- 선물을 나눠줘야 하는 경우 큐가 비어있다면 -1, 비어있지 않다면 `pq.poll()`
```java
PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
StringTokenizer st = null;
StringBuilder sb = new StringBuilder();
for (int i = 0; i < N; i++) {
    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    if (a == 0) {
        sb.append(pq.isEmpty() ? -1 : pq.poll()).append("\n");
    } else {
        for (int j = 0; j < a; j++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
    }
}
```

## :black_nib: **Review**
우선순위 큐 정렬 까먹지 말자

## 📡**Link**
- https://www.acmicpc.net/problem/14235
