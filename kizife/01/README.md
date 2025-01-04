# [백준] 14719. 빗물


## ⏰ **time**
60분 

## :pushpin: **Algorithm**
구현, 시뮬레이션

## ⏲️**Time Complexity**
O(H x W)

## :round_pushpin: **Logic**
쌓인 블록 모양을 2차원 배열 형태로 저장한다. 블록=1, 빈공간=0 <br/>
각 층마다 왼쪽 블록, 오른쪽 블록 사이에 낀 빗물을 계산해서 더해준다.
```java
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) { //벽 발견

                    if (leftWall) { //왼쪽벽 있는 상태라면
                        water += tempWater; //그 사이에 갇힌 물을 더해줌
                        tempWater = 0; // 임시물 초기화
                    }

                    leftWall = true; //벽 생긴 것으로 설정 (map[i][j]==1이니까)
                } else if (leftWall) {
                    //왼쪽 벽 있는 상태로 현재 map[i][j]==0이면
                    tempWater++; //물이 고일 수 있음
                }
            }
```


## :black_nib: **Review**
2차원 배열아 사랑해요 

## 📡**Link**
https://www.acmicpc.net/problem/14719
