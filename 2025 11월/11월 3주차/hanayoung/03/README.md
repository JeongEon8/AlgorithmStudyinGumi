# [백준 - G3] 경사로

## ⏰  **time**
3시간

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. maps 기준 행을 기준으로, 열을 기준으로 탐색 두 번
2. installCheck로 해당 열/행에서 경사로 설치 중인지 확인, canInstall은 열/행 전반에 걸쳐서의 결과.
```java
	boolean installCheck = false; // 경사로 설치 여부 확인
        int prevH = maps[i][0];
        int same = 1; // 같은 높이 나온 횟수
        boolean canInstall = true;
```
3. 이전 값과 현재 지점이 다른 높이인 경우, 현재 경사로 설치안하고 있으며, 같은 높이가 L이상 등장했으며, 현재 지점이 이전 지점보다 1 크다면 올라가는 경우에 경사로 설치 가능한 것으로 판단
4. 경사로 설치 안하고 있으며, 이전지점이 1 더 클 때는 설치 가능한지 확인 시작하기
5. 만약 same이 L과 같으면, 바로 설치가능한 경우로 same = 0으로 업데이트
6. 위의 경우로 빠져나가지 못했다면 설치 불가능한 경우로 판정
7. 현재 지점(maps[i][j])와 prevH가 같은 높이라면 same++
8. 설치 중인데, L보다 same이 작고 마지막 위치라면 canInstall을 false로 업데이트
9. 설치 중인데, same == L이면 낮아진 곳 경사로 설치 완료로 판정
10. canInstall은 true, installCheck는 false라면 answer++ 
```java
if(prevH != maps[i][j]) {
                    if(installCheck == false && same >= L && maps[i][j] - prevH == 1) {
                        // 올라가는 경우, 설치가능으로 판단
                        prevH = maps[i][j];
                        same = 1;
                        continue;
                    } else if(installCheck == false && prevH - maps[i][j] == 1) {
                        // 내려가는 경우, 설치 가능한지 확인 시작
                        installCheck = true;
                        prevH = maps[i][j];
                        same = 1;
                        if(same == L) {
                            // 경사로 길이가 1인 경우, 바로 설치 가능
                            installCheck = false;
                            same = 0;
                        }
                        continue;
                    }
                    canInstall = false;
                    break;
                } else {
                    same++;
                    if(installCheck == true && same < L && j == N-1) {
                        canInstall = false;
                    } else if(installCheck == true && same == L) {
                        // 낮아진 곳 설치 완료
                        installCheck = false;
                        same = 0;
                    }
                }
            }
            if(canInstall == true && installCheck == false) {
                answer++;
            }
```


## :black_nib: **Review**
- 골드지만 간단한 bfs인줄 알고 덤볐다가 큰일난 문제,,, 조건 하나하나 생각하려니까 꼬였는데 제대로 정리하고 시작했으면 괜찮았을지도..?

## 📡**Link**
- https://www.acmicpc.net/problem/14890
