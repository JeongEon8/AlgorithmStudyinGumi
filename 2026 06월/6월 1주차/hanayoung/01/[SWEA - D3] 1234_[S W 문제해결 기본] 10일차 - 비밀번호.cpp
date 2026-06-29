#include <iostream>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);	
    int T = 10;

    for (int tc = 1; tc <= T; tc++) {
        int N;
        std::cin >> N;
        
        std::string pwd;
        std::cin >> pwd;

        std::string answer;
        for(char c : pwd) {
            if(answer.length() > 0 && answer.back() == c) {
                answer.pop_back();
            } else {
                answer.push_back(c);
            }
        }

        std::cout << "#" << tc << ' ' << answer << '\n';
    }

    return 0;
}
