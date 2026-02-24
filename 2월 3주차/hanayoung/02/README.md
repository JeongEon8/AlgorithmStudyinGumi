# [백준 - S5] 11651. 좌표 정렬하기 2

## ⏰  **time**
20분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. p1.y가 더 작을 때 -1 리턴하여 오름차순 정렬, p1.y와 p2.y가 같다면 p1.x가 더 작을 때 음수 리턴하여 오름차순 정렬, p1.y가 더 크다면 1 반환
```java
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.y < p2.y) return -1;
                else if(p1.y == p2.y) {
                    return p1.x - p2.x;
                } else return 1;
            }
        });
```
2. 좌표값들 Point 타입의 변수로 pq에 삽입
```java
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            pq.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
```
3. pq의 크기가 0이 될 때까지 값을 하나씩 꺼내서 sb에 붙이기
```java
        while(pq.size() > 0) {
            Point p = pq.poll();
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
```
4. sb 출력하기


## :black_nib: **Review**
- 우선순위큐 최고!

## 📡 Link
https://www.acmicpc.net/problem/11651
