# [백준] 6593. 상범 빌딩  
 
## ⏰  **time**
40분 

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
3차원 배열을 활용한 bfs 문제이므로 dx, dy, dz로 이동한다.
(이제 발견했는데 exitFounded는 사용하지 않았다...)

이동할 때마다 dist값을 +1 해주고, 종점에 다다랐을 경우 이 dist값을 리턴한다.
만약 출구를 찾지 못한 채로 종료되면 -1을 리턴한다.
```java
                int x = now[0];
                int y = now[1];
                int z = now[2];
                int dist = now[3];

                if (map[x][y][z] == 'E') {
                    return dist;
                }

                ...

                return -1;
```


## :black_nib: **Review**
- 좌표값 자체에 +1 하면서 값을 구하고 있었는데, 짝꿍이 dist를 따로 빼주어서 그렇게 풀었다.
- 다음에는 값을 입력받음과 동시에 출발점을 저장해두는 게 코드 간결화에 도움 될 것 같다. 

## 📡**Link**
- https://www.acmicpc.net/problem/6593
