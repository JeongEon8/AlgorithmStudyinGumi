# [프로그래머스 - Lv3] 연속 펄스 부분 수열의 합
 
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- dp

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
dp문제
- 차례대로 최적의 값을 더해주면 구할수 있는 문제
1. 2차원 DP를 생성
2. 배열 하나씩 꺼내서 DP값을 업데이트 시켜줌
   	- 배열에 인덱스가 홀수일 경우 DP 1번쨰는 -1곱하고 짝수일 경우 +1을 곱해준다.
   		- 인덱스가 짝수 일경우는 반대로
```java
	for(int i = 1; i< len; i++){
            dp[i][i%2] = sequence[i]*(-1);
            dp[i][(i+1)%2] = sequence[i];
            if(dp[i][0]+dp[i-1][0] > dp[i][0]){
                dp[i][0] = dp[i][0]+dp[i-1][0];
                if(answer< dp[i][0]){
                   answer = dp[i][0];
                }
            }
            if(dp[i][1]+dp[i-1][1] > dp[i][1]){
                dp[i][1] = dp[i][1]+dp[i-1][1];
                if(answer< dp[i][1]){
                   answer = dp[i][1];
                }
            }
        }
```
	- 이전값이랑 더한 값이 현제 DP값보다 클경우 수정해주고 결과 값이랑도 비교해서 클경우 수정
 		- 결과 값의 초기 값은 배열에 첫번째 값을 -1과 1을 곱한거 중에서 큰값을 넣어준다.
```java
	long answer =  Math.max( dp[0][0], dp[0][1]);
```
3. 결과 값 출력


## :black_nib: **Review**
- LV2보다 쉬운데요

  ## 📡**Link**

- https://school.programmers.co.kr/learn/courses/30/lessons/161988

  

