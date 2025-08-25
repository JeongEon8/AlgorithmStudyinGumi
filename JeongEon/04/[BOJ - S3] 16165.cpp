#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int N, M;
    map<string, vector<string>> m;
    
    cin >> N >> M;
    
    for (int i = 0; i < N; i++) {
        string team;
        int member;
        cin >> team >> member;
        
        for (int j = 0; j < member; j++) {
            string name;
            cin >> name;
            m[team].push_back(name);
        }
    }

    for (int i = 0; i < M; i++) {
        int type;
        string str;
        cin >> str >> type;
        if (type) {
            for (auto it = m.begin(); it != m.end(); it++) {
                if (find(it->second.begin(), it->second.end(), str) != it->second.end()) {
                    cout << it->first << '\n';
                }
            }
        } else {
            for (auto it = m.begin(); it != m.end(); it++) {
                if (it->first.compare(str) == 0) {
                    sort(it->second.begin(), it->second.end());
                    for (string s : it->second) {
                        cout << s << '\n';
                    }
                }
            }
        }
    }
    
    return 0;
}
