# [백준 - 실버 3] 16165. 걸그룹 마스터 준석

## ⏰**time**
15분

## :pushpin: **Algorithm**
해시맵, 정렬

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. 두 개의 해시맵을 사용한다.

   * `team_member[팀명] = 멤버 목록`
   * `member_team[멤버명] = 소속 팀명`
2. 입력을 받으면서:

   * 각 팀의 멤버들을 벡터에 저장
   * 멤버 이름으로 팀명을 바로 찾을 수 있도록 `member_team`에도 저장
3. 팀별 멤버 목록은 문제 조건에 맞게 **사전순 정렬**해 둔다.
4. 질의 처리:

   * `question_type == 0`이면 팀명이 주어지므로, 해당 팀의 멤버 목록을 모두 출력
   * `question_type == 1`이면 멤버명이 주어지므로, 해당 멤버의 팀명을 출력
5. 해시맵을 사용해서 팀→멤버, 멤버→팀 조회를 모두 빠르게 처리한다.

```cpp
unordered_map<string, vector<string>> team_member;
unordered_map<string, string> member_team;

// 입력
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

// 질의
if (question_type == 0) {
    for (auto member : team_member[question]) {
        cout << member << "\n";
    }
} else {
    cout << member_team[question] << "\n";
}
```

## :black_nib: **Review**
-

## 📡 Link

[https://www.acmicpc.net/problem/16165](https://www.acmicpc.net/problem/16165)
