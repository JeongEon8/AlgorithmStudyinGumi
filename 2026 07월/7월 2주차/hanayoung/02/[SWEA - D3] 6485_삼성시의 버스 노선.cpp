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
        std::vector<int> bus(5001);

        for (int i = 0; i < N; i++) {
            int st, end;
            std::cin >> st >> end;
            for(int j = st; j <= end; j++) {
                bus[j]++;
            }
        }

        int P;
        std::cin >> P;
        std::cout << "#" << tc << ' ';

        for (int i = 0; i < P; i++) {
            int idx;
            std::cin >> idx;
            std::cout << bus[idx] << ' ';
        }
        std::cout << '\n';
    }

    return 0;
}
