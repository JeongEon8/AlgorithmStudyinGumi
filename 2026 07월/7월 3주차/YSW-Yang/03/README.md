# [PGS - Lv2] 03_삼각 달팽이

## ⏰**time**

- 40분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. n층 높이의 삼각형 형태를 저장할 2차원 배열(board)을 선언합니다.
2. 달팽이의 이동 규칙인 3가지 방향을 정의합니다.
    - (i % 3 == 0) >> 아래로 이동 (x++)
    - (i % 3 == 1) >> 오른쪽으로 이동 (y++)
    - (i % 3 == 2) >> 대각선 위로 이동 (x--, y--)
3. 외곽 루프를 i = 0부터 n-1까지 돌리며, 한 방향으로 이동하는 거리를 점차 줄여가며 숫자를 채웁니다.
4. 채워진 2차원 배열의 값을 순차적으로 1차원 배열로 옮겨 담아 반환합니다.
```java
        int[][] board = new int[n][];
        
        for(int i = 0; i < n; i++){
            board[i] = new int[i + 1];
        }

        int num = 1;
        int x = -1;
        int y = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0){
                    x++;
                }else if(i % 3 == 1){
                    y++;
                }else if(i % 3 == 2){
                    x--;
                    y--;
                }
                
                board[x][y] = num++;
            }
        }
        
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[index++] = board[i][j];
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/68645
