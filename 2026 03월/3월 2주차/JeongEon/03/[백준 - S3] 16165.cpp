#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, m;
    cin >> n >> m;

    unordered_map<string, vector<string>> team_member;
    unordered_map<string, string> member_team;

    string team, member;
    int member_num;
    while (n--) {
        cin >> team >> member_num;
        vector<string> member_list;
        while (member_num--) {
            cin >> member;
            member_list.push_back(member);
            member_team[member] = team;
        }
        sort(member_list.begin(), member_list.end());
        team_member[team] = member_list;
    }

    int question_type;
    string question;
    while (m--) {
        cin >> question >> question_type;
        if (question_type == 0) { 
            for (auto member : team_member[question]) {
                cout << member << "\n";
            }
        } else {
            cout << member_team[question] << "\n";
        }
    }
}
