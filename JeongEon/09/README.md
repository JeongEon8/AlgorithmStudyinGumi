# [백준 - 실버5] 5800. 성적 통계
 
## ⏰  **time**
5분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(N*NlogN)$

## :round_pushpin: **Logic**
1. 성적 입력 후 내림차순으로 정렬한다.
2. 바로 오른쪽과 절댓값 차 중 가장 큰 차를 저장한다.
   ```cpp
		sort(student.begin(), student.end(), greater<>());

		int maxi = student[0];
		int min = student[N-1];
		int gap = 0;

		for (int i = 0; i < N - 1; i++) {
			gap = max(abs(student[i] - student[i + 1]), gap);
		}
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/5800
