#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string str = "";
    int M, x;
    cin >> M;

    int S = 0;

    for (int i = 0; i < M; i++) {
        cin >> str;

        if(str == "add") {
            cin >> x;
            S |= (1<<x);    // OR 연산
        }

        else if (str=="remove") {
            cin >> x;
            S &= ~(1<<x);   // NOT 연산 + AND 연산
        }

        else if (str == "check") {
            cin >> x;
            if (S & (1<<x)) { // S에 x가 있음
                cout << "1\n";
            } else {
                cout << "0\n";
            }
        }

        else if (str=="toggle") {
            cin >> x;
            if (S & (1<<x)) { // S에 x가 있으면 없애야함
                S &= ~(1<<x);
            } else {
                S |= (1<<x);  // S에 없으면 추가
            }
        }

        else if (str=="all")
            S = (1<<21) - 1;  // 1~20으로 변경
        else if (str=="empty")
            S = 0;
        
    }
    
    return 0;
}