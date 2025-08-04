# [백준 - S1] 1946. 신입 사원

## ⏰  **time**
10분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O((NlogN)^T)$

## :round_pushpin: **Logic**
1. 먼저 서류 점수를 오름차순으로 정렬해놓고, 면접 점수가 작으면 ret을 올린다.
```cpp
		sort(v.begin(), v.end());
		
		int tmp = 0;
		ret = 1;
		for(int i=1; i<n; i++){
			if(v[tmp].second > v[i].second){
				ret++;
				tmp = i;
			}
		}
```

## :black_nib: **Review**
- 이렇게 사람을 뽑는 건강...

## 📡 Link
https://www.acmicpc.net/problem/1946
