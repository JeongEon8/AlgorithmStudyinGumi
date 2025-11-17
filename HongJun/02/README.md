# [프로그래머스 - Lv2] 방문 길이

## ⏰  **time**
40분

## :pushpin: **Algorithm**
- 해시맵, 집합

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 좌표를 벗어나는지 체크하는 메서드 정의
- 입력 문자에 따른 좌표 결정을 위한 해시맵 정의
- 결과값에 겹치는 좌표를 1개로 처리하기 위해서 HashSet 사용
- 명령어를 탐색하며 좌표 저장
- A->B와 B->A의 경우 2가지를 저장함
- answer의 크기에서 2로 나눈 값을 리턴

```
    // 초기 메서드 정의
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }
```

## :black_nib: **Review**


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/49994
