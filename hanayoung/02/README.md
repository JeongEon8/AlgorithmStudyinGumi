# [SWEA - D3] 02_재미있는 오셀로 게임

## ⏰**time**

30

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N^2)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 팔방향 돌 때 사용할 배열을 constexpr로 선언하여 메모리 사용량 감소
   ```
constexpr std::array<int, 8> dx = {1, -1, 0, 0, 1, 1, -1, -1}; 
constexpr std::array<int, 8> dy = {0, 0, 1, -1, 1, -1, 1, -1};
   ```
2. board 초기화 함수, 초반에 놓여야 할 돌 놓는 함  
```
void initBoard(std::vector<std::vector<int>>& board, int N) { 
board[N / 2 - 1][N / 2 - 1] = 2; 
board[N / 2][N / 2] = 2; 
board[N / 2 - 1][N / 2] = 1; 
board[N / 2][N / 2 - 1] = 1; 
}
```
3. 돌을 놓기 전 벗어났는지 확인하는 함수
```
bool isOutOfBounds(int col, int row, int N) { 
return col < 0 || row < 0 || col >= N || row >= N; 
}
```
4. 돌 놓는 함수. 팔방향을 탐색하며, 다음 자리에 놓을 수 있는지 여부와 시작 돌과 다른 색의 돌인지, 같은 색의 돌이라면 그 전까지 나타난 돌의 색상을 변
```
void placeStone(std::vector<std::vector<int>>& board, int N, int col, int row, int color) { board[row][col] = color; for (int d = 0; d < 8; d++) { int nc = col + dx[d]; int nr = row + dy[d]; if (isOutOfBounds(nc, nr, N) || board[nr][nc] != 3 - color) continue; int count = 0; int sc = nc; int sr = nr; while (!isOutOfBounds(sc, sr, N) && board[sr][sc] == 3 - color) { sc += dx[d]; sr += dy[d]; count++; } if (!isOutOfBounds(sc, sr, N) && board[sr][sc] == color) { for (int k = 0; k <= count; k++) { board[nr + dy[d] * k][nc + dx[d] * k] = color; } } } }
```
5. 전체 돌 색상 세는 함
```
void countStones(const std::vector<std::vector<int>>& board, int& black, int& white) { for (const auto& r : board) { for (int cell : r) { if (cell == 1) black++; else if (cell == 2) white++; } } }
```
## :black_nib: **Review**

- 함수로 최대한 빼보면서 벡터와 친해지고 참조 연산자랑 친해지는 시간 갖기!..

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
