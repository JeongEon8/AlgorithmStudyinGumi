# [백준] 1074. Z
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
분할 정복, 재귀 

## ⏲️**Time Complexity**
O(log N)

## :round_pushpin: **Logic**
큰 정사각형은 4분면으로 나눌 수 있고, 각 부분은 다시 4분면으로 나눌 수 있다. 
이 원리를 이용하여 제1~4분면에 각각 +0, +1, +2, +3을 해주는 방식.
특히 구하려는 r, c 좌표가 어딨느냐에 따라 범위를 좁혀 나간다.
```java
        while (size > 1) {
            size /= 2; //크기를 반으로 줄임 (몇사분면인지 확인하려고)

            if (r < size && c < size) { //1사분면
                result += 0;
            } else if (r < size) { //2사분면
                result += size * size; //1사분면 크기만큼 더해줌
                c -= size; //열을 반으로 줄임
            } else if (c < size) { //3사분면
                result += size * size * 2; //1+2사분면 크기만큼 더해줌
                r -= size; // 행을 반으로 줄임
            } else { //4사분면
                result += size * size * 3; //1+2+3사분면 크기만큼 더해줌
                r -= size; //행,
                c -= size; //열을 반으로 줄임
            }
        }
```


## :black_nib: **Review**
- 메모리 초과 때문에 고통스러웠던 문제...^^ㅋ 모든 칸에 숫자를 삽입하려고 했다가, 메모리 초과로 인해 rc 좌표 쪽으로 최대한 범위를 축소시켰다.

## 📡**Link**
- https://www.acmicpc.net/problem/1074 
