#include <iostream>
#include <vector>
#include <algorithm>

constexpr int T = 10;
int main() {
    for (int tc = 1; tc <= T; tc++) {
        int N;
        std::cin >> N;

        std::vector<int> buildings(N);
        for (int i = 0; i < N; i++) {
            std::cin >> buildings[i];
        }

        int answer = 0;
        for (int i = 2; i < N - 2; i++) {
            int tallestNeighbor = std::max({buildings[i - 2], buildings[i - 1], buildings[i + 1], buildings[i + 2]});
            answer += std::max(0, buildings[i] - tallestNeighbor);
        }

        std::cout << "#" << tc << ' ' << answer << '\n';
    }

    return 0;
}
