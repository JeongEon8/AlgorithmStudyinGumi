# [백준 - S5] 2628. 종이자르기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
가로로 자른 인덱스와 세로로 자른 인덱스를 0과 최대 길이를 추가하고 정렬한다.  
이후 1번인덱스부터 이전까지의 인덱스로 길이를 구해 넓이를 계산하고 최대 넓이를 구한다.
```java
Collections.sort(rows);
Collections.sort(columns);
int ans = 0;
for (int i = 1; i < rows.size(); i++) {
    int rowLength = rows.get(i) - rows.get(i - 1);
    for (int j = 1; j < columns.size(); j++) {
        int columnLength = columns.get(j) - columns.get(j - 1);
        ans = Math.max(ans, columnLength * rowLength);
    }
}
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/2628