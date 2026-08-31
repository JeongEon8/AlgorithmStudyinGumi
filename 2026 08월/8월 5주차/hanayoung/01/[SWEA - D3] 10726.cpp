#include <iostream>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T;
    std::cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        int N, M;
        std::cin >> N >> M;

        bool isOn = true;
        for(int i = 0; i < N; i++) {
            if(M % 2 == 0) 
            {
                isOn = false;
                break;
            }
            M /= 2;
        }
        std::cout << '#' << tc << ' ' << (isOn ? "ON" : "OFF") << '\n';
    }
    return 0;
}
