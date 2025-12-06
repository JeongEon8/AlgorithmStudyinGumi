# [백준 - G5] 2493. 탑

## ⏰  **time**
90분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. Top 정보 담을 클래스 생성
```java
    public static class Top {
        int id;
        int height;

        public Top(int id, int height) {
            this.id = id;
            this.height = height;
        }
    }
```
2. stack 크기가 0보다 클 때(값이 존재할 때), 가장 윗값보다 다음에 볼 탑의 크기가 더 높으면 pop
3. 만약 stack에 값이 존재하면 해당 i번째의 탑의 신호를 받는 값은 가장 윗값의 탑 번호이므로 업데이트, 아니라면 아무도 못 받아서 0 처리
4. stack에 값 넣기
```java
        for(int i = 0; i < N; i++) {
            while(stack.size() > 0 && stack.peek().height <= height[i]) stack.pop();
            if(stack.size() > 0) ans[i] = stack.peek().id;
            else ans[i] = 0;
            stack.add(new Top(i+1, height[i]));
        }

```


## :black_nib: **Review**
- 생각하기 너무너무 어려워서 왕창 틀리고 재도전한 문제 나중에 다시 또 풀어봐야지..

## 📡**Link**
- https://www.acmicpc.net/problem/2493
