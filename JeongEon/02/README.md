# \[백준 - 실버 1] 2667. 단지번호붙이기

## ⏰  **time**

15분

## \:pushpin: **Algorithm**

DFS(깊이 우선 탐색)

## ⏲️**Time Complexity**

\$O(N^2)\$

* 모든 칸을 최대 한 번씩 방문

## \:round\_pushpin: **Logic**

1. 입력받은 지도를 `map[y][x]`에 저장(문자 `'0'/'1'` → 정수 0/1).
2. 전체 격자를 순회하며 \*\*아직 방문하지 않은 집(=1)\*\*을 만나면 DFS 시작:

   * 방문 표시(`visited[y][x]=true`)와 함께 단지 내 집 수 `house++`.
   * 4방향(오/왼/위/아래)으로 이어진 집을 재귀적으로 탐색.
3. DFS가 끝나면 한 단지 탐색 완료 → 단지 수 `complex++`, 해당 단지의 집 수를 `result`에 저장 후 `house=0` 초기화.
4. 모든 탐색이 끝나면 `result`를 **오름차순 정렬** 후

   * 첫 줄에 **단지 수**
   * 다음 줄부터 **각 단지 내 집 수**를 한 줄에 하나씩 출력.

```cpp
void dfs(int y, int x){
    visited[y][x] = true;
    house++;
    int dx[4]={1,-1,0,0}, dy[4]={0,0,1,-1};
    for(int i=0;i<4;i++){
        int nx=x+dx[i], ny=y+dy[i];
        if(nx<0||ny<0||nx>=N||ny>=N) continue;
        if(map[ny][nx]==1 && !visited[ny][nx]) dfs(ny,nx);
    }
}

for(int y=0;y<N;y++)
  for(int x=0;x<N;x++)
    if(map[y][x]==1 && !visited[y][x]){
        dfs(y,x);
        complex++;
        result.push_back(house);
        house=0;
    }
```

## \:black\_nib: **Review**

* 전형적인 연결 요소 세기 문제. 방문 체크만 확실히 하면 실수 없음!
* 입력이 문자라 `-'0'`로 정수 변환하는 부분만 놓치지 않기.

## 📡 Link

[https://www.acmicpc.net/problem/2667](https://www.acmicpc.net/problem/2667)
