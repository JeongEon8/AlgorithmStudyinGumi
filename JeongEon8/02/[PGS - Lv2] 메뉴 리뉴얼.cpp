#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

map<string, int> m;

bool compare(pair<string, int> a, pair<string, int> b) {
    return a.second > b.second;
}

void backtracking(string order, string make_course, int course_max, int cnt, int start) {
    if (cnt >= course_max) {
        if (m.find(make_course) != m.end()) {
            m[make_course]++;
        }
        else {
            m.insert({ make_course, 1 });
        }
        return;
    }

    for (int i = start; i < order.length(); i++) {
        make_course.push_back(order[i]);
        backtracking(order, make_course, course_max, cnt + 1, i + 1);
        make_course.pop_back();
    }
}

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;
    
    // 1. orders string 정렬
    for (int i = 0; i < orders.size(); i++) {
        sort(orders[i].begin(), orders[i].end());
    }

    // 2. course에서 조합 개수를 뽑고, orders에서 조합을 만들어, 개수가 많은 것을 answers에 추가한다.
    for (int i = 0; i < course.size(); i++) {
        int course_max = course[i];
        m.clear();
        for (int j = 0; j < orders.size(); j++) {
            if (orders[j].length() >= course_max) {
                backtracking(orders[j], "", course_max, 0, 0);
            }
        }

        if (!m.empty()) {
            vector<pair<string, int>> v(m.begin(), m.end());
            sort(v.begin(), v.end(), compare);
            int comp = v[0].second;
            if (comp >= 2) {
                for (int k = 0; k < v.size(); k++) {
                    if (comp <= v[k].second) {
                        answer.push_back(v[k].first);
                        continue;
                    }
                    break;
                }
            }
        }
    }

    sort(answer.begin(), answer.end());
    
    return answer;
}
