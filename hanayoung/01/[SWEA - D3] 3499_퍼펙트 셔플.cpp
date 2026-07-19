#include <iostream>
#include <vector>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T;
    std::cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        int N;
        std::cin >> N;
        std::vector<std::string> word(N);
        for (int i = 0; i < N; i++) {
            std::cin >> word[i];
        }
        int st = (N % 2 == 0) ? N/2 : N/2+1;

        std::cout << '#' << tc << ' ';
        for (int i = 0; i < N/2; i++) {
            std::cout << word[i] << ' ';
            std::cout << word[st+i] << ' ';
        }
        if(N % 2 == 1) std::cout << word[N/2];
        std::cout << '\n';
    }
    return 0;
}
