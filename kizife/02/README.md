# [백준] 14889. 스타트와 링크
 
## ⏰  **time**
40분 

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
436ms

## :round_pushpin: **Logic**
```java
int num1 = 0;  // 첫 번째 팀의 능력치 합
		int num2 = 0;  // 두 번째 팀의 능력치 합
		
		// 두 팀의 능력치 합을 각각 계산
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				
				if (visited[i] && visited[j]) {  // 첫 번째 팀에 속한 경우
					num1 += arr[i][j];
					num1 += arr[j][i];
				} else if (!visited[i] && !visited[j]) {  // 두 번째 팀에 속한 경우
					num2 += arr[i][j];
					num2 += arr[j][i];
				}
			}
		}
```

```java
// 재귀적으로 팀 나누기 
		for (int i = index; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;  // 현재 인원을 팀에 배정
				pair(i + 1, count + 1);  // 다음 인원을 선택
				visited[i] = false;  // 선택을 취소하고 다른 경우를 탐색
			}
		}
```

## :black_nib: **Review**
- 로직과 구현 모두 낯설었다. 

## 📡**Link**
- https://www.acmicpc.net/problem/14889 
