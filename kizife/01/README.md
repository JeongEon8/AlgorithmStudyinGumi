# [백준] 3190. 뱀


## ⏰ **time**
60분

## :pushpin: **Algorithm**
구현, 덱, 큐 

## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
뱀위치, 사과위치에 각각 다른 값을 기입한다. <br/>
뱀의 머리를 전진시키는 게 디폴트, 꼬리는 사과 먹는 여부에 따라 사라지거나 잔존 <br/>
머리가 범위 벗어나거나 자기 몸(뱀값)에 부딪히면 게임 끝 
```java
            if (map[nextX][nextY] == 1) {
                //사과가 있다면
                snake.addFirst(new int[]{nextX, nextY});
                map[nextX][nextY] = 2;
                //꼬리는 그대로이므로 따로 값 변경 안 함 
            } else {
                //사과가 없다면
                snake.addFirst(new int[]{nextX, nextY});
                map[nextX][nextY] = 2;

                int[] tail = snake.pollLast();
                map[tail[0]][tail[1]] = 0; //꼬리위치는 0 삽입
            }

            //방향 전환
            if (dirChange.containsKey(time)) {
                char turn = dirChange.get(time);
                if (turn == 'L') {
                    dir = (dir + 3) % 4; // 왼쪽
                } else if (turn == 'D') {
                    dir = (dir + 1) % 4; // 오른쪽
                }
            }
```


## :black_nib: **Review**
2차원 배열아 사랑해요 2

## 📡**Link**
https://www.acmicpc.net/problem/3190
