# [백준 - S3] 18429. 근손실

## ⏰  **time**
30분

## :pushpin: **Algorithm**
순열

## ⏲️**Time Complexity**
$O(N*N!)$

## :round_pushpin: **Logic**
1. 키트들을 사용할 모든 경우의 수를 구하기 위해 재귀함수 생성
2. 사용한 적 없으면(visited[i] == false) sel[r]에 할당. 방문처리 후 perm 함수 호출
3. r이 n과 같아지면(모든 키트를 사용하면), 해당 순서로 중량 500보다 작아지지 않을 수 있는 확인. 아니라면 return 가능하면 answer++ 후 return
```java
    public static void perm(int r, int n, int[] sel, boolean[] visited, int[] kits, int k) {
        if(r == n) {
            int weight = 500;
            for(int i = 0; i < n; i++) {
                weight -= k;
                weight += sel[i];
                if(weight < 500) return;
            }
            answer++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                sel[r] = kits[i];
                visited[i] = true;
                perm(r+1, n, sel, visited, kits, k);
                visited[i] = false;
            }
        }
    }
```

## :black_nib: **Review**
- 순열도 오랜만이군,,, 조합만 좀 깔짝여서 헷갈렸다..! N이 10보다 작다면 일단 순열 조합 돌리기

## 📡 Link
https://www.acmicpc.net/problem/18429
