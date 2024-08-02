# [백준 - S4] 5883. 아이폰 9S

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

배열 각각의 index마다 자기 뒤에 자신과 같은 숫자를 세다가 처음으로 다른 숫자가 나오면 diff에 그 다른 숫자를 기록해두고 3번째 종류의 숫자가 나오면 break하고 최대치와 비교한다.

```cpp
    int  max = 1;

    for (int i = 0; i < n; i++) {
        int cnt = 1, diff = -1;
        for (int j = i + 1;j < n; j++) {
            if (vec[i] == vec[j]) {
                cnt++;
            }
            else if (diff == -1) {
                diff = vec[j];
            }
            else if (diff != vec[j]) {
                break;
            }
        }
        if (max < cnt) {
            max = cnt;
        }
    }
```

## :black_nib: **Review**

- 처음 문제를 읽었을 땐 투 포인터 문제로 생각하였으나 N이 최대 1000인 것을 뒤늦게 보고 브루트포스로 풀었습니다.

## 📡**Link**

- https://www.acmicpc.net/problem/5883
