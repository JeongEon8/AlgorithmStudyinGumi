#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

int main() {
    int N;
    cin >> N;
    for (int I = 0; I < N; I++) {
        int n;
        cin >> n;
        string s1, s2;
        unordered_map<string, int> m;
        for (int i = 0; i < n; i++) {
            cin >> s1 >> s2;
            m[s2]++;
        }
        int answer = 1;
        for (auto i: m) {
            answer *= i.second+1;
        }
        cout << answer - 1 << '\n';
    }
}
