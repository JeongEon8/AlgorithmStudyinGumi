# [백준 - S3] 33989. 벚꽃과 단풍

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 브루트포스 알고리즘
- 누적 합

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
일렬의 동전의 한 지점까지의 나온 벚꽃 개수를 누적합으로 구해둔다.  
각 지점을 확인하면서 그 왼쪽까지 단풍 면을 모두 뒤집고 그 오른쪽의 벚꽃면을 모두 뒤집는 수를 세고 그중 최소값을 찾는다.
```java
for (int i = 0; i <= n; i++) {
    int flip = (i - blossoms[i]) + (blossoms[n] - blossoms[i]);
    if (ans > flip)
        ans = flip;
}
```  
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/33989
