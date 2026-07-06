#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T;
    std::cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        int N;
        std::cin >> N;

        std::vector<int> tails;
        for (int i = 0; i < N; i++) {
            int x;
            std::cin >> x;
            auto it = std::upper_bound(tails.begin(), tails.end(), x);
            if (it == tails.end()) {
                tails.push_back(x);
            } else {
                *it = x;
            }
        }

        std::cout << '#' << tc << ' ' << tails.size() << '\n';
    }

    return 0;
}
