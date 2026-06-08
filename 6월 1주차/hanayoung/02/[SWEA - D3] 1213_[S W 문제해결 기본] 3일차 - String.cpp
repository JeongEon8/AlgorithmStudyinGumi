#include <iostream>
#include <string>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T = 10;

    for (int tc = 1; tc <= T; tc++) {
        int tcNum;
        std::cin >> tcNum;

        std::string pattern;
        std::cin >> pattern;

        std::string text;
        std::cin >> text;

        int answer = 0;
        std::size_t pos = 0;

        while ((pos = text.find(pattern, pos)) != std::string::npos) {
            answer++;
            pos += pattern.length();
        }

        std::cout << "#" << tc << ' ' << answer << '\n';
    }

    return 0;
}
