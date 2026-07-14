# [PGS - Lv2] 02_전력망을 둘로 나누기

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- 완전탐색
- BFS

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 전선 정보로 인접 행렬을 구현한 뒤, 전선을 하나씩 끊어보며 BFS로 연결된 노드 개수를 파악해 최솟값을 갱신하는 방식으로 풀었다.
   ```java
        for(int[] wire : wires){
            arr[wire[0]][wire[1]] = true;
            arr[wire[1]][wire[0]] = true;
        }
        
        for(int[] wire : wires){
            arr[wire[0]][wire[1]] = false;
            arr[wire[1]][wire[0]] = false;
            int cnt = countNode(arr, n, wire[0]);
            int diff = Math.abs(n - cnt - cnt);
            
            answer = Math.min(answer, diff);
            
            arr[wire[0]][wire[1]] = true;
            arr[wire[1]][wire[0]] = true;
        }

    public int countNode(boolean[][] arr, int n , int startNode){
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(startNode);
        visited[startNode] = true;
        
        int count = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 0; i <= n; i++){
                if(arr[cur][i] && !visited[i]){
                    queue.add(i);
                    count++;
                    visited[i] = true;
                }
            }
        }
        
        return count;
    }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/86971
