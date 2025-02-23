# [백준 - S3] 16967. 배열 복원하기

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**\
기존 배열이었던 부분은 그대로 출력하고 겹치는 부분은 복원하여 값을 변경해주고 출력한다.
```java
for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i >= heightA && j >= widthA) {
                    list[i][j]=list[i][j] - list[i - heightA][j - widthA];
                }
                sb.append(list[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/16967
