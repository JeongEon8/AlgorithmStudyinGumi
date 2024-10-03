# [백준] 2563. 색종이
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
구현 

## ⏲️**Time Complexity**
112ms

## :round_pushpin: **Logic**
1. x1, x2, y1, y2 좌표값을 설정한다.
2. 2중 for문을 작성하여, 2차원 배열로 표현된 좌표상 네모에 해당되는 범위에 1을 삽입한다.
```java
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    if(x1<=j && j<x2 && y1<=k && k<y2) {
                        arr[j][k] = 1;
                    }
                } 
            }
        }    
```

3. 1이 삽입된 인덱스의 개수를 구한다.
```java
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] ==1) {
                    count++;
                }
            }
        }
```


## :black_nib: **Review**
- 이것도 크게 어렵지 않은 문제였다. 그렇다고 엄청 빨리 푼 것은 아니지만...

## 📡**Link**
- https://www.acmicpc.net/problem/2563
