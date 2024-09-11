# [SWEA] 1244. 최대 상금  
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**
4,270 ms

## :round_pushpin: **Logic**
- swap 기회가 arr 길이를 초과할 경우, arr 길이만큼만
  ```java
  			if (arr.length < chance) {
				chance = arr.length;
			}
  ```

- dfs: 주어진 기회만큼 실행했을 경우, 그만둔다. (+현재 조합의 숫자를 계산하여 max를 업데이트함)
- 그렇지 않으면, 배열의 모든 가능한 쌍에 대해 교환을 시도
- 교환 후 dfs를 재귀적으로 호출하여 다음 단계 진행
- 교환 후 원래 상태로 되돌리기 위해 원래의 배열 상태로 복원
  ```java
  		if (count == chance) {
			String result = "";
			for (String s : arr)
				result += s;
			max = Math.max(max, Integer.parseInt(result));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				String s = arr[i];
				arr[i] = arr[j];
				arr[j] = s;

				dfs(i, count + 1);

				s = arr[i];
				arr[i] = arr[j];
				arr[j] = s;
			}
		}
  ```

## :black_nib: **Review**
- ㅠ풀긴 했는데 열심히 검색해서 푸느라 이해가 완벽하게 되진 않은 것 같다... 코드를 보면 알겠는데 아무것도 없이 혼자 풀긴 힘들다 
- 초기화 구문 위치를 현명하게 정할 것

## 📡**Link**
- [https://www.acmicpc.net/problem/2667](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD)
