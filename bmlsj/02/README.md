# [PGS - Lv2] 02\_후보키

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(2^m)$

## :round_pushpin: **Logic**

1. 조합 생성: 1부터 `m`개까지 index 번호의 조합을 생성한다.
2. 최소성 검사
   - 이미 찾아낸 후보키가 현재 내가 뽑은 조합에 통째로 들어가 있는지 확인
     ex) `{0}`이 이미 있으면, `{0, 1}, {0, 1, 2}`는 모두 `{0}`을 포함하므로 최소성을 만족X
3. 유일성 검사
   - 선택된 컬럼 조합으로 각 행의 값들을 하나의 문자열로 이어 붙인 뒤 Set에 넣어 중복 제거
   - 예시: `{1, 2}` 컬럼을 선택했을 때1행: "ryan" + "," + "music" + "," $\rightarrow$ "ryan,music,"2행: "apeach" + "," + "math" + "," $\rightarrow$ "apeach,math,"모든 행을 변환하여 HashSet에 추가한 후 `set.size() == N`이면 중복된 행이 없으므로 유일성 통과

```java
static void comb(int start, int targetLen, Set<Integer> selected) {

    if (selected.size() == targetLen) {

        // 최소성 검사
        for(Set<Integer> key: candidate) {
            if (selected.containsAll(key)) {
                return;
            }
        }

        // 유일성
        if (isUnique(selected)) {
            candidate.add(new HashSet<>(selected));
        }

        return;
    }

    for(int i = start; i < m; i++) {
        selected.add(i);
        comb(i + 1, targetLen, selected);
        selected.remove(i);
    }
}

static boolean isUnique(Set<Integer> selected) {

    Set<String> set = new HashSet<>();

    for(int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder();

        for(int j : selected) {
            sb.append(relation[i][j]).append(",");
        }

        set.add(sb.toString());
    }

    return set.size() == n;
}
```

## :black_nib: **Review**

-

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/42890>
