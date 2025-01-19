# [백준 - 골드 3] 16236. 아기 상어
 
## ⏰  **time**
100분

## :pushpin: **Algorithm**
bfs, 구현

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 먼저 bfs를 통해 아기상어와 다른 먹이 사이의 거리를 업데이트
2. 정해진 조건에 따라 다음 이동해야할 위치 구하기

```java
        while (!sharks.isEmpty()) {
            for (Shark s : sharks) {
                if (s.size < babyShark.size) {
                    s.distance = checkDistance(babyShark, s, map);
                }
            }
            Collections.sort(sharks);
            int i = 0;
            for (; i < sharks.size(); i++) {
                if (sharks.get(i).size < babyShark.size && sharks.get(i).distance != 1001) {
                    break;
                }
            }
            if (i < sharks.size()) {
                count++;
                if (count == babyShark.size) {
                    babyShark.size += 1;
                    count = 0;
                }
                map[babyShark.y][babyShark.x] = 0;
                map[sharks.get(i).y][sharks.get(i).x] = 0;
                answer += sharks.get(i).distance;
                babyShark.y = sharks.get(i).y;
                babyShark.x = sharks.get(i).x;
                System.out.println();*/
                sharks.remove(i);
            } else {
                break;
            }
        }
```


## :black_nib: **Review**
-  

## 📡 Link
https://www.acmicpc.net/problem/16236
