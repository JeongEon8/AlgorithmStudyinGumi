# [프로그래머스 - lv2] 리코쳇 로봇

## ⏰**time**

20분

## :pushpin: **Algorithm**

bfs

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

1. String 배열을 2차원 int 배열로 변경해준다.
   - D는 1, R은 start변수에, G는 end 변수에 넣어준다.
2. 큐를 생성해서 초기값 start에서 뽑아서 넣어준다.
3. 큐를 활용하여 bfs탐색을 해준다.
   - 4방향이 탐색하는데 D를 만나거나 맵 밖에 나갈때 까지 이동시켜준다.
   - D를 만나면 해당값을 큐에 넣어주고 방문체크
4. 해당위치가 end좌표랑 같으면 count 출력

```java
while (!que.isEmpty()) {
            Info cur = que.poll();
            
            if (cur.x == endX && cur.y == endY) {
                return cur.count;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x;
                int ny = cur.y;
                
                while (nx + dx[d] >= 0 && nx + dx[d] < R && 
                       ny + dy[d] >= 0 && ny + dy[d] < C && 
                       arr[nx + dx[d]][ny + dy[d]] != 1) {
                    nx += dx[d];
                    ny += dy[d];
                }
                
                
                if (!check[nx][ny]) {
                    check[nx][ny] = true;
                    que.add(new Info(nx, ny, cur.count + 1));
                }
            }
        }
        return -1; 
```



## :black_nib: **Review**
백준 그리워~~

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/169199>
