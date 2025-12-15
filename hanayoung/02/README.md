# [백준 - G5] 2096. 내려가기

## ⏰  **time**
4시간

## :pushpin: **Algorithm**
dp

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 세 칸의 가능한 작은 값과 큰 값을 저장
```java
        min = new int[3];
        max = new int[3];
```
2. copy 배열을 만들어서, 움직일 수 있는 범위를 구해서 해당 칸으로 이동할 때 가능한 가장 작은 값과 큰 값 구해서 copy 배열에 넣기
3. 3개의 값에 대해 다 돌고 나면 min와 max 배열 업데이트하고 다음 줄 탐색
```java
        for(int i = 1; i < N; i++) {
            int[] copyMin = min.clone();
            int[] copyMax = max.clone();
            for(int j = 0; j < 3; j++) {
                int minVal = Integer.MAX_VALUE;
                int maxVal = 0;
                int start = j - 1 >= 0 ? j-1: 0;
                int end = j + 1 < 3 ? j + 1 : 2;

                for(int k = start; k <= end; k++) {
                    minVal = Math.min(minVal, maps[i][j] + min[k]);
                    maxVal = Math.max(maxVal, maps[i][j] + max[k]);
                }
                copyMin[j] = minVal;
                copyMax[j] = maxVal;
            }
            min = copyMin.clone();
            max = copyMax.clone();
        }

```
6. 끝까지 탐색하면 min 배열과 max 배열에 최종 최솟값과 최댓값이 저장되므로 해당 배열들을 돌며 최솟값과 최댓값 찾아서 출력
```java
        int minAns = Math.min(min[0], min[1]);
        minAns = Math.min(minAns, min[2]);

        int maxAns = Math.max(max[0], max[1]);
        maxAns = Math.max(maxAns, max[2]);
```


## :black_nib: **Review**
- dp 어렵다어려워 거기다가 시간초과까지 그리고 한 줄만 관리해야한다니

## 📡**Link**
- https://www.acmicpc.net/problem/2096
