# [백준 - 골드 5] 2096. 내려가기
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. 처음엔 그대로 넣는다.
2. 그 다음은 입력값과 비교하여 넣는다.
3. 큰값을 출력한다.
   ```cpp
for (int i = 1; i < n; i++) {
        scanf("%d %d %d", &input[0], &input[1], &input[2]);
        //최대값을 구해주는 DP배열 
        temp_0 = maxDP[0]; temp_2 = maxDP[2];
        maxDP[0] = max(maxDP[0], maxDP[1]) + input[0];
        maxDP[2] = max(maxDP[1], maxDP[2]) + input[2];
        maxDP[1] = max(max(temp_0, maxDP[1]), temp_2) + input[1];
        //최소값을 구해주는 DP배열
        temp_0 = minDP[0]; temp_2 = minDP[2];
        minDP[0] = min(minDP[0], minDP[1]) + input[0];
        minDP[2] = min(minDP[1], minDP[2]) + input[2];
        minDP[1] = min(min(temp_0, minDP[1]), temp_2) + input[1]
}
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/2096
