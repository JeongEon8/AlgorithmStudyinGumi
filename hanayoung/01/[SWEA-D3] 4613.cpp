#include <iostream>
#include <vector>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T;
    std::cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        int N, M;
        std::cin >> N >> M;
        std::vector<std::vector<int>> colors(N, std::vector<int>(3)); // W B R 순서

        int answer = M*N;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char color;
                std::cin >> color;
                if(color == 'W') {
                    colors[i][0]++;
                } else if(color == 'B') {
                    colors[i][1]++;
                } else if(color == 'R') {
                    colors[i][2]++;
                }
            }
        }

        for (int we = 0; we < N-2; we++) {
            for (int be = we+1; be <= N-2; be++) {
                int sum = 0;
                for(int i = 0; i <= we; i++) {
                    sum += M - colors[i][0];
                }
                for (int i = we+1; i <= be; i++) {
                    sum += M - colors[i][1];
                }
                for (int i = be+1; i < N; i++) {
                    sum += M - colors[i][2];
                }
                answer = std::min(answer, sum);
            }
        }

        std::cout << '#' << tc << ' ' << answer << '\n';
    }

    return 0;
}
