# [BOJ - S3] 1449. 수리공 항승

## ⏰  **time**
30분

## :pushpin: **Algorithm**
그리디


## :round_pushpin: **Logic**
1. 정렬 후 테이프만큼 idx 이동 후 answer++
```
 while (idx < h.size()) {
        int now = h[idx];
        int end = now + l - 1;
        for (int i = idx; i < h.size(); i++) {
            if(end<h[i])break;
            idx++;
        }
        answer++;
    }
```

## :black_nib: **Review**
- 



## 📡 Link
https://www.acmicpc.net/problem/1449
