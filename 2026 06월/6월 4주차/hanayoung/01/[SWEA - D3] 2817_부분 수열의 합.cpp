#include <iostream>
#include <vector>

int dfs(const std::vector<int>& arr, int idx, int sum, int K);

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T;
    std::cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        int N, K;
        std::cin >> N >> K;

        std::vector<int> arr(N);
        for (int i = 0; i < N; i++) {
            std::cin >> arr[i];
        }

        std::cout << "#" << tc << ' ' << dfs(arr, 0, 0, K) << '\n';
    }

    return 0;
}

int dfs(const std::vector<int>& arr, int idx, int sum, int K) {
    if (idx == static_cast<int>(arr.size())) {
        return (sum == K) ? 1 : 0;
    }

    if (sum > K) {
        return 0;
    }

    return dfs(arr, idx + 1, sum + arr[idx], K)
         + dfs(arr, idx + 1, sum, K);
}
