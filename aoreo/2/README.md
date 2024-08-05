# [SWEA - D4] 1210. [S/W 문제해결 기본] 2일차 - Ladder1

## ⏰  **time**
약 2시간

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 2차원 배열 visited에 방문 여부 저장
2. queue에 방문할 노드들 추가(add)
3. queue가 비지 않을 때까지 반복하며, 방문할 경우, 노드 제거
4. 좌우로 이동가능한지 판단하고, 안될 경우 아래로만 이동가능한 경우이므로, 제일 하단의 지점이 아닌 경우 queue에 노드를 추가하고 방문 처리. 제일 하단의 지점일 경우 answer에 시작점 값 넣음.
한 반복에 노드 하나씩만 들어가므로 따로 clear 처리는 하지 않음.
5. 좌우로 이동가능하며 방문하지 않은 경우 방문할 노드 방문처리, queue에 노드 추가.

## :black_nib: **Review**
- 폴더 분리를 했음에도 같은 패키지 안으로 판단해서 그런건지 같은 class가 있다고 실행이 안되는 문제로 오래 걸렸다... 처음 봐서 왜 이러는지 알 수가 없었다...

- input 형태가 다른 문제들과 달라서 당황했당...

- 좌우로 이동가능한지 판별할 때, 방문 여부를 따로 두지 않았더니 계속해서 오른쪽으로 갔다 왼쪽으로 갔다를 반복해버리는 문제 발생... 내려와줘...😥

- 오랜만에 알고리즘 문제를 풀었더니 row, column이 헷갈려서 이걸로 꽤 오래 고생했다...

- 심지어 예시 이미지에서까지 row column이 이상하게 나와있어서 더 헤맸던 듯 잉... 고쳐줘🥲

- 제출할 때, "#"과 tc 사이에 공백이 있어서 계속 틀렸다.. 이것때문에 더 오래 걸렸다...

## 📡**Link**
- https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=1&&&&&&&&&&
