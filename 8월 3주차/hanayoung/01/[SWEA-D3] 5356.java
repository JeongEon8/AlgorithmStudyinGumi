#include <iostream>
#include <array>
#include <string>
 
int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
 
    int T;
    std::cin >> T;
 
    for (int tc = 1; tc <= T; tc++) {
        std::array<std::array<char, 15>, 5> words{};
 
        std::cout << '#' << tc << ' ';
 
        for (int i = 0; i < 5; i++) {
            std::string s;
            std::cin >> s;
 
            for(int j = 0; j < s.length(); j++) {
                words[i][j] = s.at(j);
            }
        }
 
        for(int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if(words[j][i] != '\0') std::cout << words[j][i];
            }
        }
        std::cout << '\n';
    }
 
    return 0;
}
