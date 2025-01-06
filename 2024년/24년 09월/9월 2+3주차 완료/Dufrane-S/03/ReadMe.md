# [SWEA - 모의] 2112. 경사로
 
## ⏰  **time**
120분

## :pushpin: **Algorithm**
백트래킹


## :round_pushpin: **Logic**
1. 백트래킹을 통해 모든 경우의 수를 파악해서 테스트
```
void dfs(int count, int line) {

	//line(현재 수정할 row)가 d 높이보다 크면 
	if (line >= d) {
		if (check()) {
			if (answer > count) {
				answer = count;
			}
		}
		return;
	}
	//count(현재 수정한 row의 수)가 기존 answer보다 크면, 혹은 k(최소 조건)보다 크면
	if (count >= answer || count > k)return;
	
	//통과시 answer 갱신 후 return
	if (check()) {
		if (answer > count) {
			answer = count;
		}
		return;
	}
	//변경없이 변경할 row만 + 1
	dfs(count, line + 1);

	//0으로 변경 후, 변경한 row수 count + 1 후 변경할 row 변경
	for (int i = 0; i < w; i++) {
		copybox[line][i] = 0;
	}
	dfs(count + 1, line + 1);
	//복구
	for (int i = 0; i < w; i++) {
		copybox[line][i] = box[line][i];
	}
	//1으로 변경 후, 변경한 row수 count + 1 후 변경할 row 변경
	for (int i = 0; i < w; i++) {
		copybox[line][i] = 1;
	}
	dfs(count + 1, line + 1);
	//복구
	for (int i = 0; i < w; i++) {
		copybox[line][i] = box[line][i];
	}
}
```

## :black_nib: **Review**
- .



## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu
