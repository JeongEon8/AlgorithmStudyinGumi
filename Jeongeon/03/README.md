# [백준 - 실버 5] 2822. 점수 계산

## ⏰  **time**
24분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 점수를 저장해서 점수만 내림차순으로 정렬해!
2. 5개만 더해 합산하고 문제 번호는 priority_queue를 이용해 오름차순으로 정렬해서 출력해
```cpp
    sort(arr.begin(), arr.end(), compare);

    int sum = 0;
    priority_queue<int, vector<int>, greater<>> q;
    for (int i = 0; i < 5; i++) {
        sum += arr[i].score;
        q.push(arr[i].num);
    }
```

## :black_nib: **Review**
- 우선순위 큐는 최고야!
  
## 📡 Link
https://www.acmicpc.net/problem/2822
