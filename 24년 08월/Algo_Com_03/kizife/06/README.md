# [백준] 2669. 직사각형 네개의 합집합의 면적 구하기
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
구현 

## ⏲️**Time Complexity**
100ms

## :round_pushpin: **Logic**
1. 최대 크기가 100이므로 100*100인 2차원 배열을 만들어 주었다.
2. 평면이 곧 2차원 배열이고, 좌표값이 인덱스라고 생각
3. 직사각형의 범위 내에 있는 인덱스에 색칠(1)하기
```java
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    if (x1 <= j && j < x2 && y1 <= k && k < y2) {
                        arr[j][k] = 1;
                    }
                }
            }
```

4. 1인 인덱스 수 세기
```java
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }
```

## :black_nib: **Review**
- 로직을 떠올린 후 코드로 구현하는 것은 의외로 어렵지 않았다. 야호! 

## 📡**Link**
- https://www.acmicpc.net/problem/2669
