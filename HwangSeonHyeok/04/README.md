# [백준 - G5] 32867. 피아노

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘
- 시뮬레이션

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
건반에서 최소, 최대 범위를 업데이트하고 만약 범위가 k를 넘어가면 손을 옮기는 식으로 하면된다.  
처음 max와 min을 첫 건반으로 하고 min보다 작고 k범위를 안벗어나면 min을 업데이트 max보다 크고 범위를 벗어나지 않으면 max를 업데이트한다.  
범위를 벗어나면 max와 min을 다시 새 건반으로 하고 손을 옮긴다.
```java
int ans = 0;
int max = keys[0];
int min = keys[0];
for (int i = 1; i < n; i++) {
    int nextKey = keys[i];
    if (nextKey <= max && nextKey >= min)
        continue;
    if (nextKey < min && nextKey > max - k) {
        min = nextKey;
    } else if (nextKey > max && nextKey < min + k) {
        max = nextKey;
    } else {
        ans++;
        max = nextKey;
        min = nextKey;
    }
}
```  
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/32867
