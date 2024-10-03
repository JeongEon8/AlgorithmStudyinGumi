# [백준 - G4] 15961. 회전 초밥
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
슬라이딩 윈도우

## :round_pushpin: **Logic**
- 옆으로 밀면서 N개를 확인 ⇒ 앞에 것은 사라지고 새로운 뒤에 것만 추가됨
  - 즉, 삭제되는 앞과 추가되는 뒤를 제외한 내용은 같음 ⇒ 슬라이딩 윈도우 사용하기
- 제일 앞의 초밥을 뺐는데 먹을 수 있는 초밥 목록에 해당 초밥이 들어있지 않은 경우 ⇒ 초밥의 종류 1 감소
- 제일 뒤에 초밥을 넣었는데 먹을 수 있는 초밥 목록에 처음 포함되는 경우 ⇒ 초밥의 종류 1 증가
```java
static void getMaxKind() {
  int kind = 0;

  // 초기값 넣기
  for (int i = 0; i < k; i++) {
    if (visited[arr[i]]++ == 0)
      kind++;
  }

  int maxKind = kind;
  // 각 위치를 기준으로 연속한 k개의 접시 확인하기
  for (int i = 0; i < N; i++) {
    // 제거한 값이 더 이상 list에 있지 않다면 1 감소
    if (--visited[arr[i]] == 0)
      kind--;

    int end = (i + k) % N;
    // 추가하려는 값이 처음으로 등록되는 것이면 1 증가
    if (visited[arr[end]]++ == 0)
      kind++;

    maxKind = Math.max(maxKind, visited[c] == 0 ? kind + 1 : kind);
  }
  System.out.println(maxKind);
}
```

## :black_nib: **Review**
슬라이딩 윈도우 개념을 저번에 접해봐서 해당 개념을 적용하려고 했다. 그러나 문제에 적용한 경험이 없어서 뇌피셜로 풀었더니 시간 초과가 발생했다.. 
결국 다른 풀이를 참고해서 풀었고, 슬라이딩 윈도우의 구현 방법에 대해 알 수 있어 좋았다.

## 📡**Link**
- https://www.acmicpc.net/problem/15961
