#include <iostream>
#include <string>
#include <stack>

bool isMatching(char open, char close);
    
int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int T = 10;

    for (int tc = 1; tc <= T; tc++) {
        int len; 
        std::cin >> len;

        std::string str;
        std::cin >> str;

        int answer = 1;

        std::stack<int> st;

        for(char c: str) {
            if(c == '{' || c == '[' || c == '(' || c == '<') {
                st.push(c);
            } else {
                if(st.size() == 0 || isMatching(st.top(), c) == false) {
                    answer = 0;
                    break;
                }
                st.pop();
            }
        }
        
        if(st.size() > 0) answer = 0; 

        std::cout << "#" << tc << ' ' << answer << '\n';
    }

    return 0;
}


bool isMatching(char open, char close) {
    return (open == '(' && close == ')' ||
            open == '[' && close == ']' ||
            open == '{' && close == '}' ||
            open == '<' && close == '>');
}
