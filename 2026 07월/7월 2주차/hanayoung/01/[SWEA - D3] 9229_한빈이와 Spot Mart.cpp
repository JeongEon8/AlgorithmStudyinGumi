#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T;
    std::cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        int N, M;
        int answer = -1;
        std::cin >> N >> M;

        std::vector<int> snacks(N);

        for (int i = 0; i < N; i++) {
            std::cin >> snacks[i];
        }
        std::sort(snacks.begin(), snacks.end());

        int left = 0;
        int sum = 0;
        int right = N-1;

        while(left < right) {
            sum = snacks[left] + snacks[right];
            if(sum > M) {
                right--;
            } else {
                left++;
                answer = std::max(answer, sum);
            }
        }
        std::cout << "#" << tc << ' ' << answer << '\n';
    }
    return 0;
}
