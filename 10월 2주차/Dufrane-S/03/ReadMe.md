# [백준 - S5] 7568. 덩치

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 브루트포스

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

모든 사람들끼리 비교해서 등수를 구해준다.

```
for (auto i: v) {
        int tmp = 1;
        for (auto j: v) {
            if (i.first < j.first && i.second < j.second) {
                tmp++;
            }
        }
        cout << tmp << ' ';
    }

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/7568
