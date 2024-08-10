# [백준 - S1] 2792. 보석 상자

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 이분 탐색
- 매개변수 탐색

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**

한사람이 가져갈 수 있는 최대 보석은 같은 색상의 보석 개수 범위인 1 ~ 10억개 사이다.  
각각의 색상에서 같은 색상의 보석을 받는 인원 수가 최소가 되도록 하는 수를 세주고 이 합이 n명보다 많으면 답이 더 큰 값이 어야하고 cnt가 n이하가 되는 최소 값을 구한다.

```cpp
int left = 1, right = 1e9, ans = 1e9;
    while (left <= right) {
        int mid = (left + right) / 2;
        long long cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += arr[i] / mid;
            if (arr[i] % mid != 0) {
                cnt++;
            }
        }
        if (cnt > n) {
            left = mid + 1;
        }
        else {
            if (mid < ans) {
                ans = mid;
            }
            right = mid - 1;
        }
    }
```

## :black_nib: **Review**

left를 처음엔 0으로 두고 시작해서 mid가 0인 divide by zero error가 있었다.  
mid로 나눌 일 있는 경우엔 신경 써야할듯.

## 📡**Link**

- https://www.acmicpc.net/problem/2792
