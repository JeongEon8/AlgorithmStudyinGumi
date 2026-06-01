#include <iostream>
#include <climits>

int main() {
    int T;
    std::cin >> T;

    for(int tc = 1; tc <= T; tc++) {
        std::string origin;
        int answer = 0;
        std::cin >> origin;
        std::string check(origin.size(), '0');

        for(int i = 0; i < origin.size(); i++) {
            if(check[i] != origin[i]) {
                answer++;
                for(int j = i; j < origin.size(); j++) {
                    check[j] = '0' + ('1' - check[j]);
                }
            }
        }

        std::cout << '#' << tc << ' ' << answer << '\n';
    }
}
