# [백준 - S3] 9017. 크로스 컨트리

## ⏰  **time**
70분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 6명이 통과하지 못한 팀의 선수는 제외하고 점수를 매기기 위해서, 팀 순서, 패스한 팀 체크, 패스 인원 수 체크할 배열 변수 생성
```java
            int[] entries = new int[N+1]; // 팀 순서 담기
            boolean[] passed = new boolean[N+1]; // 패스한 팀 체크
            int[] check = new int[N+1]; // 현재 패스한 인원 수 체크
```
2. check 값을 올리며 6이 된 경우, boolean 배열 true로 업데이트
```java
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                entries[i] = num; 
                check[num] += 1;
                if(check[num] == 6) passed[num] = true;
            }
```
3. pivot은 기존 배열의 등수를 가리키기 위한 변수, idx는 변동된 순서를 가리키기 위한 변수
4. 패스한 팀일 경우, 해당 팀원이 들어온 적이 없을 경우(team == null) 그대로 삽입, 있을 경우 다음 순서로 삽입하되, 4명이 이미 들어왔다면 점수를 올리지 않고 다섯 번째 선수를 업데이트 하거나 패스 선수 수만 업데이트
```java
            HashMap<Integer, Team> teams = new HashMap<>();
            int idx = 1;
            int pivot = 1;
            while(pivot < N+1) {
                // entries[pivot] 은 팀
                // pivot은 등수
                // idx는 점수를 가리킬 예정
                int teamNum = entries[pivot];
                Team team = teams.get(teamNum);
                if(passed[teamNum] == true) {
                    if(team == null) {
                        teams.put(teamNum, new Team(1, idx));
                    } else {
                        if(team.passCnt < 4) {
                            team.updateScore(idx);
                        } else if(team.passCnt == 4) {
                            teams.put(teamNum, new Team(5, team.score, idx));
                        } else {
                            team.updateCnt();
                        }
                    }
                    idx++;
                }
                pivot++;
            }
```
5. 해시맵에서 미리 정의해둔 순서대로 정렬하여 가장 첫 번째 팀이되, 패스한 팀 찾기, 팀 번호를 찾는 것이므로 key값 출력
```java
            Optional<Map.Entry<Integer, Team>> result = teams.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .filter(entry -> entry.getValue().passCnt == 6)
                    .findFirst();

            sb.append(result.get().getKey()).append("\n");
```


## :black_nib: **Review**
- 엄청 헷갈렸고 왕창 돌아갔고 코드가 굴러는 가지만 대박 더러워서 리팩토링하려다가 실패... 다시 하리라

## 📡**Link**
- https://www.acmicpc.net/problem/9017
