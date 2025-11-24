# [프로그래머스 - Lv2] 이모티콘 할인행

## ⏰  **time**
2시간

## :pushpin: **Algorithm**
중복순열

## ⏲️**Time Complexity**
$O(4^N*U*N)$

## :round_pushpin: **Logic**
1. depth는 현재 선택한 인덱스, sales는 10,20,30,40을 담고 있는 배열, current는 현재까지의 가격 배열, N은 emoticons 배열 크기
2. depth가 N이면 모두 할인율 할당완료. 유저별로 탐색하며, 한 유저에 대한 이모티콘 가격 계산 진행
3. 합계가 user[1](이모티콘 플러스 가입 안하는 최대 금액)보다 크거나 같으면 totalSubscribe++, 아니라면 totalProfit에 sum 더하기
4. 모든 유저에 대해서 탐색 후에, answer[0]보다 totalSubscribe가 크면 answer[0]과 answer[1]을 업데이트, answer[0]이 totalSubscribe와 같은데, answer[1]이 totalProfit보다 작으면 answer[1]만 업데이트
5. current[depth]에 sale을 할당하고 재귀함수를 호출하며 하나씩 다 해볼 수 있도록 함
```java
    public void recur(int depth, int[] sales, int[] current, int N, int[][] users, int[] emoticons) {
        if(depth == N) {
            int totalSubscribe = 0;
            int totalProfit = 0;
            for(int[] user: users) {
                int sum = 0;
                for(int i = 0; i < current.length; i++) { // 한 유저에 대한 이모티콘 가격 계산
                    if(user[0] <= current[i]) {
                        sum += emoticons[i] * (100-current[i]) / 100;
                    }
                }
                if(sum >= user[1]) { // 이모티콘 플러스 가입
                    totalSubscribe++;
                } else {
                    totalProfit += sum;
                }
            }
            if(answer[0] < totalSubscribe) {
                answer[0] = totalSubscribe;
                answer[1] = totalProfit;
            } else if(answer[0] == totalSubscribe && answer[1] < totalProfit) {
                answer[1] = totalProfit;
            }
            return;
        }
        
        for(int sale: sales) {
            current[depth] = sale;
            recur(depth+1, sales, current, N, users, emoticons);
        }
    }
```

## :black_nib: **Review**
- 문제를 이해하는 데에만 한세월.. 처음에는 할인율이 4가지로 한정되어있는 게 이니고 다 가능한 줄 알고 안 터지나 했지만..? 제한되어있던 문제

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/150368
