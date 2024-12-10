# [백준] 16926. 배열 돌리기 1


## ⏰ **time**
60분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
O(r × n × m)

## :round_pushpin: **Logic**
겹겹이 회전시켜야 하므로, 몇 겹이나 반복해야 하는지 계산한다.(circles) <br/>
그리고 해당 겹(?..circle)의 길이만큼 값을 옮겨줘야 하므로, length도 구한다.<br/>
회전 수의 경우, n바퀴 돌게 되면 낭비이기 때문에... r%length로 다시 구해준다.
```java
        int circles = Math.min(n, m)/2; //몇 겹 회전하는지

        for (int i = 0; i < circles; i++) {
            int length = (n+m-2- (4*i)) *2; //현재 circle의 길이
            int rot = r % length; //몇번 회전할 건지
```

시작점은 따로 빼주고, 값 옮기기를 진행한다. 순서대로 상우하좌~~
```java
        int start = arr[i][i]; //각 circle의 시작점

        for (int k = i; k < m-1-i; k++) {
            arr[i][k] = arr[i][k+1];
        }

        for (int k = i; k < n-1-i; k++) {
            arr[k][m-1-i] = arr[k+1][m-1-i];
        }

        for (int k = m-1-i; k > i; k--) {
            arr[n-1-i][k] = arr[n-1-i][k-1];
        }

        for (int k = n-1-i; k >i; k--) {
            arr[k][i] = arr[k-1][i];
        }
```

출력하면 끝...


## :black_nib: **Review**
대단한 로직이나 아이디어가 필요한 문제는 아니었다.<br/>
다만 좀 귀찮을 뿐... 옮기고 옮기고...

## 📡**Link**
https://www.acmicpc.net/problem/16926  
