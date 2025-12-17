# [프로그래머스 - lv2] 과제 진행하기

## ⏰  **time**
40분

## :pushpin: **Algorithm**
스택, 큐, 정렬

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**
1. dp배열 3차원 배열을 만들어준다.
     - 기다리는 시간, 나무, 움직인 수
2. 초기값 설정
    - 1번 자리에 있으면 tree[0][0][W] = 1, tree[0][1][W-1] = 0
    - 2번 자리에 있으면 tree[0][0][W] = 0, tree[0][1][W-1] = 1
3. 2번째 부터는 전에 값이랑 비교 해서 큰값을 넣어준다.
```java
for(int i = 0; i<W+1; i++) {
					
					if(tree ==1) {
						int max = 0;
						if(i+1<W+1 && dp[t-1][1][i+1]+1>max) {
							max = dp[t-1][1][i]+1;
						}
						if(dp[t-1][0][i]+1>max) {
							max = dp[t-1][0][i];
						}
						dp[t][0][i] = max;
					}else {
						int max = 0;
						if(i+1<W+1 && dp[t-1][0][i+1]+1>max) {
							max = dp[t-1][0][i]+1;
						}
						if(dp[t-1][1][i]+1>max) {
							max = dp[t-1][1][i];
						}
						dp[t][1][i] = max;
					}
					
				}
 }
```

## :black_nib: **Review**
- 

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/176962
