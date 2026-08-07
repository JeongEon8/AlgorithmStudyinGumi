# [PGS - Lv2] 02\_불량 사용자

## ⏰**time**

60분

## :pushpin: **Algorithm**

백트래킹

## ⏲️**Time Complexity**

$O(N!)$

## :round_pushpin: **Logic**

1. 문자열 패턴 매칭 검사 (isMatch)

- 두 문자열의 길이가 다르면 바로 false를 반환하여 인덱스 초과 에러 방지
- 길이가 같을 경우, `*` 문자를 제외한 나머지 문자가 서로 일치하는지 확인

1. 백트래킹 탐색

- `banned_id` 목록을 순서대로 하나씩 탐색
- 패턴이 매칭되는 `user_id`를 찾으면 방문 표시 후 다음 `banned_id` 인덱스로 재귀 호출하고, 탐색이 끝나면 원상복구

1. 중복 조합 제거

- 모든 banned_id에 매칭을 완료하면, 선택된 user_id 목록을 수집
- 제재 아이디 목록은 순서가 달라도 동일한 아이디 구성이면 같은 경로 생각해, 선택된 아이디들을 오름차순 정렬한 뒤 쉼표(,)로 이어 붙여 Set에 추가함으로써 중복을 제거

```java
dfs(index):
  if index == banned_id.length:
      선택된 user_id들을 수집 -> 정렬 -> 문자열로 합침 -> resultSet에 저장
      return

  for i = 0 to user_id.length - 1:
      if visited[i] 인 경우: continue
      if isMatch(user_id[i], banned_id[index]):
          visited[i] = true
          dfs(index + 1)
          visited[i] = false
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/64064>
