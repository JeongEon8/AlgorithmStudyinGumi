# [백준 - 실버 1] 1890.점프

## ⏰ **time**
49분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O((2^N)^N)$

## :round_pushpin: **Logic**
1. 점화식) `dp[i][j] = K`
2. dp가 0이면 출발점에서 시작했을 때 갈 수 없는 곳임. -> `continue`
3. board가 0이면 끝나는 지점임. -> `continue`
4. dp에 여태 저장해온 경우의 수를 더해준다. `dp[ny][nx] += dp[i][j];`
- 방향벡터를 활용한 방식
- 그냥 if문써서 dp[ny][j], dp[i][nx] 해도 됨. (그럼 반복문도 안 돌아도 돼..)
```cpp
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (dp[i][j] == 0 || board[i][j] == 0) {
				continue;
			}

			for (int k = 0; k < 2; k++) {
				int ny = board[i][j] * dy[k] + i;
				int nx = board[i][j] * dx[k] + j;

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}

				dp[ny][nx] += dp[i][j];
			}
		}
	}
```

## :black_nib: **Review**
- 그거 아니시나요?
- 비주얼 스튜디오 디버깅할 때 **조사식**을 걸 수 있는 데요?
- 조사식 = 내가 원하는 변수 혹은 함수에 어떤 값 혹은 주소를 가지는 지 확인할 수 있음
- 제가 이거 몰랐을 떄는 디버깅창에서 변수 열었다 닫았다 계속 해야했는데, 이거 알고 계속 열어놓고 값 뭐 들어가는 지 볼 수 있었어요
- 진짜 광명✨✨ 대학생 때 알았다면 정말 과제하는 시간도 반으로 줄었을 텐데.. 지금 알아버렸다..
- (물론 그때는 2010 버전 쓰고 있어서 없었으려나..?) <-- 아니 찾아보니까 있었네! 그냥 툴 활용을 못하던 거였음! 마이크로소프트 만만세!

## 📡 Link
[https://www.acmicpc.net/problem/1890](https://www.acmicpc.net/problem/1890)
