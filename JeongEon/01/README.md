# [백준 - 실버 2] 2512. 예산
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
이분탐색 

## ⏲️**Time Complexity**
$O(nlog(n))$

## :round_pushpin: **Logic**
1. 중간값보다 작으면 sum에 더해주고 국가 예산의 총액과 비교
```cpp
  while(start<=end) {
    sum=0;
    int mid = (start+end)/2;
    for(auto i=0; i<n;i++) {
        sum += min(budget[i],mid);
    }
    if(m>=sum) {
        result=mid;
        start=mid+1;
    }else {
        end=mid-1;
    }
  }
```

## :black_nib: **Review**
- 이분탐색 너무 오랜만이다... 진짜 다 까먹은듯. 큰일났다

## 📡 Link
https://www.acmicpc.net/problem/2512
