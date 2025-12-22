# [프로그래머스 - Lv2] 양궁대회

## ⏰  **time**
90분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(2^11)$

## :round_pushpin: **Logic**
1. 재귀 함수. next부터 10까지 탐색하며, 맞춘 점수 조합을 구함. 상대방이 맞췄고 남은 화살 수가 더 크거나 같다면 해당 과녁을 그 이상 맞추는 거 시도, 상대방이 맞췄다면 하나만 맞추기. 그리고 재귀함수 호출
```java
        for(int i = next; i < 10; i++) {
            if(info[i] > 0 && n - depth >= info[i]+1) {
                current[i] += info[i]+1;
                recur(depth+info[i]+1, n, i+1, current, info);
                current[i] -= info[i]+1;
            }
            if(info[i] == 0) {
                current[i] = 1;
                recur(depth+1, n, i+1, current, info);
                current[i] = 0;
            }
            recur(depth, n, i+1, current, info);
        }
```
2. n발 다 썼거나, 점수 끝까지 탐색한 경우 재귀함수 호출 중단.
3. 아직 n발 다 안쐈는데 넘어온 경우 가장 낮은 점수에 남은 개수 소진
4. compareScore 함수로 점수 계산 및 비교. 만약 반환값이 0보다 크다면 라이언 승리. max와 비교해서 max보다 크면 max와 answer 업데이트.
5. max와 같으면 answer를 하나하나 비교해서 작은 점수 과녁에 더 많이 쏜 것을 answer로 업데이트.
6. 값 복구 후 return 
```java
        if(depth == n || next == 10) {
            if(depth != n && next == 10) {
                current[10] += n - depth;
            }
            int score = compareScore(info, current);
            if(score > 0) {
                if(max < score) {
                    max = score;
                    answer = Arrays.stream(current).boxed().collect(Collectors.toList());
                } else if(max == score) {
                    for(int i = 10; i >= 0; i--) {
                        if(answer.get(i) < current[i]) {
                            answer = Arrays.stream(current).boxed().collect(Collectors.toList());
                            break;
                        } else if(answer.get(i) > current[i]) break;
                    }
                }
            }
            if(depth != n && next == 10) current[10] -= n - depth;
            return;
        }
```
7. 두 선수의 점수 비교해서 반
```java
    public int compareScore(int[] apeach, int[] ryan) {
        int aScore = 0;
        int rScore = 0;
        for(int i = 0; i < 10; i++) {
            if(apeach[i] == ryan[i] && apeach[i] == 0) continue;
            if(apeach[i] >= ryan[i]) aScore += 10-i;
            else rScore += 10-i;
        }
        
        if(aScore - rScore >= 0) return -1;
        else return rScore - aScore;
    }
```


## :black_nib: **Review**
- 재귀함수가 내맘대로 안 굴러가서 힘들었던 문제

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/92342
