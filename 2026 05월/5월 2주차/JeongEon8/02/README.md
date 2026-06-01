# [PGS - Lv2] 72411_메뉴 리뉴얼

## ⏰**time**
1시간

## :pushpin: **Algorithm**
정렬, 조합

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. order string 오름차순 정렬
2. course에서 조합 최대 개수 뽑고, orders에서 조합을 만들어, 개수가 많은 것을 answers에 추가한다.
   ```cpp
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
   ```

## :black_nib: **Review**
- 대 상 혁, 도대체 이런 편리함을 어떻게 만든 것이야

## 📡 Link
[프로그래머스 Lv2 메뉴 리뉴얼](https://school.programmers.co.kr/learn/courses/30/lessons/72411)
