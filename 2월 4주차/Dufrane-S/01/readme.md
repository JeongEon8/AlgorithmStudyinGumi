# [백준 - 실버 1] 1932. 정수 삼각형
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 삼각형 가장 윗부분부터 가장 큰 합을 갱신해가면서 하단부까지 내려오기
2. 하단부에서 가장 큰 값 찾기
   
```java
prev[0]=Integer.parseInt(br.readLine());
        for(int i=1;i<N;i++){
            int []now = new int[i+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                now[j]=Integer.parseInt(st.nextToken());
            }
            now[0]+=prev[0];
            now[i]+=prev[i-1];
            for(int j=1;j<i;j++){
                if(prev[j-1]>prev[j]){
                    now[j]+=prev[j-1];
                }else{
                    now[j]+=prev[j];
                }
            }
            prev=now;
        }
        int answer=0;
        for(int i=0;i<N;i++){
            if(prev[i]>answer)answer=prev[i];
        }
```

## :black_nib: **Review**

## 📡 Link
https://www.acmicpc.net/problem/1932
