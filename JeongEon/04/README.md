# \[백준 - 실버 3] 16165. 걸그룹 마스터 준석

## ⏰  **time**

15분

## \:pushpin: **Algorithm**

해시맵 + 정렬

## ⏲️**Time Complexity**

* 팀→멤버 저장: $O(\sum |팀원|)$
* 팀 멤버 출력(정렬): $O(k\log k)$  (팀원 수 $k$)
* 멤버→팀 조회(현재 코드): $O(\text{팀 수} \times \text{평균 팀원 수})$
  → 개선안: **멤버→팀 맵**을 추가하면 $O(1)$ 평균으로 조회 가능

## \:round\_pushpin: **Logic**

1. 팀 이름과 팀원 수를 받아 `map<string, vector<string>> m`에 저장.
2. 질의 M개 처리:

   * **type = 0**: 주어진 팀 이름의 멤버 목록을 **사전순 정렬 후** 모두 출력.
   * **type = 1**: 주어진 멤버 이름이 속한 팀을 찾아 팀 이름 출력
     (현재 구현은 모든 팀을 순회하며 `find`로 멤버 포함 여부를 검사).

```cpp
// 팀 → 멤버 목록
map<string, vector<string>> m;

if (type == 1) {              // 멤버 -> 팀
    for (auto &kv : m) {
        if (find(kv.second.begin(), kv.second.end(), str) != kv.second.end()) {
            cout << kv.first << '\n';
        }
    }
} else {                      // 팀 -> 멤버들(사전순)
    auto &v = m[str];
    sort(v.begin(), v.end());
    for (auto &name : v) cout << name << '\n';
}
```

> ⚙️ **개선 팁**
> `unordered_map<string, string> member2team;`을 함께 유지하면 type=1 질의를 $O(1)$ 평균에 처리 가능:
> `cout << member2team[str] << '\n';`

## \:black\_nib: **Review**

* 맵 한 개만으로도 정답은 가능하지만 멤버→팀 역맵을 쓰면 깔끔하고 빠름.
* 팀 멤버 출력은 입력 시 정렬해 두거나, 첫 출력 전에 한 번만 정렬하는 편이 효율적임.

## 📡 Link

[https://www.acmicpc.net/problem/16165](https://www.acmicpc.net/problem/16165)
