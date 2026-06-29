#include <array>
#include <iostream>
#include <vector>

constexpr std::array<int, 8> dx = {1, -1, 0, 0, 1, 1, -1, -1};
constexpr std::array<int, 8> dy = {0, 0, 1, -1, 1, -1, 1, -1};

void initBoard(std::vector<std::vector<int>>& board, int N);
bool isOutOfBounds(int col, int row, int N);
void placeStone(std::vector<std::vector<int>>& board, int N, int col, int row, int color);
void countStones(const std::vector<std::vector<int>>& board, int& black, int& white);

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T;
    std::cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        int N, M;
        std::cin >> N >> M;

        std::vector<std::vector<int>> board(N, std::vector<int>(N, 0));
        initBoard(board, N);

        for (int i = 0; i < M; i++) {
            int x, y, color;
            std::cin >> x >> y >> color;
            placeStone(board, N, x - 1, y - 1, color);
        }

        int black = 0;
        int white = 0;
        countStones(board, black, white);

        std::cout << '#' << tc << ' ' << black << ' ' << white << '\n';
    }

    return 0;
}

void initBoard(std::vector<std::vector<int>>& board, int N) {
    board[N / 2 - 1][N / 2 - 1] = 2;
    board[N / 2][N / 2] = 2;
    board[N / 2 - 1][N / 2] = 1;
    board[N / 2][N / 2 - 1] = 1;
}

bool isOutOfBounds(int col, int row, int N) {
    return col < 0 || row < 0 || col >= N || row >= N;
}

void placeStone(std::vector<std::vector<int>>& board, int N, int col, int row, int color) {
    board[row][col] = color;

    for (int d = 0; d < 8; d++) {
        int nc = col + dx[d];
        int nr = row + dy[d];

        if (isOutOfBounds(nc, nr, N) || board[nr][nc] != 3 - color)
            continue;

        int count = 0;
        int sc = nc;
        int sr = nr;
        while (!isOutOfBounds(sc, sr, N) && board[sr][sc] == 3 - color) {
            sc += dx[d];
            sr += dy[d];
            count++;
        }

        if (!isOutOfBounds(sc, sr, N) && board[sr][sc] == color) {
            for (int k = 0; k <= count; k++) {
                board[nr + dy[d] * k][nc + dx[d] * k] = color;
            }
        }
    }
}

void countStones(const std::vector<std::vector<int>>& board, int& black, int& white) {
    for (const auto& r : board) {
        for (int cell : r) {
            if (cell == 1) black++;
            else if (cell == 2) white++;
        }
    }
}
