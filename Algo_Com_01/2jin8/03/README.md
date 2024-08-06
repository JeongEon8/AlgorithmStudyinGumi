# [SWEA - D4] 1249. 보급로
 
## ⏰  **time**
25분

## :pushpin: **Algorithm**
BFS + 우선순위큐

## :round_pushpin: **Logic**
- `(0, 0)`에서 `(N-1, N-1)`까지 BFS 탐색 수행
- 이때, 최단 거리가 아닌 **최소 복구 작업 시간**을 구해야 하므로 큐 대신 우선순위 큐 사용하기
  - 복구 작업 시간이 작은 것을 먼저 빼서 탐색을 수행해야 함 ⇒ 복구 작업 시간을 기준으로 오름차순 정렬하기
```java
static class Point implements Comparable<Point> {
    int x, y;
    int time;// 복구 작업 시간

    public Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    @Override
    public int compareTo(Point o) { // 복구 작업 시간을 기준으로 오름차순 정렬
        return Integer.compare(time, o.time);
    }
}
```

## :black_nib: **Review**
"BFS 탐색 + 우선순위 큐" 말고도 최단 거리 알고리즘으로 풀 수 있는 것 같은데 한 번 시도해 봐야겠다.

## 📡**Link**
- [SWEA 1249_보급로](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=1)
