# [백준 - G5] 1195. 킥다운

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 구현
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**

기어의 위치를 움직였을때 위 아래가 모두 2인경우가 없도록 만드는 최단 가로 너비를 구하는 문제다.  
기어를 1칸씩 움직여가면서 브루트 포스로 구현하였다.  
아래는 1번 기어를가만히 두고 2번 기어를 움직이는 포문인데 이와 거의 같은 2번 기어를 가만히 두고 1번 기어만 움직이는 과정을 거쳐 총 2번의 과정을 통해 최단 길이를 구한다.

```cpp

for (int i = 0; i <= n.length(); i++) {
        bool possible = true;
        for (int j = 0; j < m.length(); j++) {
            if (g1[i + j] == 2 && g2[j] == 2) {
                possible = false;
                break;
            }
        }
        if (possible) {
            int curLength;
            if (n.length() > i + m.length()) {
                curLength = n.length();
            }
            else {
                curLength = i + m.length();
            }
            if (ans > curLength) {
                ans = curLength;
            }
        }
    }
```

## :black_nib: **Review**

2번 기어를 가만히 두고 1번 기어만 움직이는 경우를 생각하지 않아 반례를 찾는데 시간이 걸렸다.  

## 📡**Link**

- https://www.acmicpc.net/problem/1195
