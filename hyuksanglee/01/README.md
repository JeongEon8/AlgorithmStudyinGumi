# [백준 - G3] 1937.욕심쟁이 판다 
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
dfs, dp

## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
1. 대나무를 담는 함수 2차원 배열 map과 현재 칸에서 최대 이동할수 있는 2차원 배열 dp를 생성해준다.

   
2. for문을 돌면서 하나씩 dfs를 탐색한 결과와 dp에 저장된 값을 비교하여 최댓값으로 dp에 저장
3. dp에 가장 큰 값을 출력
	
```java
	public static int dfs(int i, int j) {

	    if (isSelected[i][j] != 0) {
	        return isSelected[i][j];
	    }

	    isSelected[i][j] = 1;  // 처음에는 자기 자신만 방문

	    for (int d = 0; d < 4; d++) {
	        int ni = i + di[d];
	        int nj = j + dj[d];
	        // 범위를 벗어나지 않고, 다음 칸이 현재 칸보다 대나무 양이 많을 경우에만 이동
	        if (ni >= 0 && nj >= 0 && ni < n && nj < n && map[ni][nj] > map[i][j]) {
	            isSelected[i][j] = Math.max(isSelected[i][j], dfs(ni, nj) + 1);
	        }
	    }

	    return isSelected[i][j];
	}
```



## :black_nib: **Review**
- dp가 너무 어려워요 

## 📡**Link**
- https://www.acmicpc.net/submit/1937/85154199
