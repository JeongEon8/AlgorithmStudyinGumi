# [백준 - 골드 5] 14503. 로봇 청소기
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 청소 했어?
2. 청소 할 곳 있어?
3. 그럼 청소 할 곳을 찾아서 반시계 방향으로 회전하고 움직여
4. 없어?
5. 그럼 후진해
6. 벽이야?
7. 그럼 종료해
   ```cpp
	while (1) {
		if (check[r][c] == false) { //1번 현재 위치 청소			
			check[r][c] = true;
			sum++;			
		}
		bool ch = false;
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4; // 방향을 틀어서 봄
			int nx = r + dx[d];// 방향을 틀어서 본 좌표의 청소값을 보기 위함
			int ny = c + dy[d];
			if (board[nx][ny] == 0 && check[nx][ny] == false) {
				//왼쪽 방향에 청소하지 않은 공간이 있다면 한 칸 움직이고 1번으로 감
				r += dx[d];
				c += dy[d];
				ch = true;
				break;
			}
		}
		if (!ch) { //조건 2-c , 2-d일 때
			int back = (d + 2) % 4; //바라보는 방향을 유지하기 위해서
			if (board[r + dx[back]][c + dy[back]] == 1) break;
			r += dx[back];
			c += dy[back];
		}
	}
   ```

## :black_nib: **Review**
- 청소기 바보 😛

## 📡 Link
https://www.acmicpc.net/problem/14503
