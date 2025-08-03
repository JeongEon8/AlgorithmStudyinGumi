# [백준 - 실버 4] 10825. 국영수

## ⏰  **time**
15분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 국어는 내림차순으로,
2. 국어 점수가 같으면 영어가 오름차순으로,
3. 국어, 영어 점수가 같으면 수학 내림차순으로,
4. 모든 점수가 같으면 이름 오름차순으로
```cpp
  bool cmp(Student a, Student b) {
  	if (a.kr == b.kr && a.en == b.en && a.math == b.math) {
  		return a.name < b.name;
  	}
  	else if (a.kr == b.kr && a.en == b.en) {
  		return a.math > b.math;
  	}
  	else if (a.kr == b.kr) {
  		return a.en < b.en;
  	}
  
  	return a.kr > b.kr; // 국어는 감소하는 순으로
  }
```

## :black_nib: **Review**
- 정렬 compare 변경하는거 오랜만이당
  
## 📡 Link
https://www.acmicpc.net/problem/10825
