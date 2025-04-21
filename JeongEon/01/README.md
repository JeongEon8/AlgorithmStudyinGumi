# [백준 - 실버 4] 10610. 30

## ⏰  **time**
10분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 30의 배수이려면 3의 배수이면서 동시에 10의 배수이면 된다.
```cpp
  for (int i = 0; i < nums.size(); ++i) {
      check += nums[i];
  }
  
  if (check % 3 != 0) {
      cout << -1;
  }
  else if (nums[nums.size() - 1] != 0) {
      cout << -1;
  }
  else {
      for (auto x : nums) cout << x;
  }
```

## :black_nib: **Review**
- 정신없게 일단 후다닥 푼다... 난 오늘이 회식인지도 아침에 알았다

## 📡 Link
https://www.acmicpc.net/problem/10610
